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
