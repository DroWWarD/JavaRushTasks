package com.javarush.task.task19.task1919;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/* 
Считаем зарплаты
*/

public class Solution {
    public static void main(String[] args) throws IOException {

        ArrayList<String> list = new ArrayList<>();
        Map<String,Double> map = new HashMap<>();
        ArrayList<String> listResult = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        while (reader.ready()){
            list.add(reader.readLine());
        }
        for (String string :list) {
            String[] element = string.split(" ");
            String name = element[0];
            Double value = Double.parseDouble(element[1]);
            if (!map.containsKey(name)){
                map.put(name, value);
            }else {
                Double sum = map.get(name) + value;
                map.replace(name, sum);
            }
        }
        for (String str: map.keySet()) {
            listResult.add(str + " " + map.get(str));
        }
        Collections.sort(listResult);
        for (String result :listResult) {
            System.out.println(result);
        }
        reader.close();
    }
}
