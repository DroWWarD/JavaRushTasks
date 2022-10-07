package com.javarush.task.task19.task1927;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/* 
Контекстная реклама
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {

        PrintStream oldPS = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream newPS = new PrintStream(baos);
        System.setOut(newPS);
        int count = 0;
        testString.printSomething();
        System.setOut(oldPS);
        String[] parsedBAOS = baos.toString().split("\n");
        for (int i = 0; i < parsedBAOS.length; i++) {
            if (count == 2) {
                System.out.println("JavaRush - курсы Java онлайн");
                count=0;
            }
            System.out.println(parsedBAOS[i]);
            count++;
        }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
