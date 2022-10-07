package com.javarush.task.task18.task1827;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Прайсы
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        String fileName = "";
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            fileName = reader.readLine();
        } catch (Exception e) {
            e.printStackTrace();
        }


        try{
            if (args[0].equals("-c")) {
                String string = "";

                char[] id = new char[8];
                Arrays.fill(id, ' ');
                char[] name = new char[30];
                Arrays.fill(name, ' ');
                char[] price = new char[8];
                Arrays.fill(price, ' ');
                char[] quantity = new char[4];
                Arrays.fill(quantity, ' ');

                int maxId = 0;
                int newId = 0;
                try (FileReader fileReader = new FileReader(fileName);
                     BufferedReader bufferedReader = new BufferedReader(fileReader)) {
                    while (bufferedReader.ready()) {
                        string = bufferedReader.readLine();
                        String idCurrentString = string.substring(0, 8);
                        int idCurrent = Integer.parseInt(idCurrentString.replaceAll("\\D", ""));
                        if (idCurrent > maxId) {
                            maxId = idCurrent;
                        }
                    }
                    newId = (maxId + 1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                char[] idNew = Integer.toString(newId).toCharArray();
                for (int i = 0; i < idNew.length; i++) {
                    id[i] = idNew[i];
                }
                char[] nameNew = args[1].toCharArray();
                for (int i = 0; i < nameNew.length; i++) {
                    name[i] = nameNew[i];
                }
                char[] priceNew = args[2].toCharArray();
                for (int i = 0; i < priceNew.length; i++) {
                    price[i] = priceNew[i];
                }
                char[] qualityNew = args[3].toCharArray();
                for (int i = 0; i < qualityNew.length; i++) {
                    quantity[i] = qualityNew[i];
                }

                try (FileWriter fileWriter = new FileWriter(fileName, true)) {
                    fileWriter.write("\n");
                    fileWriter.write(id);
                    fileWriter.write(name);
                    fileWriter.write(price);
                    fileWriter.write(quantity);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }catch (Exception e){
            System.out.println("Произведен запуск программы без параметров. Список товаров не изменен.");
        }
    }
}
