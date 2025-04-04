package com.hilmy.discount;

public class DiscountCalculator {

    public double calculateDiscount(Customer customer, Product product, int quantity) {
        double discount = 0.0;

        discount += categoryAndQuantityDiscount(customer, product, quantity);
        discount += membershipBonus(customer, product, quantity);
        discount += priceBasedDiscount(product);
        discount += universalDiscounts(customer, product, quantity);

        discount = Math.min(discount, 0.20); // Cap at 20%

        return product.getPrice() * quantity * (1 - discount);
    }

    private double categoryAndQuantityDiscount(Customer customer, Product product, int quantity) {
        String category = product.getCategory();
        double discount = 0.0;

        switch (category) {
            case "Electronics":
                if (quantity > 5) {
                    discount += 0.05;
                }
                break;

            case "Clothing":
                if (quantity > 3) {
                    discount += 0.10;
                } else if (quantity >= 2) {
                    discount += 0.05;
                }
                break;

            case "Groceries":
                if (quantity > 10) {
                    discount += 0.03;
                }
                break;

            default:
                if (quantity > 2) {
                    discount += 0.01;
                }
                break;
        }

        return discount;
    }

    private double membershipBonus(Customer customer, Product product, int quantity) {
        String category = product.getCategory();
        String level = customer.getMembershipLevel();
        double discount = 0.0;

        if (category.equals("Electronics")) {
            if (quantity > 5) {
                if (level.equals("Gold")) discount += 0.05;
                else if (level.equals("Silver")) discount += 0.03;
            } else if (level.equals("Gold")) {
                discount += 0.02;
            }
        }

        if (category.equals("Clothing") && level.equals("Gold")) {
            discount += 0.05;
        }

        return discount;
    }

    private double priceBasedDiscount(Product product) {
        if (product.getCategory().equals("Electronics") && product.getPrice() > 1000) {
            return 0.02;
        }
        return 0.0;
    }

    private double universalDiscounts(Customer customer, Product product, int quantity) {
        double discount = 0.0;
        double total = product.getPrice() * quantity;

        if (customer.getTotalSpent() > 10000) {
            discount += 0.02;
        }

        if (total > 5000) {
            discount += 0.03;
        }

        return discount;
    }
}
