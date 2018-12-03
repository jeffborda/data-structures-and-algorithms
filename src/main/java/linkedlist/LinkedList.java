package linkedlist;

public class LinkedList {

    private Node head;
    private Node current;

    public LinkedList() {
        this.head = null;
    }

    /**
     * Inserts a value to the first position of the list.
     */
    public void insert(String value) {

        this.head = new Node(value, head);

    }

    /**
     * Checks if list contains a value, returns true/false.
     */
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

    /**
     * Prints the entire list.
     */
    public void print() {
        current = head;
        while(current != null) {
            System.out.println(current.value);
            current = current.next;
        }
    }




}
