package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class ExpenseTrackerDemo {

    private static final Logger LOGGER = Logger.getLogger(ExpenseTrackerDemo.class.getName());

    private static final String INPUT_FILE_PATH = "/Users/shilpad/IdeaProjects/vapasi-2025/splitwise/src/main/resources/input.txt";

    public static void main(String[] args) {


        Ledger ledger = new Ledger();
        Map<String, Person> personMap = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(INPUT_FILE_PATH))) {

            String line;
            while ((line = br.readLine()) != null) {

                if (line.trim().isEmpty()) continue;

                try {

                    String[] parts = line.split(" spent ");
                    if (parts.length != 2) {
                        LOGGER.info("missing 'spent'): " + line);
                        continue;
                    }
                    String payerName = parts[0].trim();

                    String[] amountAndRest = parts[1].split(" for ", 2);
                    if (amountAndRest.length != 2) {
                        LOGGER.info("missing first 'for'): " + line);
                        continue;
                    }

                    double amount = Double.parseDouble(amountAndRest[0].trim());
                    String rest = amountAndRest[1].trim();


                    String description;
                    String beneficiariesStr;
                    int secondForIndex = rest.indexOf(" for ");
                    if (secondForIndex != -1) {
                        description = rest.substring(0, secondForIndex).trim();
                        beneficiariesStr = rest.substring(secondForIndex + 5).trim();
                    } else {

                        description = "No Description";
                        beneficiariesStr = rest;
                    }

                    String[] beneficiaries = beneficiariesStr.split(",\\s*");

                    Person payer = personMap.computeIfAbsent(payerName, Person::new);


                    List<Person> beneficiaryList = new ArrayList<>();
                    for (String beneficiaryName : beneficiaries) {
                        if (!beneficiaryName.isEmpty()) {
                            beneficiaryList.add(personMap.computeIfAbsent(beneficiaryName, Person::new));
                        }
                    }


                    new Expense(description, payer, amount, beneficiaryList, ledger);

                } catch (Exception e) {
                    LOGGER.info("Error in parsing line: " + line);
                    LOGGER.info("Error reading input file: " + e.getMessage());
                }
            }

        } catch (IOException e) {
            LOGGER.info("Error reading input file: " + e.getMessage());
            return;
        }

        System.out.println("\n Consolidating debts:");
        ledger.printLedger();
    }
}


