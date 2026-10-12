/**
 * SearchOperations  (Member 1)
 * Two searching algorithms. Both count their STEPS (how many elements they look at)
 * and measure their execution time using System.nanoTime().
 *
 *  - Linear Search : checks every element one by one.   Worst case O(n).
 *  - Binary Search : halves the search area each time.  Worst case O(log n).
 *                    IMPORTANT: the array MUST be sorted first.
 */
public class SearchOperations {

    // Linear search: look at elements from left to right until the target is found.
    public static SearchResult linearSearch(int[] arr, int target) {
        long startTime = System.nanoTime();
        int steps = 0;
        int foundIndex = -1;

        for (int i = 0; i < arr.length; i++) {
            steps++;                         // one element examined
            if (arr[i] == target) {
                foundIndex = i;
                break;
            }
        }

        long elapsed = System.nanoTime() - startTime;
        return new SearchResult("Linear Search", foundIndex, steps, elapsed);
    }

    // Binary search: compare with the MIDDLE element, then throw away half of the array.
    public static SearchResult binarySearch(int[] arr, int target) {
        long startTime = System.nanoTime();
        int steps = 0;
        int foundIndex = -1;
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;   // middle position (safe from overflow)
            steps++;                            // one element (the middle) examined
            if (arr[mid] == target) {
                foundIndex = mid;
                break;
            } else if (arr[mid] < target) {
                low = mid + 1;                  // target is in the right half
            } else {
                high = mid - 1;                 // target is in the left half
            }
        }

        long elapsed = System.nanoTime() - startTime;
        return new SearchResult("Binary Search", foundIndex, steps, elapsed);
    }
}
