package com.javarush.task.pro.task17.task1708;

/* 
Минимальное и максимальное
*/

public class MinMaxUtil {
    public static int min(int min1, int min2){
        return Math.min(min1, min2);
    }
    public static int min(int min1, int min2, int min3){
        return Math.min(Math.min(min1, min2), min3);
    }
    public static int min(int min1, int min2, int min3, int min4){
        return Math.min(Math.min(min1, min2), Math.min(min3, min4));
    }
    public static int min(int min1, int min2, int min3, int min4, int min5){
        return Math.min(Math.min(Math.min(min1, min2), Math.min(min3, min4)), min5);
    }
    public static int max(int min1, int min2){
        return Math.max(min1, min2);
    }
    public static int max(int min1, int min2, int min3){
        return Math.max(Math.max(min1, min2), min3);
    }
    public static int max(int min1, int min2, int min3, int min4){
        return Math.max(Math.max(min1, min2), Math.max(min3, min4));
    }
    public static int max(int min1, int min2, int min3, int min4, int min5){
        return Math.max(Math.max(Math.max(min1, min2), Math.max(min3, min4)), min5);
    }



}
