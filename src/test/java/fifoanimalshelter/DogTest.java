package fifoanimalshelter;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.*;

public class DogTest {

    @Test
    public void testCatIsInstanceOfAnimal() {
        Dog dog = new Dog();
        assertThat(dog, instanceOf(Animal.class));
    }

    @Test
    public void testDefaultConstructor_name() {
        Dog dog = new Dog();
        assertNull("Name should be 'null' if using the default constructor.", dog.name);
    }

    @Test
    public void testDefaultConstructor_intakeDate() {
        Dog dog = new Dog();
        assertNull("'intakeDate' should be 'null' when instantiated.", dog.intakeDate);
    }

    @Test
    public void testOneArgumentConstructor_name() {
        Dog dog = new Dog("Scout");
        assertEquals("Name should be 'null' if using the default constructor.", "Scout", dog.name);
    }

    @Test
    public void testOneArgumentConstructor_intakeDate() {
        Dog dog = new Dog();
        assertNull("'intakeDate' should be 'null' when instantiated.", dog.intakeDate);
    }

}
