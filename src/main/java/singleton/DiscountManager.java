package singleton;

import decorator.Component;

public class DiscountManager {
    private static DiscountManager instance;

    private DiscountManager() {}

    public static DiscountManager getInstance() {
        if (instance == null) {
            instance = new DiscountManager();
        }
        return instance;
    }

    public double applyDiscount(double price, Component discountStrategy) {
        return discountStrategy.applyDiscount(price);
    }
}