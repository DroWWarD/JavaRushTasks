package com.javarush.task.task18.task1807;

import java.io.*;

/* 
Подсчет запятых
*/

public class Solution {
    public static void main(String[] args) {
        String fileName = "";
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            fileName = reader.readLine();
        }catch (Exception e){
            e.printStackTrace();
        }

        int count = 0;
        try(FileInputStream fileIn = new FileInputStream(fileName);){
            while (fileIn.available()>0){
                if (fileIn.read() == 44) count++;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(count);

    }
}
