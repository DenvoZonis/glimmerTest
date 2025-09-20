package square.graphic2;

/**
 * 实际上实现接口的子类的内容和用继承父类的内容几乎一样
 */
public class Circle implements Graphic{
    private final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getPerimeter() {
        return Math.PI * radius * 2;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }
}
