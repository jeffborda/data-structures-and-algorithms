package repeatedword;

import org.junit.Test;

import static org.junit.Assert.*;

public class RepeatedWordTest {

    @Test
    public void testFindFirstRepeatedWord() {
        String test1 = "When I was young, I used to go to school.";
        String test2 = "It was the best of times, it was the worst of times, it was the age of wisdom, it was the age of foolishness, it was the epoch of belief, it was the epoch of incredulity, it was the season of Light, it was the season of Darkness, it was the spring of hope, it was the winter of despair, we had everything before us, we had nothing before us, we were all going direct to Heaven, we were all going direct the other way – in short, the period was so far like the present period, that some of its noisiest authorities insisted on its being received, for good or for evil, in the superlative degree of comparison only...";
        String test3 = "It was a queer, sultry summer, the summer they electrocuted the Rosenbergs, and I didn’t know what I was doing in New York...";
        String test4 = "There are no repeated words in this string, so return null. Thank you.";
        String test5 = "ThisStringHasNoSpacesButDoesHaveThisRepeatedWord";
        String test6 = "";
        assertEquals("Should return the second instance of the first repeated word.", "I", RepeatedWord.findFirstRepeatedWord(test1));
        assertEquals("Should return the second instance of the first repeated word. Note the first 'It' is capitalized, and second 'it' is not.", "it", RepeatedWord.findFirstRepeatedWord(test2));
        assertEquals("Trailing punctuation should not be compared.", "summer", RepeatedWord.findFirstRepeatedWord(test3));
        assertEquals("If there are no repeated words, it should return 'null'.", null, RepeatedWord.findFirstRepeatedWord(test4));
        assertEquals("This should return 'null' since there are no spaces between the words..", null, RepeatedWord.findFirstRepeatedWord(test5));
        assertEquals("An empty string should also return 'null' and not break anything in the process.", null, RepeatedWord.findFirstRepeatedWord(test6));
    }
}