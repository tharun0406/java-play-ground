
/**
 * A stack implemented with an array.
 *
 * Stack order is LIFO: the last value pushed is the first value popped.
 * push, pop, and peek are all O(1).
 */
public class Stacks {

    private final int[] elements;
    private int size;

    public Stacks(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be positive");
        }
        elements = new int[capacity];
    }

    /** Adds a value to the top of the stack. */
    public void push(int value) {
        if (isFull()) {
            throw new IllegalStateException("Stack overflow");
        }
        elements[size++] = value;
    }

    /** Removes and returns the value at the top. */
    public int pop() {
        ensureNotEmpty();
        return elements[--size];
    }

    /** Returns the top value without removing it. */
    public int peek() {
        ensureNotEmpty();
        return elements[size - 1];
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
            throw new IllegalStateException("Stack underflow");
        }
    }

    @Override
    public String toString() {
        StringBuilder values = new StringBuilder("bottom [");
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                values.append(", ");
            }
            values.append(elements[i]);
        }
        return values.append("] top").toString();
    }

    public static void main(String[] args) {
        Stacks stack = new Stacks(4);
        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Stack: " + stack);
        System.out.println("Peek: " + stack.peek());
        System.out.println("Pop: " + stack.pop());
        System.out.println("After pop: " + stack + ", size = " + stack.size());
    }
}
