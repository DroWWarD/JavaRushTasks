package com.javarush.task.task19.task1910;

import java.io.*;
import java.util.ArrayList;

/* 
Пунктуация
*/

public class Solution {
    public static void main(String[] args) {

        String fileName1 = "";
        String fileName2 = "";
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            fileName1 = reader.readLine();
            fileName2 = reader.readLine();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName1));
             BufferedWriter writer = new BufferedWriter(new FileWriter(fileName2))) {
            while (reader.ready()) {
                int c = reader.read();
                if (c>=48&&c<=57||c>=65&&c<=90||c>=97&&c<=122 ||c==32) {
                    writer.write(c);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
