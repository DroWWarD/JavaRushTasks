package com.javarush.task.task31.task3101;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Map;
import java.util.TreeMap;

/* 
Проход по дереву файлов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        File resultFileAbsolutePath = new File(args[1]);
        String parent =  resultFileAbsolutePath.getParent();
        File allFilesContent = new File(parent +"/allFilesContent.txt");
        FileUtils.renameFile(resultFileAbsolutePath, allFilesContent);
        File startDir = new File (args[0]);
        ArrayList<String> list = new ArrayList<>();
        findAllFiles(startDir, list);
        try(FileWriter fw = new FileWriter(allFilesContent);){
            for (String str : list) {
                File temp = new File(str);
                if (temp.length() <= 50) {
                    BufferedReader br = new BufferedReader(new FileReader(temp));
                    while (br.ready()) {
                        fw.write(br.readLine());
                    }
                    fw.append('\n');
                    br.close();
                    fw.flush();
                }
            }
        }catch (Exception e ){
            e.printStackTrace();
        }

    }
    public static void findAllFiles(File startDir, ArrayList<String> list){
        for (File file:startDir.listFiles()) {
            if (file.isFile()){
                list.add(file.getAbsolutePath());
            }else if (file.isDirectory()){
                findAllFiles(file, list);
            }
        }
    }
}
