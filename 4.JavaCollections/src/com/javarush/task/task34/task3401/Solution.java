package com.javarush.task.task34.task3401;

/* 
Числа Фибоначчи с помощью рекурсии
*/

import java.util.HashMap;
import java.util.Map;

public class Solution {

    int level = 0;
    static Map<Integer, Long> map = new HashMap<>();

    public static void main(String[] args) {
        map.put(0, 0L);
        map.put(1, 1L);
        map.put(2, 1L);
        System.out.println(fibonacci(50));     //34
    }

    public static long fibonacci(int n) {
//        if (map.containsKey(n)) {
//            return map.get(n);
//        }else {
//            long currentFib =  fibonacci(n-1) + fibonacci(n-2);
//            map.put(n, currentFib);
//            return currentFib;
//        }

        if (n<=1) return n;
        return fibonacci(n-1) + fibonacci(n-2);


    }
}


//        level++;
//        System.out.println("level = " + level + " n = " + n);
//        int nMin1 = fibonacci(n - 1);
//        System.out.println("level = " + level + " n = " + n + " nMin1 = " + nMin1);
//        int nMin2 = fibonacci(n - 2);
//        System.out.println("level = " + level + " n = " + n + " nMin2 = " + nMin2);
//        int sum = nMin1 + nMin2;
//        System.out.println("nMin1 = " + nMin1 + " nMin2 = " + nMin2 + " sum = " + sum);
//        level--;
//        return sum;

