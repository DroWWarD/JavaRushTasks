package com.javarush.task.task13.task1319;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

/* 
Писатель в файл с консоли
*/

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String stopConsoleReading = "exit";
        ArrayList<String> strings = new ArrayList<>();
        String fileName = scanner.nextLine();
        String inputString = null;
        do{
            inputString = scanner.nextLine();
            strings.add(inputString);

        }while (!inputString.equals(stopConsoleReading));

        try (FileWriter fileWriter = new FileWriter(fileName);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)){
            for (String string:strings) {
                bufferedWriter.write(string + "\n");

            }


        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
