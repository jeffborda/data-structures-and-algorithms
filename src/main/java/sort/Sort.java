package sort;

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

            // While the currentValue at index i is less than the current value below it -starting with j and moving left
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
}
