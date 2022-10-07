package com.javarush.task.pro.task17.task1703;

import java.util.ArrayList;

/* 
Космическая одиссея ч.1
*/

public class Solution {
    public static ArrayList<Astronaut> astronauts = new ArrayList<>();

    public static void main(String[] args) {
        createCrew();
        printCrewInfo();
    }

    public static void createCrew(){
        Astronaut astronautJimm = new Human();
        astronauts.add(astronautJimm);
        Astronaut astronautBob = new Human();
        astronauts.add(astronautBob);
        Astronaut astronautDog = new Dog();
        astronauts.add(astronautDog);
        Astronaut astronautCat = new Cat();
        astronauts.add(astronautCat);

    }

    public static void printCrewInfo() {
        System.out.println("На борт погружены члены экипажа: ");
        for (Astronaut astronaut : astronauts) {
            System.out.println(astronaut.getInfo());
        }
    }
}
