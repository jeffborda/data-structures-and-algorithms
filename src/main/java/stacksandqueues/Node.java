package stacksandqueues;

public class Node<T> {

    protected T value;
    protected Node next = null;

    protected Node(T value, Node next) {
        this.value = value;
        this.next = next;
    }
}
