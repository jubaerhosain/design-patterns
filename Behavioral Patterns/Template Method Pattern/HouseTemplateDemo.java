/**
 * Template method defines the steps to execute an algorithm, and it can provide
 * default implementation
 * that might be common for all or some of the subclasses.
 * Just define the skeleton of a function in an operation, deferring some steps
 * to its subclasses.
 * Template Method design pattern is used to create a method stub and deferring
 * some of the steps of implementation to the subclasses.
 */

// Template Method Abstract Class
abstract class HouseTemplate {

    // template method, final so subclasses can't override
    public final void buildHouse() {
        buildFoundation();
        buildPillars();
        buildWalls();
        buildWindows();
        System.out.println("House is built.");
    }

    // default implementation
    private void buildWindows() {
        System.out.println("Building Glass Windows");
    }

    // methods to be implemented by subclasses
    public abstract void buildWalls();

    public abstract void buildPillars();

    private void buildFoundation() {
        System.out.println("Building foundation with cement,iron rods and sand");
    }
}

// Template Method Concrete Classes

class WoodenHouse extends HouseTemplate {

    @Override
    public void buildWalls() {
        System.out.println("Building Wooden Walls");
    }

    @Override
    public void buildPillars() {
        System.out.println("Building Pillars with Wood coating");
    }

}

class GlassHouse extends HouseTemplate {

    @Override
    public void buildWalls() {
        System.out.println("Building Glass Walls");
    }

    @Override
    public void buildPillars() {
        System.out.println("Building Pillars with glass coating");
    }

}

// Template Method Design Pattern Client
// class HousingClient {

// public static void main(String[] args) {

// HouseTemplate houseType = new WoodenHouse();

// //using template method
// houseType.buildHouse();
// System.out.println("************");

// houseType = new GlassHouse();

// houseType.buildHouse();
// }

// }

public class HouseTemplateDemo {
    public static void main(String[] args) {

        HouseTemplate houseType = new WoodenHouse();

        // using template method
        houseType.buildHouse();
        System.out.println("************");

        houseType = new GlassHouse();

        houseType.buildHouse();
    }
}