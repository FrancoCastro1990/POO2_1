package view;

import model.Product;

import java.util.List;

public class ConsoleProductView implements ProductView {
    @Override
    public void displayProducts(List<Product> products) {
        System.out.println("Productos disponibles:");
        for (Product product : products) {
            System.out.println(product.getName() + " - $" + product.getPrice());
        }
    }

    @Override
    public void showMessage(String message) {
        System.out.println(message);
    }
}