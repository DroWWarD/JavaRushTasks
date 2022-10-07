package com.javarush.task.task36.task3605;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeSet;

/* 
Использование TreeSet
*/

public class Solution {
    public static void main(String[] args) throws IOException {
//Создаем лист Интеджеров, кладем в него чарики, читаемые файл ридером
        ArrayList<Integer> list = new ArrayList<>();
// Трай уиз ресоурсез, зекрывать потоки не потредуется
        try(FileReader fileReader = new FileReader(args[0])){
            while (fileReader.ready()){
                list.add(fileReader.read());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        TreeSet<String> treeSet = new TreeSet<>();
        for (int i = 0; i < list.size(); i++) {
//Если Интеджеры с листе соответствуют a-z или A-Z по таблице ASCII - запихиваем их в трисет, приводя по пути к ЛоуерКейз
            if ((list.get(i) >= 65 && list.get(i) <= 90) || (list.get(i) >= 97 && list.get(i) <= 122)){
                treeSet.add(Character.toString( (char) (int) list.get(i)).toLowerCase());
            }
        }
        int countMax = 0;
//countMax - счетчик для вывода 5 элемнтов трисета
        for (String str: treeSet) {
            if (countMax < 5){
                System.out.print(str);
                countMax++;
            }else break;
        }
    }
}
