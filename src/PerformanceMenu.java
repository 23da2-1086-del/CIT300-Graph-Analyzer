/**
 * PerformanceMenu  (Member 3)
 * Compares algorithms using STEPS and EXECUTION TIME.
 *  - Searching: Linear Search (array), Binary Search (array), Linked List Search
 *  - Graph traversal: BFS and DFS (uses the shared Graph object)
 * Every result is saved in ResultsStore.
 */
public class PerformanceMenu {

    private final Graph graph;

    public PerformanceMenu(Graph graph) {
        this.graph = graph;
    }

    public void show() {
        while (true) {
            System.out.println("\n--------------- PERFORMANCE COMPARISON ---------------");
            System.out.println("1. Compare Searching Algorithms (choose data size)");
            System.out.println("2. Compare Graph Traversals (BFS vs DFS)");
            System.out.println("3. Run Quick Full Demo (searching + graph)");
            System.out.println("4. Show Results Table");
            System.out.println("5. Explain the Results (complexity)");
            System.out.println("6. Clear Recorded Results");
            System.out.println("7. Return to Main Menu");
            int choice = InputHelper.readIntInRange("Enter your choice: ", 1, 7);

            switch (choice) {
                case 1:
                    chooseAndCompareSearching();
                    break;
                case 2:
                    compareTraversals(false);
                    break;
                case 3:
                    runQuickDemo();
                    break;
                case 4:
                    ResultsStore.displayAll();
                    break;
                case 5:
                    explainResults();
                    break;
                case 6:
                    ResultsStore.clear();
                    System.out.println("Recorded results cleared.");
                    break;
                case 7:
                    return;
            }
        }
    }

    private void chooseAndCompareSearching() {
        int n = InputHelper.readIntInRange("How many numbers in the data set (10 - 100000)? ", 10, 100000);
        System.out.println("Which target should we search for?");
        System.out.println("1. First element (best case for linear search)");
        System.out.println("2. Middle element");
        System.out.println("3. Last element");
        System.out.println("4. A value that is NOT in the data (worst case)");
        int targetCase = InputHelper.readIntInRange("Enter your choice: ", 1, 4);
        runSearchComparison(n, targetCase);
    }

    // Builds the sorted data (2, 4, 6, ... 2n), then runs all three searches on it.
    private void runSearchComparison(int n, int targetCase) {
        int[] data = new int[n];
        LinkedListOperations list = new LinkedListOperations();
        for (int i = 0; i < n; i++) {
            data[i] = (i + 1) * 2;          // sorted even numbers
            list.insertAtTail(data[i]);     // same numbers in a linked list
        }

        int target;
        String caseName;
        switch (targetCase) {
            case 1:  target = data[0];     caseName = "first element";  break;
            case 2:  target = data[n / 2]; caseName = "middle element"; break;
            case 3:  target = data[n - 1]; caseName = "last element";   break;
            default: target = 1;           caseName = "not in data (worst case)"; break;
        }

        SearchResult linear = SearchOperations.linearSearch(data, target);
        SearchResult binary = SearchOperations.binarySearch(data, target);
        SearchResult linked = list.search(target);

        System.out.println("\nData: sorted numbers 2, 4, ... " + (n * 2) + " (n = " + n + ")");
        System.out.println("Target: " + target + " (" + caseName + ")");
        System.out.printf("%-20s %-8s %-10s %-12s%n", "Algorithm", "Found?", "Steps", "Time (ns)");
        System.out.println("---------------------------------------------------");
        printAndSave(linear, n, target, caseName);
        printAndSave(binary, n, target, caseName);
        printAndSave(linked, n, target, caseName);
    }

    private void printAndSave(SearchResult r, int n, int target, String caseName) {
        System.out.printf("%-20s %-8s %-10d %-12d%n",
                r.getAlgorithm(), r.isFound() ? "Yes" : "No", r.getSteps(), r.getTimeNanos());
        ResultsStore.add("Search", r.getAlgorithm(), r.getSteps(), r.getTimeNanos(),
                "n=" + n + ", target=" + target + " (" + caseName + ")");
    }

    // 'useFirstVertex' = true skips asking the user for the start vertex (used by the quick demo).
    private void compareTraversals(boolean useFirstVertex) {
        if (graph.isEmpty()) {
            System.out.println("The graph is empty.");
            if (useFirstVertex || InputHelper.readYesNo("Load the sample graph?")) {
                graph.loadSampleGraph();
                System.out.println("Sample graph loaded.");
            } else {
                return;
            }
        }
        graph.display();
        String start;
        if (useFirstVertex) {
            start = graph.getVertices().get(0);
        } else {
            start = InputHelper.readWord("Enter the start vertex: ");
            if (!graph.hasVertex(start)) {
                System.out.println("Vertex '" + start + "' does not exist.");
                return;
            }
        }
        TraversalResult bfs = graph.bfs(start);
        TraversalResult dfs = graph.dfs(start);

        System.out.println("\nTraversal from vertex " + start + ":");
        System.out.printf("%-12s %-8s %-14s %-12s %s%n", "Algorithm", "Steps", "Peak storage", "Time (ns)", "Visit order");
        System.out.println("-------------------------------------------------------------------");
        printTraversal(bfs);
        printTraversal(dfs);
        System.out.println("Peak storage = largest queue size (BFS) or deepest recursion (DFS).");
    }

    private void printTraversal(TraversalResult t) {
        System.out.printf("%-12s %-8d %-14d %-12d %s%n",
                t.getAlgorithm(), t.getSteps(), t.getPeakStorage(), t.getTimeNanos(), t.getOrder());
        ResultsStore.add("Graph Traversal", t.getAlgorithm(), t.getSteps(), t.getTimeNanos(),
                "start=" + t.getStart() + ", order=" + t.getOrder() + ", peak=" + t.getPeakStorage());
    }

    private void runQuickDemo() {
        System.out.println("Running searching comparison for n = 100, 1000 and 10000 (worst case)...");
        runSearchComparison(100, 4);
        runSearchComparison(1000, 4);
        runSearchComparison(10000, 4);
        System.out.println("\nRunning graph traversal comparison...");
        compareTraversals(true);
        ResultsStore.displayAll();
    }

    private void explainResults() {
        System.out.println("\n--------------- HOW TO EXPLAIN THE RESULTS ---------------");
        System.out.println("Linear Search (array)  : checks one by one.            Worst case O(n).");
        System.out.println("Binary Search (array)  : halves the data each step.    Worst case O(log n).");
        System.out.println("                         Needs SORTED data.");
        System.out.println("Linked List Search     : must follow links node by node. O(n), same steps as");
        System.out.println("                         linear search, but usually slower in time because the");
        System.out.println("                         nodes are scattered in memory.");
        System.out.println("BFS and DFS            : both visit every vertex and look at every edge once");
        System.out.println("                         from each side, so both are O(V + E). Their STEP counts");
        System.out.println("                         are therefore usually equal for the same start vertex.");
        System.out.println("                         They differ in the ORDER they visit vertices and in the");
        System.out.println("                         storage they need (BFS uses a queue, DFS uses a stack /");
        System.out.println("                         recursion).");
        System.out.println("Time (ns) is measured with System.nanoTime(). It changes from run to run");
        System.out.println("(computer load, Java warm-up), so STEPS are the reliable measure.");
    }
}
