
/**
 * Created by halil on 23.10.2016.
 */

/*
* This class has all common properties for all objects.*/
public abstract class Shapes {
     double x = Math.random() * 500;//x coordination of a shape.
     double y;//y coordination of a shape.
     Object Type = this.getClass().getName(); //Type of a shape.
     boolean Full_Shape; //Explaned in IShape interface.
     double distance;//Space to (0,0) point.
     String Id;//Special number for every shape.
     double area;
     String properties;

    //Constructors for crate a shape.
    public Shapes(){
        Id =((String) Type).substring(0,1)+ String.format("%04.0f", Math.random() * 9000);
        x = Math.random() * 500;
        y = Math.random() * 500;
    }

    public Shapes(Object type) {
        x = Math.random() * 500;
        y = Math.random() * 500;
        Type = type;
    }

    public Shapes(Object type, int x, int y) {
        Type = type;
        this.x = x;
        this.y = y;
    }

    //Get and set methods to use variables of the class.
    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getType() {
        return (String ) Type;
    }

    public void setType(Object type) {
        Type = type;
    }

    public void setFull_Shape(boolean full_Shape) {
        Full_Shape = full_Shape;
    }

    public boolean isFull_Shape() {
        return Full_Shape;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    //Calculates a distance to (0,0) point.
    public double distanceToCoordinateCenter(){
        double distance = getX() * getX() + getY() * getY();
        return Math.sqrt(distance);
    }

    public String shapeId(){
        return getId();
    }

    @Override
    public String toString() {
        return  "Id='" + Id + '\'' +
                ", Type=" + Type +
                ", Full_Shape=" + Full_Shape +
                ", distance=" + distance +
                ", x=" + x +
                ", y=" + y +
                '}';
    }

    //method to set informations of shapes to table/
    public String[] toArray() {
        String[] array = {getId(), getType(), Double.toString(area) ,Boolean.toString(Full_Shape), Double.toString(distance), properties};
        return array;
    }

}