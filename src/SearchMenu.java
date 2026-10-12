/**
 * SearchMenu  (Member 1)
 * Lets the user run Linear Search and Binary Search on the array and
 * COMPARE them. Each search is saved to ResultsStore for the performance table.
 */
public class SearchMenu {

    private final ArrayOperations array;

    public SearchMenu(ArrayOperations array) {
        this.array = array;
    }

    public void show() {
        while (true) {
            System.out.println("\n--------------- SEARCHING OPERATIONS ---------------");
            System.out.println("1. Linear Search");
            System.out.println("2. Binary Search");
            System.out.println("3. Compare Linear vs Binary Search");
            System.out.println("4. Sort Array");
            System.out.println("5. Display Array");
            System.out.println("6. Return to Main Menu");
            int choice = InputHelper.readIntInRange("Enter your choice: ", 1, 6);

            switch (choice) {
                case 1:
                    runSingleSearch(false);
                    break;
                case 2:
                    runSingleSearch(true);
                    break;
                case 3:
                    compareBoth();
                    break;
                case 4:
                    array.sort();
                    System.out.println("Array sorted (ascending).");
                    array.display();
                    break;
                case 5:
                    array.display();
                    break;
                case 6:
                    return;
            }
        }
    }

    // Runs one search. 'binary' = true for binary search, false for linear search.
    private void runSingleSearch(boolean binary) {
        if (array.isEmpty()) {
            System.out.println("Array is empty! Go to Array Operations and add some numbers first.");
            return;
        }
        if (binary && !prepareSortedArray()) {
            return;
        }
        int target = InputHelper.readInt("Enter the value to search for: ");
        int[] copy = array.toArray();
        SearchResult result = binary ? SearchOperations.binarySearch(copy, target)
                                     : SearchOperations.linearSearch(copy, target);
        printResult(result, target);
        saveResult(result, target, copy.length);
    }

    // Runs BOTH searches on the same sorted array with the same target.
    private void compareBoth() {
        if (array.isEmpty()) {
            System.out.println("Array is empty! Go to Array Operations and add some numbers first.");
            return;
        }
        if (!prepareSortedArray()) {
            return;
        }
        int target = InputHelper.readInt("Enter the value to search for: ");
        int[] copy = array.toArray();
        SearchResult linear = SearchOperations.linearSearch(copy, target);
        SearchResult binary = SearchOperations.binarySearch(copy, target);

        System.out.println("\nComparison on " + copy.length + " sorted element(s), target = " + target);
        System.out.printf("%-16s %-10s %-8s %-12s%n", "Algorithm", "Found?", "Steps", "Time (ns)");
        System.out.println("--------------------------------------------------");
        printRow(linear);
        printRow(binary);
        System.out.println("Linear search can need up to n steps; binary search needs about log2(n) steps.");
        System.out.println("(Time in nanoseconds can vary a little between runs; the steps are exact.)");

        saveResult(linear, target, copy.length);
        saveResult(binary, target, copy.length);
    }

    // Binary search needs a sorted array. Offer to sort it. Returns false if the user says no.
    private boolean prepareSortedArray() {
        if (array.isSorted()) {
            return true;
        }
        System.out.println("The array is NOT sorted. Binary search only works on sorted data.");
        if (InputHelper.readYesNo("Sort the array now?")) {
            array.sort();
            System.out.println("Array sorted.");
            array.display();
            return true;
        }
        System.out.println("Search cancelled.");
        return false;
    }

    private void printResult(SearchResult result, int target) {
        if (result.isFound()) {
            System.out.println(result.getAlgorithm() + ": found " + target + " at index " + result.getIndex());
        } else {
            System.out.println(result.getAlgorithm() + ": " + target + " was NOT found.");
        }
        System.out.println("Steps: " + result.getSteps() + "   Time: " + result.getTimeNanos() + " ns");
    }

    private void printRow(SearchResult r) {
        System.out.printf("%-16s %-10s %-8d %-12d%n",
                r.getAlgorithm(), r.isFound() ? "Yes" : "No", r.getSteps(), r.getTimeNanos());
    }

    private void saveResult(SearchResult r, int target, int n) {
        String details = "n=" + n + ", target=" + target + ", " + (r.isFound() ? "found at index " + r.getIndex() : "not found");
        ResultsStore.add("Search", r.getAlgorithm(), r.getSteps(), r.getTimeNanos(), details);
    }
}
