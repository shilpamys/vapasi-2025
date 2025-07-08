package org.example;

import java.util.ArrayList;
import java.util.List;

public class Expense {
    String type;
    Person payer;
    double amount;
    List<Person> beneficiaries;
    Ledger ledger;

    public Expense(String type, Person payer, double amount, List<Person> beneficiaries, Ledger ledger) {
        this.type = type;
        this.payer = payer;
        this.amount = amount;
        this.beneficiaries = new ArrayList<>(beneficiaries);
        this.ledger = ledger;
        updateLedger();
    }

    private void updateLedger() {
        double perPersonAmount = amount / beneficiaries.size();

        for (Person beneficiary : beneficiaries) {
            if (!beneficiary.equals(payer)) {
                ledger.addDebt(payer, beneficiary, perPersonAmount);
            }
        }
    }

    @Override
    public String toString() {
        return String.format("%s: $%.2f paid by %s for %d people",
                type, amount, payer.getName(), beneficiaries.size());
    }
}
