package com.javarush.task.task20.task2027;

import java.util.ArrayList;
import java.util.List;

/* 
Кроссворд
*/

public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
        System.out.println(detectAllWords(crossword, "home", "same"));
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        List<Word> list = new ArrayList<>();
        for (String string : words) {
            Word word = new Word(string);
            char[] lineArray = string.toCharArray();
            for (int i = 0; i < crossword.length; i++) {
                for (int j = 0; j < crossword[i].length; j++) {
                    if (crossword[i][j] == lineArray[0]) {
                        if (checkVector(crossword,lineArray,0,i,j,-1,-1,word)) {
                            word.setStartPoint(j,i);
                            list.add(word);
                        }
                        else if (checkVector(crossword,lineArray,0,i,j,-1,0,word)) {
                            word.setStartPoint(j,i);
                            list.add(word);
                        }
                        else if (checkVector(crossword,lineArray,0,i,j,-1,1,word)) {
                            word.setStartPoint(j,i);
                            list.add(word);
                        }
                        else if (checkVector(crossword,lineArray,0,i,j,0,1,word)) {
                            word.setStartPoint(j,i);
                            list.add(word);
                        }
                        else if (checkVector(crossword,lineArray,0,i,j,1,1,word)) {
                            word.setStartPoint(j,i);
                            list.add(word);
                        }
                        else if (checkVector(crossword,lineArray,0,i,j,1,0,word)) {
                            word.setStartPoint(j,i);
                            list.add(word);
                        }
                        else if (checkVector(crossword,lineArray,0,i,j,1,-1,word)) {
                            word.setStartPoint(j,i);
                            list.add(word);
                        }
                        else if (checkVector(crossword,lineArray,0,i,j,0,-1,word)) {
                            word.setStartPoint(j,i);
                            list.add(word);
                        }
                    }
                }
            }
        }
        return list;
    }

    public static boolean checkVector(int[][] crossword, char[] word, int symbolIndex, int i, int j, int vectorI, int vectorJ, Word wordForCheck) {
        boolean check = false;
        int index = symbolIndex+1;
        int nextI = i + vectorI;
        int nextJ = j + vectorJ;
        if (index < word.length-1){
            if (nextI>=0 && nextJ >= 0 && nextI < crossword.length && nextJ < crossword[nextI].length){
                if (crossword[nextI][nextJ] == word[index]){
                    check = checkVector(crossword, word, index, nextI, nextJ, vectorI, vectorJ, wordForCheck);
                }
            }
        }else if (index == word.length-1){
            if (nextI>=0 && nextJ >= 0 && nextI < crossword.length && nextJ < crossword[nextI].length){
                if (crossword[nextI][nextJ] == word[index]){
                    wordForCheck.setEndPoint(nextJ, nextI);
                    check = true;
                }
            }
        }
        return check;
    }

    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
