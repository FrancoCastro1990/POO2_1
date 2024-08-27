package controller.command;

import model.Order;
import model.Product;

public class AddToCartCommand implements Command {
    private Product product;
    private Order order;

    public AddToCartCommand(Product product, Order order) {
        this.product = product;
        this.order = order;
    }

    @Override
    public void execute() {
        order.addProduct(product);
    }
}
