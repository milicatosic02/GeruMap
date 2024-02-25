package raf.ds.gerumap.message;

import raf.ds.gerumap.core.MessageGeneratorInterface;
import raf.ds.gerumap.notification.Notification;
import raf.ds.gerumap.observer.IPublisherImpl;

import java.sql.Timestamp;

public class MessageGeneratorImpl extends IPublisherImpl implements MessageGeneratorInterface {

    private String type;
    private String text;
    private Timestamp timestamp;

    public MessageGeneratorImpl(){
        type = new String();;
        timestamp = new Timestamp(System.currentTimeMillis());
        text = new String();
    }


    @Override
    public void generateMessage(Notification notification) {
        this.notifySubscribers(notification);
    }

    public String getText() {
        return text;
    }

    public String getType() {
        return type;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }
}
