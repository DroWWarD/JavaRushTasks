package com.javarush.games.snake;
import com.javarush.engine.cell.Game;
import com.javarush.engine.cell.Color;
import com.javarush.engine.cell.GameScreen;
import com.javarush.engine.cell.Key;
import com.javarush.engine.cell.*;


public class SnakeGame extends Game {
    public static final int WIDTH = 15;
    public static final int HEIGHT = 15;
    private static final int GOAL  = 22;
    private Snake snake;
    private Apple apple;
    private int turnDelay;
    public int score;
    private boolean isGameStopped;

//----------------------------------------------------------------------------------
    @Override
    public void initialize() {
        setScreenSize(WIDTH,HEIGHT);
        createGame();

    }
    private void createGame(){
        isGameStopped = false;
        turnDelay = 300;
        score = 0;
        setScore(score);
        setTurnTimer(turnDelay);
        snake = new Snake(WIDTH/2,HEIGHT/2);
        createNewApple();
        drawScene();

    }
    private void drawScene(){
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                setCellValueEx(i,j,Color.DARKSEAGREEN,"");
            }
        }
        snake.draw(this);
        apple.draw(this);
    }

    @Override
    public void onTurn(int step) {
        snake.move(apple);
        if(!apple.isAlive) {
            createNewApple();
            score=score+5;
            setScore(score);
            turnDelay = turnDelay-10;
            setTurnTimer(turnDelay);
        }
        if (!snake.isAlive) gameOver();
        if (snake.getLength()>GOAL ) win();
        drawScene();
    }


    @Override
    public void onKeyPress(Key key) {
        if (key == Key.UP) snake.setDirection(Direction.UP);
        if (key == Key.DOWN) snake.setDirection(Direction.DOWN);
        if (key == Key.LEFT) snake.setDirection(Direction.LEFT);
        if (key == Key.RIGHT) snake.setDirection(Direction.RIGHT);
        if(key == Key.SPACE){
            if (isGameStopped) createGame();
        }
    }

    private void createNewApple(){
        do {
            int x = getRandomNumber(WIDTH);
            int y = getRandomNumber(HEIGHT);
            apple = new Apple(x,y);
        }while (snake.checkCollision(apple));


    }

    private void gameOver(){
        stopTurnTimer();
        isGameStopped = true;
        showMessageDialog(Color.BLACK, "GAME OVER", Color.RED,100);
    }

    private void win(){
        stopTurnTimer();
        isGameStopped = true;
        showMessageDialog(Color.BLACK, "YOU WIN", Color.GREEN,100);
    }


}

