//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Laptop l1 = new Laptop("Mac Book Air", 16, "Intel M1");
        Laptop l2 = new Laptop("MacBook Pro", 32, "Apple M2");
        l1.displayInfo();
        l2.displayInfo();


    }
}