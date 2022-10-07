package com.javarush.task.task16.task1630;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.spec.ECField;

/* 
Последовательный вывод файлов
*/

public class Solution {
    public static String firstFileName;
    public static String secondFileName;

    static {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            firstFileName= reader.readLine();
            secondFileName = reader.readLine();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        f.join();
        System.out.println(f.getFileContent());
    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }

    public static class ReadFileThread extends Thread implements ReadFileInterface{
        private String fullFileName;
        private String fileContent = "";

        @Override
        public synchronized void start() {
            this.run();
        }

        @Override
        public void setFileName(String fullFileName) {
            this.fullFileName = fullFileName;
        }

        @Override
        public void run() {
            try(BufferedReader fileReader = new BufferedReader(new FileReader(fullFileName))){
                while (fileReader.ready()){
                    fileContent = fileContent + " " + fileReader.readLine();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        @Override
        public String getFileContent() {

            return fileContent;
        }
    }
}
