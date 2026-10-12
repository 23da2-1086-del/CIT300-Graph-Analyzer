import java.util.List;

/**
 * TraversalResult  (Member 4)
 * Holds the outcome of one graph traversal (BFS or DFS):
 * visit order, number of steps, peak storage used, and execution time.
 */
public class TraversalResult {

    private final String algorithm;
    private final String start;
    private final List<String> order;
    private final int steps;          // vertices visited + edges examined
    private final int peakStorage;    // max queue size (BFS) or max recursion depth (DFS)
    private final long timeNanos;

    public TraversalResult(String algorithm, String start, List<String> order,
                           int steps, int peakStorage, long timeNanos) {
        this.algorithm = algorithm;
        this.start = start;
        this.order = order;
        this.steps = steps;
        this.peakStorage = peakStorage;
        this.timeNanos = timeNanos;
    }

    public String getAlgorithm()    { return algorithm; }
    public String getStart()        { return start; }
    public List<String> getOrder()  { return order; }
    public int getSteps()           { return steps; }
    public int getPeakStorage()     { return peakStorage; }
    public long getTimeNanos()      { return timeNanos; }
}
