import org.example.Expense;
import org.example.Ledger;
import org.example.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class ExpenseTrackerTest {


    private Map<String, Person> personMap;
    private Ledger tracker;


    @BeforeEach
    public void setUp() {
        personMap = new HashMap<>();
        tracker = new Ledger();

    }


    @Test
    void testSelfExpense() {
        // Create person
        Person payer = personMap.computeIfAbsent("A", Person::new);

        // Create expense
        new Expense("Snacks", payer, 25.0, List.of(payer), tracker);

        // Verify no debts
        Map<Person, Map<Person, Double>> debts = tracker.getDebts();
        assertTrue(debts.isEmpty(), "Expected no debts for self-expense");
    }

    @Test
    void testDecimalAmount() {
        // Create persons
        Person payer = personMap.computeIfAbsent("A", Person::new);
        Person b = personMap.computeIfAbsent("B", Person::new);
        Person c = personMap.computeIfAbsent("C", Person::new);

        // Create expense
        new Expense("Snacks", payer, 12.70, List.of(b, c), tracker);

        // Verify debts
        Map<Person, Map<Person, Double>> debts = tracker.getDebts();
        double expectedAmount = 12.70 / 2;

        // Check B's debt
        Map<Person, Double> bDebts = debts.get(b);
        assertTrue(bDebts != null && bDebts.containsKey(payer), "B should owe A");
        assertEquals(expectedAmount, Math.abs(bDebts.get(payer)), 0.001, "B owes incorrect amount");

        // Check C's debt
        Map<Person, Double> cDebts = debts.get(c);
        assertTrue(cDebts != null && cDebts.containsKey(payer), "C should owe A");
        assertEquals(expectedAmount, Math.abs(cDebts.get(payer)), 0.001, "C owes incorrect amount");
    }

    @Test
    void testZeroAmount() {
        // Create persons
        Person payer = personMap.computeIfAbsent("A", Person::new);
        Person b = personMap.computeIfAbsent("B", Person::new);
        Person c = personMap.computeIfAbsent("C", Person::new);

        // Create expense
        new Expense("Snacks", payer, 0.0, List.of(b, c), tracker);

        // Verify no debts
        Map<Person, Map<Person, Double>> debts = tracker.getDebts();
        assertFalse(debts.isEmpty(), "Expected no debts for zero amount");
    }

    @Test
    void testNegativeAmount() {
        Person payer = personMap.computeIfAbsent("A", Person::new);
        Person b = personMap.computeIfAbsent("B", Person::new);
        Person c = personMap.computeIfAbsent("C", Person::new);

        new Expense("Snacks", payer, -25.0, List.of(b, c), tracker);

        Map<Person, Map<Person, Double>> debts = tracker.getDebts();
        assertFalse(debts.isEmpty(), "Expected no debts for negative amount");
    }

    @Test
    void testEmptyInput() {
        // Verify no debts
        Map<Person, Map<Person, Double>> debts = tracker.getDebts();
        assertTrue(debts.isEmpty(), "Expected no debts for empty input");
    }

    @Test
    void testLargeGroup() {
        // Create persons
        Person payer = personMap.computeIfAbsent("A", Person::new);
        List<Person> beneficiaries = new ArrayList<>();
        for (char c = 'B'; c <= 'Z'; c++) {
            beneficiaries.add(personMap.computeIfAbsent(String.valueOf(c), Person::new));
        }

        // Create expense
        new Expense("Snacks", payer, 2000.0, beneficiaries, tracker);

        // Verify debts
        Map<Person, Map<Person, Double>> debts = tracker.getDebts();
        double expectedAmount = 2000.0 / beneficiaries.size();

        // Check each beneficiary's debt
        for (Person beneficiary : beneficiaries) {
            Map<Person, Double> personDebts = debts.get(beneficiary);
            assertTrue(personDebts != null && personDebts.containsKey(payer),
                    "Expected beneficiary " + beneficiary.getName() + " to owe A");
            assertEquals(expectedAmount, Math.abs(personDebts.get(payer)), 0.001,
                    "Expected correct amount for beneficiary " + beneficiary.getName());
        }
    }

}
