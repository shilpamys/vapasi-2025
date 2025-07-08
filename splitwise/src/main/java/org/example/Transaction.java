package org.example;

public class Transaction {
    private final String payer;
    private final String payee;
    private final double amount;

    public Transaction(String payer, String payee, double amount) {
        this.payer = payer;
        this.payee = payee;
        this.amount = amount;
    }

    public String getPayer() {
        return payer;
    }

    public String getPayee() {
        return payee;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return String.format("%s pays %s %.2f", payer, payee, amount);
    }
}