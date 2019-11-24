package codingbat;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * RE: https://codingbat.com/java/String-2
 * Majority of tests are from CodingBat, which I migrated to junit.
 */
public class String2Test {

    // RE: https://codingbat.com/prob/p165312
    @Test
    public void doubleCharTest_01() {
        assertEquals("TThhee", String2.doubleChar("The"));
    }

    @Test
    public void doubleCharTest_02() {
        assertEquals("AAAAbbbb", String2.doubleChar("AAbb"));
    }

    @Test
    public void doubleCharTest_03() {
        assertEquals("HHii--TThheerree", String2.doubleChar("Hi-There"));
    }

    @Test
    public void doubleCharTest_04() {
        assertEquals("WWoorrdd!!", String2.doubleChar("Word!"));
    }

    @Test
    public void doubleCharTest_05() {
        assertEquals("!!!!", String2.doubleChar("!!"));
    }

    @Test
    public void doubleCharTest_06() {
        assertEquals("", String2.doubleChar(""));
    }

    @Test
    public void doubleCharTest_07() {
        assertEquals("aa", String2.doubleChar("a"));
    }

    @Test
    public void doubleCharTest_08() {
        assertEquals("..", String2.doubleChar("."));
    }

    @Test
    public void doubleCharTest_09() {
        assertEquals("aaaa", String2.doubleChar("aa"));
    }


    // RE: https://codingbat.com/prob/p125185
    @Test
    public void mixStringTest_01() {
        assertEquals("axbycz", String2.mixString("abc", "xyz"));
    }

    @Test
    public void mixStringTest_02() {
        assertEquals("HTihere", String2.mixString("Hi", "There"));
    }

    @Test
    public void mixStringTest_03() {
        assertEquals("xTxhxexre", String2.mixString("xxxx", "There"));
    }

    @Test
    public void mixStringTest_04() {
        assertEquals("xXxx", String2.mixString("xxx", "X"));
    }

    @Test
    public void mixStringTest_05() {
        assertEquals("22/7 around", String2.mixString("2/", "27 around"));
    }

    @Test
    public void mixStringTest_06() {
        assertEquals("Hello", String2.mixString("", "Hello"));
    }

    @Test
    public void mixStringTest_07() {
        assertEquals("Abc", String2.mixString("Abc", ""));
    }

    @Test
    public void mixStringTest_08() {
        assertEquals("", String2.mixString("", ""));
    }

    @Test
    public void mixStringTest_09() {
        assertEquals("ab", String2.mixString("a", "b"));
    }

    @Test
    public void mixStringTest_10() {
        assertEquals("abx", String2.mixString("a", "bx"));
    }

    @Test
    public void mixStringTest_11() {
        assertEquals("abx", String2.mixString("ax", "b"));
    }

    @Test
    public void mixStringTest_12() {
        assertEquals("SLoong", String2.mixString("So", "Long"));
    }

    @Test
    public void mixStringTest_13() {
        assertEquals("LSoong", String2.mixString("Long", "So"));
    }

    @Test
    public void mixStringTest_14() {
        assertEquals("&7@#+*.,:;%%%", String2.mixString("&@+.:", "7#*,;%%%"));
    }
    
}
