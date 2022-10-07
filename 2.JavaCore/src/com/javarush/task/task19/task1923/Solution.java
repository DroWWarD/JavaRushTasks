package com.javarush.task.task19.task1923;

import java.io.*;
import java.util.ArrayList;

/* 
Слова с цифрами
*/

public class Solution {
    public static void main(String[] args) {
        String file = args[0];
        String file2 = args[1];
        String line;
        ArrayList<String> list = new ArrayList<>();
        try (BufferedReader fileReader = new BufferedReader(new FileReader(file))){
            while ((line=fileReader.readLine())!=null){
                list.add(line);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        try(BufferedWriter fileWriter = new BufferedWriter(new FileWriter(file2))){
            for (String string : list) {
                String[] parsedString = string.split(" ");
                for (int i = 0; i < parsedString.length; i++) {
                    if (parsedString[i].contains("1")||
                            parsedString[i].contains("2")||
                            parsedString[i].contains("3")||
                            parsedString[i].contains("4")||
                            parsedString[i].contains("5")||
                            parsedString[i].contains("6")||
                            parsedString[i].contains("7")||
                            parsedString[i].contains("8")||
                            parsedString[i].contains("9")||
                            parsedString[i].contains("0")) {
                        fileWriter.write(parsedString[i]);
                        fileWriter.write(" ");
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
