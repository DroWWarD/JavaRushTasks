package com.javarush.task.task18.task1806;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/* 
Исправить ошибки
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream("C:\\JavaTest\\test.txt");
        // Создаем поток-записи-байт-в-файл
        FileOutputStream outputStream = new FileOutputStream("C:\\JavaTest\\test1.txt");

        if (inputStream.available() > 0) {
            //читаем весь файл одним куском
            byte[] buffer = new byte[inputStream.available()];
            inputStream.read(buffer);
            outputStream.write(buffer);
        }

        inputStream.close();
        outputStream.close();
    }
}
