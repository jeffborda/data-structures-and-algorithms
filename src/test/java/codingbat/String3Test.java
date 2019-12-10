package codingbat;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * RE: https://codingbat.com/java/String-3
 * Majority of tests are from CodingBat, which I migrated to junit.
 */
public class String3Test {

    // RE: https://codingbat.com/prob/p199171
    @Test
    public void countYZTest_01() {
        assertEquals(2, String3.countYZ("fez day"));
    }

    @Test
    public void countYZTest_02() {
        assertEquals(2, String3.countYZ("day fez"));
    }

    @Test
    public void countYZTest_03() {
        assertEquals(2, String3.countYZ("day fyyyz"));
    }

    @Test
    public void countYZTest_04() {
        assertEquals(1, String3.countYZ("day yak"));
    }

    @Test
    public void countYZTest_05() {
        assertEquals(1, String3.countYZ("day:yak"));
    }

    @Test
    public void countYZTest_06() {
        assertEquals(2, String3.countYZ("!!day--yaz!!"));
    }

    @Test
    public void countYZTest_07() {
        assertEquals(0, String3.countYZ("yak zak"));
    }

    @Test
    public void countYZTest_08() {
        assertEquals(2, String3.countYZ("DAY abc XYZ"));
    }

    @Test
    public void countYZTest_09() {
        assertEquals(3, String3.countYZ("aaz yyz my"));
    }

    @Test
    public void countYZTest_10() {
        assertEquals(2, String3.countYZ("y2bz"));
    }

    @Test
    public void countYZTest_11() {
        assertEquals(0, String3.countYZ("zxyx"));
    }


    // RE: RE: https://codingbat.com/prob/p192570
    @Test
    public void withoutStringTest_01() {
        assertEquals("He there", String3.withoutString("Hello there", "llo"));
    }

    @Test
    public void withoutStringTest_02() {
        assertEquals("Hllo thr", String3.withoutString("Hello there", "e"));
    }

    @Test
    public void withoutStringTest_03() {
        assertEquals("Hello there", String3.withoutString("Hello there", "x"));
    }

    @Test
    public void withoutStringTest_04() {
        assertEquals("Th  a FH", String3.withoutString("This is a FISH", "IS"));
}

    @Test
    public void withoutStringTest_05() {
        assertEquals("TH  a FH", String3.withoutString("THIS is a FISH", "is"));
    }

    @Test
    public void withoutStringTest_06() {
        assertEquals("TH  a FH", String3.withoutString("THIS is a FISH", "iS"));
    }

    @Test
    public void withoutStringTest_07() {
        assertEquals("abab", String3.withoutString("abxxxxab", "xx"));
    }

    @Test
    public void withoutStringTest_08() {
        assertEquals("abxab", String3.withoutString("abxxxab", "xx"));
    }

    @Test
    public void withoutStringTest_09() {
        assertEquals("abab", String3.withoutString("abxxxab", "x"));
    }

    @Test
    public void withoutStringTest_10() {
        assertEquals("", String3.withoutString("xxx", "x"));
    }

    @Test
    public void withoutStringTest_11() {
        assertEquals("x", String3.withoutString("xxx", "xx"));
    }

    @Test
    public void withoutStringTest_12() {
        assertEquals("xzz", String3.withoutString("xyzzy", "Y"));
    }

    @Test
    public void withoutStringTest_13() {
        assertEquals("", String3.withoutString("", "x"));
    }

    @Test
    public void withoutStringTest_14() {
        assertEquals("acac", String3.withoutString("abcabc", "b"));
    }

    @Test
    public void withoutStringTest_15() {
        assertEquals("AAbb", String3.withoutString("AA22bb", "2"));
    }

    @Test
    public void withoutStringTest_16() {
        assertEquals("", String3.withoutString("1111", "1"));
    }

    @Test
    public void withoutStringTest_17() {
        assertEquals("", String3.withoutString("1111", "11"));
    }

    @Test
    public void withoutStringTest_18() {
        assertEquals("jtx", String3.withoutString("MkjtMkx", "Mk"));
    }

    @Test
    public void withoutStringTest_19() {
        assertEquals("Hi ", String3.withoutString("Hi HoHo", "Ho"));
    }


    // RE: https://codingbat.com/prob/p141736
    @Test
    public void equalIsNotTest_01() {
        assertFalse(String3.equalIsNot("This is not"));
    }

    @Test
    public void equalIsNotTest_02() {
        assertTrue(String3.equalIsNot("This is notnot"));
    }

    @Test
    public void equalIsNotTest_03() {
        assertTrue(String3.equalIsNot("noisxxnotyynotxisi"));
    }

    @Test
    public void equalIsNotTest_04() {
        assertFalse(String3.equalIsNot("noisxxnotyynotxsi"));
    }

    @Test
    public void equalIsNotTest_05() {
        assertTrue(String3.equalIsNot("xxxyyyzzzintint"));
    }

    @Test
    public void equalIsNotTest_06() {
        assertTrue(String3.equalIsNot(""));
    }

    @Test
    public void equalIsNotTest_07() {
        assertTrue(String3.equalIsNot("isisnotnot"));
    }

    @Test
    public void equalIsNotTest_08() {
        assertFalse(String3.equalIsNot("isisnotno7Not"));
    }

    @Test
    public void equalIsNotTest_09() {
        assertFalse(String3.equalIsNot("isnotis"));
    }

    @Test
    public void equalIsNotTest_10() {
        assertFalse(String3.equalIsNot("mis3notpotbotis"));
    }


    // RE: https://github.com/jeffborda/data-structures-and-algorithms
    @Test
    public void gHappyTest_01() {
        assertTrue(String3.gHappy("xxggxx"));
    }

    @Test
    public void gHappyTest_02() {
        assertFalse(String3.gHappy("xxgxx"));
    }

    @Test
    public void gHappyTest_03() {
        assertFalse(String3.gHappy("xxggyygxx"));
    }

    @Test
    public void gHappyTest_04() {
        assertFalse(String3.gHappy("g"));
    }

    @Test
    public void gHappyTest_05() {
        assertTrue(String3.gHappy("gg"));
    }

    @Test
    public void gHappyTest_06() {
        assertTrue(String3.gHappy(""));
    }

    @Test
    public void gHappyTest_07() {

    }

    @Test
    public void gHappyTest_08() {

    }

    @Test
    public void gHappyTest_09() {

    }

    @Test
    public void gHappyTest_10() {

    }

    @Test
    public void gHappyTest_11() {

    }

    @Test
    public void gHappyTest_12() {

    }

}