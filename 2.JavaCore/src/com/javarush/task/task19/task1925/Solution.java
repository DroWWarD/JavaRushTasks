package com.javarush.task.task19.task1925;

import java.io.*;
import java.util.ArrayList;

/* 
Длинные слова
*/

public class Solution {
    public static void main(String[] args) {
        String file = args[0];
        String file2 = args[1];
        String line;
        StringBuilder sb = new StringBuilder();
        try (BufferedReader fileReader = new BufferedReader(new FileReader(file))){
            while ((line=fileReader.readLine())!=null){
                sb.append(line);
                sb.append(' ');
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        try(BufferedWriter fileWriter = new BufferedWriter(new FileWriter(file2))){
            String[] parsedString = sb.toString().split(" ");
            sb = new StringBuilder();
            for (int i = 0; i < parsedString.length; i++) {
                if (parsedString[i].length()>6){
                    sb.append(parsedString[i]);
                    sb.append(',');
                }
            }
            sb.deleteCharAt(sb.length()-1);
            fileWriter.write(sb.toString());
        }catch (Exception e){
            e.printStackTrace();
        }


    }
}
