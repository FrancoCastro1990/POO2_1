package view;

import model.Product;

import java.util.List;


public interface ProductView {
    void displayProducts(List<Product> products);
    void showMessage(String message);
}
