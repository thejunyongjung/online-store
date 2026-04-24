package com.pluralsight;

public class Product {
    private String sku;
    private String name;
    private double price;
    private String department;

    // Constructor
    Product(String sku, String name, double price, String department) {
        this.sku = sku;
        this.name = name;
        this.price = price;
        this.department = department;
    }

    // Getters
    public String getSku() { return sku;}
    public String getName() { return name;}
    public double getPrice() { return price;}
    public String getDepartment() { return department;}

    // Setters
    public void setSku(String sku) { this.sku = sku; }
    public void setName(String name) { this.name = name; }
    public void setPrice(double price) { this.price = price; }
    public void setDepartment(String department) { this.department = department; }

    // toString Method
    @Override
    public String toString() {
        return String.format("%-8s %-32s $%8.2f %15s", sku, name, price, department);
    }
    public String toReceiptString() {
        return String.format("%-8s %-32s $%8.2f", sku, name, price);
    }
}
