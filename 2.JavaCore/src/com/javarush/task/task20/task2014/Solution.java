package com.javarush.task.task20.task2014;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution
*/

public class Solution implements Serializable{
    public static void main(String[] args) {
        try{
            System.out.println(new Solution(4));
            FileOutputStream fOut = new FileOutputStream("C:\\JavaTest\\test1.txt");
            ObjectOutputStream oOut = new ObjectOutputStream(fOut);
            Solution savedObject = new Solution(22);
            oOut.writeObject(savedObject);
            oOut.flush();
            fOut.close();

            FileInputStream fIn = new FileInputStream("C:\\JavaTest\\test1.txt");
            ObjectInputStream oIn = new ObjectInputStream(fIn);
            Solution someMore = new Solution(12);
            Solution loadedObject =(Solution) oIn.readObject();
            System.out.println(savedObject.string.equals(loadedObject.string));
            fIn.close();

        }catch (Exception e){
            System.out.println("Что то пошло не так...");
        }

    }

    private final transient String pattern = "dd MMMM yyyy, EEEE";
    private transient Date currentDate;
    private transient int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and the current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }
}
