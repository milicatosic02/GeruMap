package raf.ds.gerumap.gui.swing.controller;

import raf.ds.gerumap.core.ApplicationFramework;
import raf.ds.gerumap.gui.swing.view.MainFrame;
import raf.ds.gerumap.repository.implementation.Project;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.File;

public class SaveAsAction extends AbstractRudokAction{

    public SaveAsAction(){
        putValue(SMALL_ICON, loadIcon("/images/saveAction.png"));
        putValue(NAME, "Save As Action");
        putValue(SHORT_DESCRIPTION, "Save As Action");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser jfc = new JFileChooser();

        if (!(MainFrame.getInstance().getMapTree().getSelectedNode().getMapNode() instanceof Project)) return;

        Project project = (Project) MainFrame.getInstance().getMapTree().getSelectedNode().getMapNode();
        File projectFile = null;

        if (!project.isChanged()) {
            return;
        }

        if (project.getFilePath() == null || project.getFilePath().isEmpty()) {
            if (jfc.showSaveDialog(MainFrame.getInstance()) == JFileChooser.APPROVE_OPTION) {
                projectFile = jfc.getSelectedFile();
                project.setFilePath(projectFile.getPath());
            } else {
                return;
            }

        }


        ApplicationFramework.getInstance().getSerializer().saveProject(project);

        project.setChanged(false);
    }
}
