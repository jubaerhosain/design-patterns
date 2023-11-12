/**
 * 1. Provide a unified and simplified interface to a set of interfaces in a
 * subsystem, therefore it hides the complexities of the subsystem from the
 * client
 * 2. This pattern involves a single class which provides simplified methods
 * required by client and delegates calls to methods of existing system classes.
 * 3. Practically, every Abstract Factory is a type of Facade.
 * 4. Provide a wrapper interface on top of the existing interface to help client application.
 */

interface Shape {
   void draw();
}

class Rectangle implements Shape {
   @Override
   public void draw() {
      System.out.println("Rectangle::draw()");
   }
}

class Square implements Shape {

   @Override
   public void draw() {
      System.out.println("Square::draw()");
   }
}

class Circle implements Shape {

   @Override
   public void draw() {
      System.out.println("Circle::draw()");
   }
}

// Facade class
class ShapeMaker {
   private Shape circle;
   private Shape rectangle;
   private Shape square;

   public ShapeMaker() {
      circle = new Circle();
      rectangle = new Rectangle();
      square = new Square();
   }

   public void drawCircle() {
      circle.draw();
   }

   public void drawRectangle() {
      rectangle.draw();
   }

   public void drawSquare() {
      square.draw();
   }
}

public class ShapeFacadeDemo {
   public static void main(String[] args) {
      ShapeMaker shapeMaker = new ShapeMaker();

      shapeMaker.drawCircle();
      shapeMaker.drawRectangle();
      shapeMaker.drawSquare();
   }
}
