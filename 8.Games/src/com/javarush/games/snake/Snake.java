package com.javarush.games.snake;

import com.javarush.engine.cell.*;

import java.util.ArrayList;
import java.util.List;

public class Snake {

    private static final String HEAD_SIGN = "\uD83D\uDC7E";
    private static final String BODY_SIGN = "\u26AB";
    private List<GameObject> snakeParts = new ArrayList<>();
    public boolean isAlive = true;
    private Direction direction = Direction.LEFT;

    //-----------------------------------------------------------------------------------
    public Snake(int x, int y) {
        snakeParts.add(new GameObject(x, y));
        snakeParts.add(new GameObject(x + 1, y));
        snakeParts.add(new GameObject(x + 2, y));
    }

    //------------------------------------------------------------------------------------
    public void draw(Game game) {
        if (isAlive) {
            for (int i = 0; i < snakeParts.size(); i++) {
                GameObject snakePart = snakeParts.get(i);
                if (i == 0) game.setCellValueEx(snakePart.x, snakePart.y, Color.NONE, HEAD_SIGN, Color.BLACK, 75);
                else {
                    game.setCellValueEx(snakePart.x, snakePart.y, Color.NONE, BODY_SIGN, Color.BLACK, 75);
                }
            }
        } else {
            for (int i = 0; i < snakeParts.size(); i++) {
                GameObject snakePart = snakeParts.get(i);
                if (i == 0) game.setCellValueEx(snakePart.x, snakePart.y, Color.NONE, HEAD_SIGN, Color.RED, 75);
                else {
                    game.setCellValueEx(snakePart.x, snakePart.y, Color.NONE, BODY_SIGN, Color.RED, 75);
                }
            }
        }
    }

    //------------------------------------------------------------------------------------
    public void setDirection(Direction direction) {
        if (this.direction == Direction.UP) {
            if (direction != Direction.DOWN && snakeParts.get(0).y!=snakeParts.get(1).y) this.direction = direction;
        }
        if (this.direction == Direction.DOWN) {
            if (direction != Direction.UP && snakeParts.get(0).y!=snakeParts.get(1).y) this.direction = direction;
        }
        if (this.direction == Direction.LEFT) {
            if (direction != Direction.RIGHT && snakeParts.get(0).x!=snakeParts.get(1).x) this.direction = direction;
        }
        if (this.direction == Direction.RIGHT) {
            if (direction != Direction.LEFT && snakeParts.get(0).x!=snakeParts.get(1).x) this.direction = direction;
        }
    }

    //------------------------------------------------------------------------------------
    public void move(Apple apple) {
        GameObject newHead = createNewHead();

        if (newHead.x < 0 || newHead.x >= SnakeGame.WIDTH || newHead.y < 0 || newHead.y >= SnakeGame.HEIGHT)
            isAlive = false;
        else {
            if(!checkCollision(newHead)) {
                snakeParts.add(0, newHead);
                if (newHead.x == apple.x && newHead.y == apple.y) {
                    apple.isAlive = false;
                } else removeTail();
            }else isAlive = false;

        }


    }

    //------------------------------------------------------------------------------------
    public GameObject createNewHead() {
        if (direction == Direction.UP) return new GameObject(snakeParts.get(0).x, snakeParts.get(0).y - 1);
        else if (direction == Direction.DOWN) return new GameObject(snakeParts.get(0).x, snakeParts.get(0).y + 1);
        else if (direction == Direction.LEFT) return new GameObject(snakeParts.get(0).x - 1, snakeParts.get(0).y);
        else if (direction == Direction.RIGHT) return new GameObject(snakeParts.get(0).x + 1, snakeParts.get(0).y);
        else return snakeParts.get(0);
    }

    //------------------------------------------------------------------------------------
    public void removeTail() {
        snakeParts.remove(snakeParts.size() - 1);
    }
    //------------------------------------------------------------------------------------
    public boolean checkCollision(GameObject gameObject){
        for(GameObject snakePart : snakeParts){
            if(gameObject.x == snakePart.x && gameObject.y == snakePart.y){
                return true;
            }
        }
        return false;
    }
    //-------------------------------------------------------------------------------------
    public int getLength(){
        return snakeParts.size();
    }
}
