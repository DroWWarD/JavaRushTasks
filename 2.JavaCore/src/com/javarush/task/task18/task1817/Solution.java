package com.javarush.task.task18.task1817;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

/* 
Пробелы
*/

public class Solution {
    public static void main(String[] args) {
        int count = 0;
        int countSpace = 0;
        int value = 0;
        double result =0;
        try(FileInputStream fileInputStream = new FileInputStream(args[0])){
            while (fileInputStream.available()>0){
                value = fileInputStream.read();
                if (value == 32){
                    countSpace++;
                } count++;
            }
            result = (double) countSpace/count*100;

            System.out.printf("%.2f", result);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
