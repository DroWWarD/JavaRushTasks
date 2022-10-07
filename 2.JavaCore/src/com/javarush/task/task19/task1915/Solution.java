package com.javarush.task.task19.task1915;

import java.io.*;

/* 
Дублируем текст
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();

        PrintStream oldPS = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream newPS = new PrintStream(baos);
        System.setOut(newPS);
        testString.printSomething();

        FileOutputStream fileOutputStream = new FileOutputStream(fileName);
        fileOutputStream.write(baos.toByteArray());
        System.setOut(oldPS);
        reader.close();
        fileOutputStream.close();
        System.out.println(baos.toString());

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

