package org.duocuc;


import controller.CartController;
import controller.DiscountController;
import controller.ProductController;


import controller.UserController;
import controller.command.AddToCartCommand;
import model.Order;
import model.Product;
import model.User;
import model.discount.Discount;
import view.*;

import java.util.ArrayList;
import java.util.List;


public class Main {
        public static void main(String[] args) {
            // Inicialización de productos
            List<Product> productList = new ArrayList<>();
            productList.add(new Product("1", "Camiseta Roja", 19.99, "Camisetas"));
            productList.add(new Product("2", "Pantalón Jeans", 39.99, "Pantalones"));
            productList.add(new Product("3", "Zapatos Deportivos", 59.99, "Calzado"));

            // Inicialización de vistas
            ProductView productView = new ConsoleProductView();
            CartView cartView = new ConsoleCartView();
            DiscountView discountView = new ConsoleDiscountView();

            // Inicialización de controladores
            ProductController productController = new ProductController(productList, productView);
            DiscountController discountController = new DiscountController(discountView);
            UserController userController = new UserController();

            // Crear usuarios
            User user1 = new User("U001", "Juan Pérez", "juan@email.com");
            User user2 = new User("U002", "María García", "maria@email.com");
            userController.addUser(user1);
            userController.addUser(user2);

            // Simular compras previas para user2
            for (int i = 0; i < 6; i++) {
                user2.incrementPurchaseCount();
            }

            System.out.println("Bienvenido al sistema de pedidos online");

            // Mostrar productos disponibles
            System.out.println("\nProductos disponibles:");
            productController.showProducts();

            // Proceso de compra para user1
            Order order1 = new Order("ORD001", user1);
            CartController cartController1 = new CartController(order1, cartView);

            System.out.println("\nProceso de compra para " + user1.getName());
            Product product1 = productController.getProductById("1");
            Product product2 = productController.getProductById("2");
            cartController1.executeCommand(new AddToCartCommand(product1, order1));
            cartController1.executeCommand(new AddToCartCommand(product2, order1));

            System.out.println("Carrito de " + user1.getName() + ":");
            cartController1.updateCart();

            // Aplicar descuentos para user1
            System.out.println("\nAplicando descuentos para " + user1.getName());
            discountController.showAvailableDiscounts();

            Discount tenPercentDiscount = discountController.createPercentageDiscount(10);
            discountController.applyDiscount(order1, tenPercentDiscount);

            Discount userBasedDiscount1 = discountController.createUserBasedDiscount(user1);
            discountController.applyDiscount(order1, userBasedDiscount1);

            System.out.println("Carrito de " + user1.getName() + " después de los descuentos:");
            cartController1.updateCart();

            // Proceso de compra para user2
            Order order2 = new Order("ORD002", user2);
            CartController cartController2 = new CartController(order2, cartView);

            System.out.println("\nProceso de compra para " + user2.getName());
            Product product3 = productController.getProductById("3");
            cartController2.executeCommand(new AddToCartCommand(product3, order2));

            System.out.println("Carrito de " + user2.getName() + ":");
            cartController2.updateCart();

            // Aplicar descuentos para user2
            System.out.println("\nAplicando descuentos para " + user2.getName());
            discountController.showAvailableDiscounts();

            Discount categoryDiscount = discountController.createCategoryDiscount("Calzado", 5);
            discountController.applyDiscount(order2, categoryDiscount);

            Discount userBasedDiscount2 = discountController.createUserBasedDiscount(user2);
            discountController.applyDiscount(order2, userBasedDiscount2);

            System.out.println("Carrito de " + user2.getName() + " después de los descuentos:");
            cartController2.updateCart();

            // Finalizar compras
            user1.incrementPurchaseCount();
            user2.incrementPurchaseCount();

            System.out.println("\n¡Gracias por su compra!");
            System.out.println("Resumen de compras:");
            System.out.println(user1.getName() + " - Total de compras: " + user1.getPurchaseCount());
            System.out.println(user2.getName() + " - Total de compras: " + user2.getPurchaseCount());
    }
}
