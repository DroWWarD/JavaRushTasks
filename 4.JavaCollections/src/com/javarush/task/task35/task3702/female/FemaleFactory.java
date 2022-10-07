package com.javarush.task.task35.task3702.female;

import com.javarush.task.task35.task3702.AbstractFactory;
import com.javarush.task.task35.task3702.Human;


public class FemaleFactory implements AbstractFactory {

    public Human getPerson(int age){
        if (age <= 12){
            return new KidGirl();
        }else if (age <= 19){
            return new TeenGirl();
        }
        else return new Woman();
    }

}


