/** 
 1. Allows two or more previously incompatible objects to interact
 2. Provide the interface according to client requirement while using the services of a class with a 
 different interface.
 3. The Adapter Pattern is also known as Wrapper.
*/

// Pen 
interface Pen {
    void write(String string);
}

class NormalPen implements Pen {
    @Override
    public void write(String string) {
        System.out.println(string);
    }
}

// PilotPen
interface PilotPen {
    void mark(String mark);
}

class RedPilotPen implements PilotPen {
    @Override
    public void mark(String mark) {
        System.out.println(mark);
    }

}

// Assignment
class Assignment {
    private Pen pen;

    public Assignment(Pen pen) {
        this.pen = pen;
    }

    public void writeAssignment(String assignment) {
        this.pen.write(assignment);
    }
}

// Adapter
class PenAdapter implements Pen {
    PilotPen pilotPen = new RedPilotPen();

    @Override
    public void write(String string) {
        System.out.print("Using adpter: ");
        pilotPen.mark(string);
    }

}

public class PenAdapterDemo {
    public static void main(String[] args) {

        Assignment assignment = new Assignment(new NormalPen());
        assignment.writeAssignment("Normal pen assignment");

        // Incompatible type of RedPilotPen
        // Assignment assignment1 = new Assignment(new RedPilotPen());
        // assignment.writeAssignment("Normal pen assignment");

        Assignment assignment2 = new Assignment(new PenAdapter());
        assignment2.writeAssignment("Red pilot pen assignment");
    }
}