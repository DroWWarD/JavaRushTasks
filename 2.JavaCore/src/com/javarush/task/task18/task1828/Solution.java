package com.javarush.task.task18.task1828;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Прайсы 2
*/

public class Solution {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        String fileName = "";
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            fileName = reader.readLine();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            char[] id = new char[8];
            Arrays.fill(id, ' ');
            char[] name = new char[30];
            Arrays.fill(name, ' ');
            char[] price = new char[8];
            Arrays.fill(price, ' ');
            char[] quantity = new char[4];
            Arrays.fill(quantity, ' ');


            if (args[0].equals("-u")) {

                int idFor = 0;
                int idToDelete = -1;
                try(BufferedReader buffReader = new BufferedReader(new FileReader(fileName)))
                {
                    while (buffReader.ready()) {
                        list.add(buffReader.readLine());
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
                for (String string : list) {
                    String idCurrentString = string.substring(0, 8);
                    int idCurrent = Integer.parseInt(idCurrentString.replaceAll("\\D", ""));
                    int idNeedToFind = Integer.parseInt(args[1]);
                    if (idCurrent == idNeedToFind) {
                        char[] idNew = Integer.toString(idCurrent).toCharArray();
                        for (int i = 0; i < idNew.length; i++) {
                            id[i] = idNew[i];
                        }
                        char[] nameNew = args[2].toCharArray();
                        for (int i = 0; i < nameNew.length; i++) {
                            name[i] = nameNew[i];
                        }
                        char[] priceNew = args[3].toCharArray();
                        for (int i = 0; i < priceNew.length; i++) {
                            price[i] = priceNew[i];
                        }
                        char[] quantityNew = args[4].toCharArray();
                        for (int i = 0; i < quantityNew.length; i++) {
                            quantity[i] = quantityNew[i];
                        }
                        idToDelete = idFor;
                    }
                    idFor++;
                }
                if (idToDelete >= 0) {

                    String updatedString = new String(id)+new String(name)+ new String(price)+ new String(quantity);
                    list.set(idToDelete, updatedString);
                    try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName))) {
                        bufferedWriter.write("");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    try (FileWriter fileWriter1 = new FileWriter(fileName, true)) {
                        for (String str : list) {
                            fileWriter1.write(str);
                            fileWriter1.write("\n");
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

            if (args[0].equals("-d")){

                int idFor = 0;
                int idToDelete = -1;
                try(BufferedReader buffReader = new BufferedReader(new FileReader(fileName)))
                {
                    while (buffReader.ready()) {
                        list.add(buffReader.readLine());
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
                for (String string : list) {
                    String idCurrentString = string.substring(0, 8);
                    int idCurrent = Integer.parseInt(idCurrentString.replaceAll("\\D", ""));
                    int idNeedToFind = Integer.parseInt(args[1]);
                    if (idCurrent == idNeedToFind){
                        idToDelete = idFor;
                    }
                    idFor++;
                }
                if (idToDelete >= 0) {
                    list.remove(idToDelete);
                    try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName))) {
                        bufferedWriter.write("");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    try (FileWriter fileWriter1 = new FileWriter(fileName, true)) {
                        for (String str : list) {
                            fileWriter1.write(str);
                            fileWriter1.write("\n");
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
