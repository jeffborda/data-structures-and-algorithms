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
        assertArrayEquals("insertArrayShift should insert number 99 to the right of middle element.", expected, ArrayShift.insertShiftArray(input, 99));
    }

    @Test
    public void testInsertShiftArray_evenLengthInput() {
        int[] input = {1, 2, 3, 4};
        int[] expected = {1, 2, 99, 3, 4};
        assertArrayEquals("insertArrayShift should insert number 99 to the middle", expected, ArrayShift.insertShiftArray(input, 99));
    }

    @Test
    public void testInsertShiftArray_length1Input() {
        int[] input = {1};
        int[] expected = {1, 99};
        assertArrayEquals("insertArrayShift should insert number 99 to the middle", expected, ArrayShift.insertShiftArray(input, 99));
    }

    @Test
    public void testInsertShiftArray_length2Input() {
        int[] input = {1, 2};
        int[] expected = {1, 99, 2};
        assertArrayEquals("insertArrayShift should insert number 99 to the middle", expected, ArrayShift.insertShiftArray(input, 99));
    }

    @Test
    public void testInsertShiftArray_largerOddLengthInput() {
        int[] input = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23};
        int[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 99, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23};
        assertArrayEquals("insertArrayShift should insert number 99 to the middle", expected, ArrayShift.insertShiftArray(input, 99));
    }

    @Test
    public void testShiftZerosToEnd() {
        int[] input = {0, 1, 0, 2, 0, 3, 0, 4, 0, 5};
        int[] expected = {1, 2, 3, 4, 5, 0, 0, 0, 0, 0};
        assertArrayEquals("Should shift all zero's to the right, and maintain relative order of the other numbers.", expected, ArrayShift.shiftZerosToEnd(input));
    }

    @Test
    public void testShiftZerosToEnd_lengthOneArray() {
        int[] input = {0};
        int[] expected = {0};
        assertArrayEquals("Should return the same array.", expected, ArrayShift.shiftZerosToEnd(input));
    }

    @Test
    public void testShiftZerosToEnd_zerosAlreadyToEnd() {
        int[] input = {-10, 9, -100, 0, 0, 0};
        int[] expected = {-10, 9, -100, 0, 0, 0};
        assertArrayEquals("Should return the same array.", expected, ArrayShift.shiftZerosToEnd(input));
    }

    @Test
    public void testShiftZerosToEnd_someZerosAtEnd() {
        int[] input = {1, 0, 0, 0, 2, 3, 0, 4, 5, 0, 0, 0};
        int[] expected = {1, 2, 3, 4, 5, 0, 0, 0, 0, 0, 0, 0};
        assertArrayEquals("Should shift zeros to the end.", expected, ArrayShift.shiftZerosToEnd(input));
    }
}
