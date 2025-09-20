package square.graphic2;

/**
 * 实际上实现接口的子类的内容和用继承父类的内容几乎一样
 */
public class Rectangle implements Graphic {
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
