package com.javarush.task.task19.task1908;

import java.io.*;
import java.util.ArrayList;

/* 
Выделяем числа
*/

public class Solution {
    public static void main(String[] args) throws IOException {

        String file1 = "";
        String file2 = "";
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        file1 = reader.readLine();
        file2 = reader.readLine();
        reader.close();

        BufferedReader fileReader = new BufferedReader(new FileReader(file1));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(file2));

        ArrayList<String> numbers = new ArrayList<>();
        while (fileReader.ready()){
            String line = fileReader.readLine();
            String[] parsedLine = line.split(" ");
            for (int i = 0; i < parsedLine.length; i++) {
                if (isInteger(parsedLine[i])){
                    numbers.add(parsedLine[i]);
                }
            }
        }
        for (int i = 0; i < numbers.size(); i++) {
            fileWriter.write(numbers.get(i));
            if (i < numbers.size() -1){
                fileWriter.write(" ");
            }
        }
        fileReader.close();
        fileWriter.close();
    }

    public static boolean isInteger(String string){
        try {
            Integer result = Integer.parseInt(string);
            return true;
        }catch (Exception e){
            return false;
        }
    }

}
