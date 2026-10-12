import java.util.ArrayList;

/**
 * ResultsStore  (Member 3)
 * A shared "notebook" where every search and traversal result is recorded.
 * It is used by "Display All Results" and by the Performance Comparison menu.
 * All methods are static, so any class can call ResultsStore.add(...).
 */
public class ResultsStore {

    // One line in the results table.
    private static class Record {
        String operation;
        String algorithm;
        long steps;
        long timeNanos;
        String details;
    }

    private static final ArrayList<Record> records = new ArrayList<>();

    public static void add(String operation, String algorithm, long steps, long timeNanos, String details) {
        Record r = new Record();
        r.operation = operation;
        r.algorithm = algorithm;
        r.steps = steps;
        r.timeNanos = timeNanos;
        r.details = details;
        records.add(r);
    }

    public static int count() {
        return records.size();
    }

    public static void clear() {
        records.clear();
    }

    // Prints all recorded results as a table.
    public static void displayAll() {
        System.out.println("\n=============================================");
        System.out.println(" PERFORMANCE COMPARISON / RECORDED RESULTS");
        System.out.println("=============================================");
        if (records.isEmpty()) {
            System.out.println("No results recorded yet. Run a search or a graph traversal first.");
            return;
        }
        System.out.printf("%-4s %-16s %-20s %-8s %-12s %s%n", "No.", "Operation", "Algorithm", "Steps", "Time (ns)", "Details");
        System.out.println("-------------------------------------------------------------------------------------------");
        int number = 1;
        for (Record r : records) {
            System.out.printf("%-4d %-16s %-20s %-8d %-12d %s%n",
                    number, r.operation, r.algorithm, r.steps, r.timeNanos, r.details);
            number++;
        }
        System.out.println("-------------------------------------------------------------------------------------------");
    }
}
