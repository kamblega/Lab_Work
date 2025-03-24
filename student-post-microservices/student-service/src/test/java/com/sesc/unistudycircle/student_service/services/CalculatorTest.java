package com.sesc.unistudycircle.student_service.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class CalculatorTest {

    Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    void test_addTwoNumbers() {
        //given
        int expectedResult = 30;
        //when
        int actualResult = calculator.addTwoNumbers(10, 20);
        //then
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void test_average() {
        int expectedResult = 20;
        int actualResult = calculator.average(10, 20, 30);
        assertEquals(expectedResult, actualResult);
    }



}