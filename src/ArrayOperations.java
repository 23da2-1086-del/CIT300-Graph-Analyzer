import java.util.Arrays;
import java.util.Random;

/**
 * ArrayOperations  (Member 1)
 * A simple fixed-size array of integers (capacity 100) with a "size" counter.
 * Insert and delete in the middle must SHIFT elements, so they are O(n).
 * Reading an element by index is O(1).
 */
public class ArrayOperations {

    public static final int CAPACITY = 100;
    private final int[] data = new int[CAPACITY];
    private int size = 0;   // how many positions are really used

    public int getSize()     { return size; }
    public boolean isEmpty() { return size == 0; }
    public boolean isFull()  { return size == CAPACITY; }

    // Insert at the end. O(1). Returns false if the array is full.
    public boolean insertAtEnd(int value) {
        if (isFull()) {
            return false;
        }
        data[size] = value;
        size++;
        return true;
    }

    // Insert at a given index (0 to size). Elements to the right are shifted right. O(n).
    public boolean insertAtIndex(int index, int value) {
        if (isFull() || index < 0 || index > size) {
            return false;
        }
        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];          // shift right to make space
        }
        data[index] = value;
        size++;
        return true;
    }

    // Delete the element at an index. Elements to the right are shifted left. O(n).
    public int deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Index out of range: " + index);
        }
        int removed = data[index];
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];          // shift left to close the gap
        }
        size--;
        return removed;
    }

    // Delete the first element equal to value. Returns false if the value is not in the array.
    public boolean deleteByValue(int value) {
        for (int i = 0; i < size; i++) {
            if (data[i] == value) {
                deleteAtIndex(i);
                return true;
            }
        }
        return false;
    }

    // Remove all elements.
    public void clear() {
        size = 0;
    }

    // Replace the contents with 'count' random numbers between 1 and 100.
    public void fillRandom(int count) {
        Random random = new Random();
        clear();
        for (int i = 0; i < count && i < CAPACITY; i++) {
            insertAtEnd(random.nextInt(100) + 1);
        }
    }

    // Sort the array (insertion sort - simple to explain). O(n^2).
    public void sort() {
        for (int i = 1; i < size; i++) {
            int key = data[i];
            int j = i - 1;
            while (j >= 0 && data[j] > key) {
                data[j + 1] = data[j];
                j--;
            }
            data[j + 1] = key;
        }
    }

    // Binary search only works on sorted data, so we need this check.
    public boolean isSorted() {
        for (int i = 1; i < size; i++) {
            if (data[i - 1] > data[i]) {
                return false;
            }
        }
        return true;
    }

    // Returns a COPY containing only the used part of the array (length == size).
    public int[] toArray() {
        return Arrays.copyOf(data, size);
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Array is empty.");
            return;
        }
        System.out.println("Array (size " + size + "/" + CAPACITY + ", indexes start at 0):");
        System.out.println("  " + Arrays.toString(toArray()));
    }
}
