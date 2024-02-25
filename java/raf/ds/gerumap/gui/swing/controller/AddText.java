package raf.ds.gerumap.gui.swing.controller;

import raf.ds.gerumap.gui.swing.view.modelView.AddTextView;
import raf.ds.gerumap.gui.swing.view.modelView.MindView;
import raf.ds.gerumap.gui.swing.view.modelView.ProjectView;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class AddText extends AbstractRudokAction{

    public AddText() {
        putValue(SMALL_ICON, loadIcon("/images/addText.png"));
        putValue(NAME, "AddText");
        putValue(SHORT_DESCRIPTION, "AddText");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MindView mv = (MindView) ProjectView.getInstance().getjTabbedPane().getSelectedComponent();
        if (mv.getSelectedElements().isEmpty() || mv.getSelectedElements() == null || mv.getSelectedElements().size() > 1) {
            JOptionPane.showMessageDialog(new JFrame(), "Selektujte jedan element u koji zelite da unesete tekst:", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
            AddTextView addTextView = new AddTextView();
        }
    }
