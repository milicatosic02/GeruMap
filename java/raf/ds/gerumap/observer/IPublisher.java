package raf.ds.gerumap.observer;

import raf.ds.gerumap.notification.Notification;

public interface IPublisher {

    void addSubscriber(ISubscriber subscriber);
    void notifySubscribers(Notification notification);

    int countSubscribers();


}
