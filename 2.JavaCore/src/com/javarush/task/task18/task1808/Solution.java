package com.javarush.task.task18.task1808;

import javax.imageio.stream.FileImageOutputStream;
import java.io.*;

/* 
Разделение файла
*/

public class Solution {
    public static void main(String[] args) {
        String file1 = "";
        String file2 = "";
        String file3 = "";

        try(BufferedReader reader=new BufferedReader(new InputStreamReader(System.in))){
            file1= reader.readLine();
            file2= reader.readLine();
            file3= reader.readLine();
        }catch (IOException e){
            e.printStackTrace();
        }

        try(FileInputStream fileIn1 = new FileInputStream(file1);
            FileOutputStream fileOut2 = new FileOutputStream(file2);
            FileOutputStream fileOut3 = new FileOutputStream(file3)){
            byte[] buff1 = new byte[fileIn1.available()];
            byte[] buff3 = new byte[buff1.length/2];
            byte[] buff2 = new byte[buff1.length - buff3.length];
            fileIn1.read(buff2);
            fileOut2.write(buff2);
            fileIn1.read(buff3);
            fileOut3.write(buff3);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
