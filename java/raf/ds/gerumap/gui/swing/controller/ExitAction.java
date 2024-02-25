package raf.ds.gerumap.gui.swing.controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class ExitAction extends AbstractRudokAction{

    public ExitAction(){
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_F4,ActionEvent.ALT_MASK));
        putValue(SMALL_ICON,loadIcon("/images/rectangle.png"));
        putValue(NAME,"Exit");
        putValue(SHORT_DESCRIPTION,"Exit");
        //hj
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }


}
