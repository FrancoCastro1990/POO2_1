package decorator;

public class CategoryDiscount extends Decorator {
    public CategoryDiscount(Component component) {
        super(component);
    }

    @Override
    public double applyDiscount(double price) {
        double discountedPrice = super.applyDiscount(price);
        return discountedPrice * 0.8; // 20% discount
    }
}
