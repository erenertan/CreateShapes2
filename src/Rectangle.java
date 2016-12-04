

/**
 * Created by halil on 23.10.2016.
 */
public class Rectangle extends Shapes implements IShape{

    private double width = Math.random() * 200 + 1;//Width of a rectangle.
    private double height = Math.random() * 200 + 1;//Height of a rectangle.
    private double area = width * height;//Area of a rectangle.

    //Constructors to create a rectangle objects.
    public Rectangle() {
        super();
        distance = distanceToCoordinateCenter();
        Full_Shape = isFullShape();
        super.area = this.area;
        super.properties = propertiesOfShape();
    }

    public Rectangle(Object type) {
        super(type);
    }


    //Sets and gets method to use properties of objects.
    public double getWidth() {
        return width;
    }

    public void setWidth(double with) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
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
        return distanceToCoordinateCenter() > (getHeight() + getWidth());
    }

    @Override
    public String thisIsa(IShape shape) {
        return "rectangle";
    }

    @Override
    public String getObjectName() {
        return "rectangle";
    }

    @Override
    public String propertiesOfShape() {
        return "The width is: " +  String.format("%.3f",getWidth())+ " " +
                "The height is: " + String.format("%.3f",getHeight());
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