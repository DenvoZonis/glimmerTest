package square;

import square.graphic.Circle;
import square.graphic.Graphic;
import square.graphic.Rectangle;
import square.graphic.Triangle;

public class Main {
    public static void main(String[] args) {
        double radius = 2;   //圆的半径
        double a = 3, b = 4, c = 5;   //三角形三条边的边长
        double width = 6, height = 7;   //矩形的长和宽

        //用继承的方式
        Graphic graphic = new Circle(radius);
        System.out.printf("半径为%.3f的圆的周长为%.3f，面积为%.3f\n", radius, graphic.getPerimeter(), graphic.getArea());
        graphic = new Triangle(a, b, c);
        System.out.printf("三边分别为%.3f,%.3f,%.3f的三角形的周长为%.3f，面积为%.3f\n", a, b, c, graphic.getPerimeter(), graphic.getArea());
        graphic = new Rectangle(width, height);
        System.out.printf("长为%.3f,宽为%.3f的矩形的周长为%.3f，面积为%.3f\n", width, height, graphic.getPerimeter(), graphic.getArea());

        //用接口的方式
        square.graphic2.Graphic graphic2 = new square.graphic2.Circle(radius);
        System.out.printf("半径为%.3f的圆的周长为%.3f，面积为%.3f\n", radius, graphic2.getPerimeter(), graphic2.getArea());
        graphic2 = new square.graphic2.Triangle(a, b, c);
        System.out.printf("三边分别为%.3f,%.3f,%.3f的三角形的周长为%.3f，面积为%.3f\n", a, b, c, graphic2.getPerimeter(), graphic2.getArea());
        graphic2 = new square.graphic2.Rectangle(width, height);
        System.out.printf("长为%.3f,宽为%.3f的矩形的周长为%.3f，面积为%.3f\n", width, height, graphic2.getPerimeter(), graphic2.getArea());
    }
}
