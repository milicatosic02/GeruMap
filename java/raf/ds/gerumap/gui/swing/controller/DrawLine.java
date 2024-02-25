package raf.ds.gerumap.gui.swing.controller;

import raf.ds.gerumap.gui.swing.view.modelView.MindView;
import raf.ds.gerumap.gui.swing.view.modelView.ProjectView;

import java.awt.event.ActionEvent;

public class DrawLine extends AbstractRudokAction{

    public DrawLine() {
        putValue(SMALL_ICON, loadIcon("/images/lineState.png"));
        putValue(NAME, "Draw Line");
        putValue(SHORT_DESCRIPTION, "Draw Line");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(ProjectView.getInstance().getjTabbedPane().getSelectedComponent() != null) {
            MindView mv = (MindView) ProjectView.getInstance().getjTabbedPane().getSelectedComponent();
            mv.startLineState();
        }
    }







}
