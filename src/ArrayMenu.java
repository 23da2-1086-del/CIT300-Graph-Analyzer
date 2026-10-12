/**
 * ArrayMenu  (Member 1)
 * Console submenu for Array operations. Calls ArrayOperations and SearchOperations.
 */
public class ArrayMenu {

    private final ArrayOperations array;

    public ArrayMenu(ArrayOperations array) {
        this.array = array;
    }

    public void show() {
        while (true) {
            System.out.println("\n--------------- ARRAY OPERATIONS ---------------");
            System.out.println("1. Insert at End");
            System.out.println("2. Insert at Index");
            System.out.println("3. Delete at Index");
            System.out.println("4. Delete by Value");
            System.out.println("5. Search for a Value");
            System.out.println("6. Display Array");
            System.out.println("7. Fill with Random Numbers");
            System.out.println("8. Clear Array");
            System.out.println("9. Return to Main Menu");
            int choice = InputHelper.readIntInRange("Enter your choice: ", 1, 9);

            switch (choice) {
                case 1:
                    insertAtEnd();
                    break;
                case 2:
                    insertAtIndex();
                    break;
                case 3:
                    deleteAtIndex();
                    break;
                case 4:
                    deleteByValue();
                    break;
                case 5:
                    searchValue();
                    break;
                case 6:
                    array.display();
                    break;
                case 7:
                    int count = InputHelper.readIntInRange(
                            "How many random numbers (1-" + ArrayOperations.CAPACITY + ")? ",
                            1, ArrayOperations.CAPACITY);
                    array.fillRandom(count);
                    System.out.println(count + " random numbers (1-100) stored. Old data was replaced.");
                    array.display();
                    break;
                case 8:
                    array.clear();
                    System.out.println("Array cleared.");
                    break;
                case 9:
                    return;
            }
        }
    }

    private void insertAtEnd() {
        if (array.isFull()) {
            System.out.println("Array is full! (capacity " + ArrayOperations.CAPACITY + ")");
            return;
        }
        int value = InputHelper.readInt("Enter a number to insert: ");
        array.insertAtEnd(value);
        System.out.println(value + " inserted at the end.");
    }

    private void insertAtIndex() {
        if (array.isFull()) {
            System.out.println("Array is full! (capacity " + ArrayOperations.CAPACITY + ")");
            return;
        }
        int index = InputHelper.readIntInRange("Enter index (0 to " + array.getSize() + "): ", 0, array.getSize());
        int value = InputHelper.readInt("Enter a number to insert: ");
        array.insertAtIndex(index, value);
        System.out.println(value + " inserted at index " + index + ". Elements on the right were shifted.");
    }

    private void deleteAtIndex() {
        if (array.isEmpty()) {
            System.out.println("Array is empty! Nothing to delete.");
            return;
        }
        int index = InputHelper.readIntInRange("Enter index to delete (0 to " + (array.getSize() - 1) + "): ",
                0, array.getSize() - 1);
        int removed = array.deleteAtIndex(index);
        System.out.println("Deleted " + removed + " from index " + index + ".");
    }

    private void deleteByValue() {
        if (array.isEmpty()) {
            System.out.println("Array is empty! Nothing to delete.");
            return;
        }
        int value = InputHelper.readInt("Enter the value to delete: ");
        if (array.deleteByValue(value)) {
            System.out.println("First occurrence of " + value + " deleted.");
        } else {
            System.out.println("Value " + value + " was not found in the array.");
        }
    }

    // The basic "Search" operation of the array uses linear search (works on unsorted data).
    private void searchValue() {
        if (array.isEmpty()) {
            System.out.println("Array is empty! Nothing to search.");
            return;
        }
        int target = InputHelper.readInt("Enter the value to search for: ");
        SearchResult result = SearchOperations.linearSearch(array.toArray(), target);
        if (result.isFound()) {
            System.out.println("Found " + target + " at index " + result.getIndex()
                    + " after " + result.getSteps() + " step(s).");
        } else {
            System.out.println(target + " was not found (" + result.getSteps() + " steps).");
        }
    }
}
