/**
 * StackOperations  (Member 2)
 * A Stack built on an array. Rule: LAST IN, FIRST OUT (LIFO).
 * The last item pushed is the first item popped.
 * All main operations are O(1) (they take the same time however many items there are).
 */
public class StackOperations {

    public static final int CAPACITY = 10;     // small on purpose, so "stack full" is easy to demonstrate
    private final int[] data = new int[CAPACITY];
    private int top = -1;                      // index of the top item; -1 means the stack is empty

    public boolean isEmpty() { return top == -1; }
    public boolean isFull()  { return top == CAPACITY - 1; }
    public int getSize()     { return top + 1; }

    // Adds a value on top. Returns false if the stack is full (overflow).
    public boolean push(int value) {
        if (isFull()) {
            return false;
        }
        top++;
        data[top] = value;
        return true;
    }

    // Removes and returns the top value. Throws an error if the stack is empty (underflow).
    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty! Nothing to pop.");
        }
        int value = data[top];
        top--;
        return value;
    }

    // Returns the top value without removing it.
    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty! Nothing to peek.");
        }
        return data[top];
    }

    // Prints the stack from TOP to BOTTOM.
    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return;
        }
        System.out.println("Stack (size " + getSize() + "/" + CAPACITY + "), top first:");
        for (int i = top; i >= 0; i--) {
            System.out.println(i == top ? "  | " + data[i] + " |  <-- TOP" : "  | " + data[i] + " |");
        }
        System.out.println("  +----+");
    }
}
