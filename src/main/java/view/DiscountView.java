package view;

import java.util.List;

public interface DiscountView {
    void displayAvailableDiscounts(List<String> discounts);
    void showAppliedDiscount(double discountAmount);
}
