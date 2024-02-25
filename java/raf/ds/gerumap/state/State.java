package raf.ds.gerumap.state;

import raf.ds.gerumap.gui.swing.tree.model.MapTreeItem;
import raf.ds.gerumap.gui.swing.view.modelView.MindView;
import raf.ds.gerumap.painters.ElementPainter;
import raf.ds.gerumap.repository.implementation.Element;

import java.awt.*;
import java.awt.event.MouseWheelEvent;

public abstract class State {
//    public abstract void mouseWheelMoved(MindView mv, double x, double y);

    public void mousePressed(MindView mv, int x, int y) {}
    public void mouseDragged(MindView mv,int x, int y ) {}
    public void mouseReleased(MindView mv,int x, int y) {}

    public void mouseWheelMoved(MindView mv, int x, int y,int wheelRotation){}

    public void changeElement(Color color, MindView mv){};




}
