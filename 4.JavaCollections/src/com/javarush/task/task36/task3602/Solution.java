package com.javarush.task.task36.task3602;

import java.lang.reflect.Modifier;
import java.util.Collections;
import java.util.List;

/* 
Найти класс по описанию Ӏ Java Collections: 6 уровень, 6 лекция
*/

public class Solution {
    public static void main(String[] args) {

        System.out.println(getExpectedClass());
    }

    public static Class getExpectedClass() {
        Class[] classes = Collections.class.getDeclaredClasses();
        for (int i = 0; i < classes.length; i++) {
            if (List.class.isAssignableFrom(classes[i]) && isModifierSet(classes[i].getModifiers(), Modifier.PRIVATE)
                    && isModifierSet(classes[i].getModifiers(), Modifier.STATIC)){
                if (classes[i].getSimpleName().equals("EmptyList")) return classes[i];
            }
        }
        return null;
    }

    public static boolean isModifierSet(int allModifiers, int specificModifier) {
        return (allModifiers & specificModifier) > 0;
    }

}
