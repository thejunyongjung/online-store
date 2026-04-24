package com.pluralsight;

import java.util.ArrayList;

public class ShoppingCart {
    private ArrayList<Product> cart;

    public ShoppingCart() {
        cart = new ArrayList<>();
    }
    public void addProduct(Product product) {
        cart.add(product);
    }
    public void removeProduct(Product product) {
        cart.remove(product);
    }
    public void clearCart() {
        cart.clear();
    }
    public ArrayList<Product> getCart() {
        return cart;
    }
    public double getTotal() {
        double total = 0;
        for (Product product : cart) {
            total += product.getPrice();
        }
        return total;
    }
}
