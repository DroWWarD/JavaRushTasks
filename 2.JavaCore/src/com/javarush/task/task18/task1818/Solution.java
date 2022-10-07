package com.javarush.task.task18.task1818;

import java.io.*;

/* 
Два в одном
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String file1;
        String file2;
        String file3;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            file1 = bufferedReader.readLine();
            file2 = bufferedReader.readLine();
            file3 = bufferedReader.readLine();
        bufferedReader.close();

        BufferedWriter bufferedFile1 = new BufferedWriter(new FileWriter(file1));
        BufferedReader bufferedFile2= new BufferedReader(new FileReader(file2));
        BufferedReader bufferedFile3= new BufferedReader(new FileReader(file3));
        while (bufferedFile2.ready()){
            bufferedFile1.write(bufferedFile2.readLine());
        }
        while (bufferedFile3.ready()){
            bufferedFile1.write(bufferedFile3.readLine());
        }
        bufferedFile1.close();
        bufferedFile2.close();
        bufferedFile3.close();

    }
}
