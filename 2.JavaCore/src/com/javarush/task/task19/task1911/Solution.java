package com.javarush.task.task19.task1911;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/* 
Ридер обертка
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream defaultPS = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream newPS = new PrintStream(baos);
        System.setOut(newPS);
        testString.printSomething();
        System.setOut(defaultPS);
        String result = baos.toString().toUpperCase();
        System.out.println(result);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}
