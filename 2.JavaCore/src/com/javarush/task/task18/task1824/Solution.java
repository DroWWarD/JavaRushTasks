package com.javarush.task.task18.task1824;

import java.io.*;

/* 
Файлы и исключения
*/

public class Solution {
    public static void main(String[] args) {
        String fileName = "";
        while (true){
            try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
                fileName = bufferedReader.readLine();
                try (FileInputStream fileInputStream = new FileInputStream(fileName)){

                }catch (FileNotFoundException exception){
                    System.out.println(fileName);
                    break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
