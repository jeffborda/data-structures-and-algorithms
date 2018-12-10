package stacksandqueues;

public class Node {

    protected String value;
    protected Node next = null;

    protected Node(String value, Node next) {
        this.value = value;
        this.next = next;
    }
}
