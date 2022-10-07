package com.javarush.task.task13.task1326;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/* 
Сортировка четных чисел из файла
*/

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();
        ArrayList<Integer> digitList = new ArrayList<>();
        try (FileInputStream fileInputStream = new FileInputStream(fileName);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader)){

            while (bufferedReader.ready()) {
               digitList.add(Integer.parseInt(bufferedReader.readLine()));

            }

        }catch (Exception e){
            e.printStackTrace();
        }
        Stream<Integer> result = digitList.stream().filter(x -> (x%2==0)).sorted();

        result.forEach(System.out::println);
    }
}
