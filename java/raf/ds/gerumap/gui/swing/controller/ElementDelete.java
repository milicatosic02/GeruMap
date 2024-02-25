package raf.ds.gerumap.gui.swing.controller;

import raf.ds.gerumap.gui.swing.view.MainFrame;
import raf.ds.gerumap.gui.swing.view.modelView.MindView;
import raf.ds.gerumap.gui.swing.view.modelView.ProjectView;

import java.awt.event.ActionEvent;

public class ElementDelete extends AbstractRudokAction{

    public ElementDelete(){
        putValue(SMALL_ICON, loadIcon("/images/deleteElement.png"));
        putValue(NAME, "Delete Element");
        putValue(SHORT_DESCRIPTION, "Delete element");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(ProjectView.getInstance().getjTabbedPane().getSelectedComponent() != null) {
            MindView mv = (MindView) ProjectView.getInstance().getjTabbedPane().getSelectedComponent();
            mv.startDeleteState();
        }
    }



}
