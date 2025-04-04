package com.hilmy.discount;

class Customer {
    private final String membershipLevel;
    private final double totalSpent;

    public Customer(String membershipLevel, double totalSpent) {
        this.membershipLevel = membershipLevel;
        this.totalSpent = totalSpent;
    }

    public String getMembershipLevel() {
        return membershipLevel;
    }

    public double getTotalSpent() {
        return totalSpent;
    }
}
