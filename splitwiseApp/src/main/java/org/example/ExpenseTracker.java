package org.example;

import java.util.List;

public interface ExpenseTracker {
    void trackExpense(String payer, double amount, String description, List<String> beneficiaries);
    void printLedger();
}
