package arrays;

import arrays.BinarySearch;
import org.junit.Test;

import static org.junit.Assert.*;

public class BinarySearchTest {

    private int[] testArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};

    @Test
    public void testBinarySearch_firstElement() {
        assertEquals("binarySearch method should return 0, the index of target number", 0, BinarySearch.binarySearch(testArray, 1));
    }

    @Test
    public void testBinarySearch_lastElement() {
        assertEquals("binarySearch method should return 12, the index of target number", 12, BinarySearch.binarySearch(testArray, 13));
    }

    @Test
    public void testBinarySearch_index4() {
        assertEquals("binarySearch method should return 4, the index of target number", 4, BinarySearch.binarySearch(testArray, 5));
    }

    @Test
    public void testBinarySearch_index9() {
        assertEquals("binarySearch method should return 9, the index of target number", 9, BinarySearch.binarySearch(testArray, 10));
    }

    @Test
    public void testBinarySearch_noSuchValue() {
        assertEquals("binarySearch method should return -1, if target number is not in the array", -1, BinarySearch.binarySearch(testArray, 99));
    }

    @Test
    public void testBinarySearch_length2Array() {
        int[] smallArray = {1, 2};
        assertEquals("binarySearch method should return 0, the index of target number", 0, BinarySearch.binarySearch(smallArray, 1));
        assertEquals("binarySearch method should return 1, the index of target number", 1, BinarySearch.binarySearch(smallArray, 2));
    }

    @Test
    public void testBinarySearch_length1Array() {
        int[] oneElementArray = {1};
        assertEquals("binarySearch method should return 0, the index of target number", 0, BinarySearch.binarySearch(oneElementArray, 1));
    }

    @Test
    public void testBinarySearch_lengthZeroArray() {
        int[] emptyArray = new int[0];
        assertEquals("Should return -1 without errors when given an empty array.", -1, BinarySearch.binarySearch(testArray, 99));

    }
}
