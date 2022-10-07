package com.javarush.task.pro.task15.task1519;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

/* 
Поверхностное копирование
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        try {
            Path sourceDirectory = Path.of(scanner.nextLine());
            Path targetDirectory = Path.of(scanner.nextLine());
            if (Files.isDirectory(sourceDirectory) && Files.isDirectory(targetDirectory)) {
                try (DirectoryStream<Path> files = Files.newDirectoryStream(sourceDirectory)) {
                    for (Path item : files) {
                        if (Files.isRegularFile(item)) {
                            Files.copy(item, targetDirectory.resolve(item.getFileName()));
                        }
                    }
                } catch (Exception e) {
                }
            }
        } catch (Exception c) {

        }
    }
}

