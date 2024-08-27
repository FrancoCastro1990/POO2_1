package model.discount;

public class BaseDiscount implements Discount {
    @Override
    public double apply(double price) {
        return price;
    }
}