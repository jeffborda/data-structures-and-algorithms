package multibracketvalidation;

import org.junit.Test;

import static org.junit.Assert.*;

public class MultiBracketValidationTest {

    @Test
    public void testValidateBrackets() {
        assertTrue("If there are no brackets, it is balanced, should return 'true'.", MultiBracketValidation.validateBrackets("there's no brackets here"));
        assertTrue("Should return 'true' if given a string that contains balanced brackets.", MultiBracketValidation.validateBrackets("(Hello)"));
        assertTrue("Should return 'true' if given a string that contains balanced brackets.", MultiBracketValidation.validateBrackets("(&&){tttyyy}"));
        assertTrue("Should return 'true' if given a string that contains balanced brackets.", MultiBracketValidation.validateBrackets("{()Hi there.}"));
        assertTrue("Should return 'true' if given a string that contains balanced brackets.", MultiBracketValidation.validateBrackets("{}{Code}[Fellows](())"));
        assertTrue("Should return 'true' if given a string that contains balanced brackets.", MultiBracketValidation.validateBrackets("(){}[[]]"));
        assertTrue("Should return 'true' if given a string that contains balanced brackets.", MultiBracketValidation.validateBrackets("()[[Extra Characters]]"));
        assertTrue("Should return 'true' if given a string that contains balanced brackets.", MultiBracketValidation.validateBrackets("{}(){}"));
        assertTrue("Should return 'true' if given a string that contains balanced brackets.", MultiBracketValidation.validateBrackets("a dog { jumpted }(on) {the } couch "));
        assertTrue("Should return 'true' if given a string that contains balanced brackets.", MultiBracketValidation.validateBrackets("this (test)[897[better ] return ] true "));

        assertFalse("Unbalanced brackets should return 'false'.", MultiBracketValidation.validateBrackets("{"));
        assertFalse("Unbalanced brackets should return 'false'.", MultiBracketValidation.validateBrackets("{}("));
        assertFalse("Unbalanced brackets should return 'false'.", MultiBracketValidation.validateBrackets("a{d}c(d"));
        assertFalse("Unbalanced brackets should return 'false'.", MultiBracketValidation.validateBrackets("[({}]"));
        assertFalse("Unbalanced brackets should return 'false'.", MultiBracketValidation.validateBrackets("(]("));
        assertFalse("Unbalanced brackets should return 'false'.", MultiBracketValidation.validateBrackets("{(}this bracket)"));
        assertFalse("Unbalanced brackets should return 'false'.", MultiBracketValidation.validateBrackets("{{{{{{}}}}"));
        assertFalse("Unbalanced brackets should return 'false'.", MultiBracketValidation.validateBrackets("()brackets{} [ {}rule()"));
        assertFalse("Unbalanced brackets should return 'false'.", MultiBracketValidation.validateBrackets("(i {can't} {fool} you)]"));





    }

    @Test
    public void testAreMatchingBrackets() {
        assertTrue("Should return 'true' if given a pair of matching brackets in open bracket, close bracket order.", MultiBracketValidation.areMatchingBrackets('(', ')'));
        assertTrue("Should return 'true' if given a pair of matching brackets in open bracket, close bracket order.", MultiBracketValidation.areMatchingBrackets('{', '}'));
        assertTrue("Should return 'true' if given a pair of matching brackets in open bracket, close bracket order.", MultiBracketValidation.areMatchingBrackets('[', ']'));
        assertFalse("Should return 'false' if given a closing bracket, then an open bracket.", MultiBracketValidation.areMatchingBrackets(')', '('));
        assertFalse("Should return 'false' if given a closing bracket, then an open bracket.", MultiBracketValidation.areMatchingBrackets('}', '{'));
        assertFalse("Should return 'false' if given a closing bracket, then an open bracket.", MultiBracketValidation.areMatchingBrackets(']', ']'));
        assertFalse("Should return 'false' if not matching brackets.", MultiBracketValidation.areMatchingBrackets('{', ']'));
        assertFalse("Should return 'false' if not matching brackets.", MultiBracketValidation.areMatchingBrackets('(', '}'));
        assertFalse("Should return 'false' if not matching brackets.", MultiBracketValidation.areMatchingBrackets('{', ')'));
        assertFalse("Should return 'false' if no brackets given.", MultiBracketValidation.areMatchingBrackets('a', 'z'));
        assertFalse("Should return 'false' if no brackets given.", MultiBracketValidation.areMatchingBrackets('&', '%'));
    }

    @Test
    public void testIsOpeningBracket() {
        assertTrue("Should return 'true' if given an open bracket.", MultiBracketValidation.isOpeningBracket('{'));
        assertTrue("Should return 'true' if given an open bracket.", MultiBracketValidation.isOpeningBracket('('));
        assertTrue("Should return 'true' if given an open bracket.", MultiBracketValidation.isOpeningBracket('['));
        assertFalse("Should return 'false' if given a closing bracket, or any other char.", MultiBracketValidation.isOpeningBracket('}'));
        assertFalse("Should return 'false' if given a closing bracket, or any other char.", MultiBracketValidation.isOpeningBracket(')'));
        assertFalse("Should return 'false' if given a closing bracket, or any other char.", MultiBracketValidation.isOpeningBracket(']'));
        assertFalse("Should return 'false' if given a closing bracket, or any other char.", MultiBracketValidation.isOpeningBracket('*'));
        assertFalse("Should return 'false' if given a closing bracket, or any other char.", MultiBracketValidation.isOpeningBracket('z'));
    }

    @Test
    public void testIsClosingBracket() {
        assertTrue("Should return 'true' if given an closing bracket.", MultiBracketValidation.isClosingBracket('}'));
        assertTrue("Should return 'true' if given an closing bracket.", MultiBracketValidation.isClosingBracket(')'));
        assertTrue("Should return 'true' if given an closing bracket.", MultiBracketValidation.isClosingBracket(']'));
        assertFalse("Should return 'false' if given a open bracket, or any other char.", MultiBracketValidation.isClosingBracket('{'));
        assertFalse("Should return 'false' if given a open bracket, or any other char.", MultiBracketValidation.isClosingBracket('('));
        assertFalse("Should return 'false' if given a open bracket, or any other char.", MultiBracketValidation.isClosingBracket('['));
        assertFalse("Should return 'false' if given a open bracket, or any other char.", MultiBracketValidation.isClosingBracket('{'));
        assertFalse("Should return 'false' if given a open bracket, or any other char.", MultiBracketValidation.isClosingBracket('a'));
        assertFalse("Should return 'false' if given a open bracket, or any other char.", MultiBracketValidation.isClosingBracket('%'));
    }
}