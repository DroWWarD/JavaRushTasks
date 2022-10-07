package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Разные методы для разных типов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String console = reader.readLine();
            while (!(console.equals("exit"))){
                if (isDigitInteger(console)){
                    if (Integer.parseInt(console) >0 && Integer.parseInt(console)<128) {
                        print(Short.parseShort(console));
                    }
                    else if (Integer.parseInt(console) <=0 || Integer.parseInt(console)>=128) {
                        print(Integer.parseInt(console));
                    }
                }else if(console.contains(".")){
                    if (console.indexOf(".") == console.lastIndexOf(".")) {
                        if (isDigitDouble(console)) print(Double.parseDouble(console));
                    }else print(console);

                }
                else print(console);
                console = reader.readLine();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private static boolean isDigitInteger(String s) throws NumberFormatException {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    private static boolean isDigitDouble(String s) throws NumberFormatException {
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
