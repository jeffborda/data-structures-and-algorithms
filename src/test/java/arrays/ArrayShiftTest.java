package arrays;

import arrays.ArrayShift;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class ArrayShiftTest {

    @Test
    public void testInsertShiftArray_oddLengthInput() {
        int[] input = {1, 2, 3, 4, 5};
        int[] expected = {1, 2, 3, 99, 4, 5};
        assertArrayEquals("Should insert number 99 to the right of middle element if input array is an odd length.", expected, ArrayShift.insertShiftArray(input, 99));
    }

    @Test
    public void testInsertShiftArray_evenLengthInput() {
        int[] input = {1, 2, 3, 4};
        int[] expected = {1, 2, 99, 3, 4};
        assertArrayEquals("Should insert number 99 to the middle of array if input is even numbered length.", expected, ArrayShift.insertShiftArray(input, 99));
    }

    @Test
    public void testInsertShiftArray_length1Input() {
        int[] input = {1};
        int[] expected = {1, 99};
        assertArrayEquals("Should insert the number to end of array if input array is length 1.", expected, ArrayShift.insertShiftArray(input, 99));
    }

    @Test
    public void testInsertShiftArray_length2Input() {
        int[] input = {1, 2};
        int[] expected = {1, 99, 2};
        assertArrayEquals("Should insert number 99 to the middle of input array.", expected, ArrayShift.insertShiftArray(input, 99));
    }

    @Test
    public void testInsertShiftArray_largerOddLengthInput() {
        int[] input = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23};
        int[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 99, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23};
        assertArrayEquals("Should insert number 99 to the right side of the middle with odd input array length.", expected, ArrayShift.insertShiftArray(input, 99));
    }

    @Test
    public void testShiftZerosToEnd_zeroAtFirstElement() {
        int[] input = {0, 1, 0, 2, 0, 3, 0, 4, 0, 5};
        int[] expected = {1, 2, 3, 4, 5, 0, 0, 0, 0, 0};
        assertArrayEquals("Should shift all zero's to the right, and maintain relative order of the other numbers.", expected, ArrayShift.shiftZerosToEnd(input));
    }

    @Test
    public void testShiftZerosToEnd_zeroAtFirstAndLastElement() {
        int[] input = {0, 1, 0, 2, 0, 3, 0, 4, 0, 5};
        int[] expected = {1, 2, 3, 4, 5, 0, 0, 0, 0, 0};
        assertArrayEquals("Should shift all zero's to the right, and maintain relative order of the other numbers.", expected, ArrayShift.shiftZerosToEnd(input));
    }

    @Test
    public void testShiftZerosToEnd_consecutiveZeros() {
        int[] input = {0, 0, 0, 111, 0, 0, 0, 222, 0, 0, 0};
        int[] expected = {111, 222, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        assertArrayEquals("Should shift all zero's to the right, and maintain relative order of the other numbers.", expected, ArrayShift.shiftZerosToEnd(input));
    }

    @Test
    public void testShiftZerosToEnd_lengthOneArrayWithZero() {
        int[] input = {0};
        int[] expected = {0};
        assertArrayEquals("Should return the same array.", expected, ArrayShift.shiftZerosToEnd(input));
    }

    @Test
    public void testShiftZerosToEnd_lengthOneArrayWithNonZero() {
        int[] input = {42};
        int[] expected = {42};
        assertArrayEquals("Should return the same array.", expected, ArrayShift.shiftZerosToEnd(input));
    }

    @Test
    public void testShiftZerosToEnd_zerosAlreadyAtEnd() {
        int[] input = {-10, 9, -100, 0, 0, 0};
        int[] expected = {-10, 9, -100, 0, 0, 0};
        assertArrayEquals("If array already in correct order, should return the same array.", expected, ArrayShift.shiftZerosToEnd(input));
    }

    @Test
    public void testShiftZerosToEnd_allZeros() {
        int[] input = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] expected = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        assertArrayEquals("Test array with all zeros, should return the same array.", expected, ArrayShift.shiftZerosToEnd(input));
    }
}
