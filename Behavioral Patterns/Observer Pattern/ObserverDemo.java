
import java.util.ArrayList;
import java.util.List;

/**
 * Define a one-to-many dependency between objects so that when one object
 * changes state,
 * all its dependents are notified and updated automatically.
 */

/**
 * This design pattern has 3 main components:
 * 
 * 1. Subject - This can be an interface or an abstract class that defines
 * operations for attaching (registerObserver()) and detaching the observers
 * (removeObserver()) to the subject.
 * 2. Concrete Subject - This is a concrete class of the Subject. This maintains
 * the object state and whenever any change occurs in that state, the observers
 * are notified about it using notifyObservers() method.
 * 3. Observer - This is an interface or an abstract class that defines the
 * operations for notifying this object (update()). One real work example of
 * this pattern is Facebook or Twitter. Whenever a person updates the status,
 * all the followers would get a notification about his update. An observer can
 * get the notification of the subject as long as it is subscribed or keeping
 * track of it.
 * 
 */

interface Subject {

    // methods to register and unregister observers
    public void register(Observer obj);

    public void unregister(Observer obj);

    // method to notify observers of change
    public void notifyObservers(String msg);

}

interface Observer {

    // method to update the observer, used by subject
    public void update(String msg);
}

class MyTopic implements Subject {

    private List<Observer> observers;
    private boolean changed;
    private final Object MUTEX = new Object();

    public MyTopic() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void register(Observer obj) {
        if (obj == null)
            throw new NullPointerException("Null Observer");
        synchronized (MUTEX) {
            if (!observers.contains(obj))
                observers.add(obj);
        }
    }

    @Override
    public void unregister(Observer obj) {
        synchronized (MUTEX) {
            observers.remove(obj);
        }
    }

    @Override
    public void notifyObservers(String msg) {
        List<Observer> observersLocal = null;
        // synchronization is used to make sure any observer registered after message is
        // received is not notified
        synchronized (MUTEX) {
            if (!changed)
                return;
            observersLocal = new ArrayList<>(this.observers);
            this.changed = false;
        }
        for (Observer obj : observersLocal) {
            obj.update(msg);
        }

    }

    // method to post message to the topic
    public void postMessage(String msg) {
        System.out.println("Message Posted to Topic:" + msg);
        this.changed = true;
        notifyObservers(msg);
    }

}

class MyTopicSubscriber implements Observer {

    private String name;

    public MyTopicSubscriber(String nm) {
        this.name = nm;
    }

    @Override
    public void update(String msg) {

        if (msg == null) {
            System.out.println(name + ":: No new message");
        } else
            System.out.println(name + ":: Consuming message::" + msg);
    }

}

public class ObserverDemo {
    public static void main(String[] args) {
        // create subject
        MyTopic topic = new MyTopic();

        // create observers
        Observer obj1 = new MyTopicSubscriber("Obj1");
        Observer obj2 = new MyTopicSubscriber("Obj2");
        Observer obj3 = new MyTopicSubscriber("Obj3");

        // register observers to the subject
        topic.register(obj1);
        topic.register(obj2);
        topic.register(obj3);

        // now send message to subject
        topic.postMessage("New Message");

        topic.postMessage("Hi hello");
    }
}