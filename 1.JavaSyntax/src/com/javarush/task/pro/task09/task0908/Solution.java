package com.javarush.task.pro.task09.task0908;

import java.util.regex.Pattern;

/* 
Двоично-шестнадцатеричный конвертер
*/

public class Solution {

    public static final char[] HEX = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    public static final String[] BIN = {"0000", "0001", "0010", "0011", "0100", "0101", "0110", "0111", "1000", "1001", "1010", "1011", "1100", "1101", "1110", "1111"};

    public static void main(String[] args) {
        String binaryNumber = "100111010000";
        System.out.println("Двоичное число " + binaryNumber + " равно шестнадцатеричному числу " + toHex(binaryNumber));
        String hexNumber = "9d0";
        System.out.println("Шестнадцатеричное число " + hexNumber + " равно двоичному числу " + toBinary(hexNumber));
    }

    public static String toHex(String binaryNumber) {
        if (binaryNumber == "" || binaryNumber == null) return "";
// Проверка на наличие недопустимых символов
        for (int i = 0; i < binaryNumber.length(); i++) {
            if (binaryNumber.charAt(i) != '1' && binaryNumber.charAt(i) != '0') return "";
        }
//Проверка на кратность длины строки четырем. В случае необходимости - добавление нулей в начало строки
        if (binaryNumber.length() % 4 != 0) {
            int nulls = (4 - binaryNumber.length() % 4);
            char n = '0';
            for (int j = 0; j < nulls; j++) {
                binaryNumber = n + binaryNumber;
            }
        }
// Берем по 4 символа строки, формируем из них строку темп, сравниваем ее со строками массива бинарных представлений
//и соответствующий символ из массива шестнадцатеричного представления добаляем к строке результата
        String hexDigit = "";
        for (int i = 0; i < binaryNumber.length(); i = i + 4) {
            String temp = "";
            temp = temp + binaryNumber.charAt(i) + binaryNumber.charAt(i + 1) + binaryNumber.charAt(i + 2) + binaryNumber.charAt(i + 3);
            for (int j = 0; j < BIN.length; j++) {
                if (BIN[j].equals(temp)) {
                    hexDigit = hexDigit + HEX[j];
                }
            }
        }
        return hexDigit;
    }

    public static String toBinary(String hexNumber) {
        if (hexNumber == "" || hexNumber == null) return "";
// Проверка на наличие недопустимых символов. Посимвольно строку сравниваем с элементами массива шестнадцатеричного представления
//если символ в массиве не обнаружен - флаг останется фалз и метод вернет пустую строку
        for (int i = 0; i < hexNumber.length(); i++) {
            boolean flag = false;
            for (int j = 0; j< HEX.length; j++){
                if (hexNumber.charAt(i) == HEX[j]) flag = true;
            }
            if (flag == false) return "";

        }
// Сравниваем элементы строки с элементами массива шестнадцатеричного представления. При обнаруженнии добавляем
//к строке результата соответствующую строку из массива бинарного представления
        String digDigit = "";
        for (int i = 0; i < hexNumber.length(); i++) {
            for (int j = 0; j < HEX.length; j++) {
                if (HEX[j] == hexNumber.charAt(i)) {
                    digDigit = digDigit + BIN[j];
                }
            }
        }
        return digDigit;
    }
}
