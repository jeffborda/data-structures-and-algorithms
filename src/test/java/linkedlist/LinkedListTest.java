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


}