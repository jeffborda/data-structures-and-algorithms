package codingbat;

import org.junit.Test;

import static org.junit.Assert.*;


public class String2Test {


    @Test
    public void mixStringTest_1() {
        assertEquals("axbycz", String2.mixString("abc", "xyz"));
    }

    @Test
    public void mixStringTest_2() {
        assertEquals("HTihere", String2.mixString("Hi", "There"));
    }

    @Test
    public void mixStringTest_3() {
        assertEquals("xTxhxexre", String2.mixString("xxxx", "There"));
    }

}