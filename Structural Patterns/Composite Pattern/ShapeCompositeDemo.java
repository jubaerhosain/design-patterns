
/**
 * 1. Composite pattern is a partitioning design pattern and describes a group of objects that is 
 * treated the same way as a single instance of the same type of object. The intent of a composite 
 * is to “compose” objects into tree structures to represent part-whole hierarchies.
 * 2. Allows to have a tree structure and ask each node in the tree structure to perform a task.
 * 3. Four elements
 *      a. Component
 *      b. Leaf
 *      c. Composite
 *      d. Client
 */

/**
* Composite pattern should be applied only when the group of objects should behave as the single object.
* Composite design pattern can be used to create a tree like structure.
* */

import java.util.ArrayList;
import java.util.List;

// Composite Pattern Base Component
interface Shape {
    public void draw(String fillColor);
}

// Composite Design Pattern Leaf Objects
class Triangle implements Shape {

    @Override
    public void draw(String fillColor) {
        System.out.println("Drawing Triangle with color " + fillColor);
    }

}

class Circle implements Shape {

    @Override
    public void draw(String fillColor) {
        System.out.println("Drawing Circle with color " + fillColor);
    }

}

// Composite object
class Drawing implements Shape {

    // collection of Shapes
    private List<Shape> shapes = new ArrayList<Shape>();

    @Override
    public void draw(String fillColor) {
        for (Shape sh : shapes) {
            sh.draw(fillColor);
        }
    }

    // adding shape to drawing
    public void add(Shape s) {
        this.shapes.add(s);
    }

    // removing shape from drawing
    public void remove(Shape s) {
        shapes.remove(s);
    }

    // removing all the shapes
    public void clear() {
        System.out.println("Clearing all the shapes from drawing");
        this.shapes.clear();
    }
}

public class ShapeCompositeDemo {
    public static void main(String[] args) {
        Shape tri = new Triangle();
        Shape tri1 = new Triangle();
        Shape cir = new Circle();

        Drawing drawing = new Drawing();
        drawing.add(tri1);
        drawing.add(cir);

        // drawing.draw("Red");

        // drawing.clear();

        drawing.add(tri);
        drawing.add(cir);
        // drawing.draw("Green");

        Drawing drawing2 = new Drawing();
        drawing2.add(new Triangle());
        drawing2.add(drawing);
        drawing2.draw("Blue");

    }
}