package raf.ds.gerumap.gui.swing.controller;

import raf.ds.gerumap.gui.swing.view.modelView.ChooseLineStrokeView;
import raf.ds.gerumap.gui.swing.view.modelView.MindView;
import raf.ds.gerumap.gui.swing.view.modelView.ProjectView;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ChooseLineStroke extends AbstractRudokAction{

    public ChooseLineStroke() {
        putValue(SMALL_ICON, loadIcon("/images/lineStroke.png"));
        putValue(NAME, "Choose line stroke");
        putValue(SHORT_DESCRIPTION, "Choose line stroke");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MindView mv = (MindView) ProjectView.getInstance().getjTabbedPane().getSelectedComponent();
        if (mv.getSelectedElements().isEmpty() || mv.getSelectedElements() == null) {
            JOptionPane.showMessageDialog(new JFrame(), "Selektujte elemente kojima zelite da promenite debljinu linije:", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        ChooseLineStrokeView chooseLineStrokeView = new ChooseLineStrokeView();
    }
}
