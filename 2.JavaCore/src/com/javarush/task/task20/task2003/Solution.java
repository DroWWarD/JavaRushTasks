package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* 
Знакомство с properties
*/

public class Solution {

    public static Map<String, String> runtimeStorage = new HashMap<>();

    public static void save(OutputStream outputStream) throws Exception {
        Properties prop = new Properties();
        for (Map.Entry<String, String> entry:runtimeStorage.entrySet()) {
            prop.put(entry.getKey(), entry.getValue());
        }
        prop.store(outputStream, null);
    }

    public static void load(InputStream inputStream) throws IOException {
        Properties prop = new Properties();
        prop.load(inputStream);
        for (Map.Entry<Object, Object> entry:prop.entrySet()) {
            runtimeStorage.put((String)entry.getKey(), (String) entry.getValue());
        }
    }

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             FileInputStream fis = new FileInputStream(reader.readLine())) {
            load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }


        System.out.println(runtimeStorage);
    }
}
