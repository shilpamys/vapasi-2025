//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.

        Circle c = new Circle(2);
        Triangle t = new Triangle(1, 2, 3, 4);
        Rectangle r = new Rectangle(2, 4);

        System.out.println("Circle Area " + c.calculateArea());
        System.out.println("Circle Perimeter: " + c.calculatePerimeter());

        System.out.println("Triangle Area: " + t.calculateArea());
        System.out.println("Triangle Perimeter: " + t.calculatePerimeter());

        System.out.println("Rectangle Area: " + r.calculateArea());
        System.out.println("Rectangle Perimeter: " + r.calculatePerimeter());

    }
}