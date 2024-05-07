package Low_Level_Design.Design_Patterns.Creational.prototype;


import java.util.ArrayList;


// Base prototype.
abstract class Shape{
    int X;
    int Y;
    private String color;

    Shape(){}

    // The prototype constructor. A fresh object is initialized
    // with values from the existing object.
    Shape(Shape source){
       this();
       this.X = source.X;
       this.Y = source.Y;
       this.color = source.color;
    }

    // The clone operation returns one of the Shape subclasses.
    abstract public Shape copy();

}

// Concrete prototype. The cloning method creates a new object
// in one go by calling the constructor of the current class and
// passing the current object as the constructor's argument.
// Performing all the actual copying in the constructor helps to
// keep the result consistent: the constructor will not return a
// result until the new object is fully built; thus, no object
// can have a reference to a partially-built clone.
class Rectangle extends Shape{

    private int width;
    private int height;
    private String color;

    Rectangle(Rectangle source){
        // A parent constructor call is needed to copy private
        // fields defined in the parent class.
        super(source);
        this.width = source.width;
        this.height = source.height;
        this.color = source.color;
    }

    //to initialize object when fields are private
    Rectangle(int width, int height, String color){
        this.width = width;
        this.height = height;
        this.color = color;
    }


    @Override
    public Shape copy() {
        return new Rectangle(this);
    }
}


class Circle extends Shape{

    private int radius;
    private String color;

    Circle(Circle source){
        super(source);
        this.radius = source.radius;
        this.color = source.color;
    }

    Circle(int radius, String color){
        this.radius = radius;
        this.color = color;
    }

    @Override
    public Shape copy() {
        return new Circle(this);
    }
}





public class PrototypeClient {

    public static ArrayList<Shape> shapeList = new ArrayList<>();

    PrototypeClient(){
        //initializing few objects to clone for client
        // works like PrototypeRegistry

        Rectangle rectangle1 = new Rectangle(20, 30, "red");
        Rectangle rectangle2 = new Rectangle(30, 10, "blue");

        Circle circle1 = new Circle(10, "red");
        Circle circle2 = new Circle(5, "blue");

        shapeList.add(rectangle1);
        shapeList.add(rectangle2);
        shapeList.add(circle1);
        shapeList.add(circle2);

    }

    public static void main(String[] args) throws Exception {

        // For instance, we don't know the exact elements in the
        // shapes array. All we know is that they are all
        // shapes. But thanks to polymorphism, when we call the
        // `clone` method on a shape the program checks its real
        // class and runs the appropriate clone method defined
        // in that class. That's why we get proper clones
        // instead of a set of simple Shape objects.

        System.out.println("starting cloning process from available shapes in shape list");

        ArrayList<Shape> shapeListCopy = new ArrayList<>();

        for (Shape s : shapeList) {
            shapeListCopy.add(s.copy());
        }

        System.out.println("cloning completed");
    }


}
