package sort;

import java.util.ArrayList;
import java.util.Arrays;

public class Sort {

    /**
     *
     * @param inputArray
     * @return a sorted array using Insertion Sort algorithm.
     */
    public static int[] insertionSort(int[] inputArray) {

        int currentValue;

        for(int i = 1; i < inputArray.length; i++) {
            // Save the value we are looking at, starting at the second element
            currentValue = inputArray[i];
            // Start one index below i
            int j = i - 1;

            // While the currentValue from index i is less than the current value below it -starting with j and moving left
            while(j >= 0 && currentValue < inputArray[j]){
                // Move the value below up a position
                inputArray[j + 1] = inputArray[j];
                j--;
            }
            // Put the value in its correctly sorted position
            inputArray[j + 1] = currentValue;
        }
        // Returning the same array that was passed into the method.
        return inputArray;
    }

    public static int[] mergeSort(int[] inputArray) {
        if(inputArray.length < 2) {
            return inputArray;
        }

        int[] firstHalf = Arrays.copyOfRange(inputArray, 0, inputArray.length/2);
        int[] secondHalf = Arrays.copyOfRange(inputArray, ((inputArray.length/2)), inputArray.length);

        return merge(mergeSort(firstHalf), mergeSort(secondHalf));
    }

    protected static int[] merge(int[] inputArray1, int[] inputArray2) {

        int[] result = new int[inputArray1.length + inputArray2.length];
        int index1 = 0;
        int index2 = 0;
        int i = 0;
        while(index1 < inputArray1.length && index2 < inputArray2.length) {
            if(inputArray1[index1] < inputArray2[index2]) {
                result[i] = inputArray1[index1];
                index1++;
            }
            else {
                result[i] = inputArray2[index2];
                index2++;
            }
            i++;
        }
        while(index1 < inputArray1.length) {
            result[i] = inputArray1[index1];
            index1++;
            i++;
        }
        while(index2 < inputArray2.length) {
            result[i] = inputArray2[index2];
            index2++;
            i++;
        }
        return result;
    }
}
