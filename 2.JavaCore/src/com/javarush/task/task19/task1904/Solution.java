package com.javarush.task.task19.task1904;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) throws IOException {
        String fileName = "C:\\JavaTest\\test2.txt";
        PersonScanner personScanner = new PersonScannerAdapter(new Scanner(new File(fileName)));
//        System.out.println((new Scanner(new File(fileName))).nextLine());
        System.out.println(personScanner.read().toString());

    }

    public static class PersonScannerAdapter implements PersonScanner{
        private final Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException {
            String line = fileScanner.nextLine();
            String[] lineParse = line.split(" ");
            SimpleDateFormat formatter = new SimpleDateFormat("dd MM yyyy", Locale.ENGLISH);
            Date date = null;
            String birth = lineParse[3]+ " " +lineParse[4]+" " +lineParse[5];
            try{
                date = formatter.parse(birth);
            }catch (Exception e){
                e.printStackTrace();
            }
            return new Person(lineParse[1], lineParse[2], lineParse[0], date);
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}
