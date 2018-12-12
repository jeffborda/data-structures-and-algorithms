package fifoanimalshelter;

import org.junit.Test;
import stacksandqueues.Queue;

import java.io.FileWriter;

import static org.junit.Assert.*;

public class FIFOAnimalShelterTest {

    @Test
    public void testConstructor() {
        FIFOAnimalShelter testShelter = new FIFOAnimalShelter();
        assertTrue("Both Cat and Dog queues should be empty on instantiation.", testShelter.isEmpty());
        assertEquals("Make sure the dog queue exists, and is size '0'.", 0, testShelter.getDogs().size());
        assertEquals("Make sure the cat queue exists, and is size '0'.", 0, testShelter.getCats().size());
    }

    @Test
    public void testEnqueue() {
        FIFOAnimalShelter testShelter = new FIFOAnimalShelter();
        testShelter.enqueue(new Cat());
        assertEquals("Confirm cats queue is size '1' after one Cat enqueue.", 1, testShelter.getCats().size());
        testShelter.enqueue(new Cat());
        testShelter.enqueue(new Cat());
        assertEquals("Confirm cats queue is size '3' after three Cat enqueue.", 3, testShelter.getCats().size());
        assertEquals("Confirm dogs queue is still size '0' after Cat enqueues.", 0, testShelter.getDogs().size());
        testShelter.enqueue(new Dog());
        assertEquals("Confirm dogs queue is size '1' after one Dog enqueue.", 1, testShelter.getDogs().size());
        testShelter.enqueue(new Dog());
        testShelter.enqueue(new Dog());
        testShelter.enqueue(new Dog());
        assertEquals("Confirm dogs queue is size 'f' after four Dog enqueues.", 4, testShelter.getDogs().size());
        assertEquals("Confirm cats queue is still size '3' after the Dogs were enqueued.", 3, testShelter.getCats().size());
    }

    @Test
    public void testDequeue() {
        FIFOAnimalShelter testShelter = new FIFOAnimalShelter();
        testShelter.enqueue(new Cat());
        testShelter.enqueue(new Cat());
        testShelter.enqueue(new Cat());
        testShelter.enqueue(new Cat());
        testShelter.enqueue(new Cat()); //5 Cats
        testShelter.enqueue(new Dog());
        testShelter.enqueue(new Dog());
        testShelter.enqueue(new Dog()); //3 Dogs
        assertEquals("Confirm there are 5 Cats in the queue.", 5, testShelter.getCats().size());
        assertEquals("Confirm there are 3 Dogs in the queue.", 3, testShelter.getDogs().size());
        assertTrue("Confirm when 'cat' is requested, a Cat is dequeued.", testShelter.dequeue("cat") instanceof  Cat);
        assertEquals("Cat queue should now be size '4' after one cat dequeued.", 4, testShelter.getCats().size());
        assertEquals("Dog queue should have remained size '3' after cat dequeued.", 3, testShelter.getDogs().size());
        assertTrue("It shouldn't matter about upper or lower case in 'CaT'.", testShelter.dequeue("CaT") instanceof  Cat);
        assertEquals("Cat queue should now be size '3' after two cats dequeued.", 3, testShelter.getCats().size());
        assertEquals("Dog queue should have remained size '3' after cat dequeued.", 3, testShelter.getDogs().size());

        assertTrue("Confirm when 'dog' is requested, a Dog is dequeued.", testShelter.dequeue("dog") instanceof  Dog);
        assertEquals("Dog queue should now be size '2'.", 2, testShelter.getDogs().size());
        assertEquals("Cat queue should have remained size '3' after a dog is dequeued.", 3, testShelter.getCats().size());
        assertTrue("It shouldn't matter about upper or lower case in 'DOg'.", testShelter.dequeue("DOg") instanceof  Dog);
        assertEquals("Dog queue should now be size '1'.", 1, testShelter.getDogs().size());
        assertTrue("Confirm when 'dog' is requested, a Dog is dequeued.", testShelter.dequeue("dog") instanceof  Dog);
        assertEquals("Dog queue should now be size '0'.", 0, testShelter.getDogs().size());
        assertEquals("If 'dog' dequeue request made on empty Queue, should return 'null'.", null, testShelter.dequeue("dog"));
    }
}