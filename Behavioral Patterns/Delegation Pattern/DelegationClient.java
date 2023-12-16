/**
 * Aims to separate responsibility and improve flexibility. It works by allowing
 * an object to delegate a task to another helper object, instead of performing
 * the task itself.
 */

/**
 * Key Elements:
 * 
 * 1. Delegate: This is the object that receives the request and decides whether
 * to handle it itself or delegate it to another object.
 * 2. Helper Object: This is the object responsible for actually performing the
 * delegated task.
 * 3. Interface: This defines the common contract between the delegate and the
 * helper object, ensuring compatibility and flexibility.
 */

// Delegate interface
interface Printer {
    void print(String message);
}

// Delegate implementation
class ConsolePrinter implements Printer {
    @Override
    public void print(String message) {
        System.out.println("Printing to console: " + message);
    }
}

// Delegator class
class PrintManager implements Printer {
    private Printer delegate;

    // Setter method for setting the delegate
    public void setDelegate(Printer delegate) {
        this.delegate = delegate;
    }

    // Delegated method
    @Override
    public void print(String message) {
        // Delegating the print operation to the delegate
        if (delegate != null) {
            delegate.print(message);
        }
    }
}

// Client code
public class DelegationClient {
    public static void main(String[] args) {
        // Create a PrintManager instance
        PrintManager printManager = new PrintManager();

        // Set the delegate to ConsolePrinter
        printManager.setDelegate(new ConsolePrinter());

        // Delegated print operation
        printManager.print("Hello, Delegation Pattern!");
    }
}
