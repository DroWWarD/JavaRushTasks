package com.javarush.task.task31.task3106;

import java.io.*;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

/* 
Разархивируем файл
*/

public class Solution {
    public static void main(String[] args) {
        String resultFile = args[0];
        TreeSet<String> treeSet = new TreeSet<>();
        List<FileInputStream> inputStreams = new ArrayList<>();
        try{
            for (int i = 1; i < args.length; i++) {
                treeSet.add(args[i]);
            }
            for (String name:treeSet) {
                inputStreams.add(new FileInputStream(name));
            }

            try(ZipInputStream zipIn = new ZipInputStream(new SequenceInputStream(Collections.enumeration(inputStreams)))){
                while (true) {
                    ZipEntry entry = zipIn.getNextEntry();
                    if (entry == null) break;
                    try (OutputStream os = new BufferedOutputStream(new FileOutputStream(resultFile))){
                        int buffSize = 1024;
                        byte[] buff  = new byte[buffSize];
                        for (int readBytes; (readBytes = zipIn.read(buff, 0, buffSize)) > -1; ) {
                            os.write(buff, 0, readBytes);

                        }
                        os.flush();
                    }
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }


    }
}
