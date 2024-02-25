package raf.ds.gerumap.gui.swing.controller;

import raf.ds.gerumap.gui.swing.listener.MindViewMouseAdapter;
import raf.ds.gerumap.gui.swing.view.MainFrame;
import raf.ds.gerumap.gui.swing.view.modelView.MindView;
import raf.ds.gerumap.gui.swing.view.modelView.ProjectView;
import raf.ds.gerumap.notification.Notification;
import raf.ds.gerumap.notification.NotificationCode;
import raf.ds.gerumap.repository.implementation.MindMap;

import java.awt.event.ActionEvent;

public class DrawRectangle extends AbstractRudokAction {

    public DrawRectangle() {
        putValue(SMALL_ICON, loadIcon("/images/elipsaState.png"));
        putValue(NAME, "Draw Rectangle");
        putValue(SHORT_DESCRIPTION, "Draw Rectangle");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
            if(ProjectView.getInstance().getjTabbedPane().getSelectedComponent() != null) {
                MindView mv = (MindView) ProjectView.getInstance().getjTabbedPane().getSelectedComponent();
                mv.startRectangleState();
            }
        }
    }
