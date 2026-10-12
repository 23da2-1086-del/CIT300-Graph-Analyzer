/**
 * StackMenu  (Member 2)
 * Console submenu for the Stack. Handles user input and calls StackOperations.
 */
public class StackMenu {

    private final StackOperations stack;

    public StackMenu(StackOperations stack) {
        this.stack = stack;
    }

    public void show() {
        while (true) {
            System.out.println("\n--------------- STACK OPERATIONS ---------------");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Display Stack");
            System.out.println("5. Return to Main Menu");
            int choice = InputHelper.readIntInRange("Enter your choice: ", 1, 5);

            switch (choice) {
                case 1:
                    if (stack.isFull()) {
                        System.out.println("Stack is full! (capacity " + StackOperations.CAPACITY + "). Pop something first.");
                    } else {
                        int value = InputHelper.readInt("Enter a number to push: ");
                        stack.push(value);
                        System.out.println(value + " pushed onto the stack.");
                    }
                    break;
                case 2:
                    try {
                        System.out.println("Popped: " + stack.pop());
                    } catch (IllegalStateException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        System.out.println("Top of stack: " + stack.peek());
                    } catch (IllegalStateException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 4:
                    stack.display();
                    break;
                case 5:
                    return;
            }
        }
    }
}
