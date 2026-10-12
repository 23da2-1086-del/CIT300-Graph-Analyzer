/**
 * QueueOperations  (Member 2)
 * A Queue built on a CIRCULAR array. Rule: FIRST IN, FIRST OUT (FIFO).
 * The first item added is the first item removed (like a line at a shop).
 * "Circular" means that when we reach the end of the array we wrap back to index 0,
 * so freed spaces at the front can be reused. All main operations are O(1).
 */
public class QueueOperations {

    public static final int CAPACITY = 10;
    private final int[] data = new int[CAPACITY];
    private int front = 0;     // index of the first item
    private int count = 0;     // how many items are in the queue

    public boolean isEmpty() { return count == 0; }
    public boolean isFull()  { return count == CAPACITY; }
    public int getSize()     { return count; }

    // Adds a value at the back. Returns false if the queue is full.
    public boolean enqueue(int value) {
        if (isFull()) {
            return false;
        }
        int rear = (front + count) % CAPACITY;   // the % wraps the index back to 0
        data[rear] = value;
        count++;
        return true;
    }

    // Removes and returns the front value. Throws an error if the queue is empty.
    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty! Nothing to dequeue.");
        }
        int value = data[front];
        front = (front + 1) % CAPACITY;
        count--;
        return value;
    }

    // Returns the front value without removing it.
    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty! Nothing at the front.");
        }
        return data[front];
    }

    // Prints the queue from FRONT to REAR.
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        System.out.println("Queue (size " + count + "/" + CAPACITY + "):");
        StringBuilder line = new StringBuilder("  FRONT -> ");
        for (int i = 0; i < count; i++) {
            line.append(data[(front + i) % CAPACITY]);
            if (i < count - 1) {
                line.append(" | ");
            }
        }
        line.append(" <- REAR");
        System.out.println(line);
    }
}
