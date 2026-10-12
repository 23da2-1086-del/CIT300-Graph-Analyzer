/**
 * SearchResult  (Member 1)
 * A small "box" that holds the outcome of one search:
 * which algorithm, where the value was found, how many steps, how long it took.
 * Used by Array search, Linked List search and the Performance menu.
 */
public class SearchResult {

    private final String algorithm;
    private final int index;        // position where the value was found, or -1 if not found
    private final int steps;        // number of elements examined (comparisons)
    private final long timeNanos;   // execution time in nanoseconds

    public SearchResult(String algorithm, int index, int steps, long timeNanos) {
        this.algorithm = algorithm;
        this.index = index;
        this.steps = steps;
        this.timeNanos = timeNanos;
    }

    public String getAlgorithm() { return algorithm; }
    public int getIndex()        { return index; }
    public boolean isFound()     { return index >= 0; }
    public int getSteps()        { return steps; }
    public long getTimeNanos()   { return timeNanos; }
}
