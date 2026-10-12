# Test Plan

Run the program with `java -cp out Main`. For each test, type the **Input** (one item per line, in order, starting
from the main menu), compare with **Expected**, then write what really happened in **Actual** and mark **Pass/Fail**.
**Leave Actual and Pass/Fail blank until you have run the test yourself.**

Tester name: ____________  Date: ____________  Java version: ____________

## A. Array (Member 1)
| ID | Test | Input | Expected | Actual | Pass/Fail |
|---|---|---|---|---|---|
| A1 | Insert at end | `1`,`1`,`10` then `1`,`30`, `6` | Display shows [10, 30] | | |
| A2 | Insert at index | `2`,`1`,`99` then `6` | [10, 99, 30] | | |
| A3 | Delete at index | `3`,`0` then `6` | "Deleted 10 from index 0", [99, 30] | | |
| A4 | Delete by value (exists) | `4`,`30` | "First occurrence of 30 deleted." | | |
| A5 | Delete by value (missing) | `4`,`555` | "Value 555 was not found" | | |
| A6 | Search found | `5`,`99` | "Found 99 at index 0 after 1 step(s)" | | |
| A7 | Search missing | `5`,`12345` | "was not found" with step count | | |
| A8 | Delete on empty array | `8` (clear), `3` | "Array is empty! Nothing to delete." | | |
| A9 | Letters instead of number | `abc` at insert value prompt | "Invalid input!..." and asks again | | |
| A10 | Index out of range | `2`, index `50` (size is small) | "Please enter a number between 0 and size" | | |
| A11 | Array full (boundary) | `7`,`100` then `1`,`5` | "Array is full! (capacity 100)" | | |
| A12 | Random fill | `7`,`15` | 15 numbers between 1 and 100 shown | | |

## B. Stack (Member 2)
| ID | Test | Input | Expected | Actual | Pass/Fail |
|---|---|---|---|---|---|
| B1 | Pop empty | `2`,`2` | "Error: Stack is empty! Nothing to pop." | | |
| B2 | Peek empty | `2`,`3` | "Error: Stack is empty! Nothing to peek." | | |
| B3 | Push and display | push 1,2,3 then `4` | 3 shown at TOP, then 2, then 1 | | |
| B4 | Peek | `3` | "Top of stack: 3" (not removed) | | |
| B5 | Pop order (LIFO) | `2` | "Popped: 3" | | |
| B6 | Stack full (boundary) | push 10 numbers, then push again | "Stack is full! (capacity 10)" | | |
| B7 | Invalid value | push, type `abc` | "Invalid input!..." | | |

## C. Queue (Member 2)
| ID | Test | Input | Expected | Actual | Pass/Fail |
|---|---|---|---|---|---|
| C1 | Dequeue empty | `3`,`2` | "Error: Queue is empty! Nothing to dequeue." | | |
| C2 | Peek empty | `3`,`3` | "Error: Queue is empty! Nothing at the front." | | |
| C3 | Enqueue and display | enqueue 1,2,3 then `4` | FRONT -> 1 \| 2 \| 3 <- REAR | | |
| C4 | Dequeue order (FIFO) | `2` | "Dequeued: 1" | | |
| C5 | Queue full | enqueue until 10 items, then once more | "Queue is full! (capacity 10)" | | |
| C6 | Wrap-around | fill 10, dequeue 3, enqueue 3 new, display | Items 4..10 then the 3 new ones, in order | | |

## D. Linked List (Member 3)
| ID | Test | Input | Expected | Actual | Pass/Fail |
|---|---|---|---|---|---|
| D1 | Insert head/tail | `4`,`1`,`20` ; `1`,`10` ; `2`,`30` ; `7` | HEAD -> 10 -> 20 -> 30 -> null | | |
| D2 | Insert at position | `3`,`1`,`15` ; `7` | 10 -> 15 -> 20 -> 30 | | |
| D3 | Search found | `6`,`30` | "Found 30 at position 3 after 4 step(s)" | | |
| D4 | Search missing | `6`,`777` | "not found (4 steps)" | | |
| D5 | Delete by value | `4`,`10` ; `7` | 15 -> 20 -> 30 | | |
| D6 | Delete missing value | `4`,`999` | "was not found in the list" | | |
| D7 | Delete tail then insert tail | delete `30`, insert tail `40`, display | ... -> 20 -> 40 -> null | | |
| D8 | Delete everything | delete until empty, display | "Linked list is empty." | | |
| D9 | Delete on empty | `4` or `5` on empty list | "List is empty! Nothing to delete." | | |
| D10 | Position out of range | `3`, position `99` | "Please enter a number between 0 and size" | | |

