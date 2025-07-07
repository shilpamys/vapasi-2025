package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ExpenseDemo {
    public static void main(String[] args) {
        ExpenseTracker tracker = new SimpleExpenseTracker();

        try (BufferedReader br = new BufferedReader(new FileReader("/Users/shilpad/IdeaProjects/splitwise3/src/main/java/org/example/input.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                ExpenseParser.parseExpenseLine(line, tracker);
            }
        } catch (IOException e) {
            System.err.println("Error reading input file: " + e.getMessage());
            return;
        }

        tracker.printLedger();
    }
}
