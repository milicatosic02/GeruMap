package raf.ds.gerumap.gui.swing.tree.controller;

import raf.ds.gerumap.gui.swing.view.MainFrame;
import raf.ds.gerumap.gui.swing.view.modelView.MindView;
import raf.ds.gerumap.gui.swing.view.modelView.ProjectView;
import raf.ds.gerumap.notification.Notification;
import raf.ds.gerumap.notification.NotificationCode;
import raf.ds.gerumap.repository.implementation.MindMap;
import raf.ds.gerumap.repository.implementation.Project;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class DoubleClickTree implements MouseListener {
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getClickCount() == 2 && MainFrame.getInstance().getMapTree().getSelectedNode().getMapNode() != null &&
                MainFrame.getInstance().getMapTree().getSelectedNode().getMapNode()instanceof Project) {
            ProjectView.getInstance().setProjectModel((Project) MainFrame.getInstance().getMapTree().getSelectedNode().getMapNode());
        }
        if(e.getClickCount() == 1 && MainFrame.getInstance().getMapTree().getSelectedNode() != null
                && MainFrame.getInstance().getMapTree().getSelectedNode().getMapNode() instanceof MindMap){
            MindMap mp = (MindMap) MainFrame.getInstance().getMapTree().getSelectedNode().getMapNode();
            Project pr = (Project)mp.getParent();
            MindView mv = new MindView(mp, ProjectView.getInstance());
            pr.sendMessage(new Notification(NotificationCode.OPEN_TAB, mv));
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
