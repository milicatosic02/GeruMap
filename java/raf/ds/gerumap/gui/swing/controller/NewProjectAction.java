package raf.ds.gerumap.gui.swing.controller;

import raf.ds.gerumap.factory.MapNodeFactory;
import raf.ds.gerumap.factory.UtilsFactory;
import raf.ds.gerumap.gui.swing.tree.model.MapTreeItem;
import raf.ds.gerumap.gui.swing.view.MainFrame;
import raf.ds.gerumap.notification.Notification;
import raf.ds.gerumap.notification.NotificationCode;
import raf.ds.gerumap.repository.composite.MapNode;
import raf.ds.gerumap.repository.implementation.Element;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.Random;

public class NewProjectAction extends AbstractRudokAction{

    public NewProjectAction(){
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_N,ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON,loadIcon("/images/addAction.png"));
        putValue(NAME,"New Project");
        putValue(SHORT_DESCRIPTION,"New Project");
        //
        //
    }


    @Override
    public void actionPerformed(ActionEvent arg0) {
        MapTreeItem selected = (MapTreeItem) MainFrame.getInstance().getMapTree().getSelectedNode();
        if(selected == null){
            MainFrame.getInstance().getMessageGenerator().generateMessage(new Notification(NotificationCode.NEW_PROJECT, this));
            return;
        }
        if(selected.getMapNode() instanceof Element){
            MainFrame.getInstance().getMessageGenerator().generateMessage(new Notification(NotificationCode.ELEMENT_PARENT, this));
            return;
        }
        MapNodeFactory mf = UtilsFactory.getFactory(selected);
        MapNode m = mf.makeMapNode(selected.getMapNode());
        MainFrame.getInstance().getMapTree().addChild(selected, m);

    }
}
