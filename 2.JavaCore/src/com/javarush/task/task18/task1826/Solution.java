package com.javarush.task.task18.task1826;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/* 
Шифровка
*/

public class Solution {
    public static void main(String[] args) {

        try (FileInputStream fileIn = new FileInputStream(args[1]);
             FileOutputStream fileOut = new FileOutputStream(args[2])) {
            byte[] bytes = new byte[fileIn.available()];
            if (args[0].equals("-e")){
                for (int i = 0; i < bytes.length; i++) {
                    bytes[i] = (byte) (255 - fileIn.read());
                }
            }
            if (args[0].equals("-d")){
                for (int i = 0; i < bytes.length; i++) {
                    bytes[i] = (byte) (255 - fileIn.read());
                }
            }
            fileOut.write(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}


