package controller.command;

import model.Order;
import model.Product;

public class RemoveFromCartCommand implements Command {
    private Product product;
    private Order order;

    public RemoveFromCartCommand(Product product, Order order) {
        this.product = product;
        this.order = order;
    }

    @Override
    public void execute() {
        order.removeProduct(product);
    }
}