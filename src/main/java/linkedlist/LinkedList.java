package linkedlist;

public class LinkedList {

    private Node head;
    private Node current;

    public LinkedList() {
        this.head = null;
    }

    public void insert(String value) {

        this.head = new Node(value, head);

    }

    public boolean includes(String value) {

        current = head;
        while(current != null) {
            if(current.value == value) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void print() {
        current = head;
        while(current != null) {
            System.out.println(current.value);
            current = current.next;
        }
    }




}
