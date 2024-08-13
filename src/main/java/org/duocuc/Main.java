package org.duocuc;

import manager.DiscountManager;
import singleton.Singleton;

public class Main {
    public static void main(String[] args) {
//        Singleton singleton = Singleton.getInstance();
//        System.out.println(singleton);
//        Singleton singleton2 = Singleton.getInstance();
//        System.out.println(singleton2);
//        if (singleton == singleton2) {
//            System.out.println("singleton equals singleton2");
//        } else {
//            System.out.println("singleton not equals singleton2");
//        }
        DiscountManager discountManager = DiscountManager.getInstance();

        double originalPrice = 100.0;

        System.out.println("Precio original: $" + originalPrice);
        System.out.println("Precio con descuento normal: $" + discountManager.applyDiscount(originalPrice, "NORMAL"));
        System.out.println("Precio con descuento VIP: $" + discountManager.applyDiscount(originalPrice, "VIP"));
        System.out.println("Precio con descuento especial: $" + discountManager.applyDiscount(originalPrice, "SPECIAL"));
        System.out.println("Precio sin descuento: $" + discountManager.applyDiscount(originalPrice, "NONE"));

        // Demostrar que siempre se obtiene la misma instancia
        DiscountManager anotherDiscountManager = DiscountManager.getInstance();
        System.out.println("¿Es la misma instancia? " + (discountManager == anotherDiscountManager));
    }
}