package com.javarush.task.task18.task1820;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Округление чисел
*/

public class Solution {
    public static void main(String[] args) {
        String file1 = "";
        String file2 = "";
        String digits = "";
        try(BufferedReader reader = new BufferedReader( new InputStreamReader(System.in))){
            file1= reader.readLine();
            file2= reader.readLine();
        }catch (Exception e){
            e.printStackTrace();
        }
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file1))){
                digits = bufferedReader.readLine();
        }catch (Exception e){
            e.printStackTrace();
        }
            String[] split = digits.split(" ");
            int[] numbers = new int[split.length];
            int i =0;
            for (String str:split) {
                numbers[i++] = Math.round(Float.parseFloat(str));
            }
        try(FileWriter fileWriter = new FileWriter(file2, true)){
            for (int num:numbers) {
                fileWriter.write(Integer.toString(num));
                fileWriter.write(" ");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
