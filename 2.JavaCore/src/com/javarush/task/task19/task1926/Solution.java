package com.javarush.task.task19.task1926;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Перевертыши
*/

public class Solution {
    public static void main(String[] args) {
        String file="";
        String line;

        try (BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))){
            file = bf.readLine();
        }catch (Exception e){
            e.printStackTrace();
        }

        try (BufferedReader fileReader = new BufferedReader(new FileReader(file))){
            while ((line=fileReader.readLine())!=null){
                StringBuilder sb = new StringBuilder(line);
                System.out.println((sb.reverse().toString()));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
