package fifoanimalshelter;

import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

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

    @Test
    public void testSetIntakeDate() {
        Animal animal = new Animal();
        animal.setIntakeDate();
        Date compareDate = Calendar.getInstance().getTime();
        // RE: https://stackoverflow.com/questions/21585892/comparing-dates-with-junit-testing
        assertTrue("The test animal's intakeTime should be within 500 ms to the 'compareTime",
                (compareDate.getTime() - animal.intakeDate.getTime()) < 500);
    }
}
