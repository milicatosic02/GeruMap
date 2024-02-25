package raf.ds.gerumap.state.actions;

import raf.ds.gerumap.core.ApplicationFramework;
import raf.ds.gerumap.gui.swing.view.modelView.MindView;
import raf.ds.gerumap.gui.swing.view.modelView.ProjectView;
import raf.ds.gerumap.painters.ElementPainter;
import raf.ds.gerumap.painters.TopicPainter;
import raf.ds.gerumap.painters.VezaPainter;
import raf.ds.gerumap.repository.command.AbstractCommand;
import raf.ds.gerumap.repository.command.implementations.RemoveElementCommand;
import raf.ds.gerumap.repository.implementation.Element;
import raf.ds.gerumap.state.State;

import java.util.List;

public class DeleteState extends State {

    private ProjectView mediator;
    private Element element;

    public DeleteState(ProjectView mediator){
        this.mediator = mediator;
    }


    @Override
    public void mousePressed(MindView mv, int x, int y) {
        List<ElementPainter> painteri = mv.getElementPainteri();
        List<ElementPainter> seleketovani = mv.getSelectedElements();

        mv.removeElementPainter();

        seleketovani.removeAll(seleketovani);
       // mv.getMindModel().notifySubscribers(null);
    }

}
