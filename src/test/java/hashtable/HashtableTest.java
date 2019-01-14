package hashtable;

import org.junit.Test;

import static org.junit.Assert.*;

public class HashtableTest {

    @Test
    public void testConstructor() {
        Hashtable<String> testTable = new Hashtable<>();
        assertEquals("Table should have array of size '16' when instantiated.", 16, testTable.table.length);
        assertTrue("Table should be filled with Nodes.", testTable.table[2] instanceof Node);
        assertTrue("Table should be filled with Nodes.", testTable.table[3] instanceof Node);
        assertTrue("Table should be filled with Nodes.", testTable.table[4] instanceof Node);
        assertTrue("Table should be filled with Nodes.", testTable.table[5] instanceof Node);
        assertEquals("Table should hold empty Nodes that point to 'null' upon instantiation.", null, testTable.table[0].next);
        assertEquals("Table should hold empty Nodes that point to 'null' upon instantiation.", null, testTable.table[1].next);
        assertEquals("Table should hold empty Nodes that point to 'null' upon instantiation.", null, testTable.table[6].next);
        assertEquals("Table should hold empty Nodes that point to 'null' upon instantiation.", null, testTable.table[7].next);;
        assertEquals("Table should hold empty Nodes that point to 'null' upon instantiation.", null, testTable.table[14].next);
        assertEquals("Table should hold empty Nodes that point to 'null' upon instantiation.", null, testTable.table[15].next);
    }

    @Test
    public void testAdd() {
        Hashtable<Integer> testTable = new Hashtable<>();
        int index1 = testTable.getHash("one");
        int index2 = testTable.getHash("two");
        int index3 = testTable.getHash("three");
        int index4 = testTable.getHash("four");
        testTable.add("one", 1);
        testTable.add("two", 2);
        testTable.add("three", 3);
        testTable.add("four", 4);

        assertEquals("Check value when there is no possibility of collisions.", 1, testTable.table[index1].next.value);
        // If there was a collision, this test will run
        if(index2 == index1) {
            assertEquals("This test will run if there was a collision when adding the 2.", 2, testTable.table[index2].next.next.value);
        }
        else {
            assertEquals("Check value when there was no collision", 2, testTable.table[index2].next.value);
        }


        if(index3 == index2 || index3 == index1) {
            assertEquals("This test will run if there was a collision with '1' and '3' or '2' and '3'.",3, testTable.table[index3].next.next.value);
        }
        else if(index3 == index2 && index1 == index2) {
            assertEquals("If all nodes were added to the same index, a triple collision, this test will run.", 3, testTable.table[index3].next.next.next.value);
        }
        else {
            assertEquals("Check value if there was no collision.", 3, testTable.table[index3].next.value);
        }




    }

    @Test
    public void testFind() {
        Hashtable<String> testTable = new Hashtable<>();
        testTable.add("best dog", "Scoutdog");
        assertEquals("Make sure it returns the matching Node when it is the only key/value pair in the Hashtable", "Scoutdog", testTable.find("best dog").value);
        assertEquals("Confirm the key returns correctly also.", "best dog", testTable.find("best dog").key);

        testTable.add("smallest dog", "Luna");
        testTable.add("naughty dog", "Elsa");

        assertEquals("Confirm it returns matching Node when there are multiple Nodes in the Hashtable.", "Luna", testTable.find("smallest dog").value);
        assertEquals("Confirm it returns matching Node when there are multiple Nodes in the Hashtable.", "Elsa", testTable.find("naughty dog").value);

        testTable.add("4", "four");
        testTable.add("5", "five");
        testTable.add("6", "six");
        testTable.add("7", "seven");
        testTable.add("8", "eight");
        testTable.add("9", "nine");
        testTable.add("10", "ten");
        testTable.add("11", "eleven");
        testTable.add("12", "twelve");
        testTable.add("13", "thirteen");
        testTable.add("14", "fourteen");
        testTable.add("15", "fifteen");
        testTable.add("16", "sixteen");
        testTable.add("17", "seventeen");
        testTable.add("18", "eighteen");
        testTable.add("19", "nineteen");
        testTable.add("20", "twenty");

        assertEquals("Make sure it can get values when there must be collisions.", "four", testTable.find("4").value);
        assertEquals("Make sure it can get values when there must be collisions.", "five", testTable.find("5").value);
        assertEquals("Make sure it can get values when there must be collisions.", "six", testTable.find("6").value);
        assertEquals("Make sure it can get values when there must be collisions.", "seven", testTable.find("7").value);
        assertEquals("Make sure it can get values when there must be collisions.", "eight", testTable.find("8").value);
        assertEquals("Make sure it can get values when there must be collisions.", "nine", testTable.find("9").value);
        assertEquals("Make sure it can get values when there must be collisions.", "ten", testTable.find("10").value);
        assertEquals("Make sure it can get values when there must be collisions.", "eleven", testTable.find("11").value);
        assertEquals("Make sure it can get values when there must be collisions.", "twelve", testTable.find("12").value);
        assertEquals("Make sure it can get values when there must be collisions.", "thirteen", testTable.find("13").value);
        assertEquals("Make sure it can get values when there must be collisions.", "fourteen", testTable.find("14").value);
        assertEquals("Make sure it can get values when there must be collisions.", "fifteen", testTable.find("15").value);
        assertEquals("Make sure it can get values when there must be collisions.", "sixteen", testTable.find("16").value);
        assertEquals("Make sure it can get values when there must be collisions.", "seventeen", testTable.find("17").value);
        assertEquals("Make sure it can get values when there must be collisions.", "eighteen", testTable.find("18").value);
        assertEquals("Make sure it can get values when there must be collisions.", "nineteen", testTable.find("19").value);
        assertEquals("Make sure it can get values when there must be collisions.", "twenty", testTable.find("20").value);

        for(int i = 0; i < testTable.table.length; i++) {
            System.out.println(testTable.table[i]);
        }
    }

