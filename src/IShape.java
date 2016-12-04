

public interface IShape {

    // area of a shape
    double area();

    // distance between (0,0) and the point used to draw a shape

    //I used this methods in abstract class because this methods can be used same in every class.
    //double distanceToCoordinateCenter();

    //rectangle is a full shape if: distanceToCoordinateCenter() > w+h
    //circle is a full shape if: distanceToCoordinateCenter() > r
    //square is a full shape if: distanceToCoordinateCenter() > w
    // w is width, r is radius, h is height

    boolean isFullShape();
    // returns "circle", "rectangle" or "square"

    String thisIsa(IShape shape);

    String getObjectName();

    // Returns data such as: width, radius and size(if it is a squar) etc.
    String propertiesOfShape( );

    // Retuns shape ID.

    //I used this methods in abstract class because this methods can be used same in every class.
    //String shapeId();


}