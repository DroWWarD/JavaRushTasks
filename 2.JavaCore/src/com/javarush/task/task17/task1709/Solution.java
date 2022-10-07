package com.javarush.task.task17.task1709;

/* 
Предложения
*/

public class Solution {
    public volatile  static int proposal = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread make = new Thread(new MakeProposal());
        make.start();
        make.join();
        new AcceptProposal().start();

    }

    public static class MakeProposal extends Thread {
        @Override
        public void run() {
            int thisProposal = proposal;

            while (proposal < 10) {
                System.out.println("Сделано предложение №" + (thisProposal + 1));
                proposal = ++thisProposal;
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }
        }
    }

    public static class AcceptProposal extends Thread {
        @Override
        public void run() {
            while (proposal > 0) {
                    System.out.println("Принято предложение №" + proposal);
                    proposal--;
            }
        }
    }
}
