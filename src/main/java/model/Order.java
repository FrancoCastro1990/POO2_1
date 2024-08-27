package model;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private String id;
    private User user;
    private List<Product> products;
    private double totalPrice;

    public Order(String id, User user) {
        this.id = id;
        this.user = user;
        this.products = new ArrayList<>();
        this.totalPrice = 0.0;
    }

    public void addProduct(Product product) {
        products.add(product);
        totalPrice += product.getPrice();
    }

    public void removeProduct(Product product) {
        products.remove(product);
        totalPrice -= product.getPrice();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getId() { return id; }
    public List<Product> getProducts() { return products; }
    public double getTotalPrice() { return totalPrice; }
    public void setTotalPrice(double totalPrice) { this.totalPrice = totalPrice; }

}