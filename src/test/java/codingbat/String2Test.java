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


    // RE: https://codingbat.com/prob/p147448
    @Test
    public void countHiTest_01() {
        assertEquals(1, String2.countHi("abc hi ho"));
    }

    @Test
    public void countHiTest_02() {
        assertEquals(2, String2.countHi("ABChi hi"));
    }

    @Test
    public void countHiTest_03() {
        assertEquals(2, String2.countHi("hihi"));
    }

    @Test
    public void countHiTest_04() {
        assertEquals(2, String2.countHi("hiHIhi"));
    }

    @Test
    public void countHiTest_05() {
        assertEquals(0, String2.countHi(""));
    }

    @Test
    public void countHiTest_06() {
        assertEquals(0, String2.countHi("h"));
    }

    @Test
    public void countHiTest_07() {
        assertEquals(1, String2.countHi("hi"));
    }

    @Test
    public void countHiTest_08() {
        assertEquals(0, String2.countHi("Hi is no HI on ahI"));
    }

    @Test
    public void countHiTest_09() {
        assertEquals(2, String2.countHi("hiho not HOHIhi"));
    }


    // RE: https://codingbat.com/prob/p111624
    @Test
    public void catDogTest_01() {
        assertTrue(String2.catDog("catdog"));
    }

    @Test
    public void catDogTest_02() {
        assertFalse(String2.catDog("catcat"));
    }

    @Test
    public void catDogTest_03() {
        assertTrue(String2.catDog("1cat1cadodog"));
    }

    @Test
    public void catDogTest_04() {
        assertFalse(String2.catDog("catxxdogxxxdog"));
    }

    @Test
    public void catDogTest_05() {
        assertTrue(String2.catDog("catxdogxdogxcat"));
    }

    @Test
    public void catDogTest_06() {
        assertFalse(String2.catDog("catxdogxdogxca"));
    }

    @Test
    public void catDogTest_07() {
        assertFalse(String2.catDog("dogdogcat"));
    }

    @Test
    public void catDogTest_08() {
        assertTrue(String2.catDog("dogogcat"));
    }

    @Test
    public void catDogTest_09() {
        assertFalse(String2.catDog("dog"));
    }

    @Test
    public void catDogTest_10() {
        assertFalse(String2.catDog("cat"));
    }

    @Test
    public void catDogTest_11() {
        assertTrue(String2.catDog("ca"));
    }

    @Test
    public void catDogTest_12() {
        assertTrue(String2.catDog("c"));
    }

    @Test
    public void catDogTest_13() {
        assertTrue(String2.catDog(""));
    }


    // RE: https://codingbat.com/prob/p123614
    @Test
    public void countCodeTest_01() {
        assertEquals(1, String2.countCode("aaacodebbb"));
    }

    @Test
    public void countCodeTest_02() {
        assertEquals(2, String2.countCode("codexxcode"));
    }

    @Test
    public void countCodeTest_03() {
        assertEquals(2, String2.countCode("cozexxcope"));
    }

    @Test
    public void countCodeTest_04() {
        assertEquals(1, String2.countCode("cozfxxcope"));
    }

    @Test
    public void countCodeTest_05() {
        assertEquals(1, String2.countCode("xxcozeyycop"));
    }

    @Test
    public void countCodeTest_06() {
        assertEquals(0, String2.countCode("cozcop"));
    }

    @Test
    public void countCodeTest_07() {
        assertEquals(0, String2.countCode("abcxyz"));
    }

    @Test
    public void countCodeTest_08() {
        assertEquals(1, String2.countCode("code"));
    }

    @Test
    public void countCodeTest_09() {
        assertEquals(0, String2.countCode("ode"));
    }

    @Test
    public void countCodeTest_10() {
        assertEquals(0, String2.countCode("c"));
    }

    @Test
    public void countCodeTest_11() {
        assertEquals(0, String2.countCode(""));
    }

    @Test
    public void countCodeTest_12() {
        assertEquals(3, String2.countCode("AAcodeBBcoleCCccoreDD"));
    }

    @Test
    public void countCodeTest_13() {
        assertEquals(2, String2.countCode("AAcodeBBcoleCCccorfDD"));
    }

    @Test
    public void countCodeTest_14() {
        assertEquals(3, String2.countCode("coAcodeBcoleccoreDD"));
    }


    // RE: https://codingbat.com/prob/p126880
    @Test
    public void endOtherTest_01() {
        assertTrue(String2.endOther("Hiabc", "abc"));
    }

    @Test
    public void endOtherTest_02() {
        assertTrue(String2.endOther("AbC", "HiaBc"));
    }

    @Test
    public void endOtherTest_03() {
        assertTrue(String2.endOther("abc", "abXabc"));
    }

    @Test
    public void endOtherTest_04() {
        assertFalse(String2.endOther("Hiabc", "abcd"));
    }

    @Test
    public void endOtherTest_05() {
        assertTrue(String2.endOther("Hiabc", "bc"));
    }

    @Test
    public void endOtherTest_06() {
        assertFalse(String2.endOther("Hiabcx", "bc"));
    }

    @Test
    public void endOtherTest_07() {
        assertTrue(String2.endOther("abc", "abc"));
    }

    @Test
    public void endOtherTest_08() {
        assertTrue(String2.endOther("xyz", "12xyz"));
    }

    @Test
    public void endOtherTest_09() {
        assertFalse(String2.endOther("yz", "12xz"));
    }

    @Test
    public void endOtherTest_10() {
        assertTrue(String2.endOther("Z", "12xz"));
    }

    @Test
    public void endOtherTest_11() {
        assertTrue(String2.endOther("12", "12"));
    }

    @Test
    public void endOtherTest_12() {
        assertFalse(String2.endOther("abcXYZ", "abcDEF"));
    }

    @Test
    public void endOtherTest_13() {
        assertFalse(String2.endOther("ab", "ab12"));
    }

    @Test
    public void endOtherTest_14() {
        assertTrue(String2.endOther("ab", "12ab"));
    }


    // RE: https://codingbat.com/prob/p136594
    @Test
    public void xyzThereTest_01() {
        assertTrue(String2.xyzThere("abcxyz"));
    }

    @Test
    public void xyzThereTest_02() {
        assertFalse(String2.xyzThere("abc.xyz"));
    }

    @Test
    public void xyzThereTest_03() {
        assertTrue(String2.xyzThere("xyz.abc"));
    }

    @Test
    public void xyzThereTest_04() {
        
    }

    @Test
    public void xyzThereTest_05() {

    }

    @Test
    public void xyzThereTest_06() {

    }

    @Test
    public void xyzThereTest_07() {

    }

    @Test
    public void xyzThereTest_08() {

    }

    @Test
    public void xyzThereTest_09() {

    }

    @Test
    public void xyzThereTest_10() {

    }

    @Test
    public void xyzThereTest_11() {

    }

    @Test
    public void xyzThereTest_12() {

    }

    @Test
    public void xyzThereTest_13() {

    }

    @Test
    public void xyzThereTest_14() {

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
