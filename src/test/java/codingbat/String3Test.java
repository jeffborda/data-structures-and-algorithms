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

    }

    @Test
    public void countYZTest_05() {

    }

    @Test
    public void countYZTest_06() {

    }

    @Test
    public void countYZTest_07() {

    }

    @Test
    public void countYZTest_08() {

    }

    @Test
    public void countYZTest_09() {

    }

    @Test
    public void countYZTest_10() {

    }

    @Test
    public void countYZTest_11() {

    }

}