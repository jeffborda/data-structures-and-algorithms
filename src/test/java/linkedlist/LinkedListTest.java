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
        assertFalse("Should return 'false' on empty list.", testList.includes("anything"));
    }

    @Test
    public void testInsertOneValue() {
        LinkedList testList = new LinkedList();
        testList.insert("Hello");
        assertTrue("Make sure list returns 'true' to find first thing in list.", testList.includes("Hello"));
    }

    @Test
    public void testInsertManyValues() {
        LinkedList testList = new LinkedList();
        testList.insert("Hello");
        testList.insert("word");
        testList.insert("!");
        assertTrue("Should return 'true' to a value in the end of list.", testList.includes("Hello"));
    }

    @Test
    public void testIncludes() {
        LinkedList testList = new LinkedList();
        assertFalse("make sure it doesn't find things in list that haven't been inserted", testList.includes("Scout"));
    }

    @Test
    public void testIncludesOneValue() {
        LinkedList testList = new LinkedList();
        testList.insert("I");
        assertTrue("Should contain string and return 'true'", testList.includes("I"));
    }

    @Test
    public void testIncludesManyValues() {
        LinkedList testList = new LinkedList();
        testList.insert("I");
        testList.insert("love");
        testList.insert("Java");
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

    @Test
    public void testPrintOnEmptyList() {
        LinkedList testList = new LinkedList();
        outContent.reset();
        testList.print();
        assertEquals("Empty list shouldn't print anything.", "", outContent.toString());
    }

    @Test
    public void testPrintOnOneItemList() {
        LinkedList testList = new LinkedList();
        testList.insert("Test");
        outContent.reset();
        String newLine = System.lineSeparator();
        testList.print();
        assertEquals("Check output with one item in list.", "Test" + newLine, outContent.toString());
    }
}