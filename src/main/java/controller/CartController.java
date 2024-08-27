package controller;

import controller.command.Command;
import model.Order;
import view.CartView;

public class CartController {
    private Order order;
    private CartView view;

    public CartController(Order order, CartView view) {
        this.order = order;
        this.view = view;
    }

    public void updateCart() {
        view.displayCart(order.getProducts(), order.getTotalPrice());
    }

    public void executeCommand(Command command) {
        command.execute();
        updateCart();
    }
}
