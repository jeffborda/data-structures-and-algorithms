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
    public void testIsEmpty() {
        Stack<String> testStack = new Stack<>();
        assertTrue("Should return 'true' if nothing has been pushed on the Stack.", testStack.isEmpty());
        testStack.push("1");
        testStack.push("2");
        testStack.pop();
        testStack.pop();
        assertTrue("After popping all items from the Stack, it should be empty again and return 'true'.", testStack.isEmpty());
    }

    @Test
    public void testSize() {
        Stack<Integer> testStack = new Stack<>();
        assertEquals("Stack should be size '0' when instantiated.", 0, testStack.size());
        testStack.push((Integer) 1);
        assertEquals("Stack should be size '1' after one push.", 1, testStack.size());
        testStack.push((Integer) 2);
        assertEquals("Stack should be size '2' after two pushes.", 2, testStack.size());
        testStack.push((Integer) 3);
        testStack.push((Integer) 4);
        testStack.push((Integer) 5);
        assertEquals("Stack should be size '5' after five pushes.", 5, testStack.size());
    }

    @Test
    public void testPush() {
        Stack<Integer> testStack = new Stack<>();
        assertEquals("Confirm an empty Stack returns 'null' when attempting to get a value.", null, testStack.peek());
        testStack.push((Integer) 1);
        assertEquals("Confirm the top of the stack is pointing at value that was pushed.", (Integer) 1, testStack.peek());
        testStack.push((Integer) 2);
        assertEquals("Confirm the top of the stack is pointing at the new value that was pushed.", (Integer) 2, testStack.peek());
        testStack.push((Integer) 3);
        testStack.push((Integer) 4);
        testStack.push((Integer) 5);
        assertEquals("Confirm the top of the stack is pointing at the new value that was pushed.", (Integer) 5, testStack.peek());
        assertEquals("Stack should be size '5' after five pushes.", 5, testStack.size());
    }

    @Test
    public void testPop() {
        Stack<String> testStack = new Stack<>();
        assertTrue("Confirm the new Stack is empty upon instantiation.", testStack.isEmpty());
        testStack.push("1");
        assertEquals("Pop should return the top value, and if it's the only value, top should point to null after.", "1", testStack.pop());
        assertTrue("Stack should be empty again, should return 'true'.", testStack.isEmpty());
        assertEquals("If pop() is called on an empty list, it should return 'null'.", null, testStack.pop());
        testStack.push("1");
        testStack.push("2");
        testStack.push("3");
        assertEquals("After pushing multiple values, top of stack should now be '3'.", "3", testStack.pop());
    }

    @Test
    public void testPeek() {
        Stack<String> testStack = new Stack<>();
        assertTrue("Confirm the new Stack is empty upon instantiation.", testStack.isEmpty());
        assertEquals("If peek() called on empty stack, it should return 'null'.", null, testStack.peek());
        testStack.push("1");
        assertEquals("Should return the value of the top of the stack.", "1", testStack.peek());
        testStack.push("2");
        assertEquals("Should return the value of the top of the stack.", "2", testStack.peek());
        testStack.push("3");
        assertEquals("Should return the value of the top of the stack.", "3", testStack.peek());
    }
}