package raf.ds.gerumap.observer;

//import javax.management.Notification;
import javax.management.Notification;
import java.util.ArrayList;
import java.util.List;

public class IPublisherImpl implements IPublisher{

    private transient List<ISubscriber> subscribers;

    @Override
    public void addSubscriber(ISubscriber subscriber) {
        if(subscriber == null)
            return;
        if(subscribers == null)
            subscribers = new ArrayList<>();
        if(!(subscribers.contains(subscriber)))
            subscribers.add(subscriber);
        return;
    }

    @Override
    public void notifySubscribers(raf.ds.gerumap.notification.Notification notification) {
        if(subscribers == null || subscribers.isEmpty()) {
            return;
        }
        for(ISubscriber subscriber : subscribers) {
            subscriber.update(notification);
        }
        return;
    }

    @Override
    public int countSubscribers() {
        if(subscribers == null || subscribers.size() < 1)
            return 0;
        return subscribers.size();
    }

    public List<ISubscriber> getSubscribers() {
        return subscribers;
    }

}
