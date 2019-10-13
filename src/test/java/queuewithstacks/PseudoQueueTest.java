package queuewithstacks;

import org.junit.Test;

import static org.junit.Assert.*;

public class PseudoQueueTest {

    @Test
    public void testConstructor() {
        PseudoQueue<String> testQueue1 = new PseudoQueue<>();
        assertTrue("Confirm queue is empty on instantiation.", testQueue1.isEmpty());
        testQueue1.enqueue("I");
        testQueue1.enqueue("love");
        testQueue1.enqueue("Java");
        assertEquals("Confirm values can be removed from list, in same order enqueued.", "I", testQueue1.dequeue());
        assertEquals("Confirm values can be removed from list, in same order enqueued.", "love", testQueue1.dequeue());
        assertEquals("Confirm values can be removed from list, in same order enqueued.", "Java", testQueue1.dequeue());
    }

    @Test
    public void testEnqueue() {
        PseudoQueue<String> testPseudoQueue = new PseudoQueue<>();
        testPseudoQueue.enqueue("hello");
        assertEquals("Should return only value, 'hello'.", "hello", testPseudoQueue.dequeue());
        testPseudoQueue.enqueue("1");
        testPseudoQueue.enqueue("2");
        testPseudoQueue.enqueue("3");
        assertEquals("Confirm what was enqueued - same order, '1'.", "1", testPseudoQueue.dequeue());
        assertEquals("Confirm what was enqueued - same order, '2'.", "2", testPseudoQueue.dequeue());
        assertEquals("Confirm what was enqueued - same order, '3'.", "3", testPseudoQueue.dequeue());
    }

    @Test
    public void testDequeue() {
        PseudoQueue<Integer> testPseudoQueue = new PseudoQueue<>();
        testPseudoQueue.enqueue(1);
        testPseudoQueue.enqueue(2);
        testPseudoQueue.enqueue(3);
        assertEquals("Should return first value inserted: '1'.", (Integer) 1, testPseudoQueue.dequeue());
        testPseudoQueue.enqueue(4);
        assertEquals("Should return second value inserted: '2'.", (Integer) 2, testPseudoQueue.dequeue());
        assertEquals("Should return third value inserted: '3'.", (Integer) 3, testPseudoQueue.dequeue());
        assertEquals("Should return fourth value inserted: '4'.", (Integer) 4, testPseudoQueue.dequeue());
    }
}