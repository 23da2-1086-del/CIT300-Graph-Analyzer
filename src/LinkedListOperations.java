/**
 * LinkedListOperations  (Member 3)
 * A SINGLY linked list of integers. Each Node stores a value and a link (next)
 * to the following node. We keep both a 'head' (first node) and a 'tail' (last node),
 * so inserting at the head or the tail is O(1). Searching is O(n).
 */
public class LinkedListOperations {

    // One box in the chain.
    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head = null;
    private Node tail = null;
    private int size = 0;

    public int getSize()     { return size; }
    public boolean isEmpty() { return size == 0; }

    // Insert at the front. O(1).
    public void insertAtHead(int value) {
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
        if (tail == null) {      // list was empty, so the new node is also the tail
            tail = newNode;
        }
        size++;
    }

    // Insert at the back. O(1) because we remember the tail.
    public void insertAtTail(int value) {
        Node newNode = new Node(value);
        if (tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    // Insert at a position (0 to size). O(n) because we must walk to that position.
    public boolean insertAtPosition(int position, int value) {
        if (position < 0 || position > size) {
            return false;
        }
        if (position == 0) {
            insertAtHead(value);
            return true;
        }
        if (position == size) {
            insertAtTail(value);
            return true;
        }
        Node current = head;
        for (int i = 0; i < position - 1; i++) {   // stop at the node BEFORE the position
            current = current.next;
        }
        Node newNode = new Node(value);
        newNode.next = current.next;
        current.next = newNode;
        size++;
        return true;
    }

    // Delete the first node that holds 'value'. Returns false if not found. O(n).
    public boolean deleteByValue(int value) {
        if (head == null) {
            return false;
        }
        if (head.data == value) {            // special case: the first node
            head = head.next;
            if (head == null) {
                tail = null;
            }
            size--;
            return true;
        }
        Node current = head;
        while (current.next != null && current.next.data != value) {
            current = current.next;
        }
        if (current.next == null) {
            return false;                    // reached the end, value not found
        }
        if (current.next == tail) {
            tail = current;
        }
        current.next = current.next.next;    // skip over the deleted node
        size--;
        return true;
    }

    // Delete the node at a position (0 to size-1). Returns the removed value.
    public int deleteAtPosition(int position) {
        if (position < 0 || position >= size) {
            throw new IllegalArgumentException("Position out of range: " + position);
        }
        int removed;
        if (position == 0) {
            removed = head.data;
            head = head.next;
            if (head == null) {
                tail = null;
            }
        } else {
            Node current = head;
            for (int i = 0; i < position - 1; i++) {
                current = current.next;
            }
            removed = current.next.data;
            if (current.next == tail) {
                tail = current;
            }
            current.next = current.next.next;
        }
        size--;
        return removed;
    }

    // Linear search through the nodes. Counts nodes visited as steps.
    public SearchResult search(int target) {
        long startTime = System.nanoTime();
        int steps = 0;
        int foundIndex = -1;
        Node current = head;
        int index = 0;
        while (current != null) {
            steps++;
            if (current.data == target) {
                foundIndex = index;
                break;
            }
            current = current.next;
            index++;
        }
        long elapsed = System.nanoTime() - startTime;
        return new SearchResult("Linked List Search", foundIndex, steps, elapsed);
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Linked list is empty.");
            return;
        }
        System.out.println("Linked list (size " + size + "):");
        StringBuilder line = new StringBuilder("  HEAD -> ");
        Node current = head;
        while (current != null) {
            line.append(current.data).append(" -> ");
            current = current.next;
        }
        line.append("null");
        System.out.println(line);
    }
}
