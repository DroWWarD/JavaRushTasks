package com.javarush.task.task19.task1914;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/* 
Решаем пример
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {

        PrintStream oldPS = System.out;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream newPS = new PrintStream(byteArrayOutputStream);
        System.setOut(newPS);
        testString.printSomething();
        System.setOut(oldPS);
        String resultString = byteArrayOutputStream.toString();
        String[] result = resultString.split(" ");
        int a = Integer.parseInt(result[0]);
        int b = Integer.parseInt(result[2]);
        if (result[1].equals("+")) System.out.println(a + " + " + b + " = " + (a + b));
        else if (result[1].equals("-")) System.out.println(a + " - " + b + " = " + (a - b));
        else if (result[1].equals("*")) System.out.println(a + " * " + b + " = " + (a * b));
    }
    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

