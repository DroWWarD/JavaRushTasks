package com.javarush.task.task20.task2026;

/* 
Алгоритмы-прямоугольники
*/

public class Solution {
    public static void main(String[] args) {
        byte[][] a1 = new byte[][]{
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 1}
        };
        byte[][] a2 = new byte[][]{
                {1, 0, 0, 1},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {1, 0, 0, 1}
        };

        int count1 = getRectangleCount(a1);
        System.out.println("count = " + count1 + ". Должно быть 2");
        int count2 = getRectangleCount(a2);
        System.out.println("count = " + count2 + ". Должно быть 4");
    }

    public static int getRectangleCount(byte[][] a) {
        int result = 0;
        int [] lastCoordinate = new int[2];
//Проходимся по массиву сверху вниз, слева направо, находим элемент, равный 1 (верхнюю левую координату прямоугольника)
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j] == 1){
                    lastCoordinate = findRectangle(a,i,j);
//Найдя верхнюю левую и нижнюю правую координаты - увеличиваем счетчик найденных прямоугольников и удаляем его из массива (на 0 меняем элементы)
                    result++;
                    for (int k = i; k <= lastCoordinate[0]; k++) {
                        for (int l = j; l <= lastCoordinate[1]; l++) {
                            a[k][l] = 0;
                        }
                    }
//проходимся снова по всему массиву после удаления найденных прямоугольников
                    i=0;
                    j=0;
                }
            }

        }
        return result;
    }

    public static int[] findRectangle (byte[][] a, int y, int x){
// Метод находит нижнюю правую координату прямоугольника
        int[] lastCoordinate = new int[2];
        for (int i = y; i < a.length; i++) {
            if (a[i][x] == 1){
                lastCoordinate[0] = i;
            }else break;
        }
        for (int i = x; i < a[y].length; i++) {
            if (a[y][i] == 1){
                lastCoordinate[1] = i;
            }else break;
        }
        return lastCoordinate;
    }

}
