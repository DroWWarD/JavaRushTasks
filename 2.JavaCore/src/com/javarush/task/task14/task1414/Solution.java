package com.javarush.task.task14.task1414;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
MovieFactory
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //ввести с консоли несколько ключей (строк), пункт 7
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Movie movie = null;
        String key = null;
        do {
            key = reader.readLine();
            movie = MovieFactory.getMovie(key);
            if ((key.equals("cartoon") || key.equals("thriller") || key.equals("soapOpera")))System.out.println(movie.getClass().getSimpleName());
        }while (key.equals("cartoon") || key.equals("thriller") || key.equals("soapOpera"));
        /*
8 Создать переменную movie класса Movie и для каждой введенной строки(ключа):
8.1 получить объект используя MovieFactory.getMovie и присвоить его переменной movie
8.2 вывести на экран movie.getClass().getSimpleName()
        */

    }

    static class MovieFactory {

        static Movie getMovie(String key) {
            Movie movie = null;
            if ("cartoon".equals(key)) {
                movie = new Cartoon();
            }
            if ("thriller".equals(key)) {
                movie = new Thriller();
            }
            if ("soapOpera".equals(key)) {
                movie = new SoapOpera();
            }
            return movie;
        }
    }

    static abstract class Movie {
    }

    static class Cartoon extends Movie {
    }
    static class Thriller extends Movie {
    }
    static class SoapOpera extends Movie {
    }
}
