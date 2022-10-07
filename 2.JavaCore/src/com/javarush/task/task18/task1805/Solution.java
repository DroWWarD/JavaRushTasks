package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        String fileName = "";
        try(BufferedReader reader=new BufferedReader(new InputStreamReader(System.in))) {
            fileName = reader.readLine();

        }catch (Exception e){
            e.printStackTrace();
        }
        int value = 0;
        File file = new File(fileName);
        Map<Integer, Integer> map = new HashMap<>();
        try(FileInputStream inputStream = new FileInputStream(file)){
            while (inputStream.available()>0){
                int i = inputStream.read();
                if(map.containsKey(i)){
                }else map.put(i, 1);
            }
            map.keySet().stream().sorted().forEach(x -> System.out.print(x + " " ));
        }catch (Exception e){
            e.printStackTrace();
        }


    }
}
