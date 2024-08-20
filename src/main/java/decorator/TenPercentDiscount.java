package decorator;

public class TenPercentDiscount extends Decorator {
    public TenPercentDiscount(Component component) {
        super(component);
    }

    @Override
    public double applyDiscount(double price) {
        double discountedPrice = super.applyDiscount(price);
        return discountedPrice * 0.9; // 10% discount
    }
}