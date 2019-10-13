package arrays;

import java.util.Arrays;

public class ArrayShift {
    public static void main(String[] args) {

    }

    /*
     * Takes in an array and the value to be added. Without utilizing any of the built-in methods available to your
     * language, return an array with the new value added at the middle index.
     */
    public static int[] insertShiftArray(int[] input, int insertionNumber) {

        int[] result = new int[input.length + 1];
        double middle = input.length / 2.0;
        middle += 0.5; //For rounding
        middle = Math.floor(middle); //Truncate the decimal

        for(int i = 0; i < input.length + 1; i++) {

            if(i < middle) {
                result[i] = input[i];
            }
            else if(i == middle) {
                result[i] = insertionNumber;
            }
            else {
                result[i] = input[i - 1];
            }
        }

        return result;
    }
}
