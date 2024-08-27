package model.discount;

public class DiscountManager {
    private static DiscountManager instance;

    private DiscountManager() {}

    public static DiscountManager getInstance() {
        if (instance == null) {
            instance = new DiscountManager();
        }
        return instance;
    }

    public double applyDiscount(double price, Discount discount) {
        return discount.apply(price);
    }
}
