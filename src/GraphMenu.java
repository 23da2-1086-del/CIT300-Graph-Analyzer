import java.util.List;

/**
 * GraphMenu  (Member 4)
 * Console submenu for the Graph. Validates input, calls Graph, and records
 * BFS/DFS results in ResultsStore.
 */
public class GraphMenu {

    private final Graph graph;

    public GraphMenu(Graph graph) {
        this.graph = graph;
    }

    public void show() {
        while (true) {
            System.out.println("\n--------------- GRAPH OPERATIONS ---------------");
            System.out.println("1. Add Vertex");
            System.out.println("2. Add Edge");
            System.out.println("3. Display Graph");
            System.out.println("4. BFS Traversal");
            System.out.println("5. DFS Traversal");
            System.out.println("6. Search: Shortest Path between two Vertices");
            System.out.println("7. Load Sample Graph");
            System.out.println("8. Clear Graph");
            System.out.println("9. Return to Main Menu");
            int choice = InputHelper.readIntInRange("Enter your choice: ", 1, 9);

            switch (choice) {
                case 1:
                    addVertex();
                    break;
                case 2:
                    addEdge();
                    break;
                case 3:
                    graph.display();
                    break;
                case 4:
                    traverse(true);
                    break;
                case 5:
                    traverse(false);
                    break;
                case 6:
                    findShortestPath();
                    break;
                case 7:
                    graph.loadSampleGraph();
                    System.out.println("Sample graph loaded (old graph was replaced).");
                    graph.display();
                    break;
                case 8:
                    graph.clear();
                    System.out.println("Graph cleared.");
                    break;
                case 9:
                    return;
            }
        }
    }

    private void addVertex() {
        String name = InputHelper.readWord("Enter vertex name (one word, e.g. A): ");
        if (graph.addVertex(name)) {
            System.out.println("Vertex '" + name + "' added.");
        } else {
            System.out.println("Vertex '" + name + "' already exists.");
        }
    }

    private void addEdge() {
        if (graph.getVertexCount() < 2) {
            System.out.println("You need at least 2 vertices before adding an edge.");
            return;
        }
        System.out.println("Existing vertices: " + graph.getVertices());
        String a = InputHelper.readWord("Enter first vertex: ");
        String b = InputHelper.readWord("Enter second vertex: ");
        if (!graph.hasVertex(a) || !graph.hasVertex(b)) {
            System.out.println("Both vertices must already exist.");
        } else if (a.equals(b)) {
            System.out.println("A vertex cannot connect to itself.");
        } else if (graph.hasEdge(a, b)) {
            System.out.println("Edge " + a + " - " + b + " already exists.");
        } else {
            graph.addEdge(a, b);
            System.out.println("Edge " + a + " - " + b + " added.");
        }
    }

    // bfs = true runs BFS, false runs DFS.
    private void traverse(boolean bfs) {
        if (graph.isEmpty()) {
            System.out.println("Graph is empty! Add vertices first (or load the sample graph).");
            return;
        }
        System.out.println("Existing vertices: " + graph.getVertices());
        String start = InputHelper.readWord("Enter the start vertex: ");
        if (!graph.hasVertex(start)) {
            System.out.println("Vertex '" + start + "' does not exist.");
            return;
        }
        TraversalResult result = bfs ? graph.bfs(start) : graph.dfs(start);
        System.out.println(result.getAlgorithm() + " order: " + result.getOrder());
        System.out.println("Visited " + result.getOrder().size() + " of " + graph.getVertexCount()
                + " vertices.   Steps: " + result.getSteps()
                + "   Peak storage: " + result.getPeakStorage()
                + "   Time: " + result.getTimeNanos() + " ns");
        if (result.getOrder().size() < graph.getVertexCount()) {
            System.out.println("Note: some vertices are not connected to " + start + ", so they were not reached.");
        }
        ResultsStore.add("Graph Traversal", result.getAlgorithm(), result.getSteps(), result.getTimeNanos(),
                "start=" + start + ", order=" + result.getOrder() + ", peak=" + result.getPeakStorage());
    }

    private void findShortestPath() {
        if (graph.getVertexCount() < 2) {
            System.out.println("You need at least 2 vertices.");
            return;
        }
        System.out.println("Existing vertices: " + graph.getVertices());
        String from = InputHelper.readWord("Enter start vertex: ");
        String to = InputHelper.readWord("Enter target vertex: ");
        if (!graph.hasVertex(from) || !graph.hasVertex(to)) {
            System.out.println("Both vertices must exist.");
            return;
        }
        List<String> path = graph.shortestPath(from, to);
        if (path.isEmpty()) {
            System.out.println("No path exists between " + from + " and " + to + ".");
        } else {
            System.out.println("Shortest path: " + String.join(" -> ", path) + "  (" + (path.size() - 1) + " edge(s))");
        }
    }
}
