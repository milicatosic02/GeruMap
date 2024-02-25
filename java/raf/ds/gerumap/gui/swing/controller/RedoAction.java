package raf.ds.gerumap.gui.swing.controller;

import raf.ds.gerumap.core.ApplicationFramework;
import raf.ds.gerumap.gui.swing.view.MainFrame;
import raf.ds.gerumap.gui.swing.view.modelView.MindView;
import raf.ds.gerumap.gui.swing.view.modelView.ProjectView;
import raf.ds.gerumap.repository.implementation.MindMap;

import java.awt.event.ActionEvent;

public class RedoAction extends AbstractRudokAction{

    public RedoAction(){
        putValue(SMALL_ICON, loadIcon("/images/undoAction.png"));
        putValue(NAME, "Redo Action");
        putValue(SHORT_DESCRIPTION, "Redo Action");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       // ApplicationFramework.getInstance().getMapRepository().getCommandManager().doCommand();
        MindView mv = (MindView) ProjectView.getInstance().getjTabbedPane().getSelectedComponent();
        MindMap mindMap = mv.getMindModel();
        mindMap.getCommandManager().doCommand();
    }
}
