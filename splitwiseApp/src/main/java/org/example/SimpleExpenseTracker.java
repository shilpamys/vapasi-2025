package org.example;

import java.util.ArrayList;
import java.util.List;

public class SimpleExpenseTracker implements ExpenseTracker {
    public final List<Transaction> transactions = new ArrayList<>();

    @Override
    public void trackExpense(String payer, double amount, String description, List<String> beneficiaries) {

        double amountPerPerson = amount / beneficiaries.size();


        beneficiaries.stream()
            .filter(payee -> !payee.equals(payer))
            .forEach(payee -> transactions.add(new Transaction(payee, payer, amountPerPerson)));
    }

    @Override
    public void printLedger() {
        System.out.println("\nExpense Ledger:");
        transactions.forEach(System.out::println);
    }
}
