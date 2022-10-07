package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat formatIn = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        SimpleDateFormat formatOut = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

        if (args[0].equals("-c")){
            synchronized (allPeople){
                for (int i = 1; i < args.length - 2; i = i + 3) {
                    if (args[i + 1].equals("м")) {
                        allPeople.add(Person.createMale(args[i], formatIn.parse(args[i + 2])));
                    } else allPeople.add(Person.createFemale(args[i], formatIn.parse(args[i + 2])));
                    System.out.println((allPeople.size() - 1));
                }
            }
        }

        if (args[0].equals("-u")){
            synchronized (allPeople){
                for (int i = 1; i < args.length - 3; i = i + 4) {
                    if (args[i + 2].equals("м")) {
                        allPeople.set(Integer.parseInt(args[i]), Person.createMale(args[i + 1], formatIn.parse(args[i + 3])));
                    }else allPeople.set(Integer.parseInt(args[i]), Person.createFemale(args[i + 1], formatIn.parse(args[i + 3])));
                }
            }
        }

        if (args[0].equals("-d")){
            synchronized (allPeople){
                Person nullPerson = Person.createFemale(null, null);
                nullPerson.setSex(null);
                for (int i = 1; i < args.length; i++) {
                    allPeople.set(Integer.parseInt(args[i]), nullPerson);
                }
            }
        }

        if (args[0].equals("-i")){
            synchronized (allPeople){
                for (int i = 1; i < args.length; i++) {
                    Person person = allPeople.get(Integer.parseInt(args[i]));
                    String sex = person.getSex().equals(Sex.MALE) ? "м" : "ж";
                    System.out.println(person.getName() + " " + sex + " " + formatOut.format(person.getBirthDate()));
                }
            }
        }
        switch (args[0]){

        }
    }
}
