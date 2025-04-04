// DiscountCalculatorTest.java (JUnit 3-compatible)
package com.hilmy.discount;

import junit.framework.TestCase;

/**
 * Unit test for DiscountCalculator using JUnit 3 (as specified by original pom.xml).
 */
public class DiscountCalculatorTest extends TestCase {

    private DiscountCalculator calculator;

    protected void setUp() {
        calculator = new DiscountCalculator();
    }

    public void testElectronicsGoldLargeQuantity() {
        Customer customer = new Customer("Gold", 15000);
        Product product = new Product("Electronics", 1200);
        int quantity = 6;
        double expected = product.getPrice() * quantity * 0.83;
        double total = calculator.calculateDiscount(customer, product, quantity);
        assertEquals(expected, total, 0.01);
    }

    public void testClothingSilverLowQuantity() {
        Customer customer = new Customer("Silver", 3000);
        Product product = new Product("Clothing", 100);
        int quantity = 2;
        double expected = product.getPrice() * quantity * 0.95;
        double total = calculator.calculateDiscount(customer, product, quantity);
        assertEquals(expected, total, 0.01);
    }

    public void testGroceriesHighQuantity() {
        Customer customer = new Customer("None", 200);
        Product product = new Product("Groceries", 10);
        int quantity = 11;
        double expected = product.getPrice() * quantity * 0.97;
        double total = calculator.calculateDiscount(customer, product, quantity);
        assertEquals(expected, total, 0.01);
    }

    public void testOtherCategory() {
        Customer customer = new Customer("None", 0);
        Product product = new Product("Books", 30);
        int quantity = 3;
        double expected = product.getPrice() * quantity * 0.99;
        double total = calculator.calculateDiscount(customer, product, quantity);
        assertEquals(expected, total, 0.01);
    }

    public void testMaxDiscountCap() {
        Customer customer = new Customer("Gold", 20000);
        Product product = new Product("Clothing", 500);
        int quantity = 20;
        double expected = product.getPrice() * quantity * 0.80;
        double total = calculator.calculateDiscount(customer, product, quantity);
        assertEquals(expected, total, 0.01);
    }

    public void testNoDiscount() {
        Customer customer = new Customer("None", 0);
        Product product = new Product("Clothing", 100);
        int quantity = 1;
        double expected = product.getPrice() * quantity;
        double total = calculator.calculateDiscount(customer, product, quantity);
        assertEquals(expected, total, 0.01);
    }
}
