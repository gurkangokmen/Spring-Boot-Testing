package com.luv2code.tdd;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class FizzBuzzTest {
    // If number is divisible by 3, print Fizz
    // If number is divisible by 5, print Buzz
    // If number is divisible by 3 and 5, print FizzBuzz
    // If number is NOT divisible by 3 or 5, then print the number


    // If number is divisible by 3, print Fizz
    @DisplayName("Divisible by Three")
    @Test
    @Order(1)
    void testForDivisibleByThree(){
        String expected = "Fizz";

        assertEquals(expected, FizzBuzz.compute(3), "Should return Fizz");
    }

    // If number is divisible by 5, print Buzz
    @DisplayName("Divisible by Five")
    @Test
    @Order(2)
    void testForDivisibleByFive() {

        String expected = "Buzz";

        assertEquals(expected, FizzBuzz.compute(5), "Should return Buzz");
    }

    // If number is divisible by 3 and 5, print FizzBuzz
    @DisplayName("Divisible by Three and Five")
    @Test
    @Order(3)
    void testForDivisibleByThreeAndFive() {

        String expected = "FizzBuzz";

        assertEquals(expected, FizzBuzz.compute(15), "Should return FizzBuzz");
    }


    // If number is NOT divisible by 3 or 5, then print the number
    @DisplayName("Not Divisible by Three or Five")
    @Test
    @Order(4)
    void testForNotDivisibleByThreeOrFive() {

        String expected = "1";

        assertEquals(expected, FizzBuzz.compute(1), "Should return 1");
    }




    //
    // Parameterized Test
    //

    // Behind the scenes, JUnit will run the
    // test multiple times and supply the data
    // JUnit does the looping for you :-)

    // USE @ParameterizedTest instead of @Test
    // part 1
    @DisplayName("Testing with Small data file")
    @ParameterizedTest(name="value={0}, expected={1}")
    @CsvFileSource(resources="/small-test-data.csv")
    @Order(5)
    void testSmallDataFile(int value, String expected) {

        assertEquals(expected, FizzBuzz.compute(value));

    }


    // part 2
    @DisplayName("Testing with Medium data file")
    @ParameterizedTest(name="value={0}, expected={1}")
    @CsvFileSource(resources="/medium-test-data.csv")
    @Order(6)
    void testMediumDataFile(int value, String expected) {

        assertEquals(expected, FizzBuzz.compute(value));

    }

    @DisplayName("Testing with Large data file")
    @ParameterizedTest(name="value={0}, expected={1}")
    @CsvFileSource(resources="/large-test-data.csv")
    @Order(7)
    void testLargeDataFile(int value, String expected) {

        assertEquals(expected, FizzBuzz.compute(value));

    }

    @DisplayName("Testing with @ValueSource")
    @ParameterizedTest(name="value={0}")
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10})
    @Order(8)
    void testValueSource(int value) {

        String expected = FizzBuzz.compute(value);
        assertEquals(expected, FizzBuzz.compute(value), "Should return the correct FizzBuzz value");

    }

    @DisplayName("Testing with @CsvSource")
    @ParameterizedTest(name="value={0}, expected={1}")
    @CsvSource(value = {"1,1", "2,2", "3,Fizz", "4,4", "5,Buzz", "6,Fizz", "7,7", "8,8", "9,Fizz", "10,Buzz"})
    @Order(9)
    void testCsvSource(int value, String expected) {

        assertEquals(expected, FizzBuzz.compute(value), "Should return the correct FizzBuzz value");

    }

    @DisplayName("Testing with @EnumSource")
    @ParameterizedTest(name = "value => {0}")
    @EnumSource(FizzBuzzEnum.class)
    @Order(10)
    void testEnumSource(FizzBuzzEnum fbEnum) {
        int value = fbEnum.getValue();
        String expected = fbEnum.getExpected();

        assertEquals(expected, FizzBuzz.compute(value),
                "Should return the correct FizzBuzz value");
    }

    @DisplayName("Testing with @MethodSource")
    @ParameterizedTest(name = "value => {0}")
    @MethodSource("com.luv2code.tdd.FizzBuzzTest#provideFizzBuzzEnum")
    @Order(11)
    void testMethodSource(FizzBuzzEnum fbEnum) {
        int value = fbEnum.getValue();
        String expected = fbEnum.getExpected();

        assertEquals(expected, FizzBuzz.compute(value),
                "Should return the correct FizzBuzz value");
    }

    static Stream<FizzBuzzEnum> provideFizzBuzzEnum() {
        return Stream.of(FizzBuzzEnum.values());
    }




}
