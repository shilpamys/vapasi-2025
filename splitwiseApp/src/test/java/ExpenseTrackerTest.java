import org.example.ExpenseParser;
import org.example.SimpleExpenseTracker;
import org.example.Transaction;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ExpenseTrackerTest {

    SimpleExpenseTracker tracker = new SimpleExpenseTracker();

    @Test
    void testSimpleTwoBeneficiaries() {

        String line = "A spent 25 for Snacks for B, C";

        ExpenseParser.parseExpenseLine(line, tracker);


        double expectedAmount = 25.0 / 2;

        boolean bPaysA = false;

        boolean cPaysA = false;

        for (Transaction t : tracker.transactions) {
            if (t.getPayer().equals("B") &&
                    t.getPayee().equals("A") &&
                    t.getAmount() == expectedAmount) {
                bPaysA = true;
            }
            if (t.getPayer().equals("C") &&
                    t.getPayee().equals("A") &&
                    t.getAmount() == expectedAmount) {
                cPaysA = true;
            }
        }

        assert tracker.transactions.size() == 2;
        assert bPaysA && cPaysA;
    }

    @Test
    void testSelfExpense() {

        String line = "A spent 25 for Snacks for A";

        ExpenseParser.parseExpenseLine(line, tracker);

        assert tracker.transactions.isEmpty();
    }

    @Test
    void testDecimalAmount() {


        String line = "A spent 12.70 for Snacks for B, C";


        ExpenseParser.parseExpenseLine(line, tracker);


        double expectedAmount = 12.70 / 2;


        boolean bPaysA = false;

        boolean cPaysA = false;

        for (Transaction t : tracker.transactions) {
            if (t.getPayer().equals("B") &&
                    t.getPayee().equals("A") &&
                    t.getAmount() == expectedAmount) {
                bPaysA = true;
            }
            if (t.getPayer().equals("C") &&
                    t.getPayee().equals("A") &&
                    t.getAmount() == expectedAmount) {
                cPaysA = true;
            }
        }


        assert tracker.transactions.size() == 2;
        assert bPaysA && cPaysA;
    }

    @Test
    void testZeroAmount() {

        String line = "A spent 0 for Snacks for B, C";

        ExpenseParser.parseExpenseLine(line, tracker);
        assertFalse(tracker.transactions.isEmpty());
    }

    @Test
    void testNegativeAmount() {

        String line = "A spent -25 for Snacks for B, C";


        ExpenseParser.parseExpenseLine(line, tracker);
        assertFalse(tracker.transactions.isEmpty());
    }

    @Test
    void testEmptyInput() {

        String line = "";

        ExpenseParser.parseExpenseLine(line, tracker);
        assertTrue(tracker.transactions.isEmpty());
    }

    @Test
    void testLargeGroup() {

        String line = "A spent 2000 for Snacks for A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z";

        ExpenseParser.parseExpenseLine(line, tracker);
        double expectedAmount = 2000.0 / 26;
        assertNotEquals(26, tracker.transactions.size());

        for (Transaction t : tracker.transactions) {
            assertTrue(t.getAmount() == expectedAmount);
        }

    }
    }




