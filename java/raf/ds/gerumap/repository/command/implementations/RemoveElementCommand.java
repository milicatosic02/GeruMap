package raf.ds.gerumap.repository.command.implementations;

import raf.ds.gerumap.gui.swing.view.modelView.MindView;
import raf.ds.gerumap.painters.ElementPainter;
import raf.ds.gerumap.painters.TopicPainter;
import raf.ds.gerumap.painters.VezaPainter;
import raf.ds.gerumap.repository.command.AbstractCommand;
import raf.ds.gerumap.repository.implementation.Topic;

import java.util.ArrayList;
import java.util.List;

public class RemoveElementCommand extends AbstractCommand {

    List<ElementPainter> selektovani;
    MindView mindView;
    VezaPainter vezaPainter = null;

    public RemoveElementCommand( MindView mindView) {
        this.mindView = mindView;
        this.selektovani = new ArrayList<>();
        addSelected();
    }

    private void addSelected(){
        for(ElementPainter selected: mindView.getSelectedElements())
            selektovani.add(selected);
    }

    @Override
    public void doCommand() {

        if(selektovani == null || selektovani.isEmpty()) return;

        for(ElementPainter selected: selektovani) {
            mindView.getElementPainteri().remove(selected);
            mindView.getMindModel().removeChild(selected.getElement());
        }


        for (VezaPainter vezaPainter : mindView.getVezaPainters()) {
            Topic startTopic = vezaPainter.getVeza().getStartTopic();
            Topic endTopic = vezaPainter.getVeza().getEndTopic();

            for (ElementPainter painter : mindView.getSelectedElements()) {
                if (painter instanceof TopicPainter) {
                    if (painter.getElement().equals(startTopic) || painter.getElement().equals(endTopic)) {
                       // vezaPainter.getVeza().notifySubscribers(null);
                        this.vezaPainter = vezaPainter;
                        break;
                    }
                }
            }
        }

        if(vezaPainter != null) {
            mindView.getElementPainteri().remove(this.vezaPainter);
            mindView.getMindModel().removeChild(vezaPainter.getElement());
        }

        mindView.getMindModel().notifySubscribers(null);
    }

    @Override
    public void undoCommand() {

        if(selektovani == null || selektovani.isEmpty()) return;

        for(ElementPainter selected: selektovani) {
            selected.returnOriginalColor();
            mindView.getElementPainteri().add(selected);
        }

        if(vezaPainter != null)
            mindView.getElementPainteri().add(vezaPainter);

        mindView.getMindModel().notifySubscribers(null);
    }

}
