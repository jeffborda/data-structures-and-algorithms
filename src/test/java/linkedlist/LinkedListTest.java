package linkedlist;

import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedListTest {

    @Test
    public void insert() {
        LinkedList testList = new LinkedList();
        testList.insert("Hello");
        assertTrue("Make sure list contains 'Hello'", testList.includes("Hello"));
    }

    @Test
    public void includes() {
    }

    @Test
    public void print() {
    }
}