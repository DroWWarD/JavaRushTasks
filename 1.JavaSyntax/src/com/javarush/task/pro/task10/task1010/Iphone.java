package com.javarush.task.pro.task10.task1010;

import java.util.Objects;

/* 
Два айфона
*/

public class Iphone {
    private String model;
    private String color;
    private int price;

    public Iphone(String model, String color, int price) {
        this.model = model;
        this.color = color;
        this.price = price;
    }

    public boolean equals (Object obj){
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof Iphone))
            return false;
        Iphone iphone = (Iphone) obj;
        if (this.price != iphone.price) return false;
        if (this.model == null ^ iphone.model == null) return false;
        if (this.color == null ^ iphone.color == null) return false;
        if(iphone.model == null && this.model == null && iphone.color == null && this.color == null) return true;
        else {
            if (iphone.model == null && this.model == null) return this.color.equals(iphone.color);
            if (iphone.color == null && this.color == null) return this.model.equals(iphone.model);
        }
        return this.color.equals(iphone.color) && this.model.equals(iphone.model);
    }

    public static void main(String[] args) {
        Iphone iphone1 = new Iphone("X", null, 999);
        Iphone iphone2 = new Iphone(null, null, 999);

        System.out.println(iphone1.equals(iphone2));
    }

}
