package codingbat;

/**
 *  Other String code challenges.
 */
public class OtherString {

    /**
     *  Interview question:
     *  Take in two strings and return whether one is a concatenation of the other. You may assume that the second
     *   String argument is equal to or longer than the length of the first.
     *
     *   Note: This code will fail under certain circumstances, ex: "aab", "aaab"  (see test #6). Will require double
     *    for loop. Leaving this as-is for learning purposes.
     */
    public static boolean isConcat(String str1, String str2) {

        int j = 0;
        for(int i = 0; i < str2.length(); i++) {
            if(str2.charAt(i) == str1.charAt(j)) {
                j++;
            } else {
                j = 0;
            }
            if(j == str1.length()) {
                return true;
            }
        }
        return false;
    }

    /**
     *  Corrected version of the above, using double for loop to prevent the error which occurs with repeated char's.
     */
    public static boolean isConcatenation(String str1, String str2) {

        int correctChars = 0;
        for(int i = 0; i < str2.length() - str1.length() + 1; i++) {
            for(int j = 0; j < str1.length(); j++) {
                if(str2.charAt(i + j) == str1.charAt(j)) {
                    correctChars++;
                } else {
                    correctChars = 0;
                }
            }
            if(correctChars == str1.length()) {
                return true;
            }
        }
        return false;
    }

}
