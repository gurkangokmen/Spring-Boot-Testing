# TDD

## Table of Contents
* [Traditional Method](#traditional-method)
* [Tdd Method](#tdd-method)
* [Parameterized Test](#parameterized-test)
    * [@CsvFileSource](#csvfilesource)
    * [@ValueSource](#csvfilesource)
    * [@ValueSource](#csvfilesource)
    * [@EnumSource](#csvfilesource)
    * [@MethodSource](#csvfilesource)

## Traditional Method

```
Design
↓
Code
↓
Test
```

## Tdd Method

```
Test
↓
Code
↓
Refactor
```

## Parameterized Test

### @CsvFileSource
```java
// Behind the scenes, JUnit will run the
// test multiple times and supply the data
// JUnit does the looping for you :-)

// USE @ParameterizedTest instead of @Test

@DisplayName("Testing with Small data file")
@ParameterizedTest(name="value={0}, expected={1}")
@CsvFileSource(resources="/small-test-data.csv") // file in resources folder
@Order(5)
void testSmallDataFile(int value, String expected) {

    assertEquals(expected, FizzBuzz.compute(value));

}
```

### @ValueSource
```java
@DisplayName("Testing with @ValueSource")
@ParameterizedTest(name="value={0}")
@ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10})
@Order(8)
void testValueSource(int value) {

    String expected = FizzBuzz.compute(value);
    assertEquals(expected, FizzBuzz.compute(value), "Should return the correct FizzBuzz value");

}
```
### @CsvSource
```java
@DisplayName("Testing with @CsvSource")
@ParameterizedTest(name="value={0}, expected={1}")
@CsvSource(value = {"1,1", "2,2", "3,Fizz", "4,4", "5,Buzz", "6,Fizz", "7,7", "8,8", "9,Fizz", "10,Buzz"})
@Order(9)
void testCsvSource(int value, String expected) {

    assertEquals(expected, FizzBuzz.compute(value), "Should return the correct FizzBuzz value");

}
```
### @EnumSource

```java
package com.luv2code.tdd;

public enum FizzBuzzEnum {
    FIZZ(3, "Fizz"),
    BUZZ(5, "Buzz"),
    FIZZBUZZ(15, "FizzBuzz"),
    NONE(1, "1");

    private final int value;
    private final String expected;

    FizzBuzzEnum(int value, String expected) {
        this.value = value;
        this.expected = expected;
    }

    public int getValue() {
        return value;
    }

    public String getExpected() {
        return expected;
    }

    @Override
    public String toString() {
        return String.format("Enum=%s (Value=%d, Expected=%s)", name(), value, expected);
    }

}
```



```java
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
```
### @MethodSource
```java
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
```