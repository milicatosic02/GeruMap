package raf.ds.gerumap.repository.implementation;

import raf.ds.gerumap.notification.ShapeType;
import raf.ds.gerumap.repository.composite.MapNode;
import raf.ds.gerumap.repository.implementation.Element;

import java.awt.*;

public class Topic extends Element {

   transient Shape topicShape;

    public Topic(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String getName() {
        return super.getName();
    }
    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public void setParent(MapNode parent) {
        super.setParent(parent);
    }

    @Override
    public MapNode getParent() {
        return super.getParent();
    }

    public Shape getTopicShape() {
        return topicShape;
    }

    public void setTopicShape(Shape topicShape) {
        this.topicShape = topicShape;
    }
}
