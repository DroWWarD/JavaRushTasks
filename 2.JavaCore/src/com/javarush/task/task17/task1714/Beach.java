package com.javarush.task.task17.task1714;

/* 
Comparable
*/

public class Beach implements Comparable<Beach> {
    private String name;      //название
    private float distance;   //расстояние
    private int quality;    //качество

    public Beach(String name, float distance, int quality) {
        this.name = name;
        this.distance = distance;
        this.quality = quality;
    }

    @Override
    public synchronized int compareTo(Beach beach) {
        int sum1 = 0;
        if (this.quality == beach.quality && this.distance == beach.distance) return 0;
        else if (this.quality == beach.quality) return (int)(beach.distance - this.distance);
        else if (this.distance == beach.distance) return this.quality- beach.quality;
        else {
            if (this.quality > beach.quality) {
                sum1++;
            }else sum1--;
            if (this.distance < beach.distance) {
                sum1++;
            }else sum1--;
            return sum1;
        }
    }

    public synchronized String getName() {
        return name;
    }

    public synchronized void setName(String name) {
        this.name = name;
    }

    public synchronized float getDistance() {
        return distance;
    }

    public synchronized void setDistance(float distance) {
        this.distance = distance;
    }

    public synchronized int getQuality() {
        return quality;
    }

    public synchronized void setQuality(int quality) {
        this.quality = quality;
    }

    public static void main(String[] args) {

    }
}
