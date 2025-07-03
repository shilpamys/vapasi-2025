public class Calculator {

    public int caldouble(int number) {
        if (number == 0) {
            throw new ArithmeticException("Number is 0");
        } else if (number < 0) {
            throw new ArithmeticException("Number is negative");

        }


        return number * 2;
    }
}