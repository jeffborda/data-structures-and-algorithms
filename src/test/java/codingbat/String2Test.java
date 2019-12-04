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
        assertFalse(String2.xyzThere("abcxy"));
    }

    @Test
    public void xyzThereTest_05() {
        assertTrue(String2.xyzThere("xyz"));
    }

    @Test
    public void xyzThereTest_06() {
        assertFalse(String2.xyzThere("xy"));
    }

    @Test
    public void xyzThereTest_07() {
        assertFalse(String2.xyzThere("x"));
    }

    @Test
    public void xyzThereTest_08() {
        assertFalse(String2.xyzThere(""));
    }

    @Test
    public void xyzThereTest_09() {
        assertTrue(String2.xyzThere("abc.xyzxyz"));
    }

    @Test
    public void xyzThereTest_10() {
        assertTrue(String2.xyzThere("abc.xxyz"));
    }

    @Test
    public void xyzThereTest_11() {
        assertFalse(String2.xyzThere(".xyz"));
    }

    @Test
    public void xyzThereTest_12() {
        assertFalse(String2.xyzThere("12.xyz"));
    }

    @Test
    public void xyzThereTest_13() {
        assertTrue(String2.xyzThere("12xyz"));
    }

    @Test
    public void xyzThereTest_14() {
        assertFalse(String2.xyzThere("1.xyz.xyz2.xyz"));
    }


    // RE: https://codingbat.com/prob/p175762
    @Test
    public void bobThereTest_01() {
        assertTrue(String2.bobThere("abcbob"));
    }

    @Test
    public void bobThereTest_02() {
        assertTrue(String2.bobThere("b9b"));
    }

    @Test
    public void bobThereTest_03() {
        assertFalse(String2.bobThere("bac"));
    }

    @Test
    public void bobThereTest_04() {
        assertTrue(String2.bobThere("bbb"));
    }

    @Test
    public void bobThereTest_05() {
        assertFalse(String2.bobThere("abcdefb"));
    }

    @Test
    public void bobThereTest_06() {
        assertTrue(String2.bobThere("123abcbcdbabxyz"));
    }

    @Test
    public void bobThereTest_07() {
        assertFalse(String2.bobThere("b12"));
    }

    @Test
    public void bobThereTest_08() {
        assertTrue(String2.bobThere("b1b"));
    }

    @Test
    public void bobThereTest_09() {
        assertTrue(String2.bobThere("b12b1b"));
    }

    @Test
    public void bobThereTest_10() {
        assertFalse(String2.bobThere("bbc"));
    }

    @Test
    public void bobThereTest_11() {
        assertTrue(String2.bobThere("bbb"));
    }

    @Test
    public void bobThereTest_12() {
        assertFalse(String2.bobThere("bb"));
    }

    @Test
    public void bobThereTest_13() {
        assertFalse(String2.bobThere("b"));
    }


    // RE: https://codingbat.com/prob/p134250
    @Test
    public void xyBalanceTest_01() {
        assertTrue(String2.xyBalance("aaxbby"));
    }

    @Test
    public void xyBalanceTest_02() {
        assertFalse(String2.xyBalance("aaxbb"));
    }

    @Test
    public void xyBalanceTest_03() {
        assertFalse(String2.xyBalance("yaaxbb"));
    }

    @Test
    public void xyBalanceTest_04() {
        assertTrue(String2.xyBalance("yaaxbby"));
    }

    @Test
    public void xyBalanceTest_05() {
        assertTrue(String2.xyBalance("xaxxbby"));
    }

    @Test
    public void xyBalanceTest_06() {
        assertFalse(String2.xyBalance("xaxxbbyx"));
    }

    @Test
    public void xyBalanceTest_07() {
        assertTrue(String2.xyBalance("xxbxy"));
    }

    @Test
    public void xyBalanceTest_08() {
        assertFalse(String2.xyBalance("xxbx"));
    }

    @Test
    public void xyBalanceTest_09() {
        assertTrue(String2.xyBalance("bbb"));
    }

    @Test
    public void xyBalanceTest_10() {
        assertFalse(String2.xyBalance("bxbb"));
    }

    @Test
    public void xyBalanceTest_11() {
        assertTrue(String2.xyBalance("bxyb"));
    }

    @Test
    public void xyBalanceTest_12() {
        assertTrue(String2.xyBalance("xy"));
    }

    @Test
    public void xyBalanceTest_13() {
        assertTrue(String2.xyBalance("y"));
    }

    @Test
    public void xyBalanceTest_14() {
        assertFalse(String2.xyBalance("x"));
    }

    @Test
    public void xyBalanceTest_15() {
        assertTrue(String2.xyBalance(""));
    }

    @Test
    public void xyBalanceTest_16() {
        assertFalse(String2.xyBalance("yxyxyxyx"));
    }

    @Test
    public void xyBalanceTest_17() {
        assertTrue(String2.xyBalance("yxyxyxyxy"));
    }

    @Test
    public void xyBalanceTest_18() {
        assertTrue(String2.xyBalance("12xabxxydxyxyzz"));
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


    // RE: https://codingbat.com/prob/p125185
    @Test
    public void repeatEndTest_01() {
        assertEquals("llollollo", String2.repeatEnd("Hello", 3));
    }

    @Test
    public void repeatEndTest_02() {
        assertEquals("lolo", String2.repeatEnd("Hello", 2));
    }

    @Test
    public void repeatEndTest_03() {
        assertEquals("o", String2.repeatEnd("Hello", 1));
    }

    @Test
    public void repeatEndTest_04() {
        assertEquals("", String2.repeatEnd("Hello", 0));
    }

    @Test
    public void repeatEndTest_05() {
        assertEquals("abcabcabc", String2.repeatEnd("abc", 3));
    }

    @Test
    public void repeatEndTest_06() {
        assertEquals("3434", String2.repeatEnd("1234", 2));
    }

    @Test
    public void repeatEndTest_07() {
        assertEquals("234234234", String2.repeatEnd("1234", 3));
    }

    @Test
    public void repeatEndTest_08() {
        assertEquals("", String2.repeatEnd("", 0));
    }


    // RE: https://codingbat.com/prob/p128796
    @Test
    public void repeatFrontTest_01() {
        assertEquals("ChocChoChC", String2.repeatFront("Chocolate", 4));
    }

    @Test
    public void repeatFrontTest_02() {
        assertEquals("ChoChC", String2.repeatFront("Chocolate", 3));
    }

    @Test
    public void repeatFrontTest_03() {
        assertEquals("IcI", String2.repeatFront("Ice Cream", 2));
    }

    @Test
    public void repeatFrontTest_04() {
        assertEquals("I", String2.repeatFront("Ice Cream", 1));
    }

    @Test
    public void repeatFrontTest_05() {
        assertEquals("", String2.repeatFront("Ice Cream", 0));
    }

    @Test
    public void repeatFrontTest_06() {
        assertEquals("xyzxyx", String2.repeatFront("xyz", 3));
    }

    @Test
    public void repeatFrontTest_07() {
        assertEquals("", String2.repeatFront("", 0));
    }

    @Test
    public void repeatFrontTest_08() {
        assertEquals("JavaJavJaJ", String2.repeatFront("Java", 4));
    }

    @Test
    public void repeatFrontTest_09() {
        assertEquals("J", String2.repeatFront("Java", 1));
    }


    // RE: https://codingbat.com/prob/p109637
    @Test
    public void repeatSeparatorTest_01() {
        assertEquals("WordXWordXWord", String2.repeatSeparator("Word", "X", 3));
    }

    @Test
    public void repeatSeparatorTest_02() {
        assertEquals("ThisAndThis", String2.repeatSeparator("This", "And", 2));
    }

    @Test
    public void repeatSeparatorTest_03() {
        assertEquals("This", String2.repeatSeparator("This", "And", 1));
    }

    @Test
    public void repeatSeparatorTest_04() {
        assertEquals("Hi-n-Hi", String2.repeatSeparator("Hi", "-n-", 2));
    }

    @Test
    public void repeatSeparatorTest_05() {
        assertEquals("AAA", String2.repeatSeparator("AAA", "", 1));
    }

    @Test
    public void repeatSeparatorTest_06() {
        assertEquals("", String2.repeatSeparator("AAA", "", 0));
    }

    @Test
    public void repeatSeparatorTest_07() {
        assertEquals("ABABABABA", String2.repeatSeparator("A", "B", 5));
    }

    @Test
    public void repeatSeparatorTest_08() {
        assertEquals("abcXXabcXXabc", String2.repeatSeparator("abc", "XX", 3));
    }

    @Test
    public void repeatSeparatorTest_09() {
        assertEquals("abcXXabc", String2.repeatSeparator("abc", "XX", 2));
    }

    @Test
    public void repeatSeparatorTest_10() {
        assertEquals("abc", String2.repeatSeparator("abc", "XX", 1));
    }

    @Test
    public void repeatSeparatorTest_11() {
        assertEquals("XYZaXYZ", String2.repeatSeparator("XYZ", "a", 2));
    }


    // RE:
    @Test
    public void prefixAgainTest_01() {
        assertTrue(String2.prefixAgain("abXYabc", 1));
    }

    @Test
    public void prefixAgainTest_02() {
        assertTrue(String2.prefixAgain("abXYabc", 2));
    }

    @Test
    public void prefixAgainTest_03() {
        assertFalse(String2.prefixAgain("abXYabc", 3));
    }

    @Test
    public void prefixAgainTest_04() {
        assertTrue(String2.prefixAgain("xyzxyxyxy", 2));
    }

    @Test
    public void prefixAgainTest_05() {
        assertFalse(String2.prefixAgain("xyzxyxyxy", 3));
    }

    @Test
    public void prefixAgainTest_06() {
        assertTrue(String2.prefixAgain("Hi12345Hi6789Hi10", 1));
    }

    @Test
    public void prefixAgainTest_07() {
        assertTrue(String2.prefixAgain("Hi12345Hi6789Hi10", 2));
    }

    @Test
    public void prefixAgainTest_08() {
        assertTrue(String2.prefixAgain("Hi12345Hi6789Hi10", 3));
    }

    @Test
    public void prefixAgainTest_09() {
        assertFalse(String2.prefixAgain("Hi12345Hi6789Hi10", 4));
    }

    @Test
    public void prefixAgainTest_10() {
        assertFalse(String2.prefixAgain("a", 1));
    }

    @Test
    public void prefixAgainTest_11() {
        assertTrue(String2.prefixAgain("aa", 1));
    }

    @Test
    public void prefixAgainTest_12() {
        assertFalse(String2.prefixAgain("ab", 1));
    }


    // RE: https://codingbat.com/prob/p159772
    @Test
    public void xyzMiddleTest_01() {
        assertTrue(String2.xyzMiddle("AAxyzBB"));
    }

    @Test
    public void xyzMiddleTest_02() {
        assertTrue(String2.xyzMiddle("AxyzBB"));
    }

    @Test
    public void xyzMiddleTest_03() {
        assertFalse(String2.xyzMiddle("AxyzBBB"));
    }

    @Test
    public void xyzMiddleTest_04() {
        assertFalse(String2.xyzMiddle("AxyzBBBB"));
    }

    @Test
    public void xyzMiddleTest_05() {
        assertFalse(String2.xyzMiddle("AAAxyzB"));
    }

    @Test
    public void xyzMiddleTest_06() {
        assertTrue(String2.xyzMiddle("AAAxyzBB"));
    }

    @Test
    public void xyzMiddleTest_07() {
        assertFalse(String2.xyzMiddle("AAAAxyzBB"));
    }

    @Test
    public void xyzMiddleTest_08() {
        assertFalse(String2.xyzMiddle("AAAAAxyzBBB"));
    }

    @Test
    public void xyzMiddleTest_09() {
        assertTrue(String2.xyzMiddle("1x345xyz12x4"));
    }

    @Test
    public void xyzMiddleTest_10() {
        assertTrue(String2.xyzMiddle("xyzAxyzBBB"));
    }

    @Test
    public void xyzMiddleTest_11() {
        assertTrue(String2.xyzMiddle("xyzAxyzBxyz"));
    }

    @Test
    public void xyzMiddleTest_12() {
        assertTrue(String2.xyzMiddle("xyzxyzAxyzBxyzxyz"));
    }

    @Test
    public void xyzMiddleTest_13() {
        assertTrue(String2.xyzMiddle("xyzxyzxyzBxyzxyz"));
    }

    @Test
    public void xyzMiddleTest_14() {
        assertTrue(String2.xyzMiddle("xyzxyzAxyzxyzxyz"));
    }

    @Test
    public void xyzMiddleTest_15() {
        assertFalse(String2.xyzMiddle("xyzxyzAxyzxyzxy"));
    }

    @Test
    public void xyzMiddleTest_16() {
        assertFalse(String2.xyzMiddle("AxyzxyzBB"));
    }

    @Test
    public void xyzMiddleTest_17() {
        assertFalse(String2.xyzMiddle(""));
    }

    @Test
    public void xyzMiddleTest_18() {
        assertFalse(String2.xyzMiddle("x"));
    }

    @Test
    public void xyzMiddleTest_19() {
        assertFalse(String2.xyzMiddle("xy"));
    }

    @Test
    public void xyzMiddleTest_20() {
        assertTrue(String2.xyzMiddle("xyz"));
    }

    @Test
    public void xyzMiddleTest_21() {
        assertTrue(String2.xyzMiddle("xyzz"));
    }


    // RE: https://codingbat.com/prob/p129952
    @Test
    public void getSandwichTest_01() {
        assertEquals("jam", String2.getSandwich("breadjambread"));
    }

    @Test
    public void getSandwichTest_02() {
        assertEquals("jam", String2.getSandwich("xxbreadjambreadyy"));
    }

    @Test
    public void getSandwichTest_03() {
        assertEquals("", String2.getSandwich("xxbreadyy"));
    }

    @Test
    public void getSandwichTest_04() {
        assertEquals("breadjam", String2.getSandwich("xxbreadbreadjambreadyy"));
    }

    @Test
    public void getSandwichTest_05() {
        assertEquals("A", String2.getSandwich("breadAbread"));
    }

    @Test
    public void getSandwichTest_06() {
        assertEquals("", String2.getSandwich("breadbread"));
    }

    @Test
    public void getSandwichTest_07() {
        assertEquals("", String2.getSandwich("abcbreaz"));
    }

    @Test
    public void getSandwichTest_08() {
        assertEquals("", String2.getSandwich("xyz"));
    }

    @Test
    public void getSandwichTest_09() {
        assertEquals("", String2.getSandwich(""));
    }

    @Test
    public void getSandwichTest_10() {
        assertEquals("breax", String2.getSandwich("breadbreaxbread"));
    }

    @Test
    public void getSandwichTest_11() {
        assertEquals("y", String2.getSandwich("breaxbreadybread"));
    }

    @Test
    public void getSandwichTest_12() {
        assertEquals("breadbread", String2.getSandwich("breadbreadbreadbread"));
    }

}
