package com.javarush.task.task32.task3210;

import java.io.IOException;
import java.io.RandomAccessFile;

/* 
Используем RandomAccessFile
*/

public class Solution {
    public static void main(String... args) {
        try(RandomAccessFile raf = new RandomAccessFile(args[0], "rw")){
            Long position = Long.parseLong(args[1]);
            String text = args[2];
            raf.seek(position);
            byte[] b = new byte[args[2].getBytes().length];
            raf.read(b, 0, b.length);
            raf.seek(raf.length());
            if(new String(b).equals(text)){
                raf.write(("true").getBytes());
            }else raf.write(("false").getBytes());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
