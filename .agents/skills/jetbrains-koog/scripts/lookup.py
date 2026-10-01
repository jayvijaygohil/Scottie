#!/usr/bin/env python3
"""Read retained Koog API contracts, Kotlin guides, and complete source examples.

Uses the Python standard library. Reads only this skill's references directory;
no documentation checkout, network, installation, or generated cache is needed.
"""

import argparse
import json
from pathlib import Path
import re

ROOT = Path(__file__).resolve().parents[1]
REFERENCES = ROOT / "references"
API = REFERENCES / "api"
GUIDES = REFERENCES / "guides"
EXAMPLES = REFERENCES / "kotlin-examples"
FRAGMENTS = REFERENCES / "kotlin-fragments"


def normalized(value):
    return re.sub(r"[^a-z0-9]", "", value.casefold())


def contracts():
    """Yield separately addressable declarations, retaining module variants."""
    for path in sorted(API.rglob("*.md")):
        for section in re.split(r"(?m)^## (?=ai\.koog\.)", path.read_text())[1:]:
            name = section.splitlines()[0]
            source = re.search(r"^Dokka ID: `([^`]+)`", section, re.M)
            if source:
                yield name, source[1], path, "## " + section.strip()


def headings(text):
    fence = None
    for index, line in enumerate(text.splitlines()):
        marker = re.match(r"^\s*(`{3,}|~{3,})", line)
        if marker:
            if fence is None:
                fence = marker[1][0]
            elif marker[1][0] == fence:
                fence = None
        elif fence is None:
            heading = re.match(r"^(#{1,6})\s+(.+)", line)
            if heading:
                yield index, len(heading[1]), heading[2]


def read_section(text, query):
    outline = list(headings(text))
    matches = [(i, level, title) for i, level, title in outline if query.casefold() in title.casefold()]
    if not matches:
        raise ValueError("Section not found")
    start, level, _ = matches[0]
    end = next((i for i, depth, _ in outline if i > start and depth <= level), None)
    return "\n".join(text.splitlines()[start:end])


def main():
    parser = argparse.ArgumentParser(description=__doc__)
    modes = parser.add_subparsers(dest="mode", required=True)
    api = modes.add_parser("api", help="Search a qualified symbol or preserved Dokka ID")
    api.add_argument("query")
    api.add_argument("--module", help="Restrict by module path, including variant prefixes")
    api.add_argument("--limit", type=int, default=8)
    guide = modes.add_parser("guide", help="Read a guide or list retained guide paths")
    guide.add_argument("path", nargs="?")
    guide.add_argument("--section")
    example = modes.add_parser("example", help="Find Kotlin examples; an exact filename prints its source")
    example.add_argument("query", nargs="?", default="")
    example.add_argument("--show", action="store_true", help="Print matching sources instead of a list")
    example.add_argument("--limit", type=int, default=8)
    args = parser.parse_args()
    if hasattr(args, "limit") and args.limit < 1:
        parser.error("--limit must be positive")

    if args.mode == "guide":
        if args.path is None:
            for path in sorted(GUIDES.rglob("*.md")):
                print(path.relative_to(GUIDES))
            return
        path = (GUIDES / args.path).resolve()
        if not path.is_relative_to(GUIDES.resolve()) or path.suffix != ".md" or not path.is_file():
            parser.error("Guide path must name a retained Markdown guide")
        text = path.read_text()
        if args.section:
            try:
                text = read_section(text, args.section)
            except ValueError as error:
                parser.error(str(error))
        print(text)
        return

    if args.mode == "example":
        manifest = json.loads((REFERENCES / "example-manifest.json").read_text())
        rows = manifest["examples"] + manifest["fragments"]
        exact = [row for row in rows if row["file"] == args.query]
        matches = exact or [row for row in rows if normalized(args.query) in normalized(row["file"])]
        if not matches:
            parser.exit(1, "No matching Kotlin examples.\n")
        show = args.show or bool(exact)
        for row in matches[:args.limit] if show else matches:
            if not show:
                print(row["file"])
                continue
            path = (FRAGMENTS if row["file"].endswith(".txt") else EXAMPLES) / row["file"]
            print(f"## {row['file']}\n\nFile: {path}")
            if row.get("requires_examples"):
                print("Required peer examples: " + ", ".join(row["requires_examples"]))
            for note in row["adaptations"]:
                print("Adaptation: " + note)
            if row.get("contains_placeholders"):
                print("This source includes intentional application placeholders.")
            if row.get("imports_without_exact_api_entry"):
                print("Guide-backed imports without an exact retained API entry: " + ", ".join(row["imports_without_exact_api_entry"]))
            print("\n```kotlin\n" + path.read_text().rstrip() + "\n```\n")
        print(f"Matched {len(matches)} Kotlin examples; " + (f"displayed {min(len(matches), args.limit)} sources." if show else "pass an exact filename to read one."))
        return

    query = normalized(args.query)
    matches = []
    for name, key, path, section in contracts():
        if query not in normalized(name) and query not in normalized(key):
            continue
        if args.module and normalized(args.module) not in normalized(key.split('/ai.koog.')[0]):
            continue
        matches.append((name, key, path, section))
    # A precise name or ID should return only the requested overload page(s).
    exact = [row for row in matches if args.query in {row[0], row[1]}]
    matches = exact or matches
    for _, _, path, section in matches[:args.limit]:
        print(f"Retained reference: {path}\n\n{section}\n")
    print(f"Matched {len(matches)} Kotlin symbol pages; displayed {min(len(matches), args.limit)}. Narrow the name/module or raise --limit.")
    if not matches:
        raise SystemExit(1)


if __name__ == "__main__":
    main()
