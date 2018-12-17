package tree;

public class BinarySearchTree extends BinaryTree {

    public BinarySearchTree() {
        super();
    }

    public boolean add(int value) {
        Node current = root;

        if (root == null) {
            root = new Node(value, null, null);
            return true;
        }

        while (current != null) {
            if (value == current.value) {
                return false;
            }
            else if (value < current.value) {
                if (current.left != null) {
                    current = current.left;
                }
                else {
                    current.left = new Node(value, null, null);
                    return true;
                }
            }
            else {
                if(current.right != null) {
                    current = current.right;
                }
                else {
                    current.right = new Node(value, null, null);
                    return true;
                }
            }
        }
        return false;
    }

    public Node find(int value) {
        Node current = root;

        while (current != null) {

            if(value == current.value) {
                return current;
            }

            if(current.value < value) {
                current = current.left;
            }
            else {
                current = current.left;
            }
        }
        return null;
    }
}
