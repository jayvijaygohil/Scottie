#!/usr/bin/env python3
"""Build and (optionally) apply a composed commit history.

Usage:
  python apply_plan.py PLAN.json --dry-run   # build commits, print preview, change nothing
  python apply_plan.py PLAN.json             # build commits and move the branch to them

PLAN.json:
  {"commits": [
     {"message": "feat(auth): add token refresh\\n\\nOptional body.",
      "units": ["u1", "u4", "src/whole/file.py"]},
     ...
  ]}
Commits are listed oldest first. A unit may be a unit id from context.json or a
file path (meaning every unit of that file). Units left out of the plan stay as
uncommitted changes in the working tree.

Safety: commits are built with a temporary index; the working tree is never
written. Before moving the branch the old HEAD is saved under
refs/commit-composer/backup-<timestamp> (and the staged/unstaged state under
refs/commit-composer/stash-<timestamp>).
"""
import argparse
import os
import shutil
import sys
import tempfile
import time

sys.path.insert(0, os.path.dirname(os.path.abspath(__file__)))
from composer_common import (chdir_toplevel, composer_dir, compute_target_tree, die,  # noqa: E402
                             git, in_progress_operation, load_json, run_git, try_git)


def resolve_plan(plan, units):
    by_id = {u["id"]: u for u in units}
    by_path = {}
    for u in units:
        by_path.setdefault(u["path"], []).append(u["id"])
    order = {u["id"]: i for i, u in enumerate(units)}
    used, resolved = {}, []
    commits = plan.get("commits")
    if not isinstance(commits, list) or not commits:
        die("plan must contain a non-empty 'commits' list")
    for n, c in enumerate(commits, 1):
        msg = (c.get("message") or "").strip()
        if not msg:
            die(f"commit #{n} has no message")
        ids = []
        for ref in c.get("units", []):
            refs = [ref] if ref in by_id else by_path.get(ref)
            if not refs:
                die(f"commit #{n}: unknown unit or path '{ref}'")
            for r in refs:
                if r in used:
                    die(f"unit {r} assigned to both commit #{used[r]} and #{n}")
                used[r] = n
                ids.append(r)
        if not ids:
            die(f"commit #{n} ('{msg.splitlines()[0]}') has no units")
        resolved.append({"message": msg + "\n", "units": sorted(ids, key=order.get)})
    leftover = [u["id"] for u in units if u["id"] not in used]
    return resolved, leftover, by_id


def build_patch(unit_ids, by_id):
    """Concatenate units; consecutive hunks of one file share a single header."""
    out, last_path = [], None
    for uid in unit_ids:
        u = by_id[uid]
        if u["kind"] != "hunk" or u["path"] != last_path:
            out.append(u["header"])
        body = u["body"]
        out.append(body if body.endswith("\n") or not body else body + "\n")
        last_path = u["path"] if u["kind"] == "hunk" else None
    return "".join(out)


def main():
    ap = argparse.ArgumentParser()
    ap.add_argument("plan")
    ap.add_argument("--dry-run", action="store_true")
    ap.add_argument("--context", help="path to context.json (default: <git-dir>/commit-composer/)")
    args = ap.parse_args()

    plan_path = os.path.abspath(args.plan)
    chdir_toplevel()
    ctx = load_json(args.context or os.path.join(composer_dir(), "context.json"))
    plan = load_json(plan_path)

    op = in_progress_operation()
    if op:
        die(f"a {op} is in progress; finish or abort it first")
    head = git("rev-parse", "HEAD").strip()
    if head != ctx["head"]:
        die("HEAD moved since collect_context.py ran; run it again")
    if compute_target_tree(ctx["mode"], ctx["include_untracked"]) != ctx["target_tree"]:
        die("files changed since collect_context.py ran; run it again")

    commits, leftover, by_id = resolve_plan(plan, ctx["units"])
    sign = try_git("config", "--type=bool", "commit.gpgsign") == "true"

    tmpdir = tempfile.mkdtemp(prefix="commit-composer-")
    built = []
    try:
        env = {**os.environ, "GIT_INDEX_FILE": os.path.join(tmpdir, "index")}
        git("read-tree", ctx["base"], env=env)
        parent = ctx["base"]
        parent_tree = git("rev-parse", f"{parent}^{{tree}}").strip()
        for n, c in enumerate(commits, 1):
            patch = build_patch(c["units"], by_id)
            code, _, err = run_git(["apply", "--cached", "--whitespace=nowarn", "-"],
                                   env=env, input_text=patch, check=False)
            if code != 0:
                die(f"commit #{n} ('{c['message'].splitlines()[0]}'): units {', '.join(c['units'])} "
                    f"do not apply in this order.\n{err.strip()}\n"
                    "Usually a hunk depends on another hunk placed in a later commit; "
                    "move it earlier or into the same commit.")
            tree = git("write-tree", env=env).strip()
            if tree == parent_tree:
                die(f"commit #{n} would be empty")
            msg_file = os.path.join(tmpdir, f"msg{n}")
            with open(msg_file, "w", encoding="utf-8") as f:
                f.write(c["message"])
            cmd = ["commit-tree", tree, "-p", parent, "-F", msg_file] + (["-S"] if sign else [])
            sha = run_git(cmd)[1].strip()
            built.append((sha, c))
            parent, parent_tree = sha, tree
    finally:
        shutil.rmtree(tmpdir, ignore_errors=True)

    new_head = parent
    complete = parent_tree == ctx["target_tree"]

    print("Proposed history (oldest first):\n")
    prev = ctx["base"]
    for n, (sha, c) in enumerate(built, 1):
        lines = c["message"].strip().splitlines()
        print(f"{n}. {sha[:8]}  {lines[0]}")
        for bl in lines[1:]:
            print(f"             {bl}".rstrip())
        print(f"   units: {', '.join(c['units'])}")
        for sl in git("diff", "--stat=100", prev, sha).rstrip().splitlines():
            print(f"   {sl}")
        print()
        prev = sha
    if leftover:
        print(f"Left uncommitted (not in plan): {', '.join(leftover)}")
    print(f"All planned changes accounted for: {'yes' if complete else 'no (see leftover units)'}")

    if args.dry_run:
        print("\nDry run: nothing was changed.")
        return

    ts = time.strftime("%Y%m%d-%H%M%S")
    backup = f"refs/commit-composer/backup-{ts}"
    git("update-ref", backup, head)
    stash = try_git("stash", "create")
    if stash:
        git("update-ref", f"refs/commit-composer/stash-{ts}", stash)
    git("update-ref", "-m", f"commit-composer: compose {len(built)} commits", "HEAD", new_head, head)
    git("reset", "-q")  # sync index to new HEAD; working tree untouched

    print(f"\nApplied. {ctx.get('branch') or 'HEAD'} now at {new_head[:8]}.")
    print(f"Backup of previous HEAD: {backup} ({head[:8]})")
    if stash:
        print(f"Previous staged/unstaged state saved: refs/commit-composer/stash-{ts}")
    print(f"Undo: git reset {head[:12]}   (moves the branch back; files are unchanged)")
    if ctx.get("published_commits"):
        print("Note: rewritten commits were already on a remote; publish with "
              "`git push --force-with-lease`.")


if __name__ == "__main__":
    main()