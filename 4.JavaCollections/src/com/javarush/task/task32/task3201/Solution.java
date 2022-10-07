package com.javarush.task.task32.task3201;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;

/* 
Запись в существующий файл
*/

public class Solution {
    public static void main(String... args) {
        try(RandomAccessFile raf = new RandomAccessFile(args[0], "rw")){
            if (Long.parseLong(args[1])> raf.length()){
                raf.seek(raf.length());
            }else raf.seek(Long.parseLong(args[1]));
            raf.write(args[2].getBytes());
        }catch (Exception e){
            System.out.println("WTF!?");
        }
    }
}
