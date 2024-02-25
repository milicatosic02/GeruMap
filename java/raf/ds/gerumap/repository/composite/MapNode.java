package raf.ds.gerumap.repository.composite;

import lombok.ToString;
import raf.ds.gerumap.notification.Notification;
import raf.ds.gerumap.observer.IPublisherImpl;

import java.util.Objects;


public abstract class MapNode extends IPublisherImpl {

    private String name;
    @ToString.Exclude
    private transient MapNode parent;

    public Integer count = 1;

    public MapNode (String name, MapNode parent){
        this.name = name;
        this.parent = parent;
    }

    public MapNode(){}


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MapNode mapNode = (MapNode) o;
        return Objects.equals(name, mapNode.name) && Objects.equals(parent, mapNode.parent);
    }


    /**
     * Pozivace se kad treba model nesto da obvesti svoj view.
     */
    public void sendMessage(Notification notification) {
        notifySubscribers(notification);
    }

    /**
     * Svi sem projectExplorer-a treba da override ovu metodu.
     */


    public MapNode getParent() {
        return parent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setParent(MapNode parent) {
        this.parent = parent;
    }
}
