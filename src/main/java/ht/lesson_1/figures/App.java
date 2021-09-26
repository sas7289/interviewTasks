package lesson_1.figures;

public class App {
    public static void main(String[] args) {
        Triangle triangle = new Triangle(12, 10, 7);
        Rectangle rectangle = new Rectangle(17, 14);
        Round round = new Round(5);
        double roundSquare = calcSquareFigure(round);
        double rectangleSquare = calcSquareFigure(rectangle);
        double triangleSquare = calcSquareFigure(triangle);
    }

    public static double calcSquareFigure(Figure figure) {
        return figure.calcSquare();
    }
}
