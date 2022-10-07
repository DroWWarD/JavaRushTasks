package com.javarush.task.task14.task1420;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
НОД
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            int firstDigit = Integer.parseInt(bufferedReader.readLine());
            int secondDigit = Integer.parseInt(bufferedReader.readLine());
            int max = Math.max(firstDigit,secondDigit);
            int min = Math.min(firstDigit,secondDigit);
            while (min!=0){
                int temp = min;
                min = max%min;
                max = temp;
                if (min == 0) System.out.println(max);
            }


        } catch (Exception e){
            e.printStackTrace();
        }


    }
}
