package com.javarush.task.task18.task1816;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* 
Английские буквы
*/

public class Solution {
    public static void main(String[] args) {
        int count = 0;
        int value = 0;
        try(FileInputStream fileInputStream = new FileInputStream(args[0])){
            while (fileInputStream.available()>0){
                value = fileInputStream.read();
                if ((value >=65 && value<=90) || (value>=97 && value <=122)){
                    count++;
                }
            }
            System.out.println(count);

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
