package hashtable;

public class Node<V> {

    protected String key;
    protected V value;
    protected Node next;

    public Node() {
        this.next = null;
    }

    public Node(String key, V value, Node next) {
        this.key = key;
        this.value = value;
        this.next = next;
    }

    @Override
    public java.lang.String toString() {
        return " (Key: " + this.key + " | Value: " + this.value + " | Next: " + this.next + ")";
    }

}
