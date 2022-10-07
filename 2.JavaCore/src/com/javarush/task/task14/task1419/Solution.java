package com.javarush.task.task14.task1419;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.*;

/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }
    static class MyException extends Exception{

    }
    private static void initExceptions() {   //the first exception
        //1
        try {
            float i = 1 / 0;

        } catch (Exception e) {
            exceptions.add(e);
        }
        //2
        try {
            String s = null;
            System.out.println(s.charAt(0));

        } catch (Exception e) {
            exceptions.add(e);
        }
        //3
        try {
            String a = "12345678";
            char c = a.charAt(10);
            System.out.println(c);

        } catch (Exception e) {
            exceptions.add(e);
        }
        //4
        try {
            File file = new File("C://thereIsNoFileHere.txt");
            FileReader fileReader = new FileReader(file);

        } catch (Exception e) {
            exceptions.add(e);
        }
        //5
        try {
            Integer digit = Integer.parseInt("nope");
            System.out.println(digit);

        } catch (Exception e) {
            exceptions.add(e);
        }
        //6
        try {
            int a[] = new int[10];
            a[10] = 10;
        } catch (Exception e) {
            exceptions.add(e);
        }
        //7
        try {
            Scanner scanner = new Scanner("Oumphhhh");
            System.out.println("" + scanner.nextLine());
            System.out.println("Exception Output: "
                    + scanner.ioException());
        } catch (Exception e) {
            exceptions.add(e);
        }
        //8
        try {
            Set set = new HashSet();
            Hashtable hashtable = new Hashtable();
            set.iterator().next();
            hashtable.elements().nextElement();

        } catch (Exception e) {
            exceptions.add(e);
        }
        //9
        try {
            throw new IllegalArgumentException("Уже двятое...");

        } catch (Exception e) {
            exceptions.add(e);
        }
        //10
        try {
            throw new IllegalStateException("А вот и финалочка");

        } catch (Exception e) {
            exceptions.add(e);
        }
        //11
        try {
            throw new MyException();

        } catch (Exception e) {
            exceptions.add(e);
        }
    }
}
