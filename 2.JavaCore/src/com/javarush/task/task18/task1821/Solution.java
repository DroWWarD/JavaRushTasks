package com.javarush.task.task18.task1821;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/* 
Встречаемость символов
*/

public class Solution {
    public static void main(String[] args) throws IOException {

        Map<Integer, Integer> map = new HashMap<>();
        ArrayList<String> list = new ArrayList<>();
        FileReader reader = new FileReader(args[0]);
        while (reader.ready()){
            int simbol = reader.read();
            if (!map.containsKey(simbol)){
                map.put(simbol, 1);
            }else {
                map.replace(simbol, map.get(simbol), map.get(simbol)+1);
            }
        }
        Map<Integer, Integer> sortedMap = new TreeMap<>(map);
        for (Integer key: sortedMap.keySet()) {
            list.add(key + " " + sortedMap.get(key));
        }
        for (String string:list) {
            String[] line = string.split(" ");
            System.out.println((char)Integer.parseInt(line[0]) + " " + line[1]);
        }
        reader.close();

    }
}
