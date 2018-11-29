public class BinarySearch {
    public static void main(String[] args) {

        int[] test = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};

        System.out.println(binarySearch(test, 10));
    }

    public static int binarySearch(int[] sortedArray, int target) {
        int left = 0;
        int right = sortedArray.length - 1;
        int middle = 0;
        while(left <= right) {
            middle = (int) Math.floor((left + right) / 2);
            if(sortedArray[middle] < target) {
                left = middle + 1;
            }
            else if(sortedArray[middle] > target) {
                right = middle - 1;
            }
            else {
                return middle;
            }
        }
        return -1;
    }
}
