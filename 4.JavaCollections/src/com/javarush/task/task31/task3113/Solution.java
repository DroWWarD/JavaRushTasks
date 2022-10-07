package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/* 
Что внутри папки?
*/

public class Solution{

    public static void main(String[] args) throws IOException {
        String dirName = "";
        MyFileVisitor fv = new MyFileVisitor();
        try(BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))){
            dirName= bf.readLine();
        }catch (Exception e){
            System.out.println("Wrong!");
        }
        Path directory = Paths.get(dirName);
        if (!Files.isDirectory(directory)){
            System.out.println(directory.toAbsolutePath().toString() + " - не папка");
        }else {

            Files.walkFileTree(directory, fv);
            System.out.println("Всего папок - " + fv.getDirectories());
            System.out.println("Всего файлов - " + fv.getFiles());
            System.out.println("Общий размер - " + fv.getTotalSize());

        }
    }
    public static class MyFileVisitor extends SimpleFileVisitor<Path>{
        int directories = -1;
        int files = 0;
        long totalSize = 0;

        public int getDirectories() {
            return directories;
        }

        public int getFiles() {
            return files;
        }

        public long getTotalSize() {
            return totalSize;
        }

        @Override
        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
            if (Files.isDirectory(dir)) directories++;
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            if (Files.isRegularFile(file)) {
                files++;
                totalSize += Files.readAllBytes(file).length;
            }
            return FileVisitResult.CONTINUE;
        }
    }
}
