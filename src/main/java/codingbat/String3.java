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
}
