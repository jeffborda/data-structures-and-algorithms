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

        head = new Node(value, head);

    }

    /**
     * Adds a value to the last position of the list.
     */
    public void append(String value) {

        current = head;
        if(head == null) {
            head = new Node(value, null);
        }
        else {
            while(this.hasNext()) {
                current = current.next;
            }
            current.next = new Node(value, null);
        }
    }

    /**
     * Checks if list contains a value, if so, it inserts the newValue before the search value and returns true.
     * If value is not found in list, no insert is made, and method returns false.
     */
    public boolean insertBefore(String value, String newValue) {

        current = head;
        if(head == null) {
            return false;
        }
        if(head.value == value) {
            head = new Node(newValue, head);
            return true;
        }
        while(current.next != null) {
            if(current.next.value == value) {
                current.next = new Node(newValue, current.next);
                return true;
            }
            current = current.next;
        }
        return false;
    }

    /**
     * Checks if list contains a value, if so, it inserts the newValue after the search value and returns true.
     * If value is not found in list, no insert is made, and method returns false.
     */
    public boolean insertAfter(String value, String newValue) {

        current = head;
        while(current != null) {
            if(current.value == value) {
                current.next = new Node(newValue, current.next);
                return true;
            }
            current = current.next;
        }
        return false;
    }

    /**
     * Deletes a value from the list.  If multiple values exist in list, it will delete the first occurrence.
     * Returns true if value found and deleted.  Returns false if value was not found.
     */
    public boolean deleteValue(String value) {

        current = head;
        if(head == null) {
            return false;
        }
        if(head.value == value) {
            head = current.next;
            return true;
        }
        while(current.next != null) {
            if(current.next.value == value) {
                current.next = current.next.next;
                return true;
            }
            current = current.next;
        }
        return false;
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
     * Takes in an int, and returns the kth from the end Node's String.  If in is out of bounds,
     * the method returns null.
     */
    public String kFromEnd(int k) {

        if(k < 0 || head == null) {
            return null;
        }

        current = head;
        Node follower = head;
        int count = 0;

        while(this.hasNext()) {
            current = current.next;
            count++;
            if(count > k) {
                follower = follower.next;
            }
        }

        if(count < k) {
            return null;
        }
        return follower.value;
    }

    /**
     * Finds the Node in the middle of the LinkedList and returns its value.
     */
    public String findMiddleNode() {
        //if empty list, return null
        //set current to head
        //make a follower pointer
        //iterate through the list in while loop
        //   current pointer will move two nodes at a time
        //   follower pointer will move one node at a time
        //when current reaches last node or becomes null, return followerer value

        if(head == null) {
            return null;
        }

        current = head;
        Node follower = head;
        while(current.next != null) {
            if(current.next.next != null) {
                current = current.next.next;
            }
            else {
                return follower.next.value;
            }

            follower = follower.next;
        }
        return "super";
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

    /**
     * Helper function for testing, returns the last value in the list, or returns null for an empty list.
     */
    public String getLastValue() {
        if(head == null) {
            return null;
        }
        current = head;
        while(this.hasNext()) {
            current = current.next;
        }
        return current.value;
    }

    private boolean hasNext() {
        if(current.next != null) {
            return true;
        }
        return false;
    }
}
