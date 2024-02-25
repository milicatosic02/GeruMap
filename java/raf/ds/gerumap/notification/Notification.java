package raf.ds.gerumap.notification;

public class Notification {

    private NotificationCode notificationCode;
    private Object object;

    public Notification(NotificationCode notificationCode, Object object){
        this.notificationCode = notificationCode;
        this.object = object;
    }

    public Notification(){

    }

    public NotificationCode getNotificationCode() {
        return notificationCode;
    }

    public Object getObject() {
        return object;
    }
}
