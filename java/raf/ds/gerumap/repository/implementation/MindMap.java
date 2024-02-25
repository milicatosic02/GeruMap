package raf.ds.gerumap.repository.implementation;

import raf.ds.gerumap.gui.swing.view.modelView.MindView;
import raf.ds.gerumap.notification.Notification;
import raf.ds.gerumap.notification.NotificationCode;
import raf.ds.gerumap.repository.command.CommandManager;
import raf.ds.gerumap.repository.composite.MapNode;
import raf.ds.gerumap.repository.composite.MapNodeComposite;

public class MindMap extends MapNodeComposite {

    private transient CommandManager commandManager;

    public MindMap(String name, MapNode parent, CommandManager commandManager) {

        super(name, parent);
        this.commandManager = commandManager;
    }


   @Override
    public void addChild(MapNode child) {
       if(child != null && child instanceof Element){
           Element element = (Element) child;
           if(!this.getChildren().contains(element)){
               this.getChildren().add(element);
              // sendMessage(new Notification(NotificationCode.ADD_CHILD, this));
               notifySubscribers(null);
           }
       }
    }

    @Override
    public void removeChild(MapNode child) {
        if (child != null && child instanceof Element) {
            Element element = (Element) child;
            if(this.getChildren().contains(element))
                this.getChildren().remove(element);
            notifySubscribers(null);
        }
      //  sendMessage(new Notification(NotificationCode.DELETE_CHILD, this));
    }

    public CommandManager getCommandManager() {
        return commandManager;
    }

    public void setCommandManager(CommandManager commandManager) {
        this.commandManager = commandManager;
    }
}

