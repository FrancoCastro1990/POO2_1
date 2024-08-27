package model.discount;

public class CategoryDiscount extends DiscountDecorator {
    private String category;
    private double discount;

    public CategoryDiscount(Discount discount, String category, double discountAmount) {
        super(discount);
        this.category = category;
        this.discount = discountAmount;
    }

    @Override
    public double apply(double price) {
        double discountedPrice = super.apply(price);
        // Aquí se podría agregar lógica para verificar la categoría del producto
        return discountedPrice - discount;
    }
}
