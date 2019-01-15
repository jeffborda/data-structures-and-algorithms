package hashtable;

import org.junit.Test;

import static org.junit.Assert.*;

public class HashtableTest {

    @Test
    public void testConstructor() {
        Hashtable<String> testTable = new Hashtable<>();
        assertEquals("Table should have array of size '16' when instantiated.", 16, testTable.table.length);
        for(int i = 0; i < testTable.table.length; i++) {
            assertEquals("Table should only have 'null' values before adding anything.", null, testTable.table[i]);
        }
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

        assertEquals("Check value when there is no possibility of collisions.", (Integer) 1, testTable.table[index1].value);
        // If there was a collision, this test will run
        if(index2 == index1) {
            assertEquals("This test will run if there was a collision when adding the 2.", (Integer) 2, testTable.table[index2].next.value);
        }
        else {
            assertEquals("Check value when there was no collision", (Integer) 2, testTable.table[index2].value);
        }


        if(index3 == index2 && index1 == index2) {
            assertEquals("This test will run if there was a collision with '1' and '3' or '2' and '3'.",(Integer) 3, testTable.table[index3].next.value);
        }
        else if(index3 == index2 || index3 == index1) {
            assertEquals("If all nodes were added to the same index, a triple collision, this test will run.", (Integer) 3, testTable.table[index3].next.next.value);
        }
        else {
            assertEquals("Check value if there was no collision.", (Integer) 3, testTable.table[index3].value);
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

        String[] strs = new String[]{"four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen", "twenty"};
        for(int i = 0; i < strs.length; i++) {
            testTable.add(Integer.toString(i + 4), strs[i]);
        }
        for(int i = 0; i < strs.length; i++) {
            assertEquals("Make sure it can get values when there must be collisions.", strs[i], testTable.find(((Integer)(i+4)).toString()).value);
        }

        assertEquals("Confirm original values are still in the Hashtable", "Scoutdog", testTable.find("best dog").value);
        assertEquals("Confirm original values are still in the Hashtable", "Luna", testTable.find("smallest dog").value);
        assertEquals("Confirm original values are still in the Hashtable", "Elsa", testTable.find("naughty dog").value);



    }

    @Test
    public void testContains() {
        Hashtable<String> testTable = new Hashtable<>();
        String[] strs = new String[]{"one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen", "twenty"};
        for(int i = 1; i < strs.length; i++) {
            testTable.add(((Integer)i).toString(), strs[i]);

        }

        for(int i = 1; i < strs.length; i++) {
            assertTrue("Should return 'true' when input is a key that was added to the Hashtable.", testTable.contains( ((Integer)i).toString())  );
        }

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

        assertTrue("Hash should return a number between 0 and 16.", resultInt1 >= 0 && resultInt1 <= testTable.table.length);
        assertTrue("Hash should return a number between 0 and 16.", resultInt2 >= 0 && resultInt1 <= testTable.table.length);
        assertTrue("Hash should return a number between 0 and 16.", resultInt3 >= 0 && resultInt1 <= testTable.table.length);
        assertTrue("Hash should return a number between 0 and 16.", resultInt4 >= 0 && resultInt1 <= testTable.table.length);
        assertFalse("Should be extraordinarily unlikely for all four hashes to give same number.", resultInt1 == resultInt2 && resultInt1 == resultInt3 && resultInt1 == resultInt4 && resultInt2 == resultInt3 && resultInt2 == resultInt4 && resultInt3 == resultInt4);

        String testKey5 = "Test";
        int resultInt5 = testTable.getHash(testKey5);
        assertEquals("Hash should return the same int given the same string.", resultInt4, resultInt5);
    }

    @Test
    public void testSize() {
        Hashtable<String> testTable = new Hashtable<>();
        assertEquals("Size should be '0' when instantiated.", 0, testTable.size());
        testTable.add("thing one", "thing");
        testTable.add("thing two", "thing");
        assertEquals("Size should now be '2'.", 2, testTable.size());

        String[] strs = new String[]{"one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen", "twenty"};
        for(int i = 1; i < strs.length; i++) {
            testTable.add(((Integer)i).toString(), strs[i]);

        }

        assertEquals("Confirm it returns the correct size when there have been collisions.", 21, testTable.size());
    }
}
