package com.javarush.task.task15.task1527;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String url = reader.readLine();
        if (url.contains("?")) {

            if (url.contains("&") && !url.contains("=")) {
                int currentIndex = url.indexOf("&");
                String paramFirst = url.substring(url.indexOf("?") + 1, currentIndex);
                System.out.print(paramFirst + " ");
                if (currentIndex != url.lastIndexOf("&")) {
                    int nextIndex = 0;
                    String param;
                    while (currentIndex != url.lastIndexOf("&")) {
                        nextIndex = url.indexOf("&", currentIndex + 1);
                        param = url.substring(currentIndex + 1, nextIndex);
                        System.out.print(param + " ");
                        currentIndex = nextIndex;
                    }
                }
                System.out.print(url.substring(url.lastIndexOf("&") + 1));


            } else if (url.contains("=") && !url.contains("&")) {
                String param = url.substring(url.indexOf("?") + 1, url.indexOf("="));
                String paramValue = url.substring(url.indexOf("=") + 1);
                System.out.println(param);
                if (param.equals("obj")) {
                    if (isDigitDouble(paramValue)) {
                        System.out.print("\n");
                        alert(Double.parseDouble(paramValue));
                    } else {
                        System.out.print("\n");
                        alert(paramValue);
                    }
                }
            } else if (url.contains("&") && url.contains("=")) {
                int currentIndex = url.indexOf("?") + 1;
                String objParam = null;
                while (currentIndex < url.lastIndexOf("&")) {
                    if (url.substring(currentIndex).contains("=")) {
                        String param = url.substring(currentIndex, Math.min(url.indexOf("=", currentIndex), url.indexOf("&", currentIndex)));
                        System.out.print(param + " ");
                        if (url.indexOf("=", currentIndex) < url.indexOf("&", currentIndex)) {
                            String paramValue = url.substring(url.indexOf("=", currentIndex) + 1, url.indexOf("&", currentIndex));
                            if (param.equals("obj")) {
                                objParam = paramValue;
                            }
                        }
                        currentIndex = url.indexOf("&", currentIndex + 1)+1;
                    } else {
                        String param = url.substring(currentIndex, url.indexOf("&", currentIndex));
                        System.out.print(param + " ");
                        currentIndex = url.indexOf("&", currentIndex + 1)+1;
                    }
                }
                String last = url.substring(url.lastIndexOf("&"));
                if (last.contains("=")) {
                    String param = last.substring(last.indexOf("&") + 1, last.indexOf("="));
                    String paramValue = last.substring(last.lastIndexOf("=") + 1);
                    System.out.print(param + " ");
                    if (param.equals("obj")) {
                        objParam = paramValue;
                    }
                } else System.out.print(last.substring(last.indexOf("&") + 1) + " ");

                if (objParam!=null){
                    if (isDigitDouble(objParam)) {
                        System.out.print("\n");
                        alert(Double.parseDouble(objParam));
                    } else {
                        System.out.print("\n");
                        alert(objParam);
                    }
                }

            } else System.out.println(url.substring(url.indexOf("?") + 1));
        }
    }

    private static boolean isDigitDouble(String s) throws NumberFormatException {
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}
