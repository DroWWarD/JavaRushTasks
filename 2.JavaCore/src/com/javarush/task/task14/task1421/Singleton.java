package com.javarush.task.task14.task1421;

public class Singleton {
    private static Singleton instance = null;

    private  Singleton() {
        instance = this;
    }

    public static Singleton getInstance(){
        if (instance!=null) return instance;
        else return new Singleton();
    }
}
