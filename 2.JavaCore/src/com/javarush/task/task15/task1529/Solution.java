package com.javarush.task.task15.task1529;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Осваивание статического блока
*/

public class Solution {
    public static void main(String[] args) {

    }

    static {
        reset();

    }

    public static CanFly result;

    public static void reset() {
        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))){
            String console = bufferedReader.readLine();
            if (console.equals("helicopter")) result = new Helicopter();
            if (console.equals("plane")){
                int passengers = Integer.parseInt(bufferedReader.readLine());
                result = new Plane(passengers);
            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
