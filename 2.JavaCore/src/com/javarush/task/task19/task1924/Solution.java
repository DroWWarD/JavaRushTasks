package com.javarush.task.task19.task1924;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* 
Замена чисел
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();

    static {
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");
    }

    public static void main(String[] args) {

        String fileName = "";
        ArrayList<String> list = new ArrayList<>();
        try (BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))) {
            fileName = bf.readLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try (BufferedReader brFile = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = brFile.readLine()) != null) {
                list.add(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (String string : list) {
            String[] parsedString = string.split(" ");
            String temp = "";
            String temp1 ="";
            for (int i = 0; i < parsedString.length; i++) {
                if (parsedString[i].contains(".")){
                    temp1 = parsedString[i].split("[.]")[0];
                    if (isInteger(temp1)) {
                        if (map.containsKey(Integer.parseInt(temp1))) {
                            parsedString[i] = map.get(Integer.parseInt(temp1))+ ".";
                        }
                    }
                }
                if (isInteger(parsedString[i])) {
                    if (map.containsKey(Integer.parseInt(parsedString[i]))) {
                        parsedString[i] = map.get(Integer.parseInt(parsedString[i]));
                    }
                }

                temp = temp + " " + parsedString[i];
            }
            string = temp;
            System.out.println(string.trim());
        }


    }

    public static boolean isInteger(String string) {
        try {
            int i = Integer.parseInt(string);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
