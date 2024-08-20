package org.duocuc;

import command.AddToCartCommand;
import command.RemoveFromCartCommand;
import command.ShoppingCart;
import command.UpdateQuantityCommand;
import decorator.CategoryDiscount;
import decorator.Component;
import decorator.Product;
import decorator.TenPercentDiscount;
import singleton.DiscountManager;


public class Main {
    public static void main(String[] args) {

        // Singleton Pattern Example
        System.out.println("Singleton Pattern Example:");
        DiscountManager discountManager1 = DiscountManager.getInstance();
        DiscountManager discountManager2 = DiscountManager.getInstance();
        System.out.println("Are both discount managers the same instance? " + (discountManager1 == discountManager2));
        System.out.println();

        // Decorator Pattern Example
        System.out.println("Decorator Pattern Example:");
        Component baseProduct = new Product();
        Component tenPercentOffProduct = new TenPercentDiscount(baseProduct);
        Component categoryDiscountProduct = new CategoryDiscount(baseProduct);
        Component combinedDiscountProduct = new TenPercentDiscount(new CategoryDiscount(baseProduct));

        double originalPrice = 100.0;
        System.out.println("Original price: $" + originalPrice);
        System.out.println("Price with 10% discount: $" + discountManager1.applyDiscount(originalPrice, tenPercentOffProduct));
        System.out.println("Price with category discount: $" + discountManager1.applyDiscount(originalPrice, categoryDiscountProduct));
        System.out.println("Price with combined discounts: $" + discountManager1.applyDiscount(originalPrice, combinedDiscountProduct));
        System.out.println();

        // Command Pattern Example
        System.out.println("Command Pattern Example:");
        ShoppingCart cart = new ShoppingCart();

        cart.addCommand(new AddToCartCommand("T-shirt"));
        cart.addCommand(new AddToCartCommand("Jeans"));
        cart.addCommand(new AddToCartCommand("Shoes"));
        cart.addCommand(new RemoveFromCartCommand("T-shirt"));
        cart.addCommand(new UpdateQuantityCommand("Jeans", 2));

        System.out.println("Executing shopping cart commands:");
        cart.executeCommands();

        // Demonstrating adding more commands after execution
        System.out.println("\nAdding more items to cart:");
        cart.addCommand(new AddToCartCommand("Hat"));
        cart.addCommand(new UpdateQuantityCommand("Shoes", 3));
        cart.executeCommands();
        }
}
