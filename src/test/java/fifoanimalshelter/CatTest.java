package fifoanimalshelter;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.*;

public class CatTest {

    @Test
    public void testCatIsInstanceOfAnimal() {
        Cat cat = new Cat();
        assertThat(cat, instanceOf(Animal.class));
    }

    @Test
    public void testDefaultConstructor_name() {
        Cat cat = new Cat();
        assertNull("Name should be 'null' if using the default constructor.", cat.name);
    }

    @Test
    public void testDefaultConstructor_intakeDate() {
        Cat cat = new Cat();
        assertNull("'intakeDate' should be 'null' when instantiated.", cat.intakeDate);
    }

    @Test
    public void testOneArgumentConstructor_name() {
        Cat cat = new Cat("Rascal");
        assertEquals("Name should be 'null' if using the default constructor.", "Rascal", cat.name);
    }

    @Test
    public void testOneArgumentConstructor_intakeDate() {
        Cat cat = new Cat("Rascal");
        assertNull("'intakeDate' should be 'null' when instantiated.", cat.intakeDate);
    }

}
