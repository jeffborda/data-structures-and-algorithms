package tree;

import stacksandqueues.Queue;

import java.util.ArrayList;

public class BinaryTree<T> {

    public Node<T> root;

    public BinaryTree() {
        this.root = null;
    }
    public BinaryTree(Node<T> root) {
        this.root  = root;
    }

    /*
     * This method prints the input tree with a breadth traversal.
     */
    public static void breadthFirst(BinaryTree input) {
        Queue<Node> nodes = new Queue<>();
        if(input.root != null) {
            nodes.enqueue(input.root);
        }
        int printCount = 0;
        while(nodes.size() > 0) {
            Node temp = nodes.dequeue();
            if(printCount > 0) {
                System.out.print(", ");
            }
            System.out.print(temp.value);
            printCount++;
            if(temp.left != null) {
                nodes.enqueue(temp.left);
            }
            if(temp.right != null) {
                nodes.enqueue(temp.right);
            }
        }
    }


    /**
     * This is a recursive method to find the sum of the odd numbers in a BinaryTree
     */
    public static int sumOfOdds(Node<Integer> root) {

        if(root == null) {
            return 0;
        }

        int sum = 0;
        if(root.value % 2 != 0) {
            sum = root.value;
        }
        return sum + sumOfOdds(root.left) + sumOfOdds(root.right);
    }

    public static int findMaxValue(BinaryTree tree) throws IllegalStateException {
        if(tree.root == null) {
            throw new IllegalStateException();
        }
        return findMaxHelper(tree.root);
    }

    private static int findMaxHelper(Node root) {
        int max = (int)root.value;
        if(root.left != null) {
            max = max(max, findMaxHelper(root.left));
        }
        if(root.right != null) {
            max = max(max, findMaxHelper(root.right));
        }
        return max;
    }

    private static int max(int a, int b) {
        if(a > b) {
            return a;
        }
        return b;
    }

    public ArrayList<T> inOrder() {
        ArrayList<T> result = new ArrayList<>();
        preOrderHelper(result, root);
        return result;
    }

    public ArrayList<T> preOrder() {
        ArrayList<T> result = new ArrayList<>();
        inOrderHelper(result, root);
        return result;
    }

    public ArrayList<T> postOrder() {
        ArrayList<T> result = new ArrayList<>();
        postOrderHelper(result, root);
        return result;
    }

    private void preOrderHelper(ArrayList list, Node<T> current) {
        if(current == null) {
            return;
        }

        preOrderHelper(list, current.left);
        list.add(current.value);
        preOrderHelper(list, current.right);
    }

    //Call inOrderHelper
    private void inOrderHelper(ArrayList list, Node<T> current) {
        if(current == null) {
            return;
        }

        list.add(current.value);
        inOrderHelper(list, current.left);
        inOrderHelper(list, current.right);
    }

    private void postOrderHelper(ArrayList list, Node<T> current) {
        if(current == null) {
            return;
        }
        postOrderHelper(list, current.left);
        postOrderHelper(list, current.right);
        list.add(current.value);
    }



}
