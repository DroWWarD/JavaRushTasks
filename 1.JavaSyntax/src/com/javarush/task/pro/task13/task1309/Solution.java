package com.javarush.task.pro.task13.task1309;

import java.util.HashMap;

/* 
Успеваемость студентов
*/

public class Solution {
    public static HashMap<String, Double> grades = new HashMap<>();

    public static void main(String[] args) {
        addStudents();
        System.out.println(grades);
    }

    public static void addStudents() {
        grades.put("Иван Петров", 4.1);
        grades.put("Иван Семенов", 4.9);
        grades.put("Оля Бутова", 3.5);
        grades.put("Король Семенович", 4.5);
        grades.put("Ситх Павлов", 3.8);
    }
}
