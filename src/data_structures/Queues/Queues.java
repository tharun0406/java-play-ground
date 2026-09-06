

/**
 * A fixed-capacity circular queue implemented with an array.
 *
 * Queue order is FIFO: the first value enqueued is the first value dequeued.
 * The circular index lets released array positions be reused.
 */
public class Queues {

    private final int[] elements;
    private int front;
    private int size;

    public Queues(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be positive");
        }
        elements = new int[capacity];
    }

    /** Adds a value to the rear of the queue: O(1). */
    public void enqueue(int value) {
        if (isFull()) {
            throw new IllegalStateException("Queue overflow");
        }
        int rear = (front + size) % elements.length;
        elements[rear] = value;
        size++;
    }

    /** Removes and returns the value at the front: O(1). */
    public int dequeue() {
        ensureNotEmpty();
        int value = elements[front];
        front = (front + 1) % elements.length;
        size--;
        return value;
    }

    /** Returns the next value to leave without removing it. */
    public int peek() {
        ensureNotEmpty();
        return elements[front];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == elements.length;
    }

    public int size() {
        return size;
    }

    private void ensureNotEmpty() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue underflow");
        }
    }

    @Override
    public String toString() {
        StringBuilder values = new StringBuilder("front [");
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                values.append(", ");
            }
            values.append(elements[(front + i) % elements.length]);
        }
        return values.append("] rear").toString();
    }

    public static void main(String[] args) {
        Queues queue = new Queues(3);
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        System.out.println("Queue: " + queue);

        System.out.println("Dequeue: " + queue.dequeue());
        queue.enqueue(40); // Reuses the first array position by wrapping around.
        System.out.println("After wrap-around: " + queue);
        System.out.println("Peek: " + queue.peek());
    }
}
