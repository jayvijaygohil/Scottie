---
name: commit-composer
description: AI commit composer (like GitKraken's Commit Composer) that turns messy local work into a clean, logical series of atomic commits with well-written messages. It groups hunks into commits, squashes and fixes up "wip/fix/oops" commits, reorders them, rewrites the messages, previews the result, and applies it with a backup. Use this skill whenever the user wants to clean up, tidy, squash, split, reorganize or reword commits before pushing or opening a PR, asks to "compose", "organize" or "make sense of" their changes, has a big pile of uncommitted changes to break into several commits, mentions interactive rebase / `rebase -i` / fixup / autosquash for local history, or asks Claude to commit work as multiple logical commits. Use it even if they don't name the feature, e.g. "my branch history is a mess", "commit this properly", or "split this into sensible commits".
---

# Commit Composer

Turn a pile of local changes (unpushed commits and/or uncommitted edits) into a
history a reviewer can read commit by commit. This replicates GitKraken's
Commit Composer:

| GitKraken feature | Here |
|---|---|
| AI grouping suggestions | You read the hunks and propose atomic commits |
| Squash / fixup / reorder by drag-and-drop | The user edits the plan in plain language; you rebuild it |
| AI-generated commit messages | You write messages from the actual diff, in the repo's style |
| Preview before applying | `apply_plan.py --dry-run` builds real commits without moving anything |
| Safe to experiment | Working tree never touched; backup ref written; one-line undo |

The key idea: instead of replaying `rebase -i` steps, the scripts take the
*net* change from the base to the final state, cut it into **units** (one per
diff hunk, or a whole file for new/deleted/binary files), and rebuild commits
from whichever units you assign to each. So squash, fixup, split, reorder and
reword are all the same operation: write a plan.

## Workflow

Scripts live in `scripts/` next to this file. Run them from anywhere inside the repo.

### 1. Collect

```bash
python <skill-dir>/scripts/collect_context.py [--mode auto|all|commits|worktree] [--base REF] [--include-untracked]
```

Pick the mode from what the user asked for:
- **worktree**: "commit my changes properly" — only uncommitted edits, new commits on top of HEAD.
- **commits**: "clean up my branch" — only the unpushed commits; uncommitted edits stay as they are.
- **all**: both. `auto` (default) picks whichever exists.

Add `--include-untracked` when new files the user hasn't `git add`-ed belong in the
commits (check `git status` and ask if it's unclear; scratch files and secrets
shouldn't be swept in). Use `--base` when the user names a starting point
("since main", "the last 4 commits" → `--base HEAD~4`).

The summary lists the existing commits, then every unit with its id, path,
+/- counts and hunk header. Full patches are in the `units.diff` path it prints.

**Stop and check the warnings.** If commits are already on a remote, say so and
get explicit confirmation before rewriting (it will need `git push --force-with-lease`).
If there are merge commits in range, note they will be flattened.

### 2. Understand the changes

Read `units.diff` (with `view`, in chunks if large). For each unit work out what
it does and what it depends on. The old commit messages are hints about intent,
not a structure to preserve — "fix typo" and "oops" should usually disappear into
the commit they fix.

Look at `style_samples` in `context.json` (recent subjects before the base) and
any `commitlint`/`.gitmessage`/CONTRIBUTING rules to match the repo's message
convention. The commits are created with plumbing, so commit-msg hooks will
**not** run — you have to follow the convention yourself.

### 3. Propose the composition

Group units into commits using these principles (they're what makes history
useful for review, `git bisect` and `git revert`):

- **One logical change per commit.** A reviewer should be able to state its purpose
  in one sentence. Unrelated changes in the same file go to different commits —
  that's what hunk-level units are for.
- **Each commit should build and pass on its own.** Put things before what uses
  them: renames/refactors and new helpers first, then the feature using them, then
  docs. Keep a function's definition and its call sites together if splitting
  would break the build.
- **Tests travel with the code they test**, unless the user's repo clearly does otherwise.
- **Fixups get absorbed.** A later "fix bug in X" for code that's new in this branch
  belongs inside the commit that introduces X.
- **Separate noise.** Formatting-only changes, dependency/lockfile bumps and generated
  files get their own commits so they don't bury the real change.
- **Don't over-split.** 1 coherent change = 1 commit, even if it spans 10 files.
  Typical results are 2–6 commits; one commit is a fine answer for a small coherent change.
- **Watch for things that shouldn't be committed** — debug prints, commented-out code,
  `.env` values, credentials, large binaries. Leave them out of the plan (they stay
  uncommitted) and tell the user why.

Write messages from the diff, not from the old messages:
- Subject: imperative mood, ≤ ~60 chars, no trailing period, says *what* changed.
  Use the repo's convention (e.g. `feat(auth): …` for Conventional Commits; plain
  `Add …` otherwise).
- Body (when the why isn't obvious): blank line, then what and why, wrapped at ~72.
  Mention behavior changes, migrations, or breaking changes (`BREAKING CHANGE:` footer
  in Conventional Commits).
- Never write vague subjects ("update files", "misc fixes", "changes").

Present the proposal to the user before building anything, like this:

```
Proposed history (oldest first) — replaces 5 commits + uncommitted changes

1. refactor(api): extract request retry into helper
   units: u1, u2          src/api/client.ts, src/api/retry.ts
2. feat(api): retry idempotent requests with backoff
   units: u3, u5, u6      src/api/client.ts, test/client.test.ts
   Squashes "add stuff", "fix bug", "another fix"
3. docs: describe retry configuration
   units: u7              README.md

Left uncommitted: u4 (console.log debug output in client.ts)
```

Then invite edits in the user's words ("merge 2 and 3", "move the README change
into 2", "use a different message for 1"). This is the drag-and-drop step. If the
user asked you to just do it, you may skip waiting, but still show the plan in your
final message.

### 4. Preview, then apply

Write the plan to a file (anywhere outside the work tree, e.g. `/tmp/plan.json`):

```json
{"commits": [
  {"message": "refactor(api): extract request retry into helper", "units": ["u1", "u2"]},
  {"message": "feat(api): retry idempotent requests with backoff\n\nRequests marked idempotent are retried up to 3 times.", "units": ["u3", "u5", "u6"]},
  {"message": "docs: describe retry configuration", "units": ["README.md"]}
]}
```

Commits are oldest first. A unit can be an id or a file path (= all of that file's units).

```bash
python <skill-dir>/scripts/apply_plan.py /tmp/plan.json --dry-run
python <skill-dir>/scripts/apply_plan.py /tmp/plan.json
```

The dry run builds the real commit objects and prints messages and a `--stat` per
commit without moving anything. Check "All planned changes accounted for": `no` is
expected only when you deliberately left units out.

If a commit fails to apply, a hunk depends on another hunk that comes later (e.g.
an edit inside a function added by a different unit). Move the units into the same
commit or reorder, then retry.

If the project has a fast test/build command and the user cares, you can verify an
intermediate commit with `git worktree add /tmp/check <sha>` before applying, then
`git worktree remove /tmp/check`.

### 5. Report

After applying, show `git log --oneline <base>..HEAD` and give the undo command the
script printed (`git reset <old-head>` — it moves the branch back without changing
files). Mention the force-push if the commits were published.

## What gets preserved and what doesn't

- File contents are never changed; the final tree is identical to what the user had.
- Staged-vs-unstaged distinctions are reset (everything not committed ends up
  unstaged); the previous state is saved under `refs/commit-composer/stash-*`.
- New commits get the current git identity and date, not the original authors'.
  If the branch has commits by several people, mention this before applying.
- GPG signing is honored if `commit.gpgsign` is set.
- Backups accumulate under `refs/commit-composer/`; the user can remove them with
  `git for-each-ref --format='%(refname)' refs/commit-composer | xargs -n1 git update-ref -d`.

## Lighter requests

- *Just a message for what's staged*: don't run the scripts; read `git diff --cached`
  and write the message (same message rules as above).
- *Reword only the last commit*: `git commit --amend` is simpler.
- Everything else (squash, split, reorder, reword several) goes through the workflow
  above — it's safer than `rebase -i` and handles all of them uniformly.