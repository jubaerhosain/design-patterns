import java.util.Observable;
import java.util.Observer;

// Subject (Observable)
class NewsAgency extends Observable {
    private String news;

    public void setNews(String news) {
        this.news = news;
        setChanged(); // Marks the Observable object as changed
        notifyObservers(news); // Notifies all registered Observers
    }

    public String getNews() {
        return news;
    }
}

// Observer
class NewsChannel implements Observer {
    private String news;

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof NewsAgency) {
            this.news = (String) arg;
            displayNews();
        }
    }

    public void displayNews() {
        System.out.println("News Channel: " + news);
    }
}

// Client code
public class JavaObserver {
    public static void main(String[] args) {
        // Create an Observable (Subject)
        NewsAgency newsAgency = new NewsAgency();

        // Create Observers (Subscribers)
        NewsChannel newsChannel1 = new NewsChannel();
        NewsChannel newsChannel2 = new NewsChannel();

        // Register Observers with the Observable
        newsAgency.addObserver(newsChannel1);
        newsAgency.addObserver(newsChannel2);

        // Set news in the NewsAgency, which triggers notifications to Observers
        newsAgency.setNews("Breaking News: Observer Pattern Implemented!");

        // Unregister one Observer
        newsAgency.deleteObserver(newsChannel1);

        // Set more news
        newsAgency.setNews("Another Breaking News: Observer Pattern Updated!");
    }
}
