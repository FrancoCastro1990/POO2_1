package view;

import model.Product;

import java.util.List;

public interface CartView {
    void displayCart(List<Product> products, double totalPrice);
    void showMessage(String message);
}
