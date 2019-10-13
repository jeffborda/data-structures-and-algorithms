package tree;

public class BinarySearchTree<T extends Comparable<T>> extends BinaryTree {

    public BinarySearchTree() {
        super();
    }


    //Given a sorted array (low to high) return a balanced BST
    public static BinarySearchTree<Integer> sortedArrayToBST(int[] sortedArr) {
        BinarySearchTree<Integer> answer = new BinarySearchTree<>();
        answer.root = sortedArrayToBST(sortedArr, 0, sortedArr.length - 1);
        return answer;
    }

    private static Node<Integer> sortedArrayToBST(int[] arr, int start, int end) {
        if(end < start) {
            return null;
        }
        int mid = (start + end) / 2;
        Node<Integer> n = new Node<>(arr[mid]);
        n.left = sortedArrayToBST(arr, start, mid - 1);
        n.right = sortedArrayToBST(arr, mid + 1, end);
        return n;
    }

    public boolean add(T value) {
        Node<T> current = root;
        // Check if tree is empty, if so, set the root to new node
        if (root == null) {
            root = new Node<T>(value, null, null);
            return true;
        }
        // Otherwise iterate through the tree
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
