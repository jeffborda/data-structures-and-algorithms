package multibracketvalidation;

import stacksandqueues.Stack;

public class MultiBracketValidation {

    /**
     * Checks if the input string contains balanced brackets. If so, it returns true.  If brackets are unbalanced,
     * it returns false. If there are no brackets, it returns true since not having brackets in the string means
     * it is not unbalanced.
     */
    public static boolean validateBrackets(String input) {

        Stack<Character> unmatchedBrackets = new Stack<>();
        for(int i = 0; i < input.length(); i ++) {
            if(isClosingBracket(input.charAt(i)) && unmatchedBrackets.isEmpty()) {
                return false;
            }
            if(isOpeningBracket(input.charAt(i))) {
                unmatchedBrackets.push(input.charAt(i));
            }
            if(isClosingBracket(input.charAt(i))) {
                if(!areMatchingBrackets(unmatchedBrackets.pop(), input.charAt(i))) {
                    return false;
                }
            }
        }
        if(unmatchedBrackets.isEmpty()) {
            return true;
        }
        return false;
    }

    /*
     * Helper function to determine if two brackets are matching and balanced. Parameter 'a' must be an opening bracket,
     * and parameter 'b' must be a matching closing bracket to return true.
     */
    protected static boolean areMatchingBrackets(char a, char b) {
        if(a == '(' && b == ')') {
            return true;
        }
        if(a == '[' && b == ']') {
            return true;
        }
        if(a == '{' && b == '}') {
            return true;
        }
        return false;
    }

    /**
     * Helper function to determines if the input character is an opening bracket.
     */
    protected static boolean isOpeningBracket(char c) {
        if(c == '{' || c == '(' || c == '[') {
            return true;
        }
        return false;
    }

    /**
     * Helper function to determines if the input character is a closing bracket.
     */
    protected static boolean isClosingBracket(char c) {
        if(c == '}' || c == ')' || c == ']') {
            return true;
        }
        return false;
    }
}
