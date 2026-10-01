#!/usr/bin/env python3
"""Validate retained resources without the original documentation drop or network."""

import hashlib
import json
from pathlib import Path
import re
import subprocess
import sys
from urllib.parse import unquote

# Avoid creating a cache directory when importing the sibling lookup helper.
sys.dont_write_bytecode = True
from lookup import API, EXAMPLES, FRAGMENTS, GUIDES, REFERENCES, ROOT, contracts


def require(condition, message):
    if not condition:
        raise ValueError(message)


def main():
    manifest = json.loads((REFERENCES / "example-manifest.json").read_text())
    rows = manifest["examples"]
    require(manifest["count"] == len(rows) == 340, "Expected all 340 Kotlin source examples")
    names = {row["file"] for row in rows}
    require(len(names) == len(rows), "Duplicate example filename")
    require(names == {f.name for f in EXAMPLES.glob("*.kt")}, "Example files differ from the manifest")
    require(len({row["source_sha256"] for row in rows}) == 340, "Original source coverage is duplicated")
    packages = {row["package"]: row["file"] for row in rows if row["package"]}
    for row in rows:
        path = EXAMPLES / row["file"]
        require(path.resolve().is_relative_to(EXAMPLES.resolve()), "Example path escapes the bundle")
        source = path.read_text()
        require(hashlib.sha256(path.read_bytes()).hexdigest() == row["sha256"], f"Example digest mismatch: {path.name}")
        require(not re.search(r"java|python|groovy", source, re.I), f"Non-Kotlin reference in {path.name}")
        actual_dependencies = set()
        for name in re.findall(r"^import (ai\.koog\.agents\.example\.\S+)", source, re.M):
            owner = next((f for package, f in packages.items() if name.startswith(package + ".")), None)
            require(owner is not None, f"Missing peer example for {name}")
            actual_dependencies.add(owner)
        require(actual_dependencies == set(row["requires_examples"]), f"Peer dependency mismatch: {path.name}")
        for guide in row["guides"]:
            require((REFERENCES / guide).is_file(), f"Missing guide: {guide}")

    fragments = manifest["fragments"]
    require(manifest["fragment_count"] == len(fragments) == 12, "Expected all 12 additional Kotlin fragments")
    require({row["file"] for row in fragments} == {f.name for f in FRAGMENTS.glob("*.txt")}, "Fragment files differ from manifest")
    require(len({row["source_sha256"] for row in fragments}) == 12, "Original fragment coverage is duplicated")
    for row in fragments:
        path = FRAGMENTS / row["file"]
        require(path.resolve().is_relative_to(FRAGMENTS.resolve()), "Fragment path escapes the bundle")
        require(hashlib.sha256(path.read_bytes()).hexdigest() == row["sha256"], f"Fragment digest mismatch: {path.name}")
        require(not re.search(r"java|python|groovy", path.read_text(), re.I), f"Non-Kotlin reference in {path.name}")
        for guide in row["guides"]:
            require((REFERENCES / guide).is_file(), f"Missing fragment guide: {guide}")

    require(len(list(GUIDES.rglob("*.md"))) == 92, "Expected all 92 retained guides")
    entries = list(contracts())
    require(len(entries) == 7529, "Expected all 7,529 retained Kotlin API pages")
    require(len({key for _, key, _, _ in entries}) == len(entries), "Duplicate Dokka IDs")
    for name, key, path, section in entries:
        require("1.3.0-SNAPSHOT" in section, f"Lost source version: {name}")
        for signature in re.findall(r"```kotlin\n(.*?)\n```", section, re.S):
            require("ERROR" not in signature, f"Unresolved signature marked as Kotlin: {key}")

    local_links = 0
    markdown_files = [ROOT / "SKILL.md", *REFERENCES.rglob("*.md")]
    legacy_path = "1.3.0" + "/"
    for path in markdown_files:
        text = path.read_text()
        require(legacy_path not in text, f"Temporary-source dependency in {path}")
        require(not re.search(r"java|^\s*```[ \t]*(?:groovy|xml)\b", text, re.I | re.M), f"Non-Kotlin reference in {path}")
        require("--8<--" not in text and "<!--- KNIT" not in text, f"Unresolved documentation include in {path}")
        inline_links = re.findall(r"\[[^\]\n]*\]\(([^)\n]+)\)", text)
        definitions = re.findall(r"^\[(?!\^)[^\]\n]+\]:[ \t]*(\S+)", text, re.M)
        for target in inline_links + definitions:
            if re.match(r"(?:https?|mailto):", target) or target.startswith("#"):
                continue
            require(not re.match(r"[a-z]+:", target), f"Unresolved link scheme in {path}: {target}")
            relative = unquote(target.split("#", 1)[0])
            resolved = (path.parent / relative).resolve()
            require(resolved.is_relative_to(ROOT.resolve()), f"Link escapes the bundle: {target}")
            require(resolved.exists(), f"Missing local resource in {path}: {target}")
            local_links += 1

    index = (REFERENCES / "api-index.md").read_text()
    indexed = re.findall(r"\| \[[^\]]+\]\(api/([^)]+)\) \| (\d+) \|", index)
    for filename, count in indexed:
        actual = len(re.findall(r"^## ai\.koog\.", (API / filename).read_text(), re.M))
        require(actual == int(count), f"Incorrect topic count: {filename}")

    checks = [
        (["api", "LiteRTLLMClient", "--limit", "1"], 0, "LiteRTLLMClient"),
        (["api", "discoverSkills"], 0, "SkillCollisionPrecedence"),
        (["api", "SpringAiLLMClient", "--module", "koog-spring-ai-v2", "--limit", "1"], 0, "koog-spring-ai-v2"),
        (["guide", "prompts/http-clients.md", "--section", "How it works"], 0, "KtorKoogHttpClient"),
        (["example", "example-structured-data-07.kt"], 0, "Required peer examples:"),
        (["example", "example-embeddings-05.kt"], 0, "iterativeCode"),
        (["example", "example-spring-boot-kotlin-02.txt"], 0, "MessagePart.Text"),
        (["api", "no_such_koog_symbol"], 1, "Matched 0"),
        (["api", "skills", "--limit", "0"], 2, "--limit must be positive"),
        (["guide", "../../../SKILL.md"], 2, "retained Markdown guide"),
        (["example", "missing-example.kt"], 1, "No matching Kotlin examples"),
    ]
    for args, code, expected in checks:
        result = subprocess.run([sys.executable, str(ROOT / "scripts/lookup.py"), *args], capture_output=True, text=True)
        require(result.returncode == code and expected in result.stdout + result.stderr, f"Lookup check failed: {args}")

    print(f"Validated {len(rows)} Kotlin source examples, {len(fragments)} additional Kotlin fragments, 92 guides, {len(entries)} API pages, {local_links} local links, and lookup behavior.")
    print("No Kotlin compilation or provider execution was performed.")


if __name__ == "__main__":
    try:
        main()
    except (ValueError, OSError, KeyError) as error:
        sys.exit(str(error))
