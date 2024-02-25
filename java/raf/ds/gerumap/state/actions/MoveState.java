package raf.ds.gerumap.state.actions;

import raf.ds.gerumap.gui.swing.view.modelView.MindView;
import raf.ds.gerumap.gui.swing.view.modelView.ProjectView;
import raf.ds.gerumap.painters.ElementPainter;
import raf.ds.gerumap.painters.TopicPainter;
import raf.ds.gerumap.painters.VezaPainter;
import raf.ds.gerumap.repository.command.AbstractCommand;
import raf.ds.gerumap.repository.command.implementations.MoveElementCommand;
import raf.ds.gerumap.repository.implementation.Topic;
import raf.ds.gerumap.state.State;

import java.util.ArrayList;
import java.util.List;

public class MoveState extends State {

    private ProjectView mediator;
    private List<ElementPainter> moveElements = new ArrayList<>();
    private static int startX;
    private static int startY;

    public MoveState(ProjectView mediator){
        this.mediator = mediator;
    }

    public void setPocetnoXY(MindView mv){
        for(ElementPainter selektovani: mv.getSelectedElements()) {
            selektovani.getElement().setPocetnoX(selektovani.getElement().getX());
            selektovani.getElement().setPocetnoY(selektovani.getElement().getY());
        }
    }

    @Override
    public void mousePressed(MindView mv, int x, int y){
        setPocetnoXY(mv);
            startX = x;
            startY = y;

    }

    @Override
    public void mouseDragged(MindView mv,int x, int y){
        for(ElementPainter moveElement : mv.getSelectedElements()){
            moveElement.getElement().setX(moveElement.getElement().getX()+(x-startX));
            moveElement.getElement().setY(moveElement.getElement().getY()+(y-startY));
            moveElement.getElement().notifySubscribers(null);

            //todo : proci kroz sve paintere
            // i ako je painter veza i njegov element je element koji se pomera,
            // vezu iz painteraVeze azurirati koordinatu
        }

//        for(VezaPainter vezaPainter: mv.getVezaPainters()){
//            TopicPainter startingTopic = vezaPainter.getVeza().getStartingTopic();
//            TopicPainter endingTopic = vezaPainter.getVeza().getEndingTopic();
//            if(mv.getSelectedElements().contains(startingTopic) || mv.getSelectedElements().contains(endingTopic)){
//                vezaPainter.getVeza().notifySubscribers(null);
//            }
//        }

        for (VezaPainter vezaPainter : mv.getVezaPainters()) {
            //  TopicPainter startingTopic = vezaPainter.getVeza().getStartingTopic();
            // TopicPainter endingTopic = vezaPainter.getVeza().getEndingTopic();
            Topic startTopic = vezaPainter.getVeza().getStartTopic();
            Topic endTopic = vezaPainter.getVeza().getEndTopic();

            for (ElementPainter painter : mv.getSelectedElements()) {
                if (painter instanceof TopicPainter) {
                    if (painter.getElement().equals(startTopic) || painter.getElement().equals(endTopic)) {
                        System.out.println("Usli u dobar if");
                        vezaPainter.getVeza().notifySubscribers(null);
                        break;
                    }
                }
            }
        }
        startX = x;
        startY = y;
    }

    @Override
    public void mouseReleased(MindView mv, int x, int y) {

        AbstractCommand command = new MoveElementCommand(mv, mv.getSelectedElements());
        //ApplicationFramework.getInstance().getMapRepository().getCommandManager().addCommand(command);
        mv.getMindModel().getCommandManager().addCommand(command);
    }
}
