package com.javarush.task.task19.task1906;

import java.io.*;
import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.List;

/* 
Четные символы
*/

public class Solution {
    public static void main(String[] args) {
        String fileName1 = "";
        String fileName2 = "";
        ArrayList<Integer> list = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            fileName1= reader.readLine();
            fileName2= reader.readLine();
        }catch (Exception e){
            e.printStackTrace();
        }
        try (FileReader fileReader = new FileReader(fileName1);
            FileWriter fileWriter = new FileWriter(fileName2)){
            while (fileReader.ready()){
                list.add(fileReader.read());
            }
            for (int i = 1; i < list.size(); i=i+2) {
                fileWriter.write(list.get(i));
            }

        }catch (Exception e){
            e.printStackTrace();
        }


    }
}
