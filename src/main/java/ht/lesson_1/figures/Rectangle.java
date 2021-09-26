package lesson_1.figures;

public class Rectangle extends Figure{
    private double a;
    private double b;

    public Rectangle(double a, double b) {
        this.a = a;
        this.b = b;
    }

    @Override
    double calcSquare() {
        return a * b;
    }
}
