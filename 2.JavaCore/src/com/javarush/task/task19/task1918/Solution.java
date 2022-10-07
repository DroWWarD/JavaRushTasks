package com.javarush.task.task19.task1918;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

/* 
Знакомство с тегами
*/

public class Solution {
    public static void main(String[] args) {

        String fileName ="";
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            fileName= reader.readLine();
        }catch (Exception e){
            e.printStackTrace();
        }
        StringBuilder sb = new StringBuilder();
        try (BufferedReader fileReader = new BufferedReader(new FileReader(fileName))){
            while (fileReader.ready()){
                sb.append(fileReader.readLine());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        Document document = Jsoup.parse(sb.toString(), "", Parser.xmlParser());
        Elements tegs = document.select(args[0]);
        for (Element element: tegs) {
            System.out.println(element);
        }

    }
}
