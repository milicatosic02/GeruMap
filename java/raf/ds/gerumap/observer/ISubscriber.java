package raf.ds.gerumap.observer;


import raf.ds.gerumap.notification.Notification;

public interface ISubscriber {
    void update(Notification notification);
}
