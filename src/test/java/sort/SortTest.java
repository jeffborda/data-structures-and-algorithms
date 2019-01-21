package sort;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SortTest {

    @Test
    public void testInsertionSort() {
        int[] testArray1 = new int[]{10, 5, 7, 3};
        Assert.assertEquals("Return array should be same length as input array.", testArray1.length, Sort.insertionSort(testArray1).length);
        assertArrayEquals("Sorted array should go low to high.", new int[]{3, 5, 7, 10}, Sort.insertionSort(testArray1));

        int[] testArray2 = new int[0];
        assertArrayEquals("Passing an empty array should not break the algorithm, returns empty array.", new int[]{}, Sort.insertionSort(testArray2));

        int[] testArray3 = new int[]{99};
        assertArrayEquals("If input array only has one element, it should return the same.", new int[]{99}, Sort.insertionSort(testArray3));

        int[] testArray4 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        assertArrayEquals("Passing a sorted array should return it the same as it was passed in.", new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, Sort.insertionSort(testArray4));

        int[] testArray5 = new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        assertArrayEquals("Passing in an array sorted high to low should give back array in reverse order.", new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, Sort.insertionSort(testArray5));
    }
}