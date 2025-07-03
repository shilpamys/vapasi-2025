import java.util.Scanner;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or

// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.

        System.out.print("Enter  number: ");
        Scanner scan = new Scanner(System.in);
        int userInput = scan.nextInt();

        Calculator cal = new Calculator();

        try {

            int result = cal.caldouble(userInput);
            System.out.println(result);

        } catch (ArithmeticException e) {
            System.out.println(e.getLocalizedMessage());
        }

    }
}