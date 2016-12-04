/**
 * Created by halil on 23.10.2016.
 */
public class Circle extends Shapes implements  IShape{

    private double radius;//Radius of a circle.
    private double area;//Area of a circle.

    //Constructor to create a circle objects.
    public Circle() {
        super();
        distance = distanceToCoordinateCenter();
        Full_Shape = isFullShape();
        radius = Math.random() * 200 + 1;
        area = radius * 3.14;
        super.area = this.area;
        super.properties = propertiesOfShape();
    }

    public Circle(Object type) {
        super(type);
    }

    //Sets and gets methods to use properties.
    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }


    @Override
    public double area() {
        return area;
    }

    @Override
    public boolean isFullShape() {
        return distanceToCoordinateCenter() > radius;
    }

    @Override
    public String thisIsa(IShape shape) {
        return "circle";
    }

    @Override
    public String getObjectName() {
        return "circle";
    }

    @Override
    public String propertiesOfShape() {
        return "The radius of the circle is: " + String.format("%.3f",getRadius());
    }

    @Override
    public String toString() {
        return getId() + "     " +
                getObjectName() + "   " +
                String.format("%.3f",getArea())+ "      " +
                isFullShape() + "           " +
                String.format("%.3f",getDistance()) + "            " +
                propertiesOfShape() + '\n';
    }
}