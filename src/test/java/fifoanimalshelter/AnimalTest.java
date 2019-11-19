package fifoanimalshelter;

import org.junit.Test;

import static org.junit.Assert.*;

public class AnimalTest {

    @Test
    public void testNoArgumentConstructor_name() {
        Animal animal = new Animal();
        assertNull("'name' should be 'null' upon instantiation.", animal.name);
    }

    @Test
    public void testNoArgumentConstructor_date() {
        Animal animal = new Animal();
        assertNull("'intakeDate' should be 'null' upon instantiation.", animal.intakeDate);
    }

    @Test
    public void testOneArgumentConstructor_name() {
        Animal animal = new Animal("Bob");
        assertEquals("Name should be set in the one argument constructor.", "Bob", animal.name);
    }

    @Test
    public void testOneArgumentConstructor_date() {
        Animal animal = new Animal("Sue");
        assertNull("'intakeDate' should be 'null' upon instantiation.", animal.intakeDate);
    }

}