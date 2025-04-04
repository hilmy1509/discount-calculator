// DiscountCalculatorTest.java (JUnit 5)
package com.hilmy.discount;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * This test class validates the behavior of the DiscountCalculator class
 * using JUnit 5. Make sure the Customer, Product, and DiscountCalculator
 * classes are implemented in the same package and contain the required
 * methods and constructors.
 */
public class DiscountCalculatorTest {

    private final DiscountCalculator calculator = new DiscountCalculator();

    @Test
    public void testElectronicsGoldLargeQuantity() {
        Customer customer = new Customer("Gold", 15000);
        Product product = new Product("Electronics", 1200);
        int quantity = 6;
        double total = calculator.calculateDiscount(customer, product, quantity);
        double expected = product.getPrice() * quantity * 0.83; // 17% discount
        assertEquals(expected, total, 0.01);
    }

    @Test
    public void testClothingSilverLowQuantity() {
        Customer customer = new Customer("Silver", 3000);
        Product product = new Product("Clothing", 100);
        int quantity = 2;
        double total = calculator.calculateDiscount(customer, product, quantity);
        double expected = product.getPrice() * quantity * 0.95; // 5% discount
        assertEquals(expected, total, 0.01);
    }

    @Test
    public void testGroceriesHighQuantity() {
        Customer customer = new Customer("None", 200);
        Product product = new Product("Groceries", 10);
        int quantity = 11;
        double total = calculator.calculateDiscount(customer, product, quantity);
        double expected = product.getPrice() * quantity * 0.97; // 3% discount
        assertEquals(expected, total, 0.01);
    }

    @Test
    public void testOtherCategory() {
        Customer customer = new Customer("None", 0);
        Product product = new Product("Books", 30);
        int quantity = 3;
        double total = calculator.calculateDiscount(customer, product, quantity);
        double expected = product.getPrice() * quantity * 0.99; // 1% discount
        assertEquals(expected, total, 0.01);
    }

    @Test
    public void testMaxDiscountCap() {
        Customer customer = new Customer("Gold", 20000);
        Product product = new Product("Clothing", 500);
        int quantity = 20;
        double total = calculator.calculateDiscount(customer, product, quantity);
        double maxExpectedDiscount = product.getPrice() * quantity * 0.8; // 20% cap
        assertTrue(total >= maxExpectedDiscount);
    }

    @Test
    public void testNoDiscount() {
        Customer customer = new Customer("None", 0);
        Product product = new Product("Clothing", 100);
        int quantity = 1;
        double total = calculator.calculateDiscount(customer, product, quantity);
        double expected = product.getPrice() * quantity; // No discount
        assertEquals(expected, total, 0.01);
    }
}