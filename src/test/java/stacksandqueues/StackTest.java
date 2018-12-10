package stacksandqueues;

import org.junit.Test;

import static org.junit.Assert.*;

public class StackTest {

    @Test
    public void testConstructor() {
        Stack<Integer> testIntegerStack= new Stack<>();
        assertTrue("Make sure a new Stack is empty.", testIntegerStack.isEmpty());
        testIntegerStack.push((Integer) 5);
        assertEquals("Confirm top value is '5'.", (Integer) 5, testIntegerStack.peek());
        testIntegerStack.push((Integer) 10);
        assertEquals("Confirm top value is now '10'.", (Integer) 10, testIntegerStack.peek());

        Stack<String> testStringStack = new Stack<>();
        testStringStack.push("Hello");
        testStringStack.push("World");
        assertEquals("Confirm top of the stack is 'World'.", "World", testStringStack.pop());
        assertEquals("Confirm top of the stack is 'Hello'.", "Hello", testStringStack.pop());
    }

    @Test
    public void testPush() {
        Stack<Integer> testStack = new Stack<>();
        assertEquals("Confirm an empty Stack returns 'null' when attempting to get a value.", null, testStack.peek());
        testStack.push((Integer) 1);
        assertEquals("Confirm the top of the stack is pointing at value that was pushed.", (Integer) 1, testStack.peek());
        testStack.push((Integer) 2);
        assertEquals("Confirm the top of the stack is pointing at the new value that was pushed.", (Integer) 2, testStack.peek());
    }

    @Test
    public void testPop() {
    }

    @Test
    public void testPeek() {
    }
}