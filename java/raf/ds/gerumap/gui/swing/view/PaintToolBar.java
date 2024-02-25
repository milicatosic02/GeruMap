package raf.ds.gerumap.gui.swing.view;

import jdk.jfr.internal.tool.Main;

import javax.swing.*;

public class PaintToolBar extends JToolBar {

    public PaintToolBar() {
        super(JToolBar.VERTICAL);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        add(MainFrame.getInstance().getActionManager().getDrawRectangle());
        add(MainFrame.getInstance().getActionManager().getElementDelete());
        add(MainFrame.getInstance().getActionManager().getElementMove());
        add(MainFrame.getInstance().getActionManager().getElementSelect());
        add(MainFrame.getInstance().getActionManager().getDrawLine());
        add(MainFrame.getInstance().getActionManager().getAddText());
        add(MainFrame.getInstance().getActionManager().getElementZoom());

    }
}
