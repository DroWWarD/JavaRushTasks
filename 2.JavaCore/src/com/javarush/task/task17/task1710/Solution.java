package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {

        if (args[0].equals("-c")){
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
            Date birthDate = format.parse(args[3]);
            if (args[2].equals("м")){
                allPeople.add(Person.createMale(args[1], birthDate));
                System.out.println((allPeople.size()-1));
            }else{
                allPeople.add(Person.createFemale(args[1], birthDate));
                System.out.println((allPeople.size()-1));
            }
        }

        if (args[0].equals("-r")){
            Person person = allPeople.get(Integer.parseInt(args[1]));
            String sex = person.getSex().equals(Sex.MALE)? "м": "ж";
            SimpleDateFormat simleFormat = new SimpleDateFormat("dd-MMM-yyy", Locale.ENGLISH);
            System.out.println(person.getName()+" " +sex+ " " + simleFormat.format(person.getBirthDate()));
        }

        if (args[0].equals("-u")){
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
            Date birthDate = format.parse(args[4]);
            if (args[3].equals("м")){
                allPeople.set(Integer.parseInt(args[1]) ,Person.createMale(args[2], birthDate));
            }else{
                allPeople.set(Integer.parseInt(args[1]) ,Person.createFemale(args[2], birthDate));
            }
        }

        if (args[0].equals("-d")){
            Person nullPerson = Person.createMale(null,null);
            nullPerson.setSex(null);
            allPeople.set(Integer.parseInt(args[1]), nullPerson);
        }
    }
}
