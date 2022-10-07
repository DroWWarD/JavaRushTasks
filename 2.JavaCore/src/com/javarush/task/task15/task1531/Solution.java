package com.javarush.task.task15.task1531;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;

/* 
Факториал
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(reader.readLine());
        reader.close();

        System.out.println(factorial(input));
    }

    public static String factorial(int n) {
        if (n > 150) return "Введите число меньше 150";
        else if (n < 0) return "0";
        else if (n == 0 || n == 1) return "1";
        else {
            BigInteger result = new BigInteger("1");
            for (int i = 2; i <= n; i++) {
                result = result.multiply(BigInteger.valueOf(i));
            }

            return result.toString();
        }
    }
}
