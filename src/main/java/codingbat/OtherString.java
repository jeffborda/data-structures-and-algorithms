package codingbat;

/**
 *  Other String code challenges.
 */
public class OtherString {

    /**
     *  Interview question:
     *  Take in two strings and return whether one is a concatenation of the other. You may assume that the second
     *   String argument is equal to or longer than the length of the first.
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

}
