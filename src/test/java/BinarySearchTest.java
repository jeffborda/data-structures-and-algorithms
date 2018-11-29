import org.junit.Test;

import static org.junit.Assert.*;

public class BinarySearchTest {

    @Test
    public void testBinarySearch() {
        int[] testArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};

        assertEquals("binarySearch method should return 0, the index of target number", 0, BinarySearch.binarySearch(testArray, 1));
        assertEquals("binarySearch method should return 12, the index of target number", 12, BinarySearch.binarySearch(testArray, 13));
        assertEquals("binarySearch method should return 4, the index of target number", 4, BinarySearch.binarySearch(testArray, 5));
        assertEquals("binarySearch method should return 9, the index of target number", 9, BinarySearch.binarySearch(testArray, 10));
        assertEquals("binarySearch method should return -1, if target number not found", -1, BinarySearch.binarySearch(testArray, 99));

        int[] smallArray = {1, 2};

        assertEquals("binarySearch method should return 0, the index of target number", 0, BinarySearch.binarySearch(testArray, 1));
        assertEquals("binarySearch method should return 1, the index of target number", 1, BinarySearch.binarySearch(testArray, 2));

        int[] oneElementArray = {1};

        assertEquals("binarySearch method should return 0, the index of target number", 0, BinarySearch.binarySearch(testArray, 1));


        int[] emptyArray = new int[0];

        assertEquals("binarySearch method should return 1, the index of target number", 1, BinarySearch.binarySearch(testArray, 2));
    }
}