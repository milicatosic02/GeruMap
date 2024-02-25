package raf.ds.gerumap.gui.swing.controller;

import raf.ds.gerumap.core.ApplicationFramework;
import raf.ds.gerumap.gui.swing.view.MainFrame;
import raf.ds.gerumap.repository.implementation.Project;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.File;

public class OpenAction extends AbstractRudokAction{

    public OpenAction(){
        putValue(SMALL_ICON, loadIcon("/images/openAction.png"));
        putValue(NAME, "Open Action");
        putValue(SHORT_DESCRIPTION, "Open project");
    }
    @Override
    public void actionPerformed(ActionEvent arg0) {
        JFileChooser jfc = new JFileChooser();

        if (jfc.showOpenDialog(MainFrame.getInstance()) == JFileChooser.APPROVE_OPTION) {
            try {
                File file = jfc.getSelectedFile();
                Project p = ApplicationFramework.getInstance().getSerializer().loadProject(file);
                MainFrame.getInstance().getMapTree().loadProject(p);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
