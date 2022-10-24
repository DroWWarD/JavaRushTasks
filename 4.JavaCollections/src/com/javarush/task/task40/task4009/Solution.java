package com.javarush.task.task40.task4009;

import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/* 
Buon Compleanno!
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getWeekdayOfBirthday("30.05.1984", "2015"));
    }

    public static String getWeekdayOfBirthday(String birthday, String year) {
        Year y = Year.parse(year);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.M.y").withLocale(Locale.ITALIAN);
        LocalDate date = LocalDate.parse(birthday, formatter);
        LocalDate day = date.withYear(Integer.parseInt(year));
        return day.format(DateTimeFormatter.ofPattern("EEEE", Locale.ITALIAN));
    }
}
