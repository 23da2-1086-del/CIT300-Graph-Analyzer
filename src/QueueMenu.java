/**
 * QueueMenu  (Member 2)
 * Console submenu for the Queue. Handles user input and calls QueueOperations.
 */
public class QueueMenu {

    private final QueueOperations queue;

    public QueueMenu(QueueOperations queue) {
        this.queue = queue;
    }

    public void show() {
        while (true) {
            System.out.println("\n--------------- QUEUE OPERATIONS ---------------");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Peek / Front");
            System.out.println("4. Display Queue");
            System.out.println("5. Return to Main Menu");
            int choice = InputHelper.readIntInRange("Enter your choice: ", 1, 5);

            switch (choice) {
                case 1:
                    if (queue.isFull()) {
                        System.out.println("Queue is full! (capacity " + QueueOperations.CAPACITY + "). Dequeue something first.");
                    } else {
                        int value = InputHelper.readInt("Enter a number to enqueue: ");
                        queue.enqueue(value);
                        System.out.println(value + " added to the back of the queue.");
                    }
                    break;
                case 2:
                    try {
                        System.out.println("Dequeued: " + queue.dequeue());
                    } catch (IllegalStateException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        System.out.println("Front of queue: " + queue.peek());
                    } catch (IllegalStateException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 4:
                    queue.display();
                    break;
                case 5:
                    return;
            }
        }
    }
}
