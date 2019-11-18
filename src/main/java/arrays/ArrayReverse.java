package arrays;

import java.util.Arrays;

public class ArrayReverse {

    public static String[] reverseArray(String[] original) {

        String[] result = new String[original.length];

        for(int i = 0; i < original.length; i++) {

            result[i] = original[original.length - 1 - i];
        }
        return result;
    }
}
