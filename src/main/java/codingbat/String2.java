package codingbat;

/**
 * RE: https://codingbat.com/java/String-2
 * This section contains medium level String coding challenges.
 */
public class String2 {

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
                answer.append(String.valueOf(a.charAt(i)));
                answer.append(String.valueOf(b.charAt(i)));
            }
            if(i < b.length()) {
                answer.append(b.substring(i, b.length()));
            }
            return answer.toString();
        }
        else {
            int i;
            for(i = 0; i < b.length(); i++) {
                answer.append(String.valueOf(a.charAt(i)));
                answer.append(String.valueOf(b.charAt(i)));
            }
            answer.append(a.substring(i, a.length()));
            return answer.toString();
        }
    }


}