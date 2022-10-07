package com.javarush.task.task18.task1810;

import java.io.*;

/* 
DownloadException
*/

public class Solution {

    public static void main(String[] args) throws DownloadException, IOException {
        String fileName = "";
        while (true) {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

                fileName = reader.readLine();

            } catch (IOException e) {
                e.printStackTrace();
            }
            try (FileInputStream fileIn = new FileInputStream(fileName)) {
                if (fileIn.available() < 1000) {
                    throw new DownloadException();
                }
            }catch (IOException e){
                e.printStackTrace();
            }

        }
    }

    public static class DownloadException extends Exception {

    }
}
