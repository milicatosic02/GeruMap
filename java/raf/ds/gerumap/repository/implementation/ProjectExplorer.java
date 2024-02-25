package raf.ds.gerumap.repository.implementation;

import raf.ds.gerumap.notification.Notification;
import raf.ds.gerumap.notification.NotificationCode;
import raf.ds.gerumap.repository.composite.MapNode;
import raf.ds.gerumap.repository.composite.MapNodeComposite;

import java.io.File;

public class ProjectExplorer extends MapNodeComposite {

    public ProjectExplorer(String name){
        super(name, null);
    }

    @Override
    public void sendMessage(Notification notification) {
        notifySubscribers(notification);
    }

    @Override
    public void addChild(MapNode child){
        if (child != null && child instanceof  Project){
            Project project = (Project) child;
            if(!this.getChildren().contains(project)){
                this.getChildren().add(project);
                sendMessage(new Notification(NotificationCode.NEW_PROJECT, project));
            }
        }
    }

    @Override
    public void removeChild(MapNode child) {
        if (child != null && child instanceof Project) {
            Project project = (Project) child;
            if(this.getChildren().contains(project))
                this.getChildren().remove(project);
        }
        sendMessage(new Notification(NotificationCode.DELETE_CHILD, this));
    }
}
