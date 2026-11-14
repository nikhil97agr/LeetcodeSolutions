# LeetCode Solutions Archive

A repository of LeetCode-oriented problem descriptions and solution sources for learning, revision, and reference.

## About this repository

The archive contains **4,088 problem folders**, **4,088 Markdown problem descriptions**, and **4,101 source files**. Each folder groups a problem description with one or more language-specific solutions.

Current source inventory:

| Language | Files |
| --- | ---: |
| Java | 3,675 |
| SQL | 321 |
| JavaScript | 44 |
| Python | 28 |
| TypeScript | 25 |
| Shell | 4 |
| C++ | 2 |
| Go | 2 |

## Repository structure

Browse the complete collection in [`src/`](src/).

```text
src/
└── two_sum_1/
    ├── 1-two-sum.md
    ├── Solution.java
    └── Solution.py
```

Each problem folder contains:

- **Problem description (`.md`):** the statement, difficulty, examples, constraints, and a link to the original LeetCode problem.
- **Solution files:** one or more language-specific files named `Solution.<extension>`.

> Folder names use a normalized problem title followed by the export identifier—for example, `two_sum_1`. Numeric title prefixes are spelled out so every folder name is a valid Java package identifier. The trailing identifier may differ from LeetCode's displayed problem number; use the problem title or the link in its description to identify a problem.

## Finding a solution

1. Open [`src/`](src/) and search for a problem's normalized title, such as `two_sum`.
2. Read the problem's `.md` file for context and the original LeetCode link.
3. Open a solution in your preferred language.

For example, start with [Two Sum](src/two_sum_1/).

To find a problem locally:

```bash
find src -maxdepth 1 -type d -iname '*two_sum*'
```

## Running the solutions

This is a source archive, not a single standalone application. Many solutions rely on the method signatures, test harnesses, schemas, or helper types supplied by LeetCode.

- **Java solutions:** each Java file declares the package matching its problem folder, allowing all solutions to coexist in an IDE. For direct LeetCode submission, remove the leading `package ...;` declaration. Local compilation may also require a driver or helper types such as `ListNode` and `TreeNode`.
- **Other algorithm solutions:** use the matching language environment and input assumptions from the original problem.
- **SQL solutions:** use the schema and SQL dialect specified by the original problem.

## Learning approach

Use this archive to compare approaches, revisit patterns, and understand trade-offs—not just to copy an answer. Try a problem independently first, then review a solution and work through why it succeeds.

This repository is a reference archive; it does not claim that every implementation is optimal, fully explained, or independently runnable outside its original problem environment.

## Attribution

Problem statements and platform-provided examples belong to LeetCode and their respective rights holders. This is a personal, unofficial solution archive and is not affiliated with or endorsed by LeetCode.
