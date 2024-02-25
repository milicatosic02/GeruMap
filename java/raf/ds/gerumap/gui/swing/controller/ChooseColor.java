package raf.ds.gerumap.gui.swing.controller;

import raf.ds.gerumap.gui.swing.view.modelView.ChooseColorView;
import raf.ds.gerumap.gui.swing.view.modelView.MindView;
import raf.ds.gerumap.gui.swing.view.modelView.ProjectView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class ChooseColor extends AbstractRudokAction{

    public ChooseColor(){
        putValue(SMALL_ICON,loadIcon("/images/colorChoose.png"));
        putValue(NAME,"Choose color");
        putValue(SHORT_DESCRIPTION,"Choose color");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MindView mv = (MindView) ProjectView.getInstance().getjTabbedPane().getSelectedComponent();
        if (mv.getSelectedElements().isEmpty() || mv.getSelectedElements() == null) {
            JOptionPane.showMessageDialog(new JFrame(), "Selektujte elemente kojima zelite da promenite boju:", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
       ChooseColorView chooseColorView =  new ChooseColorView();
    }
}
