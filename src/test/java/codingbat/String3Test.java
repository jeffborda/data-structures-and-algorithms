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

}