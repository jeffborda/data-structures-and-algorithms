package hashtable;

public class Node<String, V> {

    protected String key;
    protected V value;
    protected Node next;

    public Node() { }

    public Node(String key, V value, Node next) {
        this.key = key;
        this.value = value;
        this.next = null;
    }

}
