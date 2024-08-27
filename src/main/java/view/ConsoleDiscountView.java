package view;

import java.util.List;

public class ConsoleDiscountView implements DiscountView {
    @Override
    public void displayAvailableDiscounts(List<String> discounts) {
        System.out.println("Descuentos disponibles:");
        for (String discount : discounts) {
            System.out.println(discount);
        }
    }

    @Override
    public void showAppliedDiscount(double discountAmount) {
        System.out.println("Descuento aplicado: $" + discountAmount);
    }
}