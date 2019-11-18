package arrays;

import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayReverseTest {

    @Test
    public void reverseArray_length4Array() {
        String[] goodDogs = new String[]{"Scout", "Elsa", "Luna", "Maggie"};
        String[] expected = new String[]{"Maggie", "Luna", "Elsa", "Scout"};
        assertArrayEquals("Should return an array with the elements in reverse order.", expected, ArrayReverse.reverseArray(goodDogs));
    }

    @Test
    public void reverseArray_length1Array() {
        String[] oneElement = new String[]{"one"};
        String[] expected = new String[]{"one"};
        assertArrayEquals("If array has only one element, the returned array should be the same as input.", expected, ArrayReverse.reverseArray(oneElement));
    }
}