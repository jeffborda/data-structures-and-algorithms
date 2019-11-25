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
     * RE: https://codingbat.com/prob/p125185
     * Given two strings, a and b, create a bigger string made of the first char of a, the first char of b, the second
     * char of a, the second char of b, and so on. Any leftover chars go at the end of the result.
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
