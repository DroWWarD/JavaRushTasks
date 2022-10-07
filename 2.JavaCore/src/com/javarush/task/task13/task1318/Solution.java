package com.javarush.task.task13.task1318;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
Чтение файла
*/

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();
        try(FileInputStream fileInputStream = new FileInputStream(fileName);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader)){
            while (bufferedReader.ready()){
                System.out.println(bufferedReader.readLine());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}