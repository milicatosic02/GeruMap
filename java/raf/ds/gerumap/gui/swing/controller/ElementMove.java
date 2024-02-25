package raf.ds.gerumap.gui.swing.controller;

import raf.ds.gerumap.gui.swing.view.MainFrame;
import raf.ds.gerumap.gui.swing.view.modelView.MindView;
import raf.ds.gerumap.gui.swing.view.modelView.ProjectView;

import java.awt.event.ActionEvent;

public class ElementMove extends AbstractRudokAction{

    public ElementMove(){
        putValue(SMALL_ICON, loadIcon("/images/moveElement.png"));
        putValue(NAME, "Move Element");
        putValue(SHORT_DESCRIPTION, "Move Element");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MindView mv = (MindView) ProjectView.getInstance().getjTabbedPane().getSelectedComponent();
        mv.startMoveState();
    }
}
