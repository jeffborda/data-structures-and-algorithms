package codingbat;

import org.junit.Test;

import javax.print.attribute.standard.MediaSize;

import static org.junit.Assert.*;

public class OtherStringTest {

    @Test
    public void isConcatTest_01() {
        assertTrue(OtherString.isConcat("cat", "concatenation"));
    }

    @Test
    public void isConcatTest_02() {
        assertTrue(OtherString.isConcat("age", "pilgrimage"));
    }

    @Test
    public void isConcatTest_03() {
        assertTrue(OtherString.isConcat("dog", "dogma"));
    }

    @Test
    public void isConcatTest_04() {
        assertFalse(OtherString.isConcat("hello", "world"));
    }

    @Test
    public void isConcatTest_05() {
        assertTrue(OtherString.isConcat("aba", "alabama"));
    }

    @Test
    public void isConcatTest_06() {
        assertTrue(OtherString.isConcat("aab", "aaab"));
    }

    @Test
    public void isConcatenationTest_01() {
        assertTrue(OtherString.isConcatenation("cat", "concatenation"));
    }

    @Test
    public void isConcatenationTest_02() {
        assertTrue(OtherString.isConcatenation("age", "pilgrimage"));
    }

    @Test
    public void isConcatenationTest_03() {
        assertTrue(OtherString.isConcatenation("dog", "dogma"));
    }

    @Test
    public void isConcatenationTest_04() {
        assertFalse(OtherString.isConcatenation("hello", "world"));
    }

    @Test
    public void isConcatenationTest_05() {
        assertTrue(OtherString.isConcatenation("aba", "alabama"));
    }

    @Test
    public void isConcatenationTest_06() {
        assertTrue(OtherString.isConcatenation("aab", "aaab"));
    }
}