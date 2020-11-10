package com.example.myapp;

import junit.framework.TestCase;

public class CalculatorTest extends TestCase {
    public void testAdd(){
        int expected =30;
        int actual =Calculator.add(20,10);
        assertEquals(expected,actual);

    }

}