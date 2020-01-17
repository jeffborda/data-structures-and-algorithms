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
}