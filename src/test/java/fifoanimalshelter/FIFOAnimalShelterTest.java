package fifoanimalshelter;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class FIFOAnimalShelterTest {

    private FIFOAnimalShelter shelter;

    @Before
    public void setUp() {
        shelter = new FIFOAnimalShelter();
    }

    @Test
    public void testConstructor() {
        assertEquals("Dog queue exist, and is size '0'.", 0, shelter.getDogs().size());
        assertEquals("Cat queue exist, and is size '0'.", 0, shelter.getCats().size());
    }

    @Test
    public void testIsEmpty() {
        assertTrue("isEmpty() method should return 'true' if both queues are empty.", shelter.isEmpty());
    }

    @Test
    public void testIsEmpty_withCats() {
        shelter.enqueue(new Cat());
        assertFalse("If there are one or more cats in the shelter, isEmpty should return 'false'.", shelter.isEmpty());
    }

    @Test
    public void testIsEmpty_withDogs() {
        shelter.enqueue(new Dog());
        assertFalse("If there are one or more dogs in the shelter, isEmpty should return 'false'.", shelter.isEmpty());
    }

    @Test
    public void testEmpty_withDogsAndCats() {
        shelter.enqueue(new Cat());
        shelter.enqueue(new Dog());
        assertFalse("If there are  dog in the shelter, isEmpty should return 'false'.", shelter.isEmpty());
    }

    @Test
    public void testEnqueue_withCat() {
        shelter.enqueue(new Cat());
        assertEquals("Confirm cats queue is size '1' after one Cat enqueue.", 1, shelter.getCats().size());
    }

    @Test
    public void testEnqueue_multipleCats() {
        shelter.enqueue(new Cat());
        shelter.enqueue(new Cat());
        shelter.enqueue(new Cat());
        assertEquals("Confirm cats queue is size '3' after three Cat enqueue.", 3, shelter.getCats().size());
        assertTrue("Confirm dogs queue is still empty after Cat enqueues.", shelter.getDogs().isEmpty());
    }

    @Test
    public void testEnqueue_withDog() {
        shelter.enqueue(new Dog());
        assertEquals("Confirm dogs queue is size '1' after one Dog enqueue.", 1, shelter.getDogs().size());
    }

    @Test
    public void testEnqueue_multipleDogs() {
        shelter.enqueue(new Dog());
        shelter.enqueue(new Dog());
        shelter.enqueue(new Dog());
        assertEquals("Confirm dogs queue is size '3' after four Dog enqueues.", 3, shelter.getDogs().size());
        assertTrue("Confirm cats queue is still empty after the Dogs were enqueued.", shelter.getCats().isEmpty());
    }

    @Test
    public void testEnqueue_multipleCatsAndDogs() {
        shelter.enqueue(new Dog());
        shelter.enqueue(new Dog());
        shelter.enqueue(new Dog());
        shelter.enqueue(new Cat());
        shelter.enqueue(new Cat());
        assertEquals("Dog queue should be size '3'.", 3, shelter.getDogs().size());
        assertEquals("Cat queue should be size '2'.", 2, shelter.getCats().size());
    }

    @Test(expected = IllegalStateException.class)
    public void testGetNextDog_emptyDogQueue() {
        shelter.getNextDog();
    }

    @Test(expected = IllegalStateException.class)
    public void testGetNextCat_emptyCatQueue() {
        shelter.getNextCat();
    }

    @Test
    public void testGetNextDog() {
        shelter.enqueue(new Dog("Maggie"));
        shelter.enqueue(new Dog("Copper"));
        shelter.enqueue(new Cat("Sandoz"));
        shelter.enqueue(new Cat("Rascal"));
        assertEquals("Should return the dog which has been at the shelter the longest.", "Maggie", shelter.getNextDog().name);
        assertEquals("Size of the dogs queue should now be '1'.", 1, shelter.getDogs().size());
    }

    @Test
    public void testGetNextCat() {
        shelter.enqueue(new Dog("Maggie"));
        shelter.enqueue(new Dog("Copper"));
        shelter.enqueue(new Cat("Sandoz"));
        shelter.enqueue(new Cat("Rascal"));
        assertEquals("Should return the cat which has been at the shelter the longest.",
                "Sandoz", shelter.getNextCat().name);
        assertEquals("Size of the cats queue should now be '1'.", 1, shelter.getCats().size());
    }

    @Test
    public void testGetNextAnimal() {
        shelter.enqueue(new Dog("Maggie"));
        shelter.enqueue(new Dog("Copper"));
        shelter.enqueue(new Cat("Sandoz"));
        shelter.enqueue(new Cat("Rascal"));
        assertEquals("Should return the cat or dog that has been at the shelter the longest.",
                "Maggie", shelter.getNextAnimal().name);
    }

    @Test
    public void testGetNextAnimal_emptyDogQueue() {
        shelter.enqueue(new Cat("Sandoz"));
        shelter.enqueue(new Cat("Rascal"));
        assertEquals("If the dogs queue is empty, it should return the next cat regardless of intake date.",
                "Sandoz", shelter.getNextAnimal().name);
    }

    @Test
    public void testGetNextAnimal_emptyCatQueue() {
        shelter.enqueue(new Dog("Maggie"));
        shelter.enqueue(new Dog("Copper"));
        assertEquals("If the cats queue is empty, it should return the next dog regardless of intake date.",
                "Maggie", shelter.getNextAnimal().name);
    }

    @Test(expected = IllegalStateException.class)
    public void testGetNextAnimal_catsAndDogsQueuesEmpty() {
        shelter.getNextAnimal();
    }

}
