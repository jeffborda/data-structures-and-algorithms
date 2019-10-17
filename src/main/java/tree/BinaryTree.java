package tree;

// My data structures
import stacksandqueues.Queue;
import linkedlist.LinkedList;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


public class BinaryTree<T extends Comparable<? super T>> {

    public Node<T> root;

    public BinaryTree() {
        this.root = null;
    }
    public BinaryTree(Node<T> root) {
        this.root  = root;
    }


    /**
     *  This method takes in a BinaryTree and returns boolean on whether or not it is a BinarySearchTree
     */
    public static boolean isBinarySearchTree(BinaryTree<Integer> inputTree) {
        // Call the recursive helper method
        return isBinarySearchTree(inputTree.root, null, null);
    }

    private static boolean isBinarySearchTree(Node<Integer> root, Node<Integer> left, Node<Integer> right) {

        if(root == null) {
            return true;
        }
        if(left != null && left.value >= root.value) {
            return false;
        }
        if(right != null && right.value <= root.value) {
            return false;
        }

        return isBinarySearchTree(root.left, left, root) && isBinarySearchTree(root.right, root, right);
    }

    /**
     * This method takes the binary tree and returns an ArrayList of LinkedLists of the nodes at each depth of the tree.
     */
    public ArrayList<LinkedList<T>> binaryTreeToLinkedListByDepth() {
        Queue<Node<T>> qOne = new Queue<>(); // Using my Queue class
        Queue<Node<T>> qTwo = new Queue<>();
        ArrayList<LinkedList<T>> result = new ArrayList<>(); // Using java.util.ArrayList

        if(this.root != null) {
            qOne.enqueue(this.root);
        }

        LinkedList<T> depthList = new LinkedList<>(); // Using my LinkedList class

        while(!qOne.isEmpty()) {
            Node<T> n = qOne.dequeue();
            depthList.insert(n.value);
            // Enqueue right first so values are added left to right since LinkedList insert adds from the head.
            if(n.right != null) {
                qTwo.enqueue(n.right);
            }
            if(n.left != null) {
                qTwo.enqueue(n.left);
            }

            if(qOne.isEmpty()) {
                qOne = qTwo;
                qTwo = new Queue<>();
                result.add(depthList);
                depthList = new LinkedList<>();
            }
        }
        return result;
    }

    /**
     * Takes in two binary trees and returns a set of values found in both trees.
     */
    public static <T> Set<T> treeIntersection(BinaryTree treeOne, BinaryTree treeTwo) {
        // TODO: Refactor the unchecked assignment
        Set<T> setTreeOne = integerTreeToSet(treeOne);
        Set<T> setTreeTwo = integerTreeToSet(treeTwo);
        Set<T> sharedValues = new HashSet<>();

        for(T n : setTreeTwo) {
            if(!setTreeOne.add(n)) {
                // If it can't add to the Set of the first tree values, then it's a dupe value
                sharedValues.add(n);
            }
        }
        return sharedValues;
    }

    /**
     * Takes in a BinaryTree and returns it in a breadth-first ordered list.
     */
    private static <T> Set<T> integerTreeToSet(BinaryTree input) {
        java.util.Queue<Node<T>> nodes = new java.util.LinkedList<>();
        Set<T> result = new HashSet<>();
        if(input.root != null) {
            nodes.add(input.root);
        }
        while(!nodes.isEmpty()) {
            Node<T> current = nodes.remove();
            result.add(current.value);
            if(current.left != null) {
                nodes.add(current.left);
            }
            if(current.right != null) {
                nodes.add(current.right);
            }
        }
        return result;
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
