package raf.ds.gerumap.painters;

import raf.ds.gerumap.gui.swing.view.modelView.MindView;
import raf.ds.gerumap.gui.swing.view.modelView.ProjectView;
import raf.ds.gerumap.notification.Notification;
import raf.ds.gerumap.repository.implementation.Topic;
import raf.ds.gerumap.repository.implementation.MindMap;

import java.awt.geom.Ellipse2D;

public class TopicPainter extends ElementPainter{

    Topic topic;

    public TopicPainter(Topic topic){
        this.element = topic;
        this.element.addSubscriber(this);
        this.shape = new Ellipse2D.Double(element.getX(), element.getY(), 100, 70);
        Ellipse2D.Double e = new Ellipse2D.Double(element.getX(), element.getY(), 100, 70);
        this.topic = topic;
        topic.setTopicShape(this.shape);
    }

    @Override
    public void update(Notification notification) {

        this.shape = new Ellipse2D.Double(element.getX(), element.getY(), 100, 70);
        this.topic.setTopicShape(this.shape);

        MindView mv = (MindView) ProjectView.getInstance().getjTabbedPane().getSelectedComponent();
        MindMap mindMap = mv.getMindModel();
        mindMap.notifySubscribers(null);
    }


}