    @Test
    public void testContains() {
        Hashtable<String> testTable = new Hashtable<>();
        testTable.add("1", "one");
        testTable.add("2", "two");
        testTable.add("3", "three");
        testTable.add("4", "four");
        testTable.add("5", "five");
        testTable.add("6", "six");
        testTable.add("7", "seven");
        testTable.add("8", "eight");
        testTable.add("9", "nine");
        testTable.add("10", "ten");
        testTable.add("11", "eleven");
        testTable.add("12", "twelve");
        testTable.add("13", "thirteen");
        testTable.add("14", "fourteen");
        testTable.add("15", "fifteen");
        testTable.add("16", "sixteen");
        testTable.add("17", "seventeen");
        testTable.add("18", "eighteen");
        testTable.add("19", "nineteen");
        testTable.add("20", "twenty");

        assertTrue("Should return 'true' when input is a key that was added to the Hashtable.", testTable.contains("1"));
        assertTrue("Should return 'true' when input is a key that was added to the Hashtable.", testTable.contains("2"));
        assertTrue("Should return 'true' when input is a key that was added to the Hashtable.", testTable.contains("3"));
        assertTrue("Should return 'true' when input is a key that was added to the Hashtable.", testTable.contains("4"));
        assertTrue("Should return 'true' when input is a key that was added to the Hashtable.", testTable.contains("5"));
        assertTrue("Should return 'true' when input is a key that was added to the Hashtable.", testTable.contains("6"));
        assertTrue("Should return 'true' when input is a key that was added to the Hashtable.", testTable.contains("7"));
        assertTrue("Should return 'true' when input is a key that was added to the Hashtable.", testTable.contains("8"));
        assertTrue("Should return 'true' when input is a key that was added to the Hashtable.", testTable.contains("9"));
        assertTrue("Should return 'true' when input is a key that was added to the Hashtable.", testTable.contains("10"));
        assertTrue("Should return 'true' when input is a key that was added to the Hashtable.", testTable.contains("11"));
        assertTrue("Should return 'true' when input is a key that was added to the Hashtable.", testTable.contains("12"));
        assertTrue("Should return 'true' when input is a key that was added to the Hashtable.", testTable.contains("13"));
        assertTrue("Should return 'true' when input is a key that was added to the Hashtable.", testTable.contains("14"));
        assertTrue("Should return 'true' when input is a key that was added to the Hashtable.", testTable.contains("15"));
        assertTrue("Should return 'true' when input is a key that was added to the Hashtable.", testTable.contains("16"));
        assertTrue("Should return 'true' when input is a key that was added to the Hashtable.", testTable.contains("17"));
        assertTrue("Should return 'true' when input is a key that was added to the Hashtable.", testTable.contains("18"));
        assertTrue("Should return 'true' when input is a key that was added to the Hashtable.", testTable.contains("19"));
        assertTrue("Should return 'true' when input is a key that was added to the Hashtable.", testTable.contains("20"));
        assertFalse("Should return 'false' when input NOT in Hashtable.", testTable.contains("99999"));
        assertFalse("Should return 'false' when input NOT in Hashtable.", testTable.contains("FALSE"));



    }


    @Test
    public void testGetHash() {
        Hashtable<String> testTable = new Hashtable<>();
        String testKey1 = "test";
        String testKey2 = "a";
        String testKey3 = "1837 my name is Jeff!";
        String testKey4 = "Test";

        int resultInt1 = testTable.getHash(testKey1);
        int resultInt2 = testTable.getHash(testKey2);
        int resultInt3 = testTable.getHash(testKey3);
        int resultInt4 = testTable.getHash(testKey4);



        System.out.println(resultInt1);
        System.out.println(resultInt2);
        System.out.println(resultInt3);
        System.out.println(resultInt4);


        assertTrue("Hash should return a number between 0 and 16.", resultInt1 >= 0 && resultInt1 <= 16);
        assertTrue("Hash should return a number between 0 and 16.", resultInt2 >= 0 && resultInt1 <= 16);
        assertTrue("Hash should return a number between 0 and 16.", resultInt3 >= 0 && resultInt1 <= 16);
        assertTrue("Hash should return a number between 0 and 16.", resultInt4 >= 0 && resultInt1 <= 16);

        String testKey5 = "Test";
        int resultInt5 = testTable.getHash(testKey5);
        assertEquals("Hash should return the same int given the same string.", resultInt4, resultInt5);
    }
}
