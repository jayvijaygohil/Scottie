"""Shared helpers for commit-composer scripts (stdlib only)."""
import json
import os
import re
import shutil
import subprocess
import sys
import tempfile

ENC = "utf-8"
ERR = "surrogateescape"  # round-trips non-UTF-8 bytes through str/JSON


def die(msg):
    sys.stderr.write(f"commit-composer: {msg}\n")
    sys.exit(1)


def run_git(args, env=None, input_text=None, check=True):
    """Run git, return (returncode, stdout, stderr) as str."""
    data = input_text.encode(ENC, ERR) if input_text is not None else None
    r = subprocess.run(
        ["git", "-c", "core.quotePath=false", *args],
        capture_output=True, env=env, input=data,
    )
    out = r.stdout.decode(ENC, ERR)
    err = r.stderr.decode(ENC, ERR)
    if check and r.returncode != 0:
        die(f"`git {' '.join(args)}` failed:\n{err.strip()}")
    return r.returncode, out, err


def git(*args, env=None, input_text=None):
    return run_git(list(args), env=env, input_text=input_text)[1]


def try_git(*args):
    code, out, _ = run_git(list(args), check=False)
    return out.strip() if code == 0 else None


def chdir_toplevel():
    top = try_git("rev-parse", "--show-toplevel")
    if not top:
        die("not inside a git work tree")
    os.chdir(top)
    return top


def composer_dir():
    path = git("rev-parse", "--git-path", "commit-composer").strip()
    os.makedirs(path, exist_ok=True)
    return path


def in_progress_operation():
    for name, label in [("rebase-merge", "rebase"), ("rebase-apply", "rebase/am"),
                        ("MERGE_HEAD", "merge"), ("CHERRY_PICK_HEAD", "cherry-pick"),
                        ("REVERT_HEAD", "revert"), ("BISECT_LOG", "bisect")]:
        if os.path.exists(git("rev-parse", "--git-path", name).strip()):
            return label
    return None


def compute_target_tree(mode, include_untracked):
    """Tree representing the final state the composed commits must add up to."""
    if mode == "commits":
        return git("rev-parse", "HEAD^{tree}").strip()
    real_index = git("rev-parse", "--git-path", "index").strip()
    tmpdir = tempfile.mkdtemp(prefix="commit-composer-")
    try:
        tmp_index = os.path.join(tmpdir, "index")
        env = {**os.environ, "GIT_INDEX_FILE": tmp_index}
        if os.path.exists(real_index):
            shutil.copyfile(real_index, tmp_index)
        else:
            git("read-tree", "HEAD", env=env)
        git("add", "-u", env=env)          # tracked edits/deletions (+ staged new files)
        if include_untracked:
            git("add", "-A", env=env)      # untracked, honouring .gitignore
        return git("write-tree", env=env).strip()
    finally:
        shutil.rmtree(tmpdir, ignore_errors=True)


def _path_from_diff_line(line):
    rest = line[len("diff --git "):].rstrip("\n")
    if rest.startswith('"'):
        # quoted paths: "a/x y" "b/x y"
        m = re.match(r'"a/(.*)" "b/', rest)
        if m:
            return bytes(m.group(1), ENC, ERR).decode("unicode_escape").encode("latin-1").decode(ENC, ERR)
    # with --no-renames both sides are identical: "a/P b/P" -> len = 2*len(P) + 5
    plen = (len(rest) - 5) // 2
    return rest[2:2 + plen]


def parse_units(raw):
    """Split a `git diff` into composable units (hunks, or whole files)."""
    units = []
    blocks = re.split(r"(?m)^(?=diff --git )", raw)
    for block in blocks:
        if not block.startswith("diff --git "):
            continue
        lines = block.splitlines(keepends=True)
        path = _path_from_diff_line(lines[0])
        first_hunk = next((i for i, l in enumerate(lines) if l.startswith("@@")), len(lines))
        header = "".join(lines[:first_hunk])
        is_binary = "GIT binary patch" in block or "\nBinary files " in block
        status = ("added" if "\nnew file mode" in header else
                  "deleted" if "\ndeleted file mode" in header else
                  "mode-change" if "\nold mode" in header else "modified")
        hunks, cur = [], None
        for l in lines[first_hunk:]:
            if l.startswith("@@"):
                cur = [l]
                hunks.append(cur)
            elif cur is not None:
                cur.append(l)

        def stats(body_lines):
            add = sum(1 for l in body_lines if l.startswith("+") and not l.startswith("+++"))
            rem = sum(1 for l in body_lines if l.startswith("-") and not l.startswith("---"))
            return add, rem

        if is_binary or status != "modified" or len(hunks) <= 1:
            add, rem = stats(lines[first_hunk:])
            units.append({"path": path, "kind": "binary" if is_binary else "file",
                          "status": status, "header": header,
                          "body": "".join(lines[first_hunk:]),
                          "added": add, "removed": rem,
                          "label": "binary" if is_binary else (hunks[0][0].strip() if hunks else status)})
        else:
            for h in hunks:
                add, rem = stats(h)
                units.append({"path": path, "kind": "hunk", "status": status,
                              "header": header, "body": "".join(h),
                              "added": add, "removed": rem, "label": h[0].strip()})
    for i, u in enumerate(units, 1):
        u["id"] = f"u{i}"
    return units


def load_json(path):
    with open(path, encoding=ENC) as f:
        return json.load(f)


def save_json(path, obj):
    with open(path, "w", encoding=ENC, errors=ERR) as f:
        json.dump(obj, f, indent=2)