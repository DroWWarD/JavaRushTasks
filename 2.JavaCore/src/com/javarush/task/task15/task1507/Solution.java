package com.javarush.task.task15.task1507;

/* 
ООП - Перегрузка
*/

public class Solution {
    public static void main(String[] args) {
        printMatrix(2, 3, "8");
    }

    public static void printMatrix(int m, int n, String value) {
        System.out.println("Заполняем объектами String");
        printMatrix(m, n, (Object) value);
    }

    public static void printMatrix(int m, int n, Object value) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(value);
            }
            System.out.println();
        }
    }
    public static void printMatrix (int n, int m, int r){

    }
    public static void printMatrix (String n, int m, int r){

    }
    public static void printMatrix (int n, String m, int r){

    }
    public static void printMatrix (Object n, int m, int r){

    }
    public static void printMatrix (int n, Object m, int r){

    }
    public static void printMatrix (String n, String m, int r){

    }
    public static void printMatrix (int n, Object m, Object r){

    }
    public static void printMatrix (String n, Object m, String r){

    }

}
