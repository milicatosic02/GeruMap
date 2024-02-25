package raf.ds.gerumap.state.actions;

import jdk.jfr.internal.tool.Main;
import raf.ds.gerumap.gui.swing.view.MainFrame;
import raf.ds.gerumap.gui.swing.view.modelView.MindView;
import raf.ds.gerumap.gui.swing.view.modelView.ProjectView;
import raf.ds.gerumap.painters.ElementPainter;
import raf.ds.gerumap.painters.TopicPainter;
import raf.ds.gerumap.painters.VezaPainter;
import raf.ds.gerumap.repository.implementation.Element;
import raf.ds.gerumap.repository.implementation.MindMap;
import raf.ds.gerumap.state.State;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.List;

public class SelectState extends State {

    private ProjectView mediator;
    private Element start;
    Color color;

    int x;
    int y;
    public SelectState(ProjectView mediator){
        this.mediator = mediator;
    }

    @Override
    public void mousePressed(MindView mv, int x, int y) {
        this.x = x;
        this.y= y;
        List<ElementPainter> painters = mv.getElementPainteri();

        for(ElementPainter p:painters){
            if (p.elementAt(x,y)){
                if(!mv.getSelectedElements().contains(p)){
                    select(p,mv);
                }else{
                    undoSelect(p,mv);
                }
               return;
            }
        }
    }


    public void undoSelect(ElementPainter painter,MindView mv){

        if(mv.getSelectedElements().contains(painter)){
            mv.getSelectedElements().remove(painter);
            painter.returnOriginalColor();
        }
    }

    public void select(ElementPainter painter, MindView mindView){

        if(!mindView.getSelectedElements().contains(painter)){
            mindView.getSelectedElements().add(painter);
            painter.setSelectedColor();
            }
    }


    @Override
    public void mouseDragged(MindView mv, int x, int y) {
        mv.setSelectionRectangle(new Rectangle2D.Double(this.x, this.y, x - this.x, y - this.y));
        mv.getMindModel().notifySubscribers(null);
    }


    @Override
    public void mouseReleased(MindView mv,int x, int y) {
        List<ElementPainter> painters = mv.getElementPainteri();

        if(mv.getSelectionRectangle() != null) {
            System.out.println("IF");
            for (ElementPainter p : painters) {
                if (mv.getSelectionRectangle().contains(p.getElement().getX(), p.getElement().getY())) {
                    if (!mv.getSelectedElements().contains(p)) {
                        select(p, mv);
                    } else {
                        undoSelect(p, mv);
                    }
                }
            }
        }
        mv.setSelectionRectangle(null);
       mv.getMindModel().notifySubscribers(null);
    }
}
