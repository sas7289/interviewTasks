package lesson_1.figures;

public class Round extends Figure{
    private double r;

    public Round(double r) {
        this.r = r;
    }

    @Override
    double calcSquare() {
        return 3.14 * r * r;
    }
}
