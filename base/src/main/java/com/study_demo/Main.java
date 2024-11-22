package com.study_demo;

import lombok.Data;

public class Main {
    private static Singleton s1;
    private static Singleton s2;

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> s1 = Singleton.getInstance());
        Thread t2 = new Thread(() -> s2 = Singleton.getInstance());
        t1.start();
        t2.start();

        Thread.sleep(1000);
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s1 == s2);
    }


    @Data
    public static class Singleton {
        private static Singleton instance;

        private Singleton() {
        }

        public static Singleton getInstance() {
            if (instance == null){
                instance = new Singleton();
            }
            return instance;
        }
    }
}