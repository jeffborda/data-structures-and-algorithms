package codingbat;

/**
 * RE: https://codingbat.com/java/String-2
 * This section contains medium level String coding challenges.
 */
public class String2 {

    /**
     * RE: https://codingbat.com/prob/p165312
     * Given a string, return a string where for every char in the original, there are two chars.
     */
    public static String doubleChar(String str) {
        StringBuilder answer = new StringBuilder();
        for(int i = 0; i < str.length(); i++) {
            answer.append(String.valueOf(str.charAt(i)) + String.valueOf(str.charAt(i)));
        }
        return answer.toString();
    }

    /**
     *  RE: https://codingbat.com/prob/p147448
     *  Return the number of times that the string "hi" appears anywhere in the given string.
     */
    public static int countHi(String str) {
        int answer = 0;
        for(int i = 0; i < str.length() - 1; i++) {
            if(str.substring(i, i + 2).equals("hi")) {
                answer++;
            }
        }
        return answer;
    }

    /**
     *  RE: https://codingbat.com/prob/p111624
     *  Return true if the string "cat" and "dog" appear the same number of times in the given string.
     */
    public static boolean catDog(String str) {
        int catCount = 0;
        int dogCount = 0;
        for(int i = 0; i < str.length() - 2; i++) {
            if(str.substring(i, i + 3).equals("dog") ) {
                dogCount++;
            }
            else if(str.substring(i, i + 3).equals("cat")) {
                catCount++;
            }
        }
        return catCount == dogCount;
    }

    /**
     *  RE: https://codingbat.com/prob/p123614
     *  Return the number of times that the string "code" appears anywhere in the given string, except we'll accept any
     *    letter for the 'd', so "cope" and "cooe" count.
     */
    public static int countCode(String str) {
        int answer = 0;
        for(int i = 0; i < str.length() - 3; i++) {
            if(str.substring(i, i + 2).equals("co") && str.charAt(i + 3) == 'e' ) {
                answer++;
            }
        }
        return answer;
    }

    /**
     *  RE: https://codingbat.com/prob/p126880
     *  Given two strings, return true if either of the strings appears at the very end of the other string, ignoring
     *    upper/lower case differences (in other words, the computation should not be "case sensitive"). Note:
     *    str.toLowerCase() returns the lowercase version of a string.
     */
    public static boolean endOther(String a, String b) {
        // Ridiculous one liner :)
        return a.length() >= b.length() ? a.substring(a.length() - b.length()).toLowerCase().equals(b.toLowerCase()) : b.substring(b.length() - a.length()).toLowerCase().equals(a.toLowerCase());
    }

    /**
     *  RE: https://codingbat.com/prob/p136594
     *  Return true if the given string contains an appearance of "xyz" where the xyz is not directly preceded by a
     *    period (.). So "xxyz" counts but "x.xyz" does not.
     */
    public static boolean xyzThere(String str) {
        for(int i = 0; i < str.length() - 2; i++) {
            if(i == 0 && str.substring(i, i + 3).equals("xyz"))
                return true;
            else if(str.substring(i, i + 3).equals("xyz") && str.charAt(i - 1) != '.')
                return true;
        }
        return false;
    }


    /**
     * RE: https://codingbat.com/prob/p125185
     * Given two strings, a and b, create a bigger string made of the first char of a, the first char of b, the second
     *   char of a, the second char of b, and so on. Any leftover chars go at the end of the result.
     */
    public static String mixString(String a, String b) {
        if(a.isEmpty() || b.isEmpty()) {
            if(a.isEmpty()) {
                return b;
            }
            return a;
        }
        StringBuilder answer = new StringBuilder();
        if(a.length() <= b.length()) {
            int i;
            for(i = 0; i < a.length(); i++) {
                answer.append((a.charAt(i)));
                answer.append((b.charAt(i)));
            }
            if(i < b.length()) {
                answer.append(b.substring(i));
            }
        }
        else {
            int i;
            for(i = 0; i < b.length(); i++) {
                answer.append((a.charAt(i)));
                answer.append((b.charAt(i)));
            }
            answer.append(a.substring(i));
        }
        return answer.toString();
    }

}
