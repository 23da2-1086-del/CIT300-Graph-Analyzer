/**
 * LinkedListMenu  (Member 3)
 * Console submenu for the Linked List.
 */
public class LinkedListMenu {

    private final LinkedListOperations list;

    public LinkedListMenu(LinkedListOperations list) {
        this.list = list;
    }

    public void show() {
        while (true) {
            System.out.println("\n--------------- LINKED LIST OPERATIONS ---------------");
            System.out.println("1. Insert at Head (front)");
            System.out.println("2. Insert at Tail (end)");
            System.out.println("3. Insert at Position");
            System.out.println("4. Delete by Value");
            System.out.println("5. Delete at Position");
            System.out.println("6. Search for a Value");
            System.out.println("7. Display List");
            System.out.println("8. Return to Main Menu");
            int choice = InputHelper.readIntInRange("Enter your choice: ", 1, 8);

            switch (choice) {
                case 1: {
                    int value = InputHelper.readInt("Enter a number to insert: ");
                    list.insertAtHead(value);
                    System.out.println(value + " inserted at the head.");
                    break;
                }
                case 2: {
                    int value = InputHelper.readInt("Enter a number to insert: ");
                    list.insertAtTail(value);
                    System.out.println(value + " inserted at the tail.");
                    break;
                }
                case 3: {
                    int position = InputHelper.readIntInRange(
                            "Enter position (0 to " + list.getSize() + "): ", 0, list.getSize());
                    int value = InputHelper.readInt("Enter a number to insert: ");
                    list.insertAtPosition(position, value);
                    System.out.println(value + " inserted at position " + position + ".");
                    break;
                }
                case 4:
                    deleteByValue();
                    break;
                case 5:
                    deleteAtPosition();
                    break;
                case 6:
                    search();
                    break;
                case 7:
                    list.display();
                    break;
                case 8:
                    return;
            }
        }
    }

    private void deleteByValue() {
        if (list.isEmpty()) {
            System.out.println("List is empty! Nothing to delete.");
            return;
        }
        int value = InputHelper.readInt("Enter the value to delete: ");
        if (list.deleteByValue(value)) {
            System.out.println("First node with value " + value + " deleted.");
        } else {
            System.out.println("Value " + value + " was not found in the list.");
        }
    }

    private void deleteAtPosition() {
        if (list.isEmpty()) {
            System.out.println("List is empty! Nothing to delete.");
            return;
        }
        int position = InputHelper.readIntInRange(
                "Enter position to delete (0 to " + (list.getSize() - 1) + "): ", 0, list.getSize() - 1);
        int removed = list.deleteAtPosition(position);
        System.out.println("Deleted " + removed + " from position " + position + ".");
    }

    private void search() {
        if (list.isEmpty()) {
            System.out.println("List is empty! Nothing to search.");
            return;
        }
        int target = InputHelper.readInt("Enter the value to search for: ");
        SearchResult result = list.search(target);
        if (result.isFound()) {
            System.out.println("Found " + target + " at position " + result.getIndex()
                    + " after " + result.getSteps() + " step(s).");
        } else {
            System.out.println(target + " was not found (" + result.getSteps() + " steps).");
        }
        ResultsStore.add("Search", "Linked List Search", result.getSteps(), result.getTimeNanos(),
                "n=" + list.getSize() + ", target=" + target + ", " + (result.isFound() ? "found" : "not found"));
    }
}
