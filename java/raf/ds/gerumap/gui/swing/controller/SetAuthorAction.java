package raf.ds.gerumap.gui.swing.controller;

import raf.ds.gerumap.gui.swing.view.MainFrame;
import raf.ds.gerumap.gui.swing.view.modelView.ProjectView;
import raf.ds.gerumap.gui.swing.view.modelView.SetAuthorNameView;
import raf.ds.gerumap.notification.Notification;
import raf.ds.gerumap.notification.NotificationCode;
import raf.ds.gerumap.observer.IPublisher;
import raf.ds.gerumap.observer.IPublisherImpl;
import raf.ds.gerumap.observer.ISubscriber;
import raf.ds.gerumap.repository.implementation.ProjectExplorer;

import java.awt.event.ActionEvent;

public class SetAuthorAction extends AbstractRudokAction implements IPublisher{

    public SetAuthorAction(){
        putValue(NAME, "Set author name");
        putValue(SHORT_DESCRIPTION, "Set author name");
        putValue(SMALL_ICON,loadIcon("/images/authorImage.png"));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().getMapTree().getSelectedNode().getMapNode();
        if(MainFrame.getInstance().getMapTree().getSelectedNode().getMapNode() == null){
            MainFrame.getInstance().getMessageGenerator().generateMessage(new Notification(NotificationCode.ADD_AUTHOR, this));
            return;
        }
        if(MainFrame.getInstance().getMapTree().getSelectedNode().getMapNode() instanceof ProjectExplorer){
            MainFrame.getInstance().getMessageGenerator().generateMessage(new Notification(NotificationCode.ADD_AUTHOR_PROJECTE, this));
            return;
        }
       new SetAuthorNameView();
    }


    @Override
    public void addSubscriber(ISubscriber subscriber) {

    }

    @Override
    public void notifySubscribers(Notification notification) {

    }

    @Override
    public int countSubscribers() {
        return 0;
    }
}
