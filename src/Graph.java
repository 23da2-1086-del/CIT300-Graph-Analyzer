import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Graph  (Member 4)
 * An UNDIRECTED, unweighted graph stored as an ADJACENCY LIST:
 * each vertex name is a key, and its value is the list of neighbours.
 *
 *   A : [B, C]
 *   B : [A, D]
 *
 * Memory: O(V + E).   BFS and DFS time: O(V + E).
 * "Steps" in this class = vertices visited + edges examined (neighbour checks).
 */
public class Graph {

    // LinkedHashMap keeps vertices in the order they were added (nice for display).
    private final Map<String, List<String>> adjacencyList = new LinkedHashMap<>();
    private int edgeCount = 0;

    // ---------- basic operations ----------

    public boolean isEmpty()                { return adjacencyList.isEmpty(); }
    public int getVertexCount()             { return adjacencyList.size(); }
    public int getEdgeCount()               { return edgeCount; }
    public boolean hasVertex(String name)   { return adjacencyList.containsKey(name); }

    public List<String> getVertices() {
        return new ArrayList<>(adjacencyList.keySet());
    }

    public boolean hasEdge(String a, String b) {
        return hasVertex(a) && adjacencyList.get(a).contains(b);
    }

    // Returns false if the vertex already exists.
    public boolean addVertex(String name) {
        if (hasVertex(name)) {
            return false;
        }
        adjacencyList.put(name, new ArrayList<>());
        return true;
    }

    // Returns false if a vertex is missing, both are the same, or the edge already exists.
    public boolean addEdge(String a, String b) {
        if (!hasVertex(a) || !hasVertex(b) || a.equals(b) || hasEdge(a, b)) {
            return false;
        }
        adjacencyList.get(a).add(b);
        adjacencyList.get(b).add(a);      // undirected: add in both directions
        edgeCount++;
        return true;
    }

    public void clear() {
        adjacencyList.clear();
        edgeCount = 0;
    }

    // Replaces the graph with a small example graph (handy for demonstrations).
    public void loadSampleGraph() {
        clear();
        String[] names = {"A", "B", "C", "D", "E", "F"};
        for (String n : names) {
            addVertex(n);
        }
        addEdge("A", "B");
        addEdge("A", "C");
        addEdge("B", "D");
        addEdge("C", "D");
        addEdge("C", "E");
        addEdge("D", "F");
        addEdge("E", "F");
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Graph is empty.");
            return;
        }
        System.out.println("Graph (" + getVertexCount() + " vertices, " + edgeCount + " edges) - adjacency list:");
        for (Map.Entry<String, List<String>> entry : adjacencyList.entrySet()) {
            System.out.println("  " + entry.getKey() + " -> " + entry.getValue());
        }
    }

    // ---------- BFS ----------

    /**
     * Breadth-First Search: visit the start vertex, then all its neighbours,
     * then the neighbours of those neighbours (level by level). Uses a QUEUE.
     * Returns null if the start vertex does not exist.
     */
    public TraversalResult bfs(String start) {
        if (!hasVertex(start)) {
            return null;
        }
        long startTime = System.nanoTime();
        List<String> order = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new ArrayDeque<>();
        int steps = 0;
        int peak = 0;

        visited.add(start);
        queue.add(start);
        peak = 1;

        while (!queue.isEmpty()) {
            String current = queue.remove();     // take from the FRONT
            order.add(current);
            steps++;                             // one vertex visited
            for (String neighbour : adjacencyList.get(current)) {
                steps++;                         // one edge examined
                if (!visited.contains(neighbour)) {
                    visited.add(neighbour);      // mark when added, so it is never added twice
                    queue.add(neighbour);        // add to the BACK
                }
            }
            peak = Math.max(peak, queue.size());
        }

        long elapsed = System.nanoTime() - startTime;
        return new TraversalResult("BFS", start, order, steps, peak, elapsed);
    }

    // ---------- DFS ----------

    // Counters used while the recursive DFS runs.
    private int dfsSteps;
    private int dfsPeakDepth;

    /**
     * Depth-First Search: go as DEEP as possible along one path, then backtrack.
     * Uses RECURSION (the program's call stack works like a stack).
     * Returns null if the start vertex does not exist.
     */
    public TraversalResult dfs(String start) {
        if (!hasVertex(start)) {
            return null;
        }
        long startTime = System.nanoTime();
        List<String> order = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        dfsSteps = 0;
        dfsPeakDepth = 0;

        dfsVisit(start, visited, order, 1);

        long elapsed = System.nanoTime() - startTime;
        return new TraversalResult("DFS", start, order, dfsSteps, dfsPeakDepth, elapsed);
    }

    private void dfsVisit(String current, Set<String> visited, List<String> order, int depth) {
        visited.add(current);
        order.add(current);
        dfsSteps++;                              // one vertex visited
        dfsPeakDepth = Math.max(dfsPeakDepth, depth);

        for (String neighbour : adjacencyList.get(current)) {
            dfsSteps++;                          // one edge examined
            if (!visited.contains(neighbour)) {
                dfsVisit(neighbour, visited, order, depth + 1);   // go deeper
            }
        }
    }

    // ---------- search: shortest path (using BFS) ----------

    /**
     * Finds the path with the FEWEST edges between two vertices using BFS.
     * Returns an empty list if there is no path (or a vertex does not exist).
     */
    public List<String> shortestPath(String from, String to) {
        if (!hasVertex(from) || !hasVertex(to)) {
            return new ArrayList<>();
        }
        Map<String, String> cameFrom = new HashMap<>();   // remembers how we reached each vertex
        Queue<String> queue = new ArrayDeque<>();
        cameFrom.put(from, null);
        queue.add(from);

        while (!queue.isEmpty()) {
            String current = queue.remove();
            if (current.equals(to)) {
                break;
            }
            for (String neighbour : adjacencyList.get(current)) {
                if (!cameFrom.containsKey(neighbour)) {
                    cameFrom.put(neighbour, current);
                    queue.add(neighbour);
                }
            }
        }

        List<String> path = new ArrayList<>();
        if (!cameFrom.containsKey(to)) {
            return path;                          // 'to' was never reached
        }
        for (String v = to; v != null; v = cameFrom.get(v)) {
            path.add(v);                          // walk backwards from 'to' to 'from'
        }
        Collections.reverse(path);
        return path;
    }
}
