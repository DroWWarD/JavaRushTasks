package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) {
        String file = "";
        ArrayList<String> list = new ArrayList<>();
        String line = "";
        int trigger = 0;
        try(BufferedReader bf=new BufferedReader(new InputStreamReader(System.in))){
            file = bf.readLine();
        }catch (Exception e){
            e.printStackTrace();
        }
        try (BufferedReader fileReader = new BufferedReader(new FileReader(file))){
            while ((line=fileReader.readLine())!=null){
                list.add(line);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        for (String string:list) {
            String[] parsedString = string.split("[ .,!?;:\"]");
            for (int i = 0; i < parsedString.length ; i++) {
                if (words.contains(parsedString[i])) trigger++;
            }
            if (trigger==2) System.out.println(string);
            trigger=0;
        }
    }
}
