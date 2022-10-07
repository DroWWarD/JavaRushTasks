package com.javarush.task.pro.task15.task1504;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

/* 
Перепутанные байты
*/

public class Solution {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in);
             var inputStream = Files.newInputStream(Paths.get(scanner.nextLine()));
             var outputStream = Files.newOutputStream(Paths.get(scanner.nextLine()))
        ) {

            int size = 2;
            byte[] buffer = new byte[size];
            while (inputStream.available() > 0) {
                int real = inputStream.read(buffer);
                if (real!=1) {
                byte temp = buffer[0];
                buffer[0] = buffer[1];
                buffer[1] = temp;
                }
                outputStream.write(buffer, 0, real);
            }
        } catch (Exception e) {
            System.out.println("Что то пошло не так: " + e);
        }
    }
}

