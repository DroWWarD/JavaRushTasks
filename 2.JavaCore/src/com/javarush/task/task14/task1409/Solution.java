package com.javarush.task.task14.task1409;

/* 
Мосты
*/

public class Solution {
    public static void main(String[] args) {
        println(new WaterBridge());
        println(new SuspensionBridge());
    }
    public static void println(Bridge bridge){
        int i = bridge.getCarsCount();
        System.out.println(i);

    }
}

