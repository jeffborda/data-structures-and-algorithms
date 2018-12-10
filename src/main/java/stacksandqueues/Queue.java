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
        rear.next = new Node(value, null);
        rear = rear.next;
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

    public T peek() {
        if(front != null) {
            return front.value;
        }
        return null;
    }
}
