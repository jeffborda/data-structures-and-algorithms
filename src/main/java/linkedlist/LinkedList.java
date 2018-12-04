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
     * Prints the entire list with commas in between values.
     */
    public void print() {
        current = head;
        while(current != null) {
            System.out.print(current.value);
            if(current.next != null) {
                System.out.print(", ");
            }
            current = current.next;
        }
        if(head != null) {
            System.out.println();
        }
    }


    /**
     * Helper function for testing, returns the value of head, or returns null for an empty list.
     */
    public String getHeadValue() {
        if(head == null) {
            return null;
        }
        return head.value;
    }
}
