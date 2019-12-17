package codingbat;

/**
 * RE: https://codingbat.com/java/String-3
 * This section contains medium level String coding challenges.
 */
public class String3 {

    /**
     *  RE: https://codingbat.com/prob/p199171
     *  Given a string, count the number of words ending in 'y' or 'z' -- so the 'y' in "heavy" and the 'z' in "fez"
     *   count, but not the 'y' in "yellow" (not case sensitive). We'll say that a y or z is at the end of a word if
     *   there is not an alphabetic letter immediately following it. (Note: Character.isLetter(char) tests if a char is
     *   an alphabetic letter.)
     */
    public static int countYZ(String str) {
        String[] words = str.split("[^a-zA-Z]");
        int count = 0;
        for(String word : words) {
            if(word.toLowerCase().endsWith("y") || word.toLowerCase().endsWith("z")) {
                count++;
            }
        }
        return count;
    }

    /**
     *  RE: https://codingbat.com/prob/p192570
     *  Given two strings, 'base' and 'remove', return a version of the base string where all instances of the remove
     *   string have been removed (not case sensitive). You may assume that the remove string is length 1 or more.
     *   Remove only non-overlapping instances, so with "xxx" removing "xx" leaves "x".
     */
    public static String withoutString(String base, String remove) {
        StringBuilder answer = new StringBuilder();
        for(int i = 0; i < base.length(); i++) {
            if(i <= base.length() - remove.length()) {
                if(base.substring(i, i + remove.length()).equalsIgnoreCase(remove)) {
                    i += remove.length() - 1;
                } else {
                    answer.append(base.charAt(i));
                }
            } else {
                answer.append(base.charAt(i));
            }
        }
        return answer.toString();
    }

    /**
     *  RE: https://codingbat.com/prob/p141736
     *  Given a string, return true if the number of appearances of "is" anywhere in the string is equal to the number
     *   of appearances of "not" anywhere in the string (case sensitive).
     */
    public static boolean equalIsNot(String str) {
        int isCount = 0;
        int notCount = 0;
        for(int i = 0; i < str.length(); i++) {
            if(i <= str.length() - "not".length() && str.substring(i, i + "not".length() ).equals("not")) {
                notCount++;
            } else if(i <= str.length() - "is".length() && str.substring(i, i + "is".length() ).equals("is") ) {
                isCount++;
            }
        }
        return isCount == notCount;
    }

    /**
     *  RE: https://github.com/jeffborda/data-structures-and-algorithms
     *  We'll say that a lowercase 'g' in a string is "happy" if there is another 'g' immediately to its left or right.
     *   Return true if all the g's in the given string are happy.
     */
    public static boolean gHappy(String str) {
        // Checks if 'str' is only "g", or if it starts or ends with 'g' without another 'g' next to it
        if(str.equals("g")
                || (str.startsWith("g") && str.charAt(1) != 'g')
                || (str.endsWith("g") && str.charAt(str.length() - 2) != 'g')) {
            return false;
        }
        // Checks str except for first and last letter
        for(int i = 1; i < str.length() - 1; i++) {
            if(str.charAt(i) == 'g' && (str.charAt(i - 1) != 'g' && str.charAt(i + 1) != 'g')) {
                return false;
            }
        }
        return true;
    }

    /**
     *  RE: https://codingbat.com/prob/p195714
     *  We'll say that a "triple" in a string is a char appearing three times in a row. Return the number of triples in
     *   the given string. The triples may overlap.
     */
    public static int countTriple(String str) {
        int tripleCount = 0;
        for(int i = 0; i < str.length() - 2; i++) {
            if(str.charAt(i) == str.charAt(i + 1) && str.charAt(i) == str.charAt(i + 2)) {
                tripleCount++;
            }
        }
        return tripleCount;
    }

}
