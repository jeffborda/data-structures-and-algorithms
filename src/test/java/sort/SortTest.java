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

    @Test
    public void quickSort() {
        int[] testArray1 = new int[]{10, 5, 7, 3, 9};
        Sort.quickSort(testArray1);

        assertArrayEquals("Sorted array should go low to high.", new int[]{3, 5, 7, 9, 10}, testArray1);

        int[] testArray2 = new int[0];
        Sort.quickSort(testArray2);
        assertArrayEquals("Passing an empty array should not break the algorithm, returns empty array.", new int[]{}, testArray2);

        int[] testArray3 = new int[]{99};
        Sort.quickSort(testArray3);
        assertArrayEquals("If input array only has one element, it should return the same.", new int[]{99}, testArray3);

        int[] testArray4 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Sort.quickSort(testArray4);
        assertArrayEquals("Passing a sorted array should return it the same as it was passed in.", new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, testArray4);

        int[] testArray5 = new int[]{11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        Sort.quickSort(testArray5);
        assertArrayEquals("Passing in an array sorted high to low should give back array in reverse order.", new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11}, testArray5);

        int[] testArray6 = new int[]{45, 1, 94, 40, 65, 71, 74, 82, 62, 34, 57, 67, 35, 79, 63, 90, 76, 13, 58, 9, 66, 28, 72, 31, 32, 88, 10, 29, 83, 0, 95, 30, 5, 47, 52, 46, 56, 61, 75, 49, 33, 27, 91, 22, 7, 39, 50, 48, 89, 84};
        int[] expected6 = new int[] {0, 1, 5, 7, 9, 10, 13, 22, 27, 28, 29, 30, 31, 32, 33, 34, 35, 39, 40, 45, 46, 47, 48, 49, 50, 52, 56, 57, 58, 61, 62, 63, 65, 66, 67, 71, 72, 74, 75, 76, 79, 82, 83, 84, 88, 89, 90, 91, 94, 95};
        Sort.quickSort(testArray6);
        assertArrayEquals("Test a large list.", expected6, testArray6);

        int[] testArray7 = new int[]{99, 1};
        Sort.quickSort(testArray7);
        assertArrayEquals("Two element array.", new int[]{1, 99}, testArray7);

        int[] testArray8 = new int[]{99, 50, 1, -1, 110};
        Sort.quickSort(testArray8);
        assertArrayEquals("Three element array.", new int[]{-1, 1, 50, 99, 110}, testArray8);

        int[] testArray9 = new int[]{7, 8, 1, 9, 10};
        Sort.quickSort(testArray9);
        assertArrayEquals("Test case where the pivot gets swapped initially.", new int[]{1, 7, 8, 9, 10},  testArray9);

        int[] testArray10 = new int[]{12, 6, 13, 15, 3, 19, 8, 7, 17, 20, 2, 14, 0, 11}; //breaking at size 14
        int[] expected10 = new int[] {0, 2, 3, 6, 7, 8, 11, 12, 13, 14, 15, 17, 19, 20};
        Sort.quickSort(testArray10);
        assertArrayEquals("Test a medium list", expected10, testArray10);

    }


    @Test
    public void testRadixSort() {
        int[] testArray1 = new int[]{9, 8, 5, 6, 7, 0};
        int[] expected1 = new int[]{0, 5, 6, 7, 8, 9};
        assertArrayEquals("Single digits test with a '0' input.", expected1, Sort.radixSort(testArray1));

        int[] testArray2 = new int[]{56, 79, 64, 51, 21, 11, 32, 25, 86, 32, 27, 74};
        int[] expected2 = new int[] {11, 21, 25, 27, 32, 32, 51, 56, 64, 74, 79, 86};
        assertArrayEquals("Double digits test", expected2, Sort.radixSort(testArray2));

        int[] testArray3 = new int[]{493, 311, 677, 274, 328, 376, 841, 298, 823, 768, 987, 683, 988, 886, 640, 109, 656, 517, 209, 801};
        int[] expected3 =  new int[]{109, 209, 274, 298, 311, 328, 376, 493, 517, 640, 656, 677, 683, 768, 801, 823, 841, 886, 987, 988};
        assertArrayEquals("Three digits test", expected3, Sort.radixSort(testArray3));

        int[] testArray4 = new int[]{9610, 3129, 9642, 5438, 2339, 3123, 7764, 67, 7610, 2480, 7811, 19, 4025, 4704, 6187, 9237, 4790, 1461, 4124, 843};
        int[] expected4  = new int[]{19, 67, 843, 1461, 2339, 2480, 3123, 3129, 4025, 4124, 4704, 4790, 5438, 6187, 7610, 7764, 7811, 9237, 9610, 9642};
        assertArrayEquals("Should handle input array with numbers of different length.", expected4, Sort.radixSort(testArray4));
    }

}