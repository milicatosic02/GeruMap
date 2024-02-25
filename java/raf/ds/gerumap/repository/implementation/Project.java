package raf.ds.gerumap.repository.implementation;

import raf.ds.gerumap.gui.swing.view.MainFrame;
import raf.ds.gerumap.notification.Notification;
import raf.ds.gerumap.notification.NotificationCode;
import raf.ds.gerumap.repository.composite.MapNode;
import raf.ds.gerumap.repository.composite.MapNodeComposite;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.nio.charset.MalformedInputException;


public class Project extends MapNodeComposite{

    private String authorName;
    private String filePath;
    protected boolean changed = true;

    public Project(String name, MapNode parent){

        super(name,parent);
    }

    @Override
    public void sendMessage(Notification notification) {
       notifySubscribers(notification);
    }

    @Override
    public void addChild(MapNode child) {
        if(child != null && child instanceof MindMap){
            MindMap mindMap = (MindMap) child;
            if(!this.getChildren().contains(mindMap)) {
                this.getChildren().add(mindMap);
                sendMessage(new Notification(NotificationCode.ADD_CHILD, mindMap));
            }
        }
    }

    @Override
    public void removeChild(MapNode child) {
        if (child != null && child instanceof MindMap) {
            MindMap mindMap = (MindMap) child;
            if(this.getChildren().contains(mindMap)) {
                this.getChildren().remove(mindMap);
            }
        }
        sendMessage(new Notification(NotificationCode.DELETE_CHILD, this));
    }


    public void setAuthorName(String authorName) {

        this.authorName = authorName;
        changed = true;
    }


    public String getAuthorName() {
        return authorName;
    }

    public String getFilePath() {
        return filePath;
    }

    public boolean isChanged() {
        return changed;
    }

    public void setChanged(boolean changed) {
        this.changed = changed;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
