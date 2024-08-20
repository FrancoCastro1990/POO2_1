package decorator;

public class Product implements Component {
    @Override
    public double applyDiscount(double price) {
        return price; // No discount applied
    }
}