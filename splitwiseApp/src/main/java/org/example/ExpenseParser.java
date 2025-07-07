package org.example;

import java.util.List;
import java.util.logging.Logger;

public class ExpenseParser {
    private static final Logger LOGGER = Logger.getLogger(ExpenseParser.class.getName());

    public static void parseExpenseLine(String line, ExpenseTracker tracker) {
        try {
            if (line == null || line.trim().isEmpty()) {
                LOGGER.info("Skipping empty input line.");
                return;
            }

            String[] parts = line.split(" spent ");
            if (parts.length < 2) {
                LOGGER.info("Error: Invalid expense line format. Missing 'spent' part.");
                return;
            }

            String payer = parts[0];
            String[] amountAndDescription = parts[1].split(" for ");
            if (amountAndDescription.length < 3) {
                LOGGER.info("Error: Invalid expense line format. Missing amount or description.");
                return;
            }

            double amount = Double.parseDouble(amountAndDescription[0]);
            String description = amountAndDescription[1];
            String beneficiariesStr = amountAndDescription[2];

            List<String> beneficiaries = List.of(beneficiariesStr.split(",\\s*"));
            tracker.trackExpense(payer, amount, description, beneficiaries);

        } catch (Exception e) {
            LOGGER.info("Error: " + e.getMessage());
        }
    }
}









