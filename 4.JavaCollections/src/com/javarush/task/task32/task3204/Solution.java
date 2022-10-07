package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

/* 
Генератор паролей
*/

public class Solution {
    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        byte [] symbols = new byte[]{
                48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65,
                66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76,
                77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87,
                88, 89, 90, 97, 98, 99, 100, 101, 102, 103,
                104, 105, 106, 107, 108, 109, 110, 111, 112,
                113, 114, 115, 116, 117, 118, 119, 120, 121, 122};

//        String [] digits = new String[]{
//                "0","1","2","3","4","5","6","7","8","9"
//        };
//
//        String [] lowerCase = new String[]{
//                "q","w","e","r","t","y","u","i","o","p","a","s","d","f","g","h","j","k","l","z","x","c","v","b","n","m"
//        };
//        String [] upperCase = new String[]{
//                "Q","W","E","R","T","Y","U","I","O","P","A","S","D","F","G","H","J","K","L","Z","X","C","V","B","N","M"
//        };

        byte[] pass = new byte[8];
        String passWord = Arrays.toString(pass);
        while (!(passWord.matches(".*[a-z]+.*") &&
                passWord.matches(".*[A-Z]+.*") &&
               passWord.matches(".*[0-9]+.*"))) {

            for (int i = 0; i < 8; i++) {
                int random = (int) (Math.random() * symbols.length);
                byte key = symbols[random];
                pass[i] = key;
            }
            passWord = new String(pass);

        }
        try{
            baos.write(pass);
        }catch (Exception e ){
            e.printStackTrace();
        }
        return baos;
    }
}
