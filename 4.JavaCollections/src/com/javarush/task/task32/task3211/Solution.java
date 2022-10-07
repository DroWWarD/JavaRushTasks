package com.javarush.task.task32.task3211;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.security.MessageDigest;

/* 
Целостность информации
*/

public class Solution {
    public static void main(String... args) throws Exception {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(new String("test string"));
        oos.flush();
        System.out.println(compareMD5(bos, "5a47d12a2e3f9fecf2d9ba1fd98152eb")); //true

    }

    public static boolean compareMD5(ByteArrayOutputStream byteArrayOutputStream, String md5) throws Exception {

        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        byte[] digest = messageDigest.digest(byteArrayOutputStream.toByteArray());
        String myMD5 = "";
        for (int i = 0; i < digest.length; i++) {
            String symbol = Integer.toHexString(0xFF & digest[i]);
            if (symbol.length()<2) symbol = "0"+symbol;
            myMD5 = myMD5+symbol;
        }

        System.out.println(myMD5);
        return md5.equals(myMD5);
    }
}