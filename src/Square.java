/**
 * Created by halil on 23.10.2016.
 */
public class Square extends Shapes implements IShape {

    private double edge; //Length of a side of square.
    private double area;//Area of a square.

    //Constructors to create square objects.
    public Square() {
        super();
        distance = distanceToCoordinateCenter();
        Full_Shape = isFullShape();
        edge = Math.random()*200 + 1;
        area = edge * edge;
        super.area = this.area;
        super.properties = propertiesOfShape();
    }

    public Square(Object type, double edge) {
        super(type);
        this.edge = edge;
    }

    public Square(Object type, int x, int y, double edge) {
        super(type, x, y);
        this.edge = edge;
    }

    //Sets and gets methods to use properties.
    public double getEdge() {
        return edge;
    }

    public void setEdge(double edge) {
        this.edge = edge;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    @Override
    public double area() {
        double area = edge * edge;
        setArea(area);
        return area;
    }

    @Override
    public boolean isFullShape() {
        return getDistance() > getEdge();
    }

    //Gives type of the objects as string.
    @Override
    public String thisIsa(IShape shape) {
        return "square";
    }

    @Override
    public String getObjectName() {
        return "square";
    }

    @Override
    public String propertiesOfShape() {
        return "The size of the square: " + String.format("%.3f",getEdge());
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