/**
 * The Bridge pattern "decouples an abstraction from its implementation" so that
 * the two can vary independently.
 * It involves creating a bridge interface, which acts as a bridge between the
 * abstraction (high-level components)
 * and the implementation (low-level components).
 * This pattern is useful when you want to avoid a permanent binding between an
 * abstraction and its implementation
 * and allow them to evolve separately.
 * 
 * Bridge between the Abstraction and the Implementation
 *
 * Lets to split large class or closely related classes into 2 hierarchies -
 * abstraction and implementation.
 * These hierarchies are independent of each other and are used whenever we need
 * to decouple an abstraction from
 * implementation. This is called a Bridge pattern because it acts as a bridge
 * between the abstract class and
 * the implementation class
 */

/**
 * There are 4 main elements of Bridge Pattern. They are:
 * 
 * 1. Abstraction – This is the core of the pattern and it defines its crux. This
 * contains a reference to the implementer.
 * 2. Refined Abstraction – This extends the abstraction and takes refined details
 * of the requirements and hides it from the implementors.
 * 3. Implementer – This is the interface for the implementation classes.
 * 4. Concrete Implementation – These are the concrete implementation classes that
 * implement the Implementer interface.
 */

// Abstraction
interface Shape {
    void draw();
}

// Implementor (Bridge Interface)
interface DrawingAPI {
    void drawCircle(int x, int y, int radius);
}

// Concrete Implementor
class DrawingAPI1 implements DrawingAPI {
    @Override
    public void drawCircle(int x, int y, int radius) {
        System.out.println("API1.circle at " + x + ':' + y + ' ' + radius);
    }
}

// Concrete Implementor
class DrawingAPI2 implements DrawingAPI {
    @Override
    public void drawCircle(int x, int y, int radius) {
        System.out.println("API2.circle at " + x + ':' + y + ' ' + radius);
    }
}

// Refined Abstraction
class Circle implements Shape {
    private final int x, y, radius;
    private final DrawingAPI drawingAPI;

    public Circle(int x, int y, int radius, DrawingAPI drawingAPI) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.drawingAPI = drawingAPI;
    }

    @Override
    public void draw() {
        drawingAPI.drawCircle(x, y, radius);
    }
}

public class CircleBridgeExample {
    public static void main(String[] args) {
        DrawingAPI api1 = new DrawingAPI1();
        DrawingAPI api2 = new DrawingAPI2();

        Shape circle1 = new Circle(1, 2, 3, api1);
        Shape circle2 = new Circle(5, 7, 11, api2);

        circle1.draw();
        circle2.draw();
    }
}
