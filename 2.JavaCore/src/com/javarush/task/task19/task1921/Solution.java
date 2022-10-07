package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws ParseException {
        ArrayList<String> list = new ArrayList<>();
        SimpleDateFormat formatter = new SimpleDateFormat("dd MM yyyy");
        try(BufferedReader bf = new BufferedReader(new FileReader(args[0]))){
            while (bf.ready()){
                list.add(bf.readLine());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        for (String string:list) {
            String name="";
            String birthDate ="";
            String[] parser = string.split(" ");
            for (int i = 0; i < parser.length; i++) {
                if (!isInteger(parser[i])){
                    name = name + parser[i] + " ";
                }
            }
            int day = Integer.parseInt(parser[parser.length-3]);
            int month = (Integer.parseInt(parser[parser.length-2]))-1;
            int year = Integer.parseInt(parser[parser.length-1]);
            Calendar birthDay = new GregorianCalendar(year, month, day);
            PEOPLE.add(new Person(name.trim(), birthDay.getTime()));
        }
        for (Person person:PEOPLE) {
            System.out.println(person.getName() + person.getBirthDate());
        }
    }

    public static boolean isInteger(String string){
        try {
            int i = Integer.parseInt(string);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
