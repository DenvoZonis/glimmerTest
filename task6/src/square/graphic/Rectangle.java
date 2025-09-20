package square.graphic;

public class Rectangle extends Graphic {
    private final double width, height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double getPerimeter() {
        return  2 * (width + height);
    }

    @Override
    public double getArea() {
        return width * height;
    }
}
