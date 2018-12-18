package tree;

public class BinarySearchTree<T extends Comparable<T>> extends BinaryTree {

    public BinarySearchTree() {
        super();
    }

    public boolean add(T value) {
        Node<T> current = root;

        if (root == null) {
            root = new Node<T>(value, null, null);
            return true;
        }

        while (current != null) {
            if (value == current.value) {
                return false;
            }
            else if (value.compareTo(current.value) < 0) {
                if (current.left != null) {
                    current = current.left;
                }
                else {
                    current.left = new Node<T>(value, null, null);
                    return true;
                }
            }
            else {
                if(current.right != null) {
                    current = current.right;
                }
                else {
                    current.right = new Node<T>(value, null, null);
                    return true;
                }
            }
        }
        return false;
    }

    public Node<T> find(T value) {
        Node<T> current = root;

        while (current != null) {

            if(value == current.value) {
                return current;
            }

            if(value.compareTo(current.value) < 0) {
                current = current.left;
            }
            else {
                current = current.right;
            }
        }
        return null;
    }
}
