import java.util.Arrays;

public class ArrayReverse {
    public static void main(String[] args) {

        String[] goodDogs = {"Scout-dog", "Stella", "Elsa", "Maggie", "Copper"};
        System.out.println("goodDogs Array: " + Arrays.toString(goodDogs));
        System.out.println("Length of goodDogs: " + goodDogs.length);
        System.out.println("After reversing: " + Arrays.toString(reverseArray(goodDogs)));

        //Edge Case Tests
        System.out.println("\n::::Edge Case Tests::::");
        String[] emptyArray = new String[0];
        System.out.println("emptyArray Array: " + Arrays.toString(emptyArray));
        System.out.println("Length of emptyArray: " + emptyArray.length);
        System.out.println("After reversing: " + Arrays.toString(reverseArray(emptyArray)));

        String[] oneElementArray = new String[1];
        oneElementArray[0] = "It's just me here.";
        System.out.println("\noneElementArray Array: " + Arrays.toString(oneElementArray));
        System.out.println("Length of oneElementArray: " + oneElementArray.length);
        System.out.println("After reversing: " + Arrays.toString(reverseArray(oneElementArray)));

        String[] twoElementArray = {"I'm with stinky ->","<-I'm with stupid"};
        System.out.println("\ntwoElementArray Array: " + Arrays.toString(twoElementArray));
        System.out.println("Length of twoElementArray: " + twoElementArray.length);
        System.out.println("After reversing: " + Arrays.toString(reverseArray(twoElementArray)));

    }

    public static String[] reverseArray(String[] original) {

        String[] result = new String[original.length];

        for(int i = 0; i < original.length; i++) {

            result[i] = original[original.length - 1 - i];
        }
        return result;
    }
}
