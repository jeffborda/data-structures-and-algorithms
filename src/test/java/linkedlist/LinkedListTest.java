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
    public void insert() {

        LinkedList testList = new LinkedList();

        assertFalse("Should return 'false' on empty list.", testList.includes("anything"));
        testList.insert("Hello");
        assertTrue("Make sure list contains Hello, should return 'true'", testList.includes("Hello"));
        testList.insert("world");
        assertTrue("Make sure list returns 'true' to find first thing in list.", testList.includes("Hello"));
        assertTrue("Make sure list returns 'true' to find last thing in list.", testList.includes("world"));
        assertFalse("Make sure list returns 'false', on filled list", testList.includes("nope"));
    }

    @Test
    public void includes() {

        LinkedList testList = new LinkedList();
        assertFalse("make sure it doesn't find things in list that haven't been inserted", testList.includes("Scout"));
        assertFalse("make sure it doesn't find things in list that haven't been inserted", testList.includes("Dog"));
        testList.insert("I");
        testList.insert("love");
        testList.insert("Java");
        assertTrue("Should contain string and return 'true'", testList.includes("I"));
        assertTrue("Should contain string and return 'true'", testList.includes("love"));
        assertTrue("Should contain string and return 'true'", testList.includes("Java"));
    }

    @Test
    public void print() {
        LinkedList testList = new LinkedList();
        testList.insert("three");
        testList.insert("two");
        testList.insert("one");
        // Finds the new line character being used depending on what system is being used.
        String newLine = System.lineSeparator();
        testList.print();
        assertEquals("Check output stream", "one" + newLine + "two" + newLine + "three" + newLine, outContent.toString());

        // Clears the output stream for tests
        outContent.reset();
        testList.insert("zero");
        testList.print();
        assertEquals("Check output stream", "zero" + newLine + "one" + newLine + "two" + newLine + "three" + newLine, outContent.toString());

        outContent.reset();
        testList.insert("minus one");
        testList.print();
        assertEquals("Check output stream", "minus one" + newLine + "zero" + newLine + "one" + newLine + "two" + newLine + "three" + newLine, outContent.toString());
    }
}