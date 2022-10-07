package com.javarush.task.task32.task3202;

import java.io.*;

/* 
Читаем из потока
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        StringWriter writer = getAllDataFromInputStream(new FileInputStream("C:\\JavaTest\\test1.txt"));
        System.out.println(writer.toString());
    }

    public static StringWriter getAllDataFromInputStream(InputStream is) throws IOException {
        StringWriter sw = new StringWriter();
        try(BufferedReader br = new BufferedReader(new InputStreamReader(is))){
            String line;
            while ((line = br.readLine()) != null){
                sw.write(line);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return sw;
    }
}
