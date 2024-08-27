package controller;

import model.Order;
import model.User;
import model.discount.*;
import view.DiscountView;

import java.util.Arrays;
import java.util.List;

public class DiscountController {
    private DiscountManager discountManager;
    private DiscountView view;

    public DiscountController(DiscountView view) {
        this.discountManager = DiscountManager.getInstance();
        this.view = view;
    }

    public void applyDiscount(Order order, Discount discount) {
        double originalPrice = order.getTotalPrice();
        double discountedPrice = discountManager.applyDiscount(originalPrice, discount);
        order.setTotalPrice(discountedPrice);
        view.showAppliedDiscount(originalPrice - discountedPrice);
    }

    public void showAvailableDiscounts() {
        List<String> discounts = Arrays.asList(
                "10% de descuento en toda la tienda",
                "20% de descuento en categoría 'Camisetas'",
                "$5 de descuento en compras superiores a $50"
        );
        view.displayAvailableDiscounts(discounts);
    }

    public Discount createPercentageDiscount(double percentage) {
        return new PercentageDiscount(new BaseDiscount(), percentage);
    }

    public Discount createCategoryDiscount(String category, double amount) {
        return new CategoryDiscount(new BaseDiscount(), category, amount);
    }

    public Discount createCombinedDiscount(Discount discount1, Discount discount2) {
        return new DiscountDecorator(discount1) {
            @Override
            public double apply(double price) {
                return discount2.apply(super.apply(price));
            }
        };
    }
    public Discount createUserBasedDiscount(User user) {
        // Ejemplo: Si el usuario ha realizado más de 5 compras, obtiene un 15% de descuento
        if (user.getPurchaseCount() > 5) {
            return new PercentageDiscount(new BaseDiscount(), 15);
        }
        return new BaseDiscount();
    }
}