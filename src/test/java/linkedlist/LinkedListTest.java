package linkedlist;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class LinkedListTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }


    @Test
    public void testInsert() {
        LinkedList testList = new LinkedList();
        assertEquals("Should return 'null' on empty list.", null, testList.getHeadValue());
        testList.insert("Hello");
        assertEquals("Make sure list returns first thing in list.", "Hello", testList.getHeadValue());
        testList.insert("World");
        assertEquals("Make sure list returns first thing in list.", "World", testList.getHeadValue());
        assertTrue("List should still contain the first value inserted.", testList.includes("Hello"));
    }

    @Test
    public void testIncludes() {
        LinkedList testList = new LinkedList();
        testList.insert("I");
        assertTrue("Should contain string and return 'true'", testList.includes("I"));
        testList.insert("love");
        testList.insert("Java");
        assertTrue("Should contain string and return 'true'", testList.includes("love"));
        assertTrue("Should contain string and return 'true'", testList.includes("Java"));
    }

    @Test
    public void testPrint() {
        LinkedList testList = new LinkedList();
        testList.insert("three");
        testList.insert("two");
        testList.insert("one");
        // Finds the new line character being used depending on what system is being used.
        String newLine = System.lineSeparator();
        testList.print();
        assertEquals("Check output stream", "one, two, three" + newLine, outContent.toString());

        // Clears the output stream for tests
        outContent.reset();
        testList.insert("zero");
        testList.print();
        assertEquals("Check output stream", "zero, one, two, three" + newLine, outContent.toString());

        outContent.reset();
        LinkedList emptyTestList = new LinkedList();
        emptyTestList.print();
        assertEquals("Check output stream on empty list, should print nothing.", "", outContent.toString());
    }

    @Test
    public void testAppend() {
        LinkedList testList = new LinkedList();
        testList.append("3");
        assertEquals("Inserted a '3' into empty list, last value should be '3'.", "3", testList.getHeadValue());
        assertEquals("Inserted a '3' into empty list, last value should be '3'.", "3", testList.getLastValue());
        testList.insert("2");
        testList.insert("1");

        testList.append("4");
        outContent.reset();
        String newLine = System.lineSeparator();
        testList.print();
        assertEquals("Check list order through the print method, '4' should be at the end.", "1, 2, 3, 4" + newLine, outContent.toString());
        assertEquals("Check the last Node's value, should be '4'.", "4", testList.getLastValue());
        testList.append("I am last");
        assertEquals("Check the last Node's value after another append, should be 'I am last'.", "I am last", testList.getLastValue());
    }

    @Test
    public void testInsertBefore() {
        LinkedList testList = new LinkedList();
        assertFalse("Should return 'false' and not insert on an empty list", testList.insertBefore("2", "1"));
        assertFalse("Make sure the value '1' was not inserted into empty list.", testList.includes("1"));
        testList.insert("2");
        assertTrue("Should return 'true' and insert '1' before '2'.", testList.insertBefore("2", "1"));
        assertEquals("Confirm that '1' is at the first position.", "1", testList.getHeadValue());
        testList.append("4");
        assertTrue("Should return 'true' and insert '3' before '4'.", testList.insertBefore("4", "3"));
        outContent.reset();
        String newLine = System.lineSeparator();
        testList.print();
        assertEquals("Check that list prints as '1, 2, 3, 4'.", "1, 2, 3, 4" + newLine, outContent.toString());
        assertFalse("Should return false if value not found.", testList.insertBefore("5", "99"));
    }

    @Test
    public void testInsertAfter() {
        LinkedList testList = new LinkedList();
        assertFalse("Should return 'false' and not insert on an empty list.", testList.insertAfter("10", "99"));
        assertFalse("Confirm that value '99' was not inserted into empty list.", testList.includes("99"));
        testList.insert("1");
        assertTrue("Should return 'true' and insert '2' after '1'.", testList.insertAfter("1", "2"));
        assertEquals("Confirm that '2' is at the last position.", "2", testList.getLastValue());
        assertTrue("Should return 'true' and insert '1.5' between '1' and '2'.", testList.insertAfter("1", "1.5"));
        assertTrue("Confirm '1.5' is now contained in the list.", testList.includes("1.5"));
        assertEquals("Confirm '1' is still the head.", "1", testList.getHeadValue());
        assertEquals("Confirm '2' is still the tail.", "2", testList.getLastValue());
        assertTrue("Should return 'true' and insert '3' after the '2'.", testList.insertAfter("2", "3"));
        assertEquals("Confirm '3' is now the tail.", "3", testList.getLastValue());
    }

    @Test
    public void testDeleteValue() {
        LinkedList testList = new LinkedList();
        assertFalse("Should return 'false' on an empty list.", testList.deleteValue("99"));
        testList.insert("1");
        assertTrue("Should return 'true' and delete '1' from the list.", testList.deleteValue("1"));
        assertEquals("Head should now be pointing at null.", null, testList.getHeadValue());
        testList.insert("3");
        testList.insert("2");
        testList.insert("1");
        assertTrue("Should return 'true' and remove '2' from the middle of list.", testList.deleteValue("2"));
        assertEquals("Confirm '3' is at the end of the list and list is intact.", "3", testList.getLastValue());
    }

    @Test
    public void testKFromTheEnd() {
        LinkedList testList = new LinkedList();
        testList.insert("1");
        assertEquals("Should return first and only value '1' if k is '0'.", "1", testList.kFromEnd(0));
        assertEquals("Should return 'null' if too few elements in regards to k.", null, testList.kFromEnd(2));
        testList.append("2");
        testList.append("3");
        testList.append("4");
        testList.append("5");
        // testList is now: {1, 2, 3, 4, 5}
        assertEquals("Confirm '1' is at the head of list.", "1", testList.getHeadValue());
        assertEquals("Confirm '5' is at the tail of list.", "5", testList.getLastValue());
        assertEquals("Should return '5' when k is 0.", "5", testList.kFromEnd(0));
        assertEquals("Should return '4' when k is 1.", "4", testList.kFromEnd(1));
        assertEquals("Should return '3' when k is 2.", "3", testList.kFromEnd(2));
        assertEquals("Should return '2' when k is 3.", "2", testList.kFromEnd(3));
        assertEquals("Should return '1' when k is 4.", "1", testList.kFromEnd(4));
        assertEquals("Should return 'null' when k is > 4.", null, testList.kFromEnd(5));
        assertEquals("Should return 'null' when k is > 4.", null, testList.kFromEnd(100));
        assertEquals("Should also return null if given negative k.", null, testList.kFromEnd(-1));
    }

}