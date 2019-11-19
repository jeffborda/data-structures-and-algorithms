package arrays;

import java.util.Arrays;

public class ArrayShift {

    /*
     * Takes in an array and the value to be added. Without utilizing any of the built-in methods available to your
     *  language, return an array with the new value added at the middle index.
     * NOTE: Insert number on the "right" side of the middle when input array is of odd number length.
     *   example: insertShiftArray(new int[1, 2, 3], 99)  --returns--> [1, 2, 99, 3]
     */
    public static int[] insertShiftArray(int[] input, int insertionNumber) {

        int[] result = new int[input.length + 1];
        int middle = input.length / 2;
        middle += 0.5; //For rounding
//        middle = Math.floor(middle); //Truncate the decimal

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

    /**
     *  Takes in an array and moves all the zero's to the end of the array, while
     *    maintaining the relative order of other numbers.
     */
    public static int[] shiftZerosToEnd(int[] nums) {

        // Count of non-zero elements
        int count = 0;
        // Traverse the array. If arr[i] is
        // non-zero, then swap the element at
        // index 'count' with the element at
        // index 'i'
        for (int i = 0; i < nums.length; i++) {
            //This will move the zero's to right, and other numbers left
            if (nums[i] != 0) {
                int temp = nums[count];
                nums[count] = nums[i];
                nums[i] = temp;
                count++;
            }
            // example:
            // [1, 0, 2, 3, 0]
            // [1, 2, 0, 3, 0]
            // [1, 2, 3, 0, 0]
        }
        return nums;
    }
}
