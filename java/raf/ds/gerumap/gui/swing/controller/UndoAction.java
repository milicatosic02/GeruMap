package raf.ds.gerumap.gui.swing.controller;

import raf.ds.gerumap.core.ApplicationFramework;
import raf.ds.gerumap.gui.swing.view.MainFrame;
import raf.ds.gerumap.gui.swing.view.modelView.MindView;
import raf.ds.gerumap.gui.swing.view.modelView.ProjectView;
import raf.ds.gerumap.repository.implementation.MindMap;

import java.awt.event.ActionEvent;

public class UndoAction extends AbstractRudokAction{

    public UndoAction(){
        putValue(SMALL_ICON, loadIcon("/images/redoAction.png"));
        putValue(NAME, "Undo Action");
        putValue(SHORT_DESCRIPTION, "Undo Action");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
       // ApplicationFramework.getInstance().getMapRepository().getCommandManager().undoCommand();
        MindView mv = (MindView) ProjectView.getInstance().getjTabbedPane().getSelectedComponent();
        MindMap mindMap = mv.getMindModel();
        mindMap.getCommandManager().undoCommand();
    }
}
