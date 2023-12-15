/**
 * The Proxy Design Pattern provides an object representing another object.
 * It acts as an intermediary or placeholder, controlling access to the real
 * object.
 * This can be useful for various purposes, such as "controlling access", "logging",
 * caching, or
 * "delaying the instantiation" or "azy initialization" of the real object until it is actually needed.
 * 
 */

/**
 * The Proxy pattern typically consists of three key components:
 * 
 * 1. Subject: An interface or an abstract class that defines the common
 * interface between the Proxy and the Real Subject.
 * 
 * 2. Real Subject: The actual object that the Proxy represents. It contains the
 * real implementation of the functionality we want to access.
 * 
 * 3. Proxy: The surrogate object that implements the same interface as the Real
 * Subject. The Proxy controls and manages access to the Real Subject and can
 * add additional behavior as needed.
 */

interface Image {
    void display();
}

class RealImage implements Image {
    private String filename;

    public RealImage(String filename) {
        this.filename = filename;
        loadImageFromDisk();
    }

    private void loadImageFromDisk() {
        System.out.println("Loading image: " + filename);
    }

    public void display() {
        System.out.println("Displaying image: " + filename);
    }
}

class ProxyImage implements Image {
    private RealImage realImage;
    private String filename;

    public ProxyImage(String filename) {
        this.filename = filename;
    }

    public void display() {
        if (realImage == null) {
            realImage = new RealImage(filename);
        }
        realImage.display();
    }
}

public class ImageProxy {
    public static void main(String[] args) {
        Image image1 = new ProxyImage("image1.jpg");

        // The real image is loaded and displayed only when needed
        image1.display();

        // The real image has already been loaded, so it won't be loaded again
        image1.display();

        Image image2 = new ProxyImage("image2.jpg");
        image2.display();
    }
}
