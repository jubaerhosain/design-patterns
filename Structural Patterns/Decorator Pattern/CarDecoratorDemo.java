/**
 * 1. Decorator design pattern is used to modify the functionality of an object at runtime.
 * 2. Uses abstract classes or interface with composition to implement.
 * 3. The Decorator Pattern is also known as Wrapper.
 */

/**
 * They are mostly used to apply SRP (Single Responsibility Principle) as we
 * divide functionalities
 * into classes with unique concerns.
 */

// Component Interface
interface Car {
    public void assemble();
}

// Component Implementation
class BasicCar implements Car {
    @Override
    public void assemble() {
        System.out.print("Basic Car.");
    }

}

// Decorator
class CarDecorator implements Car {

    protected Car car;

    public CarDecorator(Car c) {
        this.car = c;
    }

    @Override
    public void assemble() {
        this.car.assemble();
    }

}

// Concrete Decorators
class SportsCar extends CarDecorator {

    public SportsCar(Car c) {
        super(c);
    }

    @Override
    public void assemble() {
        super.assemble();
        System.out.print(" Adding features of Sports Car.");
    }
}

class LuxuryCar extends CarDecorator {

    public LuxuryCar(Car c) {
        super(c);
    }

    @Override
    public void assemble() {
        super.assemble();
        System.out.print(" Adding features of Luxury Car.");
    }
}

public class CarDecoratorDemo {
    public static void main(String[] args) {
        Car sportsCar = new SportsCar(new BasicCar());
        sportsCar.assemble();
        System.out.println("\n*****");

        // sport and luxury car extends car through CarDecorator

        Car sportsLuxuryCar = new SportsCar(new LuxuryCar(new BasicCar()));
        Car doubleSport = new SportsCar(sportsLuxuryCar);

        sportsLuxuryCar.assemble();
        System.out.println();
        doubleSport.assemble();
    }
}