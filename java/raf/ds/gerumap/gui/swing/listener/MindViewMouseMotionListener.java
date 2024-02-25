package raf.ds.gerumap.gui.swing.listener;

import raf.ds.gerumap.gui.swing.view.MainFrame;
import raf.ds.gerumap.gui.swing.view.modelView.MindView;
import raf.ds.gerumap.notification.Notification;
import raf.ds.gerumap.notification.NotificationCode;
import raf.ds.gerumap.repository.composite.MapNode;
import raf.ds.gerumap.repository.implementation.MindMap;
import raf.ds.gerumap.state.State;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MindViewMouseMotionListener implements MouseMotionListener {

    private MindView mv;

    public MindViewMouseMotionListener(MindView mv){
        this.mv = mv;
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        mv.misPrevlacenje(mv, e.getX(), e.getY());
    }


    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
