package com.javarush.task.task18.task1819;

import java.io.*;

/* 
Объединение файлов
*/

public class Solution {
    public static void main(String[] args) {
        String fileName1 = "";
        String fileName2 = "";
        byte[] file1;
        byte[] file2;

        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))){
            fileName1 = bufferedReader.readLine();
            fileName2 = bufferedReader.readLine();
        }catch (Exception e){
            e.printStackTrace();
        }
        try(FileInputStream fileInputStream1 =  new FileInputStream(fileName1);
            FileInputStream fileInputStream2 =  new FileInputStream(fileName2)){
            file1 = new byte[fileInputStream1.available()];
            fileInputStream1.read(file1);
            file2 = new byte[fileInputStream2.available()];
            fileInputStream2.read(file2);

            FileOutputStream fileOutputStream = new FileOutputStream(fileName1);
            fileOutputStream.write(file2);
            fileOutputStream.write(file1);
            fileOutputStream.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
