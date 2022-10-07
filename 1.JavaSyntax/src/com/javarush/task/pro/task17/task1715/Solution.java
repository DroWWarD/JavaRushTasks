package com.javarush.task.pro.task17.task1715;

import java.util.ArrayList;
import java.util.List;

/* 
Вилларибо и Виллабаджо.
*/

public class Solution {
    static List<MusicalInstrument> orchestra = new ArrayList<>();

    public static void main(String[] args) {
        createKeyboardOrchestra();
        createStringedOrchestra();
        playOrchestra();
    }

    public static void createKeyboardOrchestra() {
        Organ organ = new Organ();
        orchestra.add((MusicalInstrument) organ);
        Piano piano1 = new Piano();
        Piano piano2 = new Piano();
        Piano piano3 = new Piano();
        orchestra.add((MusicalInstrument) piano1);
        orchestra.add((MusicalInstrument) piano2);
        orchestra.add((MusicalInstrument) piano3);
    }

    public static void createStringedOrchestra() {
        Violin violin1 = new Violin();
        Violin violin2 = new Violin();
        orchestra.add((MusicalInstrument) violin1);
        orchestra.add((MusicalInstrument) violin2);
        Guitar guitar = new Guitar();
        orchestra.add((MusicalInstrument) guitar);
    }

    public static void playOrchestra() {
        for(MusicalInstrument musicalInstrument:orchestra){
            musicalInstrument.play();
        }
    }
}
