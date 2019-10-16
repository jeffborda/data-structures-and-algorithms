package linkedlist;

import java.util.StringJoiner;

public class LinkedList<T> {

    protected Node<T> head;

    public LinkedList() {
        this.head = null;
    }

    /**
     * Takes two LinkedLists and merges the nodes zipper style (L1, L2, L1, L2..) and returns a single LinkedList.
     */
    public static LinkedList merge(LinkedList one, LinkedList two) {

        if(one.head == null) {
            return two;
        }
        if(two.head == null) {
            return one;
        }

        Node list1Leader = one.head.next;
        Node list1Follower = one.head;
        Node twoCurrent = two.head;

        while(list1Leader != null) {
            two.head = twoCurrent.next;
            list1Follower.next = twoCurrent;
            twoCurrent.next = list1Leader;
            if(two.head == null) {
                return one;
            }
            twoCurrent = two.head;
            list1Follower = list1Leader;
            list1Leader = list1Leader.next;
        }
        list1Follower.next = twoCurrent;
        return one;

    }

    /**
     * Inserts a value to the first position of the list.
     */
    public void insert(T value) {

        this.head = new Node<T>(value, this.head);
    }

    public int size() {

        if(this.isEmpty()) {
            return 0;
        }
        int count = 0;
        Node<T> current = this.head;
        while(current != null) {
            count++;
            current = current.next;
        }
        return count;
    }


    /**
     * Adds a value to the last position of the list.
     */
    public void append(T value) {

        if(this.head == null) {
            this.head = new Node<T>(value, null);
        }
        else {
            Node<T> current = head;
            while(current.next != null) {
                current = current.next;
            }
            current.next = new Node<T>(value, null);
        }
    }

    /**
     * Checks if list contains a value, if so, it inserts the newValue before the search value and returns true.
     * If value is not found in list, no insert is made, and method returns false.
     */
    public boolean insertBefore(T value, T newValue) {

        Node<T> current = head;
        if(this.head == null) {
            return false;
        }
        if(this.head.value == value) {
            this.head = new Node<T>(newValue, this.head);
            return true;
        }
        while(current.next != null) {
            if(current.next.value == value) {
                current.next = new Node<T>(newValue, current.next);
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
    public boolean insertAfter(T value, T newValue) {

        Node<T> current = this.head;
        while(current != null) {
            if(current.value == value) {
                current.next = new Node<T>(newValue, current.next);
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
    public boolean deleteValue(T value) {

        Node<T> current = this.head;
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
    public boolean includes(T value) {

        Node<T> current = this.head;
        while(current != null) {
            if(current.value.equals(value)) {
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
    public T kFromEnd(int k) {

        if(k < 0 || this.head == null) {
            //throw an illegalArgumentException
            return null;
        }

        Node<T> current = this.head;
        Node<T> follower = this.head;
        int count = 0;

        while(current.next != null) {
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
    public T findMiddleNode() {
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

        Node<T> current = this.head;
        Node<T> follower = this.head;
        while(current.next != null) {
            if(current.next.next != null) {
                current = current.next.next;
            }
            else {
                return follower.next.value;
            }

            follower = follower.next;
        }
        return follower.value;
    }

    /**
     * This method reverses the order of a linked list.
     */
    public void reverseList() {

        if(this.head == null) {
            return;
        }

        Node<T> leader = this.head.next;
        Node<T> current = this.head;
        Node<T> follow = this.head;

        this.head.next = null;

        while(leader != null) {

            // "Hop" current over to leader
            current = leader;
            // Iterate leader forward one
            leader = leader.next;
            // Set the current Node's next back to follower
            current.next = follow;
            // "Hop" follower over to current
            follow = current;
        }
        this.head = current;
    }

    /**
     * Returns true if list is empty, false if not empty.
     */
    public boolean isEmpty() {

        return this.head == null;
    }

    /**
     * Deletes all Nodes in a list.
     */
    public void deleteAll() {

        this.head = null;
    }



    /**
     * Prints the entire list with commas in between values.
     */
    public void print() {
        Node<T> current = this.head;
        StringJoiner stringJoiner = new StringJoiner(", ");
        while(current != null) {
            stringJoiner.add(current.value.toString());
            current = current.next;
        }
        if(this.head != null) {
            System.out.println(stringJoiner);
        }
    }

    /**
     * Helper function for testing, returns the value of head, or returns null for an empty list.
     */
    public T getHeadValue() {
        if(this.head == null) {
            return null;
        }
        return this.head.value;
    }

    /**
     * Helper function for testing, returns the last value in the list, or returns null for an empty list.
     */
    public T getLastValue() {
        if(this.head == null) {
            return null;
        }
        Node<T> current = this.head;
        while(current.next != null) {
            current = current.next;
        }
        return current.value;
    }

    private boolean hasNext(Node<T> current) {
        return current != null;
    }


    public Node<T> getHead() {
        return this.head;
    }

    @Override
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner(", ");
        Node<T> current = this.head;
        while(current != null) {
            stringJoiner.add(current.value.toString());
            current = current.next;
        }
        return stringJoiner.toString();
    }
}