## E. Searching (Member 1)
| ID | Test | Input | Expected | Actual | Pass/Fail |
|---|---|---|---|---|---|
| E1 | Search on empty array | `5`,`1` | "Array is empty! Go to Array Operations..." | | |
| E2 | Binary on unsorted | fill random, `5`,`2` | Warns "NOT sorted", asks to sort | | |
| E3 | Decline sort | answer `n` | "Search cancelled." | | |
| E4 | Accept sort | answer `y` | Sorted array shown, then search runs | | |
| E5 | Compare both | `5`,`3`, target | Table with both algorithms; binary steps <= about log2(n)+1 | | |
| E6 | Bad y/n answer | type `maybe` | "Please type y or n." | | |

## F. Graph (Member 4)
| ID | Test | Input | Expected | Actual | Pass/Fail |
|---|---|---|---|---|---|
| F1 | BFS on empty graph | `6`,`4` | "Graph is empty! Add vertices first..." | | |
| F2 | Add vertices | `1` A, B, C | "Vertex 'A' added." etc. | | |
| F3 | Duplicate vertex | `1` A again | "Vertex 'A' already exists." | | |
| F4 | Vertex with space | `1`, `a b` | "Please enter a single word without spaces." | | |
| F5 | Add edge | `2` A B | "Edge A - B added." | | |
| F6 | Duplicate edge | `2` A B again | "Edge A - B already exists." | | |
| F7 | Self loop | `2` A A | "A vertex cannot connect to itself." | | |
| F8 | Edge with missing vertex | `2` A Z | "Both vertices must already exist." | | |
| F9 | Sample graph display | `7` then `3` | A -> [B, C]; B -> [A, D]; C -> [A, D, E]; D -> [B, C, F]; E -> [C, F]; F -> [D, E] | | |
| F10 | BFS from A | `4`, `A` | [A, B, C, D, E, F], Steps 20, Peak 2 | | |
| F11 | DFS from A | `5`, `A` | [A, B, D, C, E, F], Steps 20, Peak 6 | | |
| F12 | Missing start vertex | `4`, `Z` | "Vertex 'Z' does not exist." | | |
| F13 | Shortest path | `6`, `A`, `F` | A -> B -> D -> F (3 edge(s)) | | |
| F14 | No path | add vertex X (no edges), path A to X | "No path exists between A and X." | | |
| F15 | Disconnected note | BFS from A with X unconnected | Note that some vertices were not reached | | |

## G. Performance, Results, Main Menu (Members 3 and 2)
| ID | Test | Input | Expected | Actual | Pass/Fail |
|---|---|---|---|---|---|
| G1 | Quick demo | `7`,`3` | Search tables for n=100, 1000, 10000 (linear = n steps; binary 6, 9, 13), BFS/DFS 20 steps, results table | | |
| G2 | Custom size | `7`,`1`, size `100000`, option `4` | Linear and linked list = 100000 steps, binary = 16 | | |
| G3 | Size out of range | `7`,`1`, size `5` | "Please enter a number between 10 and 100000." | | |
| G4 | Traversal with empty graph | `7`,`2` | Offers to load the sample graph | | |
| G5 | Results table | `7`,`4` | All recorded rows listed with numbers | | |
| G6 | Clear results | `7`,`6`, then `4` | "No results recorded yet." | | |
| G7 | Explanation | `7`,`5` | Text about O(n), O(log n), O(V+E) | | |
| G8 | Display All Results | `8` | Current content of all 5 structures, then results table | | |
| G9 | Main menu invalid | `0`, `10`, `abc` | Each time: error message, menu asks again | | |
| G10 | Exit | `9` | Goodbye message, program ends | | |
| G11 | Integration | Add data in Array, Stack, Queue, List, Graph, then `8` | Everything appears in Display All Results | | |

## Troubleshooting
| Problem | Fix |
|---|---|
| `'javac' is not recognized` | Install a JDK (not just a JRE) and reopen PowerShell. Check with `javac -version` |
| `class X is public, should be declared in a file named X.java` | File name must match the class name exactly |
| `cannot find symbol` | A file is missing from `src` or not compiled. Compile all files together |
| `Could not find or load main class Main` | Run from the project folder with `java -cp out Main` |
| Program ends immediately | Input finished (e.g. piped file ended). Run it interactively |
| Strange characters | Use a UTF-8 terminal, or ignore; all menu text is plain ASCII |
