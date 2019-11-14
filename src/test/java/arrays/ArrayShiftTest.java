package arrays;

import arrays.ArrayShift;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class ArrayShiftTest {

    @Test
    public void testInsertShiftArray() {

        //ArrayShift classUnderTest = new ArrayShift();

        // Odd number of elements
        int[] test1 = {1, 2, 3, 4, 5};
        int[] test1Expected = {1, 2, 3, 99, 4, 5};


        // Even number of elements
        int[] test2 = {1, 2, 3, 4};
        int[] test2Expected = {1, 2, 99, 3, 4};

        // One element
        int[] test3 = {1};
        int[] test3Expected = {1, 99};

        // Two elements
        int[] test4 = {1, 2};
        int[] test4Expected = {1, 99, 2};

        // Large odd number of elements
        int[] test5 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23};
        int[] test5Expected = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 99, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23};

        assertArrayEquals("insertArrayShift should insert number 99 to the middle", test1Expected, ArrayShift.insertShiftArray(test1, 99));
        assertArrayEquals("insertArrayShift should insert number 99 to the middle", test2Expected, ArrayShift.insertShiftArray(test2, 99));
        assertArrayEquals("insertArrayShift should insert number 99 to the middle", test3Expected, ArrayShift.insertShiftArray(test3, 99));
        assertArrayEquals("insertArrayShift should insert number 99 to the middle", test4Expected, ArrayShift.insertShiftArray(test4, 99));
        assertArrayEquals("insertArrayShift should insert number 99 to the middle", test5Expected, ArrayShift.insertShiftArray(test5, 99));
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
