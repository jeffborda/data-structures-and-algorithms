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
    public void testConstructor() {
        LinkedList<Integer> testList = new LinkedList<>();
        assertNull("this.head should be 'null' upon instantiation.", testList.head);
    }


    @Test
    public void testInsert() {
        LinkedList<String> testList = new LinkedList<>();
        assertNull("Should return 'null' on empty list.", testList.getHeadValue());
        testList.insert("Hello");
        assertEquals("Make sure list returns first thing in list.", "Hello", testList.getHeadValue());
        testList.insert("World");
        assertEquals("Make sure list returns first thing in list.", "World", testList.getHeadValue());
        assertTrue("List should still contain the first value inserted.", testList.includes("Hello"));
    }
    @Test
    public void testIncludes() {
        LinkedList<String> testList = new LinkedList<>();
        testList.insert("I");
        assertTrue("Should contain string and return 'true'", testList.includes("I"));
        testList.insert("love");
        testList.insert("Java");
        assertTrue("Should contain string and return 'true'", testList.includes("love"));
        assertTrue("Should contain string and return 'true'", testList.includes("Java"));
    }

    @Test
    public void testPrint() {
        LinkedList<String> testList = new LinkedList<>();
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
        LinkedList<String> testList = new LinkedList<>();
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
        assertEquals("Check the last Entry's value, should be '4'.", "4", testList.getLastValue());
        testList.append("I am last");
        assertEquals("Check the last Entry's value after another append, should be 'I am last'.", "I am last", testList.getLastValue());
    }

    @Test
    public void testInsertBefore() {
        LinkedList<String> testList = new LinkedList<>();
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
        LinkedList<String> testList = new LinkedList<>();
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
        LinkedList<String> testList = new LinkedList<>();
        assertFalse("Should return 'false' on an empty list.", testList.deleteValue("99"));
        testList.insert("1");
        assertTrue("Should return 'true' and delete '1' from the list.", testList.deleteValue("1"));
        assertNull("Head should now be pointing at null.", testList.getHeadValue());
        testList.insert("3");
        testList.insert("2");
        testList.insert("1");
        assertTrue("Should return 'true' and remove '2' from the middle of list.", testList.deleteValue("2"));
        assertEquals("Confirm '3' is at the end of the list and list is intact.", "3", testList.getLastValue());
    }

    @Test
    public void testKFromTheEnd() {
        LinkedList<String> testList = new LinkedList<>();
        assertNull("Should return 'null' if called on empty list.", testList.kFromEnd(0));
        testList.insert("1");
        assertEquals("Should return first and only value '1' if k is '0'.", "1", testList.kFromEnd(0));
        assertNull("Should return 'null' if too few elements in regards to k.", testList.kFromEnd(2));
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
        assertNull("Should return 'null' when k is > 4.", testList.kFromEnd(5));
        assertNull("Should return 'null' when k is > 4.", testList.kFromEnd(100));
        assertNull("Should also return null if given negative k.", testList.kFromEnd(-1));
    }

    @Test
    public void testFindMiddleNode() {
        LinkedList<String> testList = new LinkedList<>();
        assertNull("Should return 'null' if called on empty list.", testList.findMiddleNode());
        testList.insert("1");
        assertEquals("Should return first and only value '1'.", "1", testList.findMiddleNode());
        testList.append("2");
        assertEquals("Should return '2' in two element list.", "2", testList.findMiddleNode());
        testList.append("3");
        assertEquals("Should return '2' in three element list.", "2", testList.findMiddleNode());
        testList.append("4");
        assertEquals("Should return '3' in four element list.", "3", testList.findMiddleNode());
        testList.append("5");
        assertEquals("Should return '3' in five element list.", "3", testList.findMiddleNode());
        testList.append("6");
        assertEquals("Should return '4' in six element list.", "4", testList.findMiddleNode());
        testList.append("7");
        assertEquals("Should return '4' in seven element list.", "4", testList.findMiddleNode());
    }

    @Test
    public void testIsEmpty() {
        LinkedList<String> testList = new LinkedList<>();
        assertTrue("List should be empty, returning 'true'.", testList.isEmpty());
        testList.insert("Hello");
        assertFalse("List should have one Entry, returning 'false'.", testList.isEmpty());
    }

    @Test
    public void testSize() {
        LinkedList<String> testList = new LinkedList<>();
        assertTrue("List should be empty, returning 'true'.", testList.isEmpty());
        assertEquals("List should be size '0'.", 0, testList.size());
        testList.insert("1");
        assertEquals("List should be size '1'.", 1, testList.size());
        testList.insert("2");
        assertEquals("List should be size '2'.", 2, testList.size());
        testList.insert("3");
        assertEquals("List should be size '3'.", 3, testList.size());
    }

    @Test
    public void testDeleteAll() {
        LinkedList<String> testList = new LinkedList<>();
        testList.insert("Hello");
        testList.append("world!");
        assertEquals("Confirm list is size '2'.", 2, testList.size());
        testList.deleteAll();
        assertTrue("List should now be empty, returns 'true'.", testList.isEmpty());
        testList.insert("Good work");
        assertEquals("Confirm new value is inserted after deleteAll runs.", "Good work", testList.getHeadValue());
    }

    @Test
    public void testLinkedListMerge() {
        // Test on lists of equal length
        LinkedList<String> list1 = new LinkedList<>();
        LinkedList<String> list2 = new LinkedList<>();
        assertTrue("list1 should start empty.", list1.isEmpty());
        assertTrue("list2 should start empty.", list2.isEmpty());
        list1.insert("1");
        list1.append("3");
        list1.append("5");
        list1.append("7");
        list1.append("9"); //list1:{1, 3, 5, 7, 9}
        list2.insert("2");
        list2.append("4");
        list2.append("6");
        list2.append("8");
        list2.append("10"); //list2:{2, 4, 6, 8, 10}
        LinkedList<String> testMerge = LinkedList.merge(list1, list2); //expect: {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}
        assertEquals("Merged list should be length '10'.", 10, testMerge.size());
        assertEquals("Head value of merged list should be '1'.", "1", testMerge.getHeadValue());
        assertEquals("Tail value of merged list should be '10'.", "10", testMerge.getLastValue());
        assertTrue("Remove the tail value of '10', should return 'true'.", testMerge.deleteValue("10"));
        assertEquals("Tail value of merged list should now be '9'.", "9", testMerge.getLastValue());
        assertTrue("Remove the tail value of '9', should return 'true'.", testMerge.deleteValue("9"));
        assertEquals("Tail value of merged list should now be '8'.", "8", testMerge.getLastValue());

        //Test on lists where list1 > list2
        list1.deleteAll();
        list2.deleteAll();
        testMerge.deleteAll();
        list1.append("1");
        list1.append("3");
        list1.append("5");
        list1.append("6");
        list1.append("7"); //list1:{1, 3, 5, 6, 7}
        list2.append("2");
        list2.append("4"); //list2:{2, 4}
        testMerge = LinkedList.merge(list1, list2); //expect: {1, 2, 3, 4, 5, 6, 7}
        assertEquals("Merged list should be length '7'.", 7, testMerge.size());
        assertEquals("Head value of merged list should be '1'.", "1", testMerge.getHeadValue());
        assertEquals("Tail value of merged list should be '7'.", "7", testMerge.getLastValue());
        assertTrue("Remove the tail value of '7', should return 'true'.", testMerge.deleteValue("7"));
        assertEquals("Tail value of merged list should now be '6'.", "6", testMerge.getLastValue());
        assertTrue("Remove the tail value of '6', should return 'true'.", testMerge.deleteValue("6"));
        assertEquals("Tail value of merged list should now be '5'.", "5", testMerge.getLastValue());

        //Test on lists where list1 < list2
        list1.deleteAll();
        list2.deleteAll();
        testMerge.deleteAll();
        list1.append("1");
        list1.append("3");
        list1.append("5"); //list1:{1, 3, 5}
        list2.append("2");
        list2.append("4");
        list2.append("6");
        list2.append("7");
        list2.append("8");
        list2.append("9"); //list2:{2, 4, 6, 7, 8, 9}
        testMerge = LinkedList.merge(list1, list2); //expect: {1, 2, 3, 4, 5, 6, 7, 8, 9}
        assertEquals("Merged list should be length '9'.", 9, testMerge.size());
        assertEquals("Head value of merged list should be '1'.", "1", testMerge.getHeadValue());
        assertEquals("Tail value of merged list should be '9'.", "9", testMerge.getLastValue());
        assertTrue("Remove the tail value of '9', should return 'true'.", testMerge.deleteValue("9"));
        assertEquals("Tail value of merged list should now be '8'.", "8", testMerge.getLastValue());
        assertTrue("Remove the tail value of '8', should return 'true'.", testMerge.deleteValue("8"));
        assertEquals("Tail value of merged list should now be '7'.", "7", testMerge.getLastValue());
        testMerge.deleteValue("7");
        testMerge.deleteValue("6");
        System.out.println(testMerge.toString());
        assertEquals("Tail value of merged list should now be '5'.", "5", testMerge.getLastValue());

        // list1 = 0 < list2
        list1.deleteAll();
        list2.deleteAll();
        testMerge.deleteAll();
        list2.insert("3");
        list2.insert("2");
        list2.insert("1");
        testMerge = LinkedList.merge(list1, list2);
        assertEquals("Merged list should be length '3'.", 3, testMerge.size());
        assertEquals("Head value of merged list should be '1'.", "1", testMerge.getHeadValue());
        assertEquals("Tail value of merged list should be '3'.", "3", testMerge.getLastValue());

        // list1 > list2 = 0
        list1.deleteAll();
        list2.deleteAll();
        testMerge.deleteAll();
        list1.insert("3");
        list1.insert("2");
        list1.insert("1");
        testMerge = LinkedList.merge(list1, list2);
        assertEquals("Merged list should be length '3'.", 3, testMerge.size());
        assertEquals("Head value of merged list should be '1'.", "1", testMerge.getHeadValue());
        assertEquals("Tail value of merged list should be '3'.", "3", testMerge.getLastValue());
    }

    @Test
    public void testReverseLinkedList() {
        LinkedList<String> testList = new LinkedList<>();
        testList.insert("5"); // Tail
        testList.insert("4");
        testList.insert("3");
        testList.insert("2");
        testList.insert("1"); // Head

        assertEquals("Confirm head value is '1' before reversing", "1", testList.getHeadValue());
        assertEquals("Confirm last value is '5' before reversing", "5", testList.getLastValue());

        testList.reverseList();

        assertEquals("Now head value should be '5'.", "5", testList.getHeadValue());
        assertEquals("Now last value should be '1'.", "1", testList.getLastValue());
        assertEquals("Middle value should be '3'.", "3", testList.findMiddleNode());
    }

}