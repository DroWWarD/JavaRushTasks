package com.javarush.task.task31.task3112;

import java.io.FileInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/* 
Загрузчик файлов
*/

public class Solution {

    public static void main(String[] args) throws IOException {
        Path passwords = downloadFile("https://javarush.ru/testdata/secretPasswords.txt", Paths.get("C:/JavaTest"));

        for (String line : Files.readAllLines(passwords)) {
            System.out.println(line);
        }
    }

    public static Path downloadFile(String urlString, Path downloadDirectory) throws IOException {
        URL url = new URL(urlString);
        InputStream is = url.openStream();
        Path temp = Files.createTempFile(null, null);

        Files.copy(is, temp, StandardCopyOption.REPLACE_EXISTING);

        String[] parse = urlString.split("/");
        String fileName = parse[parse.length-1];
        Path file = Paths.get(fileName);
        Path absolutePath = downloadDirectory.resolve(file);

        Files.move(temp, absolutePath);
        return absolutePath;
    }
}
