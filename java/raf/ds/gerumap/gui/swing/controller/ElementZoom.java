package raf.ds.gerumap.gui.swing.controller;

import raf.ds.gerumap.gui.swing.view.modelView.MindView;
import raf.ds.gerumap.gui.swing.view.modelView.ProjectView;

import java.awt.event.ActionEvent;

public class ElementZoom extends AbstractRudokAction{

    public ElementZoom(){
        putValue(SMALL_ICON, loadIcon("/images/zoomInState.png"));
        putValue(NAME, "Zoom Element");
        putValue(SHORT_DESCRIPTION, "Zoom element");
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        MindView mv = (MindView) ProjectView.getInstance().getjTabbedPane().getSelectedComponent();
        mv.startZoomState();
    }
}
