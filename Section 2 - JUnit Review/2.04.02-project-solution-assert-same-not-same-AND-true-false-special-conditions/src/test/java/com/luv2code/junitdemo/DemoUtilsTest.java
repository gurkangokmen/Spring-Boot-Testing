package com.luv2code.junitdemo;

import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DemoUtilsTest {

    /*
        - assertEquals: compares the string contents
        - assertSame: compares memory location
     */

    @DisplayName("Strings - Not Same")
    @Test
    void testStringsNotSame() {

        String strOne = new String("luv2code");
        String strTwo = new String("luv2code");

        assertNotSame(strOne, strTwo, "Objects should not refer to same object");
    }

    // Notice in the test above that notSame will test to see if the two instances are the same.
    // In this case they are different instances (different memory locations).
    // This is because we are using the new keyword.

    @DisplayName("Strings - Equals")
    @Test
    void testStringsEquals() {

        String strOne = new String("luv2code");
        String strTwo = new String("luv2code");

        assertEquals(strOne, strTwo, "String contents are equals");
    }

    // Notice in the test above that equals test for the string contents.
    // They are equal ... even though they are different instances (different memory locations).

    // The tricky thing is when you use
    /*
        String strOne = "luv2code";
        String strTwo = "luv2code";
     */

    // In this case, Java performs an optimization. Instead of creating two new instances (two new objects)
    // ... Java simply shares the object reference.
    // As a result, assertEquals will return true since same object reference.
    // Also assertSame will return true since same string contents. Here's a test for this.
    @DisplayName("Strings - Same - String Literal")
    @Test
    void testStringsSameStringLiteratal() {

        String strOne = "luv2code";
        String strTwo = "luv2code";

        assertSame(strOne, strTwo, "Objects should refer to same object");
    }

    @DisplayName("Strings - Equals - String Literal")
    @Test
    void testStringsEqualsStringLiteral() {

        String strOne = "luv2code";
        String strTwo = "luv2code";

        assertEquals(strOne, strTwo, "String contents are equals");
    }

}










