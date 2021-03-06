package codingbat;

import java.util.StringJoiner;

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
     *   letter for the 'd', so "cope" and "cooe" count.
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
     *   upper/lower case differences (in other words, the computation should not be "case sensitive"). Note:
     *   str.toLowerCase() returns the lowercase version of a string.
     */
    public static boolean endOther(String a, String b) {
        // Ridiculous one liner :)
        return a.length() >= b.length() ? a.substring(a.length() - b.length()).toLowerCase().equals(b.toLowerCase()) : b.substring(b.length() - a.length()).toLowerCase().equals(a.toLowerCase());
    }

    /**
     *  RE: https://codingbat.com/prob/p136594
     *  Return true if the given string contains an appearance of "xyz" where the xyz is not directly preceded by a
     *   period (.). So "xxyz" counts but "x.xyz" does not.
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
     *  RE: https://codingbat.com/prob/p175762
     *  Return true if the given string contains a "bob" string, but where the middle 'o' char can be any char.
     */
    public static boolean bobThere(String str) {
        for(int i = 0; i < str.length() - 2; i++) {
            if(str.charAt(i) == 'b' && str.charAt(i + 2) == 'b')
                return true;
        }
        return false;
    }

    /**
     *  RE: https://codingbat.com/prob/p134250
     *  We'll say that a String is xy-balanced if for all the 'x' chars in the string, there exists a 'y' char
     *   somewhere later in the string. So "xxy" is balanced, but "xyx" is not. One 'y' can balance multiple 'x's.
     *   Return true if the given string is xy-balanced.
     */
    public static boolean xyBalance(String str) {

        return str.lastIndexOf("x") <= str.lastIndexOf("y");
    }

    /**
     * RE: https://codingbat.com/prob/p125185
     * Given two strings, a and b, create a bigger string made of the first char of a, the first char of b, the second
     *  char of a, the second char of b, and so on. Any leftover chars go at the end of the result.
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

    /**
     *  RE: https://codingbat.com/prob/p152339
     *  Given a string and an int n, return a string made of n repetitions of the last n characters of the string. You
     *   may assume that n is between 0 and the length of the string, inclusive.
     */
    public static String repeatEnd(String str, int n) {
        StringBuilder answer = new StringBuilder();
        for(int i = 0; i < n; i++) {
            answer.append(str.substring(str.length() - n) );
        }
        return answer.toString();
    }

    /**
     *  RE: https://codingbat.com/prob/p128796
     *  Given a string and an int n, return a string made of the first n characters of the string, followed by the first
     *   n-1 characters of the string, and so on. You may assume that n is between 0 and the length of the string,
     *   inclusive (i.e. n >= 0 and n <= str.length()).
     */
    public static String repeatFront(String str, int n) {
        StringBuilder answer = new StringBuilder();
        for(int i = 0; i < n; i++) {
            answer.append(str.substring(0, n - i));
        }
        return answer.toString();
    }

    /**
     *  RE: https://codingbat.com/prob/p109637
     *  Given two strings, word and a separator sep, return a big string made of count occurrences of the word,
     *    separated by the separator string.
     */
    public static String repeatSeparator(String word, String sep, int count) {
        StringJoiner answer = new StringJoiner(sep);
        for(int i = 0; i < count; i++) {
            answer.add(word);
        }
        return answer.toString();
    }

    /**
     *  RE: https://codingbat.com/prob/p136417
     *  Given a string, consider the prefix string made of the first N chars of the string. Does that prefix string
     *   appear somewhere else in the string? Assume that the string is not empty and that N is in the range
     *   1..str.length().
     */
    public static boolean prefixAgain(String str, int n) {
        // first call to substring() returns the substring from n to the end of string
        return str.substring(n).contains(str.substring(0, n));
    }

    /**
     *  RE: https://codingbat.com/prob/p159772
     *  Given a string, does "xyz" appear in the middle of the string? To define middle, we'll say that the number of
     *   chars to the left and right of the "xyz" must differ by at most one. This problem is harder than it looks.
     */
    public static boolean xyzMiddle(String str) {
        // Eliminate short strings and strings not containing 'xyz'
        if(!str.contains("xyz")) {
            return false;
        }
        // Plan: Get the middle substring of input, such that if it contains an 'xyz' we return true.
        // The appropriate middle will vary depending on if input string is even or odd length.
        int evenLengthStart = (str.length() / 2) - 2;
        int evenLengthEnd = 4;
        int oddLengthStart = (str.length() / 2) - 1;
        int oddLengthEnd = 3;

        if(str.length() % 2 == 0) {
            return str.substring(evenLengthStart, evenLengthStart + evenLengthEnd).contains("xyz");
        }
        return str.substring(oddLengthStart, oddLengthStart + oddLengthEnd).equals("xyz");
    }

    /**
     *  RE: https://codingbat.com/prob/p129952
     *  A sandwich is two pieces of bread with something in between. Return the string that is between the first and
     *   last appearance of "bread" in the given string, or return the empty string "" if there are not two pieces of
     *   bread.
     */
    public static String getSandwich(String str) {
        // TODO: Consider if refactoring this code using the following string methods would be simpler/more clear:
        //  indexOf(String str, int fromIndex) Returns the index within this string of the first occurrence of the specified character, starting the search at the specified index.
        //  lastIndexOf(String str, int fromIndex) Returns the index within this string of the last occurrence of the specified substring, searching backward starting at the specified index.
        String targetWord = "bread";
        int targetWordLength = targetWord.length();
        // Start from the right of the input string
        for(int i = 0; i < str.length() - targetWordLength; i++) {
            // If the substring matches target string
            if(str.substring(i, i + targetWordLength).equals(targetWord)) {
                // Start looping from the left to search for a second occurrence of the target word
                for(int j = str.length() - targetWordLength; j > i; j--) {
                    // If a second target word is found, return what's between the two words
                    if(str.substring(j, j + targetWordLength).equals(targetWord)) {
                        return str.substring(i + targetWordLength, j);
                    }
                }
            }
        }
        return "";
    }

    /**
     *  RE: https://codingbat.com/prob/p194491
     *  Returns true if for every '*' (star) in the string, if there are chars both immediately before and after the
     *   star, they are the same.
     */
    public static boolean sameStarChar(String str) {
        for(int i = 1; i < str.length() - 1; i++) {
            if(str.charAt(i) == '*' && str.charAt(i - 1) != str.charAt(i + 1)) {
                return false;
            }
        }
        return true;
    }

    /**
     *  RE: https://codingbat.com/prob/p122943
     *  Given a string, compute a new string by moving the first char to come after the next two chars, so "abc" yields
     *   "bca". Repeat this process for each subsequent group of 3 chars, so "abcdef" yields "bcaefd". Ignore any group
     *   of fewer than 3 chars at the end.
     */
    public static String oneTwo(String str) {
        StringBuilder answer = new StringBuilder();
        final int SHIFT_INTERVAL = 3;
        boolean doShift = false;
        for(int i = 0; i < str.length(); i++) {
            if(i % SHIFT_INTERVAL != 0 && !doShift) {
                answer.append(str.charAt(i));
                doShift = true;
            }
            else if(i % SHIFT_INTERVAL != 0 && doShift) {
                answer.append(str.charAt(i));
                answer.append(str.charAt(i - 2));
                doShift = false;
            }
            else if(str.length() - i < SHIFT_INTERVAL) {
                break;
            }
        }
        return answer.toString();
    }

    /**
     *  RE: https://codingbat.com/prob/p180759
     *  Look for patterns like "zip" and "zap" in the string -- length-3, starting with 'z' and ending with 'p'. Return
     *   a string where for all such words, the middle letter is gone, so "zipXzap" yields "zpXzp".
     */
    public static String zipZap(String str) {
        if(str.length() < 3) {
            return str;
        }
        StringBuilder answer = new StringBuilder();
        for(int i = 0; i < str.length(); i++) {
            if(i < str.length() - 2 && str.charAt(i) == 'z' && str.charAt(i + 2) == 'p') {
                answer.append("zp");
                i += 2;
            }
            else {
                answer.append(str.charAt(i));
            }
        }
        return answer.toString();
    }

    /**
     *  RE: https://codingbat.com/prob/p139564
     *  Return a version of the given string, where for every star (*) in the string the star and the chars immediately
     *   to its left and right are gone. So "ab*cd" yields "ad" and "ab**cd" also yields "ad".
     */
    public static String starOut(String str) {
        StringBuilder answer = new StringBuilder();
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '*') {
            continue; //continue statements not required, but used in place of an empty conditional
            } else if(i > 0 && str.charAt(i - 1) == '*') {
                continue;
            } else if(i < str.length() - 1 && str.charAt(i + 1) == '*') {
                continue;
            } else {
                answer.append(String.valueOf(str.charAt(i)));
            }
        }
        return answer.toString();
    }

    /**
     *  RE: https://codingbat.com/prob/p170829
     *  Given a string and a non-empty word string, return a version of the original String where all chars have been
     *   replaced by pluses ("+"), except for appearances of the word string which are preserved unchanged.
     */
    public static String plusOut(String str, String word) {
        StringBuilder answer = new StringBuilder();
        for(int i = 0; i < str.length(); i++) {
            // First condition makes it safe to do the second condition without going out of bounds
            if(str.charAt(i) != word.charAt(0) || !str.substring(i, i + word.length()).equals(word)) {
                answer.append("+");
            }
            // It must be the match, append it to answer and skip through the length of 'word' in 'str'
            else {
                answer.append(word);
                i += word.length() - 1; //skip the rest of the length since it matches
            }
        }
        return answer.toString();
    }

    /**
     *  RE: https://codingbat.com/prob/p147538
     *  Given a string and a non-empty word string, return a string made of each char just before and just after every
     *   appearance of the word in the string. Ignore cases where there is no char before or after the word, and a char
     *   may be included twice if it is between two words.
     */
    public static String wordEnds(String str, String word) {
        StringBuilder answer = new StringBuilder();
        for(int i = 0; i < str.length() - word.length() + 1; i++) {
            if(str.substring(i, i + word.length()).equals(word)) {
                if(i > 0) {
                    answer.append(str.charAt(i - 1));
                }
                if(i + word.length() < str.length()) {
                    answer.append(str.charAt(i + word.length()));
                }
            }
        }
        return answer.toString();
    }

}
