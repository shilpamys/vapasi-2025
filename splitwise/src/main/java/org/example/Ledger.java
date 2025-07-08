package org.example;


import java.util.HashMap;
import java.util.Map;

public class Ledger {
    private final Map<Person, Map<Person, Double>> debts;

    public Map<Person, Map<Person, Double>> getDebts() {
        return debts;
    }

    public Ledger() {
        this.debts = new HashMap<>();
    }

    public void addDebt(Person creditor, Person debtor, double amount) {

        Map<Person, Double> creditorDebts = debts.computeIfAbsent(creditor, _ -> new HashMap<>());

        Map<Person, Double> debtorDebts = debts.computeIfAbsent(debtor, _ -> new HashMap<>());

        double currentDebt = creditorDebts.getOrDefault(debtor, 0.0);

        double newDebt = currentDebt + amount;

        creditorDebts.put(debtor, newDebt);
        debtorDebts.put(creditor, -newDebt);
    }

    public void printLedger() {
        for (Map.Entry<Person, Map<Person, Double>> entry : debts.entrySet()) {
            Person creditor = entry.getKey();
            Map<Person, Double> creditorDebts = entry.getValue();

            for (Map.Entry<Person, Double> debtEntry : creditorDebts.entrySet()) {
                Person debtor = debtEntry.getKey();
                double amount = debtEntry.getValue();

                if (amount > 0) {
                    System.out.printf("%s pays %s: %.2f%n", debtor.getName(), creditor.getName(), amount);
                }
            }
        }
    }
}