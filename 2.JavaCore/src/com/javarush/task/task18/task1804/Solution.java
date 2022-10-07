package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* 
Самые редкие байты
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
                    value = map.get(i);
                    map.replace(i, value, ++value);
                }else map.put(i, 1);
            }
            int result = Collections.min(map.values());
            for (Integer integer: map.keySet()) {
                if (map.get(integer) == result) System.out.print(integer + " ");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
