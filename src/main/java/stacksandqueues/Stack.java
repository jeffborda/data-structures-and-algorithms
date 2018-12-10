package stacksandqueues;

/**
 * Data structure that can hold any Object type. It is structured like a stack of plates.  When values are added, they
 * stack up, just like a stack of plates.  Values are always added and removed from the top of the Stack.
 */
public class Stack<T> {

    Node<T> top;

    public Stack() {
        this.top = null;
    }

    /**
     * Pushes a new Node with a value on the top of the stack.
     * @param value
     */
    public void push(T value) {
        top = new Node(value, top);
    }

    /**
     * Returns the value of the top of the stack, pop of the top Node.
     * @return value at the top of the stack.
     */
    public T pop() {
        if(top != null) {
            Node<T> temp = top;
            top = top.next;
            return temp.value;
        }
        return null;
    }

    /**
     * Returns the value of the top Node, but does NOT pop it off.
     * @return value at the top of the stack.
     */
    public T peek() {
        if(top != null) {
            return top.value;
        }
        return null;
    }

    /**
     * Determines if a Stack has any Nodes or not.
     * @return if the Stack is empty.
     */
    public boolean isEmpty() {
        if(top == null) {
            return true;
        }
        return false;
    }

    /**
     * Returns the size of the Stack.
     * @return size of the Stack.
     */
    public int size() {
        int count = 0;
        if(top == null) {
            return count;
        }
        Node<T> current = top;
        while(current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

}
