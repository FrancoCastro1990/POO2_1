package org.duocuc;

import singleton.Singleton;

public class Main {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        System.out.println(singleton);
        Singleton singleton2 = Singleton.getInstance();
        System.out.println(singleton2);
        if (singleton == singleton2) {
            System.out.println("singleton equals singleton2");
        } else {
            System.out.println("singleton not equals singleton2");
        }
    }
}