package hashtable;

import org.junit.Test;

import static org.junit.Assert.*;

public class HashtableTest {

    @Test
    public void testConstructor() {
        Hashtable<String, String> testTable = new Hashtable<>();
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

    }

    @Test
    public void testFind() {

    }

    @Test
    public void testContains() {

    }

    @Test
    public void testGetHash() {

    }

    @Test
    public void testHash() {
        Hashtable<String, String> testTable = new Hashtable<>();
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
