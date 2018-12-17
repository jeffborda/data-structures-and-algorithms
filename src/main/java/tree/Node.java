package tree;

public class Node {

    int value;
    protected Node left;
    protected Node right;

    public Node(int value, Node left, Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}
