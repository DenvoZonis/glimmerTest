package square.graphic2;

/**
 * 实际上实现接口的子类的内容和用继承父类的内容几乎一样
 */
public class Triangle implements Graphic {
    private final double a, b, c;

    /**
     * 使用三边的边长来创建一个三角形。注意此处没有验证输入边长的有效性
     * @param a 其中一个边的长度
     * @param b 其中一个边的长度
     * @param c 其中一个边的长度
     */
    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double getPerimeter() {
        return a + b + c;
    }

    @Override
    public double getArea() {
        //使用海伦公式
        double p = (a + b + c) / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }
}
