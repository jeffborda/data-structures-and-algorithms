import java.util.Arrays;

public class ArrayShift {
    public static void main(String[] args) {

        //:::Tests:::
        // Odd number of elements
        int[] test1 = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(insertShiftArray(test1, 99)));
        // Even number of elements
        int[] test2 = {1, 2, 3, 4};
        System.out.println(Arrays.toString(insertShiftArray(test2, 99)));
        // One element
        int[] test3 = {1};
        System.out.println(Arrays.toString(insertShiftArray(test3, 99)));
        // Two elements
        int[] test4 = {1, 2};
        System.out.println(Arrays.toString(insertShiftArray(test4, 99)));
        // Large odd number of elements
        int[] test5 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23};
        System.out.println(Arrays.toString(insertShiftArray(test5, 99)));
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
