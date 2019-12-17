package arrays;

import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayReverseTest {

    @Test
    public void reverseArray_oddLengthInput() {
        String[] testArr = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15"};
        String[] expected = new String[]{"15", "14", "13", "12", "11", "10", "9", "8", "7", "6", "5", "4", "3", "2", "1"};
        assertArrayEquals("Should return an array with the elements in reverse order.", expected, ArrayReverse.reverseArray(testArr));
    }

    @Test
    public void reverseArray_evenLengthInput() {
        String[] testArr = new String[]{"Scout", "Elsa", "Luna", "Maggie", "Copper", "Stella"};
        String[] expected = new String[]{"Stella", "Copper", "Maggie", "Luna", "Elsa", "Scout"};
        assertArrayEquals("Should return an array with the elements in reverse order.", expected, ArrayReverse.reverseArray(testArr));
    }

    @Test
    public void reverseArray_length1Array() {
        String[] testArr = new String[]{"one"};
        String[] expected = new String[]{"one"};
        assertArrayEquals("If array has only one element, the returned array should be the same as input.", expected, ArrayReverse.reverseArray(testArr));
    }

    @Test
    public void reverseArray_length0Array() {
        String[] testArr = new String[0];
        String[] expected = new String[0];
        assertArrayEquals("If array has length 0, it should return a length zero array.", expected, ArrayReverse.reverseArray(testArr));
    }
}
