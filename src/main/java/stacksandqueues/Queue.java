package stacksandqueues;

public class Queue<T> {

    Node<T> front;
    Node<T> rear;

    public Queue() {
        this.front = null;
        this.rear = null;
    }

    /**
     * Adds a Node to the back of the Queue with the input value.
     * @param value
     */
    public void enqueue(T value) {
        if(front == null) {
            rear = new Node<>(value, null);
            front = rear;
            return;
        }
        else {
            rear.next = new Node<>(value, null);
            rear = rear.next;
        }
    }

    /**
     * Removes the Node at the front of the Queue and returns its value.
     * @return the value of the front Node.
     */
    public T dequeue() {
        if(front != null) {
            Node<T> temp = front;
            front = front.next;
            return temp.value;
        }
        return null;
    }

    /**
     * Returns the value at the front of the Queue, but does not change the Queue.
     * @return value at the front of the Queue
     */
    public T peek() {
        if(front != null) {
            return front.value;
        }
        return null;
    }

    /**
     * Determines if the Queue is empty or not, returns boolean.
     * @return true if Queue is empty, false if it has one or more Nodes.
     */
    public boolean isEmpty() {
        if(front == null) {
            return true;
        }
        return false;
    }

    /**
     * Finds the size of the Queue.  Empty Queue returns 0, one Node in Queue returns 1, etc.
     * @return number of Nodes in the Queue.
     */
    public int size() {
        int count = 0;
        if(front == null) {
            return count;
        }
        Node<T> current = front;
        while(current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    /**
     * Helper function for testing purposes. Returns the last Node's value in the Queue.
     * @return the value at the back of the Queue, or null if Queue is empty.
     */
    protected T getRearValue() {
        if(front == null) {
            return null;
        }
        return rear.value;
    }
}
