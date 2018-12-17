package tree;

import java.util.ArrayList;

public class BinaryTree {

    public Node root = null;

    public BinaryTree(Node root) {
        this.root  = root;
    }

    public ArrayList<Integer> inOrder() {
        ArrayList<Integer> result = new ArrayList<>();
        Node current = root;

        preOrderHelper(result, root);

        return result;
    }

    public ArrayList<Integer> preOrder() {
        ArrayList<Integer> result = new ArrayList<>();
        Node current = root;

        inOrderHelper(result, current);

        return result;
    }

    public ArrayList<Integer> postOrder() {
        ArrayList<Integer> result = new ArrayList<>();
        Node current = root;

        postOrderHelper(result, current);
        return result;
    }

    private void preOrderHelper(ArrayList list, Node current) {
        if(current == null) {
            return;
        }

        preOrderHelper(list, current.left);
        list.add(current.value);
        preOrderHelper(list, current.right);
    }

    private void inOrderHelper(ArrayList list, Node current) {
        if(current == null) {
            return;
        }

        list.add(current.value);
        preOrderHelper(list, current.left);
        preOrderHelper(list, current.right);
    }

    private void postOrderHelper(ArrayList list, Node current) {
        if(current == null) {
            return;
        }
        postOrderHelper(list, current.left);
        postOrderHelper(list, current.right);
        list.add(current.value);
    }



}
