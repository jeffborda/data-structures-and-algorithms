package repeatedword;

import java.util.HashSet;
import java.util.Set;

public class RepeatedWord {

    /**
     * Returns the first word to occur more than once in the input string.
     */
    public static String findFirstRepeatedWord(String input) {
        String[] splitInput = input.split(" ");
        Set<String> uniqueWords = new HashSet<>();
        for(String inputWord : splitInput) {
            // Help on Regex line from: https://stackoverflow.com/questions/8115679/how-do-i-remove-all-punctuation-that-follows-a-single-word-in-java/8115708
            // Regex removes common trailing punctuation.
            if(!uniqueWords.add(inputWord.toLowerCase().replaceAll("([a-z]+)[?:!.,;']*", "$1"))) {
                return inputWord;
            }
        }
        return null;
    }
}
