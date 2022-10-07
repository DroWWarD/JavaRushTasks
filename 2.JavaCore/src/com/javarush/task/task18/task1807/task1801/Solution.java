package com.javarush.task.task18.task1807.task1801;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        String fileName = "";
        try(BufferedReader reader=new BufferedReader(new InputStreamReader(System.in))) {
            fileName = reader.readLine();

        }catch (Exception e){
            e.printStackTrace();
        }
        File file = new File(fileName);
        ArrayList<Integer> bytes = new ArrayList<>();
        try(FileInputStream inputStream = new FileInputStream(file)){
            while (inputStream.available()>0){
                int i = inputStream.read();
                bytes.add(i);
            }
            System.out.println(Collections.max(bytes));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
