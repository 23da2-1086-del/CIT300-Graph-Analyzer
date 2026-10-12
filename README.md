# Data Structure & Graph Performance Analyzer

**Module:** CIT300 Data Structures and Algorithms – Graded Practical Assignment 2
**Type:** Console-based Java application (one integrated system)

## Project Description
A menu-driven Java console application that lets the user work with an **Array, Stack, Queue,
Linked List, Searching algorithms (Linear and Binary) and a Graph (BFS and DFS)**, and then
**compare the performance** of the algorithms using step counts and execution time.

## Group Members
> Replace every [placeholder]. Each member must write their OWN contribution honestly.

| Student Name | Student ID | Assigned Responsibility |
|---|---|---|
| [Member 1 full name] | [ID] | Array and Searching |
| [Member 2 full name] | [ID] | Stack, Queue, Main Menu, Input Validation |
| [Member 3 full name] | [ID] | Linked List and Performance Comparison |
| [Member 4 full name] | [ID] | Graph, Documentation and Final Testing |

### Individual Contributions
**Member 1 – [name], [ID]** (Array and Searching)
- Files: `ArrayOperations.java`, `ArrayMenu.java`, `SearchOperations.java`, `SearchResult.java`, `SearchMenu.java`
- [Describe what YOU implemented, tested, changed or improved]

**Member 2 – [name], [ID]** (Stack, Queue, Main Menu)
- Files: `StackOperations.java`, `StackMenu.java`, `QueueOperations.java`, `QueueMenu.java`, `InputHelper.java`, `Main.java`
- [Describe what YOU implemented, tested, changed or improved]

**Member 3 – [name], [ID]** (Linked List, Performance)
- Files: `LinkedListOperations.java`, `LinkedListMenu.java`, `ResultsStore.java`, `PerformanceMenu.java`
- [Describe what YOU implemented, tested, changed or improved]

**Member 4 – [name], [ID]** (Graph, Documentation, Testing)
- Files: `Graph.java`, `TraversalResult.java`, `GraphMenu.java`, `README.md`, `TEST_PLAN.md`
- [Describe what YOU implemented, tested, changed or improved]

## Technologies Used
- Java (JDK 17 or newer recommended; tested with JDK 21 class libraries)
- Git and GitHub (branches, commits, pull requests)

## Main Features
- **Array** (capacity 100): insert at end/index, delete by index/value, search, display, random fill, clear
- **Stack** (array, capacity 10): push, pop, peek, display; handles empty and full
- **Queue** (circular array, capacity 10): enqueue, dequeue, peek, display; handles empty and full
- **Linked List** (singly, head and tail): insert at head/tail/position, delete by value/position, search, display
- **Searching:** Linear Search and Binary Search with step counts and time; automatic "sort first?" check; side-by-side comparison
- **Graph** (undirected, adjacency list): add vertex, add edge, display, BFS, DFS, shortest path (search), sample graph
- **Performance Comparison:** Linear vs Binary vs Linked List search for n up to 100000; BFS vs DFS with steps, peak storage and time; results table; explanation of complexity
- **Display All Results:** current contents of every structure plus every recorded result
- **Input validation:** letters, empty input, out-of-range numbers, duplicate/missing vertices are all handled

## Folder Structure
```
CIT300-Graph-Analyzer/
├── src/
│   ├── Main.java                  (Member 2)
│   ├── InputHelper.java           (Member 2)
│   ├── StackOperations.java       (Member 2)
│   ├── StackMenu.java             (Member 2)
│   ├── QueueOperations.java       (Member 2)
│   ├── QueueMenu.java             (Member 2)
│   ├── ArrayOperations.java       (Member 1)
│   ├── ArrayMenu.java             (Member 1)
│   ├── SearchResult.java          (Member 1)
│   ├── SearchOperations.java      (Member 1)
│   ├── SearchMenu.java            (Member 1)
│   ├── LinkedListOperations.java  (Member 3)
│   ├── LinkedListMenu.java        (Member 3)
│   ├── ResultsStore.java          (Member 3)
│   ├── PerformanceMenu.java       (Member 3)
│   ├── Graph.java                 (Member 4)
│   ├── TraversalResult.java       (Member 4)
│   └── GraphMenu.java             (Member 4)
├── docs/  (MEMBER_GUIDE.md, GITHUB_GUIDE.md, TEST_PLAN.md)
├── run.bat
├── .gitignore
└── README.md
```

## How to Compile and Run
Open PowerShell in the project folder (the folder that contains `src`).
```powershell
mkdir out
javac -d out (Get-ChildItem -Path src -Filter *.java | ForEach-Object { $_.FullName })
java -cp out Main
```
Or just double-click `run.bat`. If `javac` is not recognised, install a JDK (not only a JRE).

## Complexity Summary
| Operation | Complexity |
|---|---|
| Array insert/delete in the middle | O(n) |
| Stack push/pop/peek, Queue enqueue/dequeue/peek | O(1) |
| Linked list insert at head/tail | O(1) |
| Linked list search/delete by value | O(n) |
| Linear search | O(n) |
| Binary search (sorted data) | O(log n) |
| BFS and DFS (adjacency list) | O(V + E) |

## Testing Status
See `docs/TEST_PLAN.md`. **Actual results are recorded in that file by the group after running the tests.**
Status: [update this line honestly, e.g. "All tests run on dd/mm/yyyy – 40/40 passed"]

## GitHub Workflow
One shared repository; each member works on their own branch (`member1-array-searching`,
`member2-stack-queue-menu`, `member3-linkedlist-performance`, `member4-graph-docs`),
commits their own work, and opens a pull request into `main` that another member reviews.
See `docs/GITHUB_GUIDE.md`.
