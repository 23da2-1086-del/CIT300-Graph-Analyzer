# Data Structure & Graph Performance Analyzer

**Module:** CIT300 Data Structures and Algorithms – Graded Practical Assignment 2
**Type:** Console-based Java application (one integrated system)

## Project Description
A menu-driven Java console application that lets the user work with an **Array, Stack, Queue,
Linked List, Searching algorithms (Linear and Binary) and a Graph (BFS and DFS)**, and then
**compare the performance** of the algorithms using step counts and execution time.

## Group Members

| Student Name | Student ID | Assigned Responsibility |
|---|---|---|
| M.F.M. Amry | 23DA2-1086 | Array and Searching |
| M.S.M. Saneej | 23DA2-0962 | Stack, Queue, Main Menu, Input Validation |
| M.N.M. Afrath | 23DA2-0689 | Linked List and Performance Comparison |
| N.M. Askan | 23DA2-1098 | Graph, Documentation and Final Testing |

### Individual Contributions

**Member 1 – M.F.M. Amry, 23DA2-1086** (Array and Searching)
- Files: `ArrayOperations.java`, `ArrayMenu.java`, `SearchOperations.java`, `SearchResult.java`, `SearchMenu.java`
- I implemented the array (insert at end or index, delete by index or value, search, display, random fill, clear) and Linear and Binary Search with step counts and execution time. I created `SearchResult.java` to store each search result and handled missing values and invalid indexes.

**Member 2 – M.S.M. Saneej, 23DA2-0962** (Stack, Queue, Main Menu)
- Files: `StackOperations.java`, `StackMenu.java`, `QueueOperations.java`, `QueueMenu.java`, `InputHelper.java`, `Main.java`
- I implemented the stack (LIFO) with push, pop, peek and display, and the circular-array queue (FIFO) with enqueue, dequeue, peek and display, including empty and full checks. I wrote `InputHelper.java` to validate input and `Main.java` to connect all sections through the main menu.

**Member 3 – M.N.M. Afrath, 23DA2-0689** (Linked List, Performance)
- Files: `LinkedListOperations.java`, `LinkedListMenu.java`, `ResultsStore.java`, `PerformanceMenu.java`
- I implemented the singly linked list (insert at head, tail or position, delete by value or position, search, display) with head and tail references. I also built the performance comparison, `ResultsStore.java` for recorded results, and `PerformanceMenu.java` to run comparisons and show them.

**Member 4 – N.M. Askan, 23DA2-1098** (Graph, Documentation, Testing)
- Files: `Graph.java`, `TraversalResult.java`, `GraphMenu.java`, `README.md`, `docs/TEST_PLAN.md`
- I implemented the undirected adjacency-list graph with BFS and DFS, `TraversalResult.java` for traversal results, and `GraphMenu.java` with input validation. I also prepared the README and the test plan and helped with final testing.

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
See `docs/TEST_PLAN.md`. Actual results are recorded in that file by the group after running the tests.
Status: Tests not yet run

## GitHub Workflow
One shared repository; each member works on their own branch (`member1-array-searching`,
`member2-stack-queue-menu`, `member3-linkedlist-performance`, `member4-graph-docs`),
commits their own work, and opens a pull request into `main` that another member reviews.
See `docs/GITHUB_GUIDE.md`.
