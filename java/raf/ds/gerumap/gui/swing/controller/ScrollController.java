package raf.ds.gerumap.gui.swing.controller;

import raf.ds.gerumap.gui.swing.tree.model.MapTreeItem;
import raf.ds.gerumap.gui.swing.view.modelView.MindView;
import raf.ds.gerumap.painters.ZoomPainter;
import raf.ds.gerumap.state.State;
import raf.ds.gerumap.state.StateManager;

import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class ScrollController implements MouseWheelListener {

    private StateManager stateManager;

    private MindView mindView;

    public ScrollController(StateManager stateManager, MindView mindView){

        this.stateManager = stateManager;
        this.mindView = mindView;
    }


    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        int x = pom(e);
        int y = pom2(e);
        if(e.getModifiers()!= 18){
            this.stateManager.getCurrentState().mouseWheelMoved(mindView,x,y,e.getWheelRotation());
        }
    }

    private int pom(MouseEvent e){
        ZoomPainter z = mindView.getZoomPainter();
        return (int) (e.getX()/z.getZoomFactor() - z.getxOffSet()/z.getZoomFactor());
    }

    private int pom2(MouseEvent e){
        ZoomPainter z = mindView.getZoomPainter();
        return (int) (e.getY()/z.getZoomFactor() - z.getYoffSet()/z.getZoomFactor());
    }

}
