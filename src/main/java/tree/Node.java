package tree;

public class Node<T extends Comparable<? super T>> {

    public T value;
    public Node<T> left;
    public Node<T> right;

    public Node(T value, Node left, Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public Node(T value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }


}
