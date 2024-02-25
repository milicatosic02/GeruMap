package raf.ds.gerumap.gui.swing.listener;

import raf.ds.gerumap.gui.swing.view.MainFrame;
import raf.ds.gerumap.gui.swing.view.modelView.MindView;
import raf.ds.gerumap.gui.swing.view.modelView.ProjectView;
import raf.ds.gerumap.repository.implementation.MindMap;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MindViewMouseAdapter extends MouseAdapter {
    private MindView mv;

    public MindViewMouseAdapter(MindView mv) {
        this.mv = mv;
    }

    @Override
    public void mousePressed(MouseEvent e) {

        mv.misKliknut(mv, e.getX(), e.getY());
    }


    @Override
    public void mouseReleased(MouseEvent e) {
       mv.misOtpusten(mv, e.getX(), e.getY());
    }
}
