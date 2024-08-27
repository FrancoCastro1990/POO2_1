package controller;

import model.Product;
import view.ProductView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ProductController {
    private List<Product> products;
    private ProductView view;

    public ProductController(List<Product> products, ProductView view) {
        this.products = products;
        this.view = view;
    }

    public void showProducts() {
        view.displayProducts(products);
    }

    public void addProduct(Product product) {
        products.add(product);
        view.showMessage("Producto agregado: " + product.getName());
    }

    public Product getProductById(String id) {
        return products.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}