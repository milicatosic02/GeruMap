package raf.ds.gerumap.repository.command.implementations;

import raf.ds.gerumap.gui.swing.view.modelView.MindView;
import raf.ds.gerumap.painters.ElementPainter;
import raf.ds.gerumap.painters.TopicPainter;
import raf.ds.gerumap.painters.VezaPainter;
import raf.ds.gerumap.repository.command.AbstractCommand;
import raf.ds.gerumap.repository.implementation.Topic;

import java.util.ArrayList;
import java.util.List;

public class MoveElementCommand extends AbstractCommand {

    MindView mindView;
    List<ElementPainter> movedElements = new ArrayList<>();

    public MoveElementCommand(MindView mindView,List<ElementPainter> movedElements) {
        this.mindView = mindView;
        this.movedElements = movedElements;
        setNovoXY(movedElements);
    }

    private void setNovoXY(List<ElementPainter> movedElements){
        for(ElementPainter moved: movedElements){
            moved.getElement().setNovoX(moved.getElement().getX());
            moved.getElement().setNovoY(moved.getElement().getY());
        }
    }

    @Override
    public void doCommand() {
        for (ElementPainter moveElement : movedElements) {
            moveElement.getElement().setX(moveElement.getElement().getNovoX());
            moveElement.getElement().setY(moveElement.getElement().getNovoY());
            moveElement.getElement().notifySubscribers(null);
        }

        for (VezaPainter vezaPainter : mindView.getVezaPainters()) {
            Topic startTopic = vezaPainter.getVeza().getStartTopic();
            Topic endTopic = vezaPainter.getVeza().getEndTopic();

            for (ElementPainter painter : movedElements) {
                if (painter instanceof TopicPainter) {
                    if (painter.getElement().equals(startTopic) || painter.getElement().equals(endTopic)) {
                        System.out.println("usli u dobar if(moveCommand)");
                        vezaPainter.getVeza().notifySubscribers(null);
                        break;
                    }
                }
            }
        }
    }


    @Override
    public void undoCommand() {
        for (ElementPainter moveElement : movedElements) {
            moveElement.getElement().setX(moveElement.getElement().getPocetnoX());
            moveElement.getElement().setY(moveElement.getElement().getPocetnoY());
            moveElement.getElement().notifySubscribers(null);
        }

        for (VezaPainter vezaPainter : mindView.getVezaPainters()) {
            Topic startTopic = vezaPainter.getVeza().getStartTopic();
            Topic endTopic = vezaPainter.getVeza().getEndTopic();

            for (ElementPainter painter : movedElements) {
                if (painter instanceof TopicPainter) {
                    if (painter.getElement().equals(startTopic) || painter.getElement().equals(endTopic)) {
                        vezaPainter.getVeza().notifySubscribers(null);
                        break;
                    }
                }
            }
        }
    }
}
