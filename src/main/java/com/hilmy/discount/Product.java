package com.hilmy.discount;

public class Product {
    private final String category;
    private final double price;

    public Product(String category, double price) {
        this.category = category;
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }
}
