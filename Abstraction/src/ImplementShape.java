import java.util.concurrent.TransferQueue;

class Circle extends Shape {
    double radius;
    double area;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double calculateArea() {
        return Math.PI * radius * radius;

    }

    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }
}

class Triangle extends Shape {
    double height;
    double a;
    double b;
    double c;


    Triangle(double a, double b, double c, double height) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.height = height;
    }

    public double calculateArea() {

        return (a * b) / 2;
    }

    public double calculatePerimeter() {
        return a + b + c;
    }

}

class Rectangle extends Shape {
    double width;
    double length;

    Rectangle(double width, double length) {
        this.length = length;
        this.width = width;
    }

    public double calculateArea() {
        return width * length;
    }

    public double calculatePerimeter() {
        return (width + length) * 2;
    }

}