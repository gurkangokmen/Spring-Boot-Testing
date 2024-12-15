package com.luv2code.junitdemo;

import org.junit.jupiter.api.*;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DemoUtilsTest {



    @DisplayName("Array Equals")
    @Test
    void testArrayEquals() {
        String[] stringArray = {"A", "B", "C"};
        String[] firstThreeLettersOfAlphabet = {"A", "B", "C"};

        assertArrayEquals(stringArray, firstThreeLettersOfAlphabet, "Arrays should be the same");
    }


    @DisplayName("Iterable equals")
    @Test
    void testIterableEquals() {
        List<String> theList = List.of("luv", "2", "code");
        List<String> academyInList = List.of("luv", "2", "code");

        assertIterableEquals(theList, academyInList, "Expected list should be same as actual list");
    }

    @DisplayName("Iterable equals 2")
    @Test
    void testIterableEquals2() {
        List<String> expectedList = List.of("luv", "\\d+", "code");
        List<String> actualList = List.of("luv", "9", "code");

        // ONLY THIS TEST FAIL!
        assertIterableEquals(expectedList, actualList, "Expected list should be same as actual list");
    }

    @DisplayName("Lines match")
    @Test
    void testLinesMatch() {
        List<String> theList = List.of("luv", "2", "code");
        List<String> academyInList = List.of("luv", "2", "code");
        assertLinesMatch(theList, academyInList, "Lines should match");
    }


    @DisplayName("Lines match 2")
    @Test
    void testLinesMatch2() {
        List<String> expectedList = List.of("luv", "\\d+", "code");
        List<String> actualList = List.of("luv", "9", "code");
        assertLinesMatch(expectedList, actualList, "Lines should match");
    }


}






