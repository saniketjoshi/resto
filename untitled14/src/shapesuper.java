class Shape
{
     void draw();
     double calculateArea();
}

class Circle extends Shape
{
    double radius;
    Circle(double radius)
    {
        this.radius = radius;
    }
    void draw()
    {
        System.out.println("Drawing a Circle");
    }
    double calculateArea()
    {
        return Math.PI * radius * radius;
    }
}
class Cylinder extends Circle
{
    double height;
    Cylinder(double radius, double height)
    {
        super(radius);
        this.height = height;
    }
    void draw()
    {
        System.out.println("Drawing a Cylinder");
    }
    double calculateArea()
    {
        return 2 * Math.PI * radius * (radius + height);
    }
}
public class shapesuper
{
    public static void main(String[] args)
    {
        Shape circle = new Circle(5);
        circle.draw();
        System.out.println("Circle Area: " + circle.calculateArea());

        Shape cylinder = new Cylinder(5, 10);
        cylinder.draw();
        System.out.println("Cylinder Surface Area: " + cylinder.calculateArea());
    }
}