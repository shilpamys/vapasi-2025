package org.example;

import java.util.List;

public class ExpenseParser {
    
    public static void parseExpenseLine(String line, ExpenseTracker tracker) {
        String[] parts = line.split(" spent ");
        String payer = parts[0];
        
        String[] amountAndDescription = parts[1].split(" for ");
        double amount = Double.parseDouble(amountAndDescription[0]);
        String description = amountAndDescription[1];
        
        String beneficiariesStr = amountAndDescription[2];
        List<String> beneficiaries = List.of(beneficiariesStr.split(", "));
        
        tracker.trackExpense(payer, amount, description, beneficiaries);
    }
}
