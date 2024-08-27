package model.discount;

public class PercentageDiscount extends DiscountDecorator {
    private double percentage;

    public PercentageDiscount(Discount discount, double percentage) {
        super(discount);
        this.percentage = percentage;
    }

    @Override
    public double apply(double price) {
        double discountedPrice = super.apply(price);
        return discountedPrice * (1 - percentage / 100);
    }
}