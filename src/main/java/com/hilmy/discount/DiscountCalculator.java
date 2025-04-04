package com.hilmy.discount;

// Initial version (to be refactored)

public class DiscountCalculator {

    public double calculateDiscount(Customer customer, Product product, int quantity) {
        double discount = 0.0;

        // Quantity-based checks first (the worst way possible)
        if (quantity > 5) {
            if (product.getCategory().equals("Electronics")) {
                discount += 0.05;
                if (customer.getMembershipLevel().equals("Gold")) {
                    discount += 0.05;
                } else if (customer.getMembershipLevel().equals("Silver")) {
                    discount += 0.03;
                }
            } else if (quantity > 10) {
                if (product.getCategory().equals("Groceries")) {
                    discount += 0.03;
                }
            }
        } else if (quantity > 3) {
            if (product.getCategory().equals("Clothing")) {
                discount += 0.1;
            }
        } else if (quantity > 2) {
            if (!product.getCategory().equals("Electronics") &&
                    !product.getCategory().equals("Clothing") &&
                    !product.getCategory().equals("Groceries")) {
                discount += 0.01;
            }
        } else if (quantity > 1) {
            if (product.getCategory().equals("Clothing")) {
                discount += 0.05;
            }
        }

        // Now handle cases that weren't caught by quantity checks
        if (quantity <= 5 && product.getCategory().equals("Electronics")) {
            if (customer.getMembershipLevel().equals("Gold")) {
                discount += 0.02;
            }
        }

        // Price checks scattered throughout
        if (product.getCategory().equals("Electronics") && product.getPrice() > 1000) {
            discount += 0.02;
        }

        if (product.getCategory().equals("Clothing") && !(quantity > 3) && customer.getMembershipLevel().equals("Gold")) {
            discount += 0.05;
        }

        if (customer.getTotalSpent() > 10000 || product.getPrice() * quantity > 5000) {
            if (customer.getTotalSpent() > 10000) {
                discount += 0.02;
            }
            if (product.getPrice() * quantity > 5000) {
                discount += 0.03;
            }
        }

        // Max discount check with confusing logic
        if (discount > 0.2 == true) {
            discount = 0.2;
        }
        if (!(discount > 0.2)) {
            System.out.println("Discount never is higher than 20% even though it's not");
        }

        return product.getPrice() * quantity * (1 - discount);
    }
}

