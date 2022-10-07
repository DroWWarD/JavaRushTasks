package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();
    public static ArrayList<String> list1 = new ArrayList<>();
    public static ArrayList<String> list2 = new ArrayList<>();

    public static void main(String[] args) {

        String file1="";
        String file2="";

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            file1 = reader.readLine();
            file2 = reader.readLine();
        }catch (Exception e){
            e.printStackTrace();
        }

        try(BufferedReader fileReader = new BufferedReader(new FileReader(file1))){
            while (fileReader.ready()){
                list1.add(fileReader.readLine());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        try(BufferedReader fileReader = new BufferedReader(new FileReader(file2))){
            while (fileReader.ready()){
                list2.add(fileReader.readLine());
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        while (!list1.isEmpty()&& !list2.isEmpty()){
            if (list1.get(0).equals(list2.get(0))){
                lines.add(new LineItem(Type.SAME, list1.get(0)));
                list1.remove(0);
                list2.remove(0);
            }else if (list1.get(0).equals(list2.get(1))){
                lines.add(new LineItem(Type.ADDED, list2.get(0)));
                list2.remove(0);
            }else if (list1.get(1).equals(list2.get(0))){
                lines.add(new LineItem(Type.REMOVED, list1.get(0)));
                list1.remove(0);
            }
        }
        if (list1.isEmpty()&& !list2.isEmpty()){
            lines.add(new LineItem(Type.ADDED, list2.get(0)));
        }
        if (!list1.isEmpty()&& list2.isEmpty()){
            lines.add(new LineItem(Type.REMOVED, list1.get(0)));
        }




//        for (int i = 0, j=0; i< list1.size()&&j< list2.size(); i++, j++) {
//            if (list1.get(i).equals(list2.get(j))){
//                lines.add(new LineItem(Type.SAME, list1.get(i)));
//            }else if (j == list2.size()-1){
//                break;
//            }else if (list1.get(i).equals(list2.get(j+1))){
//                lines.add(new LineItem(Type.ADDED, list2.get(j)));
//                i--;
//            }else if (i== list1.size()-1){
//                break;
//            }else if (list1.get(i+1).equals(list2.get(j))){
//                lines.add(new LineItem(Type.REMOVED, list1.get(i)));
//                j--;
//            }
//        }
//         if (list1.size() > list2.size()) {
//                lines.add(new LineItem(Type.REMOVED, list1.get(list1.size()-1)));
//        }else {
//                lines.add(new LineItem(Type.ADDED, list2.get(lines.size()-1)));
//        }
//



//        int i =0;
//        for (int j =0; j< list1.size();j++) {
//            if (i< list2.size()){
//                if (Integer.parseInt(list1.get(j).split("трока")[1]) == Integer.parseInt(list2.get(i).split("трока")[1])) {
//                    lines.add(new LineItem(Type.SAME, list1.get(j)));
//                    i++;
//                } else if (Integer.parseInt(list1.get(j).split("трока")[1]) < Integer.parseInt(list2.get(i).split("трока")[1])) {
//                    lines.add(new LineItem(Type.REMOVED, list1.get(j)));
//                } else {
//                    lines.add(new LineItem(Type.ADDED, list2.get(i)));
//                    i++;
//                    j--;
//                }
//            } else lines.add(new LineItem(Type.REMOVED, list1.get(j)));
//        }
//        if (list2.size()> list1.size()){
//            lines.add(new LineItem(Type.ADDED, list2.get(i)));
//        }
        for (LineItem line: lines) {
            System.out.println(line.type+ " " +line.line);
        }
    }


    public enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
