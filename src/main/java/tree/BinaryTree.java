package tree;

import java.util.ArrayList;

public class BinaryTree<T> {

    public Node<T> root;

    public BinaryTree() {
        this.root = null;
    }
    public BinaryTree(Node<T> root) {
        this.root  = root;
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
