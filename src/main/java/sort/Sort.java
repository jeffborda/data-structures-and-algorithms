package sort;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

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

        // Try this to keep everything in one loop:
        // if array2 is out of elements OR ....
        //if(  (index2 == inputArray2.length) || ((index1 < inputArray1.length) && (inputArray1[index1] < inputArray2[index2]))  )
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



    public static void quickSort(int[] inputArray) {
        // No need to sort, return it back
        if(inputArray.length < 2) {
            return;
        }
        // Call the helper
        quickSortHelper(inputArray, 0, inputArray.length-1);
    }



    private static void quickSortHelper(int[] inputArray, int start, int end) {

        int left = start;
        int right = end;
        //Set pivot to middle element
        int pivot = inputArray[(left + right) / 2];
        int temp;

        // Put the numbers into their left and right buckets
        //   Smaller on the left, larger on the right
        // Do this until the left and right pointers converge
        while(left <= right) {
            // Move the left pointer -->  until it finds a number bigger than the pivot (or it hits the pivot number)
            while(inputArray[left] < pivot) {
                left++; // -->
            }
            // Move the right pointer <--  until it finds a number smaller than the pivot (or it hits the pivot number)
            while(inputArray[right] > pivot) {
                right--; // <--
            }

            // Do this statement until left and right pointers converge to the pivot index
            //  So, if the index of the left pointer is less than the index of the right pointer
            //    Swap the large number on the left with the small number on the right
            //    Move left pointer -->
            //    Move right pointer <--
            if(left < right) {
                // Swap
                temp = inputArray[left];
                inputArray[left] = inputArray[right];
                inputArray[right] = temp;
                left++; // -->
                right--; // <--

            }
            else if (left == right) {
                left++;
                right--;
            }
        }
        // Upon dropping out of loop, left and right are centered on the pivot element
        //  OR they are past each other in a 2 element array

        // Reset left to the left of the pivot, reset right to the right of the pivot
//        left--; // <--
//        right++; // -->

        // BASE CASE IS:  if (bucket.length < 2)
        // So do recursion until the size of the bucket is less than 2
        // Using pointers to determine length: if (start == left || right == end)  is the same as having one element.
        if(left < end) {
            // Call helper on small side bucket: start to right
            quickSortHelper(inputArray, left, end);
        }
        if(right > start) {
            quickSortHelper(inputArray, start, right);
        }
    }
}
