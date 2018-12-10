package stacksandqueues;

import org.junit.Test;

import static org.junit.Assert.*;

public class QueueTest {

    @Test
    public void testConstructor() {
        Queue<String> testStringQueue = new Queue<>();
        assertTrue("Confirm Queue is empty after being instantiated.", testStringQueue.isEmpty());
        assertEquals("Confirm empty Queue is size '0'.", 0, testStringQueue.size());
        testStringQueue.enqueue("1");
        assertEquals("Queue should be size '1' after enqueueing one value.", 1, testStringQueue.size());
        assertEquals("Front of the Queue should be one value enqueued into the Queue.", "1", testStringQueue.peek());

        Queue<Integer> testIntegerQueue = new Queue<>();
        assertTrue("Confirm Queue is empty after being instantiated.", testIntegerQueue.isEmpty());
        assertEquals("Confirm empty Queue is size '0'.", 0, testIntegerQueue.size());
        testIntegerQueue.enqueue((Integer) 1);
        assertEquals("Make sure the rear of the Queue has the value of '1'.", (Integer) 1, testIntegerQueue.getRearValue());
        testIntegerQueue.enqueue((Integer) 2);
        assertEquals("Make sure the rear of the Queue has the value of '2'.", (Integer) 2, testIntegerQueue.getRearValue());
        testIntegerQueue.enqueue((Integer) 3);
        assertEquals("Make sure the rear of the Queue has the value of '3'.", (Integer) 3, testIntegerQueue.getRearValue());
        assertEquals("Confirm the front of the queue is still '1'.", (Integer) 1, testIntegerQueue.peek());

    }

    @Test
    public void testIsEmpty() {
        Queue<String> testQueue = new Queue<>();
        assertTrue("Queue should be empty upon instantiation.", testQueue.isEmpty());
        testQueue.enqueue("1");
        assertFalse("Should return 'false' if there is an item in the queue.", testQueue.isEmpty());
        testQueue.dequeue();
        assertTrue("After one enqueue and one dequeue, the Queue should be empty again.", testQueue.isEmpty());
    }

    @Test
    public void testSize() {
        Queue<String> testQueue = new Queue<>();
        assertEquals("Queue should be empty upon instantiation, size should return '0'.", 0, testQueue.size());
        testQueue.enqueue("1");
        assertEquals("After one enqueue, the Queue should be size '1'.", 1, testQueue.size());
        testQueue.enqueue("2");
        assertEquals("After two enqueues, the Queue should be size '2'.", 2, testQueue.size());
        testQueue.enqueue("3");
        assertEquals("After three enqueues, the Queue should be size '3'.", 3, testQueue.size());
        testQueue.enqueue("4");
        testQueue.enqueue("5");
        assertEquals("After five enqueues, the Queue should be size '5'.", 5, testQueue.size());
    }

    @Test
    public void testEnqueue() {
        Queue<String> testQueue = new Queue<>();
        testQueue.enqueue("1");
        assertEquals("Front of the Queue should contain the value '1'.", "1", testQueue.peek());
        assertEquals("The rear should have the same value as the front with one Node in the Queue.", "1", testQueue.getRearValue());
        assertEquals("Size of the queue should be '1'.", 1, testQueue.size());
        testQueue.enqueue("2");
        assertEquals("Front of the Queue should still contain the value '1'.", "1", testQueue.peek());
        assertEquals("The rear should now contain the last value that was enqueued.", "2", testQueue.getRearValue());
        assertEquals("Size of the queue should be '2'.", 2, testQueue.size());
        testQueue.enqueue("3");
        assertEquals("Front of the Queue should still contain the value '1'.", "1", testQueue.peek());
        assertEquals("The rear should now contain the last value that was enqueued.", "3", testQueue.getRearValue());
        assertEquals("Size of the queue should be '3'.", 3, testQueue.size());
    }

    @Test
    public void testDequeue() {
        Queue<String> testQueue = new Queue<>();
        assertEquals("When dequeue is called on an empty Queue, it should return 'null'.", null, testQueue.dequeue());
        testQueue.enqueue("1");
        assertEquals("Should return the value of the only item in the queue, then reset pointers to null.", "1", testQueue.dequeue());
        assertTrue("Confirm queue is now empty, should return 'true'.", testQueue.isEmpty());
        assertEquals("Confirm the size of the queue is '0'.", 0, testQueue.size());
        testQueue.enqueue("1");
        testQueue.enqueue("2");
        testQueue.enqueue("3");
        assertEquals("Should return '1', the front value of the queue.", "1", testQueue.dequeue());
        assertEquals("Should return '2', the front value of the queue.", "2", testQueue.dequeue());
        assertEquals("Should return '3', the front value of the queue.", "3", testQueue.dequeue());
        assertTrue("Queue should be empty after dequeueing all items.", testQueue.isEmpty());
    }

    @Test
    public void testPeek() {
        Queue<String> testQueue = new Queue<>();
        
    }
}