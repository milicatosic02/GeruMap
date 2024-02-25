package raf.ds.gerumap.gui.swing.controller;

import raf.ds.gerumap.gui.swing.tree.model.MapTreeItem;
import raf.ds.gerumap.gui.swing.view.MainFrame;
import raf.ds.gerumap.notification.Notification;
import raf.ds.gerumap.notification.NotificationCode;
import raf.ds.gerumap.repository.composite.MapNode;
import raf.ds.gerumap.repository.implementation.ProjectExplorer;

import javax.print.attribute.standard.MediaSize;
import java.awt.event.ActionEvent;

public class DeleteAction extends AbstractRudokAction{

    public DeleteAction(){
        putValue(NAME, "Delete");
        putValue(SMALL_ICON, loadIcon("/images/delete.png"));
        putValue(SHORT_DESCRIPTION, "Delete");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MapTreeItem selected = (MapTreeItem) MainFrame.getInstance().getMapTree().getSelectedNode();
        if(selected == null){
            MainFrame.getInstance().getMessageGenerator().generateMessage(new Notification(NotificationCode.DELETE_MESSAGE, this));
            return;
        }
        if(selected.getMapNode() instanceof ProjectExplorer){
            MainFrame.getInstance().getMessageGenerator().generateMessage(new Notification(NotificationCode.DELETE_PROJECTEXPLOREAR, this));
            return;
        }

        System.out.println("PARENT: " + selected.getMapNode().getParent());

        MainFrame.getInstance().getMapTree().deleteChild(selected);
    }
}
