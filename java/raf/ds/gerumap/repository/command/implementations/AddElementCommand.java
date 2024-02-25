package raf.ds.gerumap.repository.command.implementations;

import raf.ds.gerumap.gui.swing.view.modelView.MindView;
import raf.ds.gerumap.painters.ElementPainter;
import raf.ds.gerumap.repository.command.AbstractCommand;
import raf.ds.gerumap.repository.composite.MapNodeComposite;

public class AddElementCommand extends AbstractCommand {

    ElementPainter elementPainter;
    MindView mindView;

    public AddElementCommand(MindView mv, ElementPainter elementPainter) {
        this.mindView = mv;
        this.elementPainter = elementPainter;
    }

    @Override
    public void doCommand() {
        if(elementPainter == null) return;
        System.out.println("docommand");
        mindView.getElementi().add(elementPainter);
        System.out.println(mindView.getElementi().size());
        System.out.println(mindView.getMindModel().getName());
        mindView.getMindModel().notifySubscribers(null);
    }

    @Override
    public void undoCommand() {
        if(elementPainter == null) return;
        mindView.getElementPainteri().remove(elementPainter);
        mindView.getMindModel().notifySubscribers(null);
    }
}
