package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Logger;

public class ExpenseDemo {
    private static final Logger LOGGER = Logger.getLogger(ExpenseDemo.class.getName());

    private static final String INPUT_FILE_PATH = "/Users/shilpad/IdeaProjects/Final/src/main/java/org/example/input.txt";


    public static void main(String[] args) {

        ExpenseTracker tracker = new SimpleExpenseTracker();

        try (BufferedReader br = new BufferedReader(new FileReader(INPUT_FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                ExpenseParser.parseExpenseLine(line, tracker);
            }
        } catch (IOException e) {
            LOGGER.info("Error reading input file: " + e.getMessage());
            return;
        }

        tracker.printLedger();
    }
}
