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

        int[] testArray5 = new int[]{11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        assertArrayEquals("Passing in an array sorted high to low should give back array in reverse order.", new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11}, Sort.insertionSort(testArray5));
    }

    @Test
    public void testMergeSort() {
        int[] testArray1 = new int[]{2, 1, 4, 3};
        assertArrayEquals("Should return a sorted array from low to high values.", new int[]{1, 2, 3, 4}, Sort.mergeSort(testArray1));

        int[] testArray2 = new int[]{20, 18, 5, 3, 7, 1, 2, 8, 10, 14, 4};
        assertArrayEquals("Should return a sorted array from low to high values.", new int[]{1, 2, 3, 4, 5, 7, 8, 10, 14, 18, 20}, Sort.mergeSort(testArray2));

        int[] testArray3 = new int[]{};
        assertArrayEquals("Method should be able to handle an empty array.", new int[]{}, Sort.mergeSort(testArray3));

        int[] testArray4 = new int[]{99};
        assertArrayEquals("Passing in a one element array should return a copy of the same array.", new int[]{99}, Sort.mergeSort(testArray4));

        int[] testArray5 = new int[]{-5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5};
        assertArrayEquals("Passing in a sorted array should return a copy of the same array.", new int[]{-5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5}, Sort.mergeSort(testArray5));
    }

    @Test
    public void testMerge() {

        int[] testArray1 = new int[]{1, 3, 5, 7, 9};
        int[] testArray2 = new int[]{2, 4, 6, 8};

        assertArrayEquals("Should return one sorted array when passing in two sorted arrays.", new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, Sort.merge(testArray1, testArray2));
        assertEquals("Result length should be the sum length of both input arrays.", testArray1.length + testArray2.length, Sort.merge(testArray1, testArray2).length);

        int[] testArray3 = new int[]{0, 5, 10, 15, 20, 25, 30};
        int[] testArray4 = new int[]{1};

        assertArrayEquals("Method should support uneven lengths of input arrays.", new int[]{0, 1, 5, 10, 15, 20, 25, 30}, Sort.merge(testArray3, testArray4));
        assertArrayEquals("Order parameters are passed should have no effect.", new int[]{0, 1, 5, 10, 15, 20, 25, 30}, Sort.merge(testArray4, testArray3));

    }
}