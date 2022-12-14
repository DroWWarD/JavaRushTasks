package com.javarush.task.task35.task3702;

import com.javarush.task.task35.task3702.female.FemaleFactory;
import com.javarush.task.task35.task3702.male.MaleFactory;

public class FactoryProducer {
    public static enum HumanFactoryType{
        MALE,
        FEMALE
    }

    public static AbstractFactory getFactory(HumanFactoryType type){
        if (type.equals(HumanFactoryType.MALE)) return new MaleFactory();
        else if (type.equals(HumanFactoryType.FEMALE)) return new FemaleFactory();
        else return null;
    }

}
