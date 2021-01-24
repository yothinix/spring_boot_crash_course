package com.odds;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FizzBuzzTest {
    @Test
    void getOneShouldReturnOneTest() {
        FizzBuzz fizzBuzz = new FizzBuzz();
        String actual = fizzBuzz.get(1);
        Assertions.assertEquals("1", actual);
    }

    @Test
    void getTwoShouldReturnTwoTest() {
        FizzBuzz fizBuzz = new FizzBuzz();
        String actual = fizBuzz.get(2);
        Assertions.assertEquals("2", actual);
    }
}
