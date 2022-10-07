package com.javarush.games.minigames.mini05;

import com.javarush.engine.cell.Game;
import com.javarush.engine.cell.Color;

/* 
Цвета радуги
*/

public class RainbowGame extends Game {

    @Override
    public void initialize() {
        setScreenSize(10,7);
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 7; j++) {
                if (j == 0){
                    setCellColor(i,j, Color.RED);
                }else if (j == 1){
                    setCellColor(i,j, Color.ORANGE);
                }else if (j == 2){
                    setCellColor(i,j, Color.YELLOW);
                }else if (j == 3){
                    setCellColor(i,j, Color.GREEN);
                }else if (j == 4){
                    setCellColor(i,j, Color.BLUE);
                }else if (j == 5){
                    setCellColor(i,j, Color.INDIGO);
                }else if (j == 6){
                    setCellColor(i,j, Color.VIOLET);
                }

            }
        }
    }
}
