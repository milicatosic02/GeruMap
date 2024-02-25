package raf.ds.gerumap.state.actions;

import raf.ds.gerumap.gui.swing.tree.model.MapTreeItem;
import raf.ds.gerumap.gui.swing.view.MainFrame;
import raf.ds.gerumap.gui.swing.view.modelView.MindView;
import raf.ds.gerumap.gui.swing.view.modelView.ProjectView;
import raf.ds.gerumap.painters.TopicPainter;
import raf.ds.gerumap.repository.implementation.Topic;
import raf.ds.gerumap.repository.implementation.MindMap;
import raf.ds.gerumap.state.State;

public class ElipsaState extends State {

    int brojac = 0;


    public ElipsaState(ProjectView mediator) {

    }

    @Override
    public void mousePressed(MindView mv, int x, int y) {
        MindMap mindMap = (MindMap) mv.getMindModel();
        MapTreeItem mapTreeItem = (MapTreeItem)MainFrame.getInstance().getMapTree().getSelectedNode();
        Topic topic = new Topic(x,y);
        topic.setParent(mindMap);
        mindMap.addChild(topic);
        topic.setName("Elipse" + ++brojac);
        TopicPainter topicPainter = new TopicPainter(topic);
        mv.getElementi().add(topicPainter);
        mv.addElementPainter(topicPainter);
       // MainFrame.getInstance().getMapTree().addChild(mapTreeItem, topic);
        mindMap.notifySubscribers(null);
    }

}
