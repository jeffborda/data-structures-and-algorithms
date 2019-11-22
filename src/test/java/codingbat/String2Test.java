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

    @Test
    public void mixStringTest_4() {
        assertEquals("xXxx", String2.mixString("xxx", "X"));
    }

    @Test
    public void mixStringTest_5() {
        assertEquals("22/7 around", String2.mixString("2/", "27 around"));
    }

    @Test
    public void mixStringTest_6() {
        assertEquals("Hello", String2.mixString("", "Hello"));
    }

    @Test
    public void mixStringTest_7() {
        assertEquals("Abc", String2.mixString("Abc", ""));
    }

}