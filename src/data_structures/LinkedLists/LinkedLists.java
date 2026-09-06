

/**
 * Singly linked-list fundamentals.
 *
 * A linked list stores each value in a node. Every node points to the next
 * node, so insertion at the front is O(1), while locating an index is O(n).
 */
public class LinkedLists {

    private static class Node {
        private final int value;
        private Node next;

        Node(int value) {
            this.value = value;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    /** Adds a value to the end of the list: O(1). */
    public void addLast(int value) {
        Node node = new Node(value);
        if (head == null) {
            head = node;
        } else {
            tail.next = node;
        }
        tail = node;
        size++;
    }

    /** Adds a value to the front of the list: O(1). */
    public void addFirst(int value) {
        Node node = new Node(value);
        node.next = head;
        head = node;
        if (tail == null) {
            tail = node;
        }
        size++;
    }

    /** Returns the value at an index: O(n). */
    public int get(int index) {
        return nodeAt(index).value;
    }

    /** Removes the first matching value and reports whether it was found: O(n). */
    public boolean remove(int value) {
        Node previous = null;
        Node current = head;

        while (current != null) {
            if (current.value == value) {
                if (previous == null) {
                    head = current.next;
                } else {
                    previous.next = current.next;
                }
                if (current == tail) {
                    tail = previous;
                }
                size--;
                return true;
            }
            previous = current;
            current = current.next;
        }
        return false;
    }

    /** Reverses all links in place: O(n). */
    public void reverse() {
        Node previous = null;
        Node current = head;
        tail = head;

        while (current != null) {
            Node next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        head = previous;
    }

    public int size() {
        return size;
    }

    private Node nodeAt(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", size: " + size);
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    @Override
    public String toString() {
        StringBuilder values = new StringBuilder("[");
        for (Node current = head; current != null; current = current.next) {
            if (values.length() > 1) {
                values.append(" -> ");
            }
            values.append(current.value);
        }
        return values.append(']').toString();
    }

    public static void main(String[] args) {
        LinkedLists list = new LinkedLists();
        list.addLast(20);
        list.addLast(30);
        list.addFirst(10);
        System.out.println("After adds: " + list);
        System.out.println("Value at index 1: " + list.get(1));

        list.remove(20);
        System.out.println("After removing 20: " + list);

        list.reverse();
        System.out.println("After reverse: " + list + ", size = " + list.size());
    }
}
