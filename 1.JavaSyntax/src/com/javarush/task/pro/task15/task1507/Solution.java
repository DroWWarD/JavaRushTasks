package com.javarush.task.pro.task15.task1507;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

/* 
Пропускаем не всех
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        try (Scanner scanner = new Scanner(System.in)) {
            List<String> lines = Files.readAllLines(Path.of(scanner.nextLine()));
            int i = 0;
            for (String line : lines) {
                if (i % 2 == 0) {
                    System.out.println(line);
                }
                i++;
            }
        } catch (Exception e) {
            System.out.println("Нихера не понятно, почему теорию дают одну, а задачки на закрепление материала используют вообще другие методы )");
        }
    }
}

