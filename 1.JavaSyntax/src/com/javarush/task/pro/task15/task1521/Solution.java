package com.javarush.task.pro.task15.task1521;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

/* 
Временное сохранение файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        try {
            Scanner scanner = new Scanner(System.in);

            String line = scanner.nextLine();
            URL url = new URL(line);
            InputStream inputStream = url.openStream();
            byte[] bytes = inputStream.readAllBytes();
            var temp = Files.createTempFile( null, null);
            Files.write(temp, bytes);


        }catch (Exception e){

        }
    }
}