package model.discount;

public abstract class DiscountDecorator implements Discount {
    protected Discount wrappedDiscount;

    public DiscountDecorator(Discount discount) {
        this.wrappedDiscount = discount;
    }

    @Override
    public double apply(double price) {
        return wrappedDiscount.apply(price);
    }
}
