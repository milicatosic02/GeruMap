package raf.ds.gerumap.repository.implementation;

import raf.ds.gerumap.repository.composite.MapNode;
import raf.ds.gerumap.repository.implementation.Element;
import raf.ds.gerumap.repository.implementation.Topic;

public class Veza extends Element {

   Topic startTopic;
   Topic endTopic;

    public Veza(int x ,int y,int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }


    public Topic getStartTopic() {
        return startTopic;
    }

    public void setStartTopic(Topic startTopic) {
        this.startTopic = startTopic;
    }

    public Topic getEndTopic() {
        return endTopic;
    }

    public void setEndTopic(Topic endTopic) {
        this.endTopic = endTopic;
    }
}
