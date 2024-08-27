package view;

import model.Product;

import java.util.List;

public class ConsoleCartView implements CartView {
    @Override
    public void displayCart(List<Product> products, double totalPrice) {
        System.out.println("Carrito de compras:");
        for (Product product : products) {
            System.out.println(product.getName() + " - $" + product.getPrice());
        }
        System.out.println("Total: $" + totalPrice);
    }

    @Override
    public void showMessage(String message) {
        System.out.println(message);
    }
}
