package fifoanimalshelter;

import fizzbuzztree.FizzBuzzTree;
import org.junit.Test;
import static org.junit.Assert.*;

public class FIFOAnimalShelterTest {

    @Test
    public void testConstructor() {
        FIFOAnimalShelter testShelter = new FIFOAnimalShelter();
        assertEquals("Dog queue exist, and is size '0'.", 0, testShelter.getDogs().size());
        assertEquals("Cat queue exist, and is size '0'.", 0, testShelter.getCats().size());
    }

    @Test
    public void testIsEmpty() {
        FIFOAnimalShelter testShelter = new FIFOAnimalShelter();
        assertTrue("isEmpty() method should return 'true' if both queues are empty.", testShelter.isEmpty());
    }

    @Test
    public void testIsEmpty_withCats() {
        FIFOAnimalShelter testShelter = new FIFOAnimalShelter();
        testShelter.enqueue(new Cat());
        assertFalse("If there are one or more cats in the shelter, isEmpty should return 'false'.", testShelter.isEmpty());
    }

    @Test
    public void testIsEmpty_withDogs() {
        FIFOAnimalShelter testShelter = new FIFOAnimalShelter();
        testShelter.enqueue(new Dog());
        assertFalse("If there are one or more dogs in the shelter, isEmpty should return 'false'.", testShelter.isEmpty());
    }

    @Test
    public void testEmpty_withDogsAndCats() {
        FIFOAnimalShelter testShelter = new FIFOAnimalShelter();
        testShelter.enqueue(new Cat());
        testShelter.enqueue(new Dog());
        assertFalse("If there are  dog in the shelter, isEmpty should return 'false'.", testShelter.isEmpty());
    }

    @Test
    public void testEnqueue_withCat() {
        FIFOAnimalShelter testShelter = new FIFOAnimalShelter();
        testShelter.enqueue(new Cat());
        assertEquals("Confirm cats queue is size '1' after one Cat enqueue.", 1, testShelter.getCats().size());
    }

    @Test
    public void testEnqueue_multipleCats() {
        FIFOAnimalShelter testShelter = new FIFOAnimalShelter();
        testShelter.enqueue(new Cat());
        testShelter.enqueue(new Cat());
        testShelter.enqueue(new Cat());
        assertEquals("Confirm cats queue is size '3' after three Cat enqueue.", 3, testShelter.getCats().size());
        assertTrue("Confirm dogs queue is still empty after Cat enqueues.", testShelter.getDogs().isEmpty());
    }

    @Test
    public void testEnqueue_withDog() {
        FIFOAnimalShelter testShelter = new FIFOAnimalShelter();
        testShelter.enqueue(new Dog());
        assertEquals("Confirm dogs queue is size '1' after one Dog enqueue.", 1, testShelter.getDogs().size());
    }

    @Test
    public void testEnqueue_multipleDogs() {
        FIFOAnimalShelter testShelter = new FIFOAnimalShelter();
        testShelter.enqueue(new Dog());
        testShelter.enqueue(new Dog());
        testShelter.enqueue(new Dog());
        assertEquals("Confirm dogs queue is size '3' after four Dog enqueues.", 3, testShelter.getDogs().size());
        assertTrue("Confirm cats queue is still empty after the Dogs were enqueued.", testShelter.getCats().isEmpty());
    }

    @Test
    public void testEnqueue_multipleCatsAndDogs() {
        FIFOAnimalShelter testShelter = new FIFOAnimalShelter();
        testShelter.enqueue(new Dog());
        testShelter.enqueue(new Dog());
        testShelter.enqueue(new Dog());
        testShelter.enqueue(new Cat());
        testShelter.enqueue(new Cat());
        assertEquals("Dog queue should be size '3'.", 3, testShelter.getDogs().size());
        assertEquals("Cat queue should be size '2'.", 2, testShelter.getDogs().size());
    }

}
