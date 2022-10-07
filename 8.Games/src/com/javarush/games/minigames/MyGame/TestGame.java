package com.javarush.games.minigames.MyGame;
import com.javarush.engine.cell.Game;
import com.javarush.engine.cell.Color;
;

public class TestGame extends Game {
    @Override
    public void initialize() {
        setScreenSize(8,8);
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if((i+j)%2==0){
                    setCellColor(i,j, Color.WHITE);
                }else setCellColor(i,j, Color.BROWN);
            }
        }
    }

}
