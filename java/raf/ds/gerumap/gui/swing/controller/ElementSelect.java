package raf.ds.gerumap.gui.swing.controller;

import raf.ds.gerumap.gui.swing.view.MainFrame;
import raf.ds.gerumap.gui.swing.view.modelView.MindView;
import raf.ds.gerumap.gui.swing.view.modelView.ProjectView;

import java.awt.event.ActionEvent;

public class ElementSelect extends AbstractRudokAction{

    public ElementSelect(){
        putValue(SMALL_ICON, loadIcon("/images/selectelement.png"));
        putValue(NAME, "Select Element");
        putValue(SHORT_DESCRIPTION, "Select Element");
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(ProjectView.getInstance().getjTabbedPane().getSelectedComponent() != null) {
            MindView mv = (MindView) ProjectView.getInstance().getjTabbedPane().getSelectedComponent();
            mv.startSelectState();
        }
    }
}
