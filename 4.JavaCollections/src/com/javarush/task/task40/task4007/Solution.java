package com.javarush.task.task40.task4007;

import javafx.util.converter.LocalDateTimeStringConverter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

/* 
Работа с датами
*/

public class Solution {
    public static void main(String[] args) throws ParseException {
        printDate("21.4.2014 15:56:45");
        System.out.println();
        printDate("21.4.2014");
        System.out.println();
        printDate("17:33:40");
    }

    public static void printDate(String date) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        if (date.contains(".") && date.contains(":")) {
            String[] parser = date.split("[. :]");
            int[] parserInt = new int[parser.length];
            for (int i = 0; i < parser.length; i++) {
                parserInt[i] = Integer.parseInt(parser[i]);
            }
            calendar.set(parserInt[2], parserInt[1]-1, parserInt[0], parserInt[3], parserInt[4], parserInt[5]);
            System.out.println("День: " + calendar.get(Calendar.DATE));
            System.out.println("День недели: " + (calendar.get(Calendar.DAY_OF_WEEK) == 1 ? "7":calendar.get(Calendar.DAY_OF_WEEK)-1));
            System.out.println("День месяца: " + calendar.get(Calendar.DAY_OF_MONTH));
            System.out.println("День года: " + calendar.get(Calendar.DAY_OF_YEAR));
            System.out.println("Неделя месяца: " + calendar.get(Calendar.WEEK_OF_MONTH));
            System.out.println("Неделя года: " + calendar.get(Calendar.WEEK_OF_YEAR));
            System.out.println("Месяц: " + (calendar.get(Calendar.MONTH)+1));
            System.out.println("Год: " + calendar.get(Calendar.YEAR));
            if (calendar.get(Calendar.AM_PM) == Calendar.PM) {
                System.out.println("AM или PM: PM");
            }
            else {
                System.out.println("AM или PM: AM");
            }
            System.out.println("Часы: " + calendar.get(Calendar.HOUR));
            System.out.println("Часы дня: " + calendar.get(Calendar.HOUR_OF_DAY));
            System.out.println("Минуты: " + calendar.get(Calendar.MINUTE));
            System.out.println("Секунды: " + calendar.get(Calendar.SECOND));
        }else if (date.contains(".")){
            String[] parser = date.split("[.]");
            int[] parserInt = new int[parser.length];
            for (int i = 0; i < parser.length; i++) {
                parserInt[i] = Integer.parseInt(parser[i]);
            }
            calendar.set(parserInt[2], parserInt[1]-1, parserInt[0]);
            System.out.println("День: " + calendar.get(Calendar.DATE));
            System.out.println("День недели: " + (calendar.get(Calendar.DAY_OF_WEEK) == 1 ? "7":calendar.get(Calendar.DAY_OF_WEEK)-1));
            System.out.println("День месяца: " + calendar.get(Calendar.DAY_OF_MONTH));
            System.out.println("День года: " + calendar.get(Calendar.DAY_OF_YEAR));
            System.out.println("Неделя месяца: " + calendar.get(Calendar.WEEK_OF_MONTH));
            System.out.println("Неделя года: " + calendar.get(Calendar.WEEK_OF_YEAR));
            System.out.println("Месяц: " + (calendar.get(Calendar.MONTH)+1));
            System.out.println("Год: " + calendar.get(Calendar.YEAR));
        }else if (date.contains(":")){
            String[] parser = date.split("[:]");
            int[] parserInt = new int[parser.length];
            for (int i = 0; i < parser.length; i++) {
                parserInt[i] = Integer.parseInt(parser[i]);
            }
            SimpleDateFormat format = new SimpleDateFormat("H:m:s");
            calendar.setTime(format.parse(date));
            if (calendar.get(Calendar.AM_PM) == Calendar.PM) {
                System.out.println("AM или PM: PM");
            }
            else {
                System.out.println("AM или PM: AM");
            }
            System.out.println("Часы: " + calendar.get(Calendar.HOUR));
            System.out.println("Часы дня: " + calendar.get(Calendar.HOUR_OF_DAY));
            System.out.println("Минуты: " + calendar.get(Calendar.MINUTE));
            System.out.println("Секунды: " + calendar.get(Calendar.SECOND));

        }
    }
}
