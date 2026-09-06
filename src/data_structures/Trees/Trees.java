

/**
 * Binary-search-tree fundamentals for distinct integer values.
 *
 * For every node, smaller values are on the left and larger values are on the
 * right. Search and insertion take O(h), where h is the tree height.
 */
public class Trees {

    private static class Node {
        private final int value;
        private Node left;
        private Node right;

        Node(int value) {
            this.value = value;
        }
    }

    private Node root;

    /** Inserts a distinct value. Duplicate values are ignored. */
    public void insert(int value) {
        if (root == null) {
            root = new Node(value);
            return;
        }

        Node current = root;
        while (true) {
            if (value == current.value) {
                return;
            }
            if (value < current.value) {
                if (current.left == null) {
                    current.left = new Node(value);
                    return;
                }
                current = current.left;
            } else {
                if (current.right == null) {
                    current.right = new Node(value);
                    return;
                }
                current = current.right;
            }
        }
    }

    /** Searches for a value by following the BST ordering: O(h). */
    public boolean contains(int value) {
        Node current = root;
        while (current != null) {
            if (value == current.value) {
                return true;
            }
            current = value < current.value ? current.left : current.right;
        }
        return false;
    }

    /** In-order traversal of a BST produces sorted values. */
    public String inOrder() {
        StringBuilder values = new StringBuilder();
        inOrder(root, values);
        return values.toString().trim();
    }

    /** Height is the number of nodes on the longest root-to-leaf path. */
    public int height() {
        return height(root);
    }

    private void inOrder(Node node, StringBuilder values) {
        if (node == null) {
            return;
        }
        inOrder(node.left, values);
        values.append(node.value).append(' ');
        inOrder(node.right, values);
    }

    private int height(Node node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(height(node.left), height(node.right));
    }

    public static void main(String[] args) {
        Trees tree = new Trees();
        int[] values = {50, 30, 70, 20, 40, 60, 80};
        for (int value : values) {
            tree.insert(value);
        }

        System.out.println("In-order (sorted): " + tree.inOrder());
        System.out.println("Contains 60: " + tree.contains(60));
        System.out.println("Contains 99: " + tree.contains(99));
        System.out.println("Height: " + tree.height());
    }
}
