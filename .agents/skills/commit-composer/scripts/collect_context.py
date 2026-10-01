#!/usr/bin/env python3
"""Collect everything Commit Composer needs to propose a new commit history.

Usage:
  python collect_context.py [--mode auto|all|commits|worktree] [--base REF]
                            [--include-untracked] [--context-lines 1|2|3]

Modes:
  worktree  compose only uncommitted changes into new commits on top of HEAD
  commits   rewrite only the local (unpushed) commits base..HEAD
  all       rewrite local commits AND fold in uncommitted changes
  auto      (default) all / commits / worktree depending on what exists

Writes <git-dir>/commit-composer/context.json and units.diff, prints a summary.
The working tree and index are never modified by this script.
"""
import argparse
import os
import sys

sys.path.insert(0, os.path.dirname(os.path.abspath(__file__)))
from composer_common import (chdir_toplevel, composer_dir, compute_target_tree, die,  # noqa: E402
                             git, in_progress_operation, parse_units, save_json, try_git, ENC, ERR)


def detect_base():
    """Return (base_sha, base_ref) for the start of local, unpushed work."""
    head = git("rev-parse", "HEAD").strip()
    current = try_git("symbolic-ref", "--short", "HEAD")
    candidates = []
    upstream = try_git("rev-parse", "--abbrev-ref", "--symbolic-full-name", "@{u}")
    if upstream:
        candidates.append(upstream)
    origin_head = try_git("symbolic-ref", "--short", "refs/remotes/origin/HEAD")
    candidates += [origin_head, "origin/main", "origin/master", "main", "master", "develop"]
    for ref in candidates:
        if not ref or ref == current:
            continue
        if try_git("rev-parse", "--verify", "-q", f"{ref}^{{commit}}"):
            mb = try_git("merge-base", "HEAD", ref)
            if mb:
                return mb, ref
    return head, None


def main():
    ap = argparse.ArgumentParser()
    ap.add_argument("--mode", default="auto", choices=["auto", "all", "commits", "worktree"])
    ap.add_argument("--base", help="ref/sha where local work starts (default: upstream merge-base)")
    ap.add_argument("--include-untracked", action="store_true",
                    help="also compose untracked (non-ignored) files")
    ap.add_argument("--context-lines", type=int, default=1, choices=[1, 2, 3],
                    help="diff context; smaller = finer-grained hunks (default 1)")
    args = ap.parse_args()

    chdir_toplevel()
    if not try_git("rev-parse", "--verify", "-q", "HEAD"):
        die("repository has no commits yet; make an initial commit first")
    op = in_progress_operation()
    if op:
        die(f"a {op} is in progress; finish or abort it first")

    head = git("rev-parse", "HEAD").strip()
    branch = try_git("symbolic-ref", "--short", "HEAD")

    if args.base:
        base = try_git("rev-parse", "--verify", f"{args.base}^{{commit}}")
        if not base:
            die(f"unknown base {args.base}")
        if try_git("merge-base", "--is-ancestor", base, "HEAD") is None:
            die(f"base {args.base} is not an ancestor of HEAD")
        base_ref = args.base
    else:
        base, base_ref = detect_base()

    worktree_tree = compute_target_tree("worktree", args.include_untracked)
    dirty = worktree_tree != git("rev-parse", "HEAD^{tree}").strip()
    has_commits = base != head

    mode = args.mode
    if mode == "auto":
        mode = "all" if (has_commits and dirty) else "commits" if has_commits else "worktree"
    if mode == "worktree":
        base, base_ref = head, "HEAD"

    target_tree = worktree_tree if mode in ("all", "worktree") else git("rev-parse", "HEAD^{tree}").strip()

    commits = []
    if base != head:
        fmt = "%H%x1f%an%x1f%ad%x1f%s%x1f%b%x1e"
        raw = git("log", "--reverse", "--date=short", f"--format={fmt}", f"{base}..HEAD")
        for rec in raw.split("\x1e"):
            rec = rec.strip("\n")
            if not rec:
                continue
            sha, author, date, subject, body = (rec.split("\x1f") + [""] * 5)[:5]
            files = git("diff-tree", "--no-commit-id", "--name-only", "-r", "--root", sha).split()
            commits.append({"sha": sha, "author": author, "date": date, "subject": subject,
                            "body": body.strip(), "files": files})
    merges = git("rev-list", "--merges", f"{base}..HEAD").split() if base != head else []
    published = [c["sha"] for c in commits
                 if git("for-each-ref", "--contains", c["sha"], "--format=%(refname)", "refs/remotes").strip()]

    style_samples = git("log", "-n", "30", "--format=%s", base).splitlines()

    raw_diff = git("diff", "--no-renames", "--no-color", "--no-ext-diff", "--binary",
                   "--full-index", f"-U{args.context_lines}", base, target_tree)
    units = parse_units(raw_diff)

    cdir = composer_dir()
    ctx = {
        "version": 1, "mode": mode, "include_untracked": args.include_untracked,
        "branch": branch, "head": head, "base": base, "base_ref": base_ref,
        "target_tree": target_tree, "commits": commits, "merges_in_range": merges,
        "published_commits": published, "style_samples": style_samples,
        "units": units,
    }
    save_json(os.path.join(cdir, "context.json"), ctx)

    with open(os.path.join(cdir, "units.diff"), "w", encoding=ENC, errors=ERR) as f:
        for u in units:
            f.write(f"### {u['id']}  {u['path']}  [{u['status']}/{u['kind']}]  "
                    f"+{u['added']} -{u['removed']}  {u['label']}\n")
            f.write(u["header"] + u["body"])
            if not (u["header"] + u["body"]).endswith("\n"):
                f.write("\n")
            f.write("\n")

    # ---- summary ----
    print(f"Mode: {mode}   Branch: {branch or '(detached)'}")
    print(f"Base: {base[:10]} ({base_ref or 'no upstream found; using HEAD'})   HEAD: {head[:10]}")
    print(f"Uncommitted changes {'included' if mode in ('all', 'worktree') else 'NOT included'}"
          f"{' (untracked included)' if args.include_untracked else ''}; working tree dirty: {dirty}")
    if commits:
        print(f"\nLocal commits being recomposed ({len(commits)}, oldest first):")
        for c in commits:
            print(f"  {c['sha'][:8]}  {c['subject']}  [{len(c['files'])} files]")
    if merges:
        print(f"\nWARNING: {len(merges)} merge commit(s) in range; they will be flattened.")
    if published:
        print(f"\nWARNING: {len(published)} of these commits already exist on a remote. "
              "Rewriting them requires a force-push; confirm with the user.")
    print(f"\nUnits ({len(units)}):")
    for u in units:
        print(f"  {u['id']:>5}  {u['path']}  [{u['status']}/{u['kind']}]  "
              f"+{u['added']} -{u['removed']}  {u['label'][:70]}")
    if not units:
        print("  (nothing to compose)")
    print(f"\nFull patches: {os.path.join(cdir, 'units.diff')}")
    print(f"Context:      {os.path.join(cdir, 'context.json')}")


if __name__ == "__main__":
    main()