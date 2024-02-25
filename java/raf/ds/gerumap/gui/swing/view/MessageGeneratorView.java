package raf.ds.gerumap.gui.swing.view;

import jdk.nashorn.internal.scripts.JO;
import raf.ds.gerumap.message.MessageGeneratorImpl;
import raf.ds.gerumap.notification.Notification;
import raf.ds.gerumap.observer.ISubscriber;

import javax.swing.*;

public class MessageGeneratorView implements ISubscriber {

    @Override
    public void update(Notification notification) {
        switch(notification.getNotificationCode()){
            case NEW_PROJECT:
                newProject();
                break;
            case PROJECTEXPLORER_RENAME:
                pExplorerRename();
                break;
            case DELETE_MESSAGE:
                deleteMess();
                break;
            case DELETE_PROJECTEXPLOREAR:
                 deleteProjectE();
                 break;
            case ELEMENT_PARENT:
                elementParent();
                break;
            case ADD_AUTHOR:
                addAuthor();
                break;
            case ADD_AUTHOR_PROJECTE:
                addAuthorPE();
                break;
            case MINDMAP_SELECT:
                mindMapSelect();
                break;
        }
    }



    private void newProject() {
        JOptionPane.showMessageDialog(new JFrame(), "Morate da oznacite ProjectExplorer da bi napravili novi projekat!", "Error", JOptionPane.ERROR_MESSAGE);
    }

    private void addAuthor(){
        JOptionPane.showMessageDialog(new JFrame(), "Morate da oznacite Projekat da biste dodali autora!", "Error", JOptionPane.ERROR_MESSAGE);

    }

    private void addAuthorPE(){
        JOptionPane.showMessageDialog(new JFrame(), "ProjectExplorer ne moze imati autora!!", "Error", JOptionPane.ERROR_MESSAGE);

    }

    private void elementParent(){
        JOptionPane.showMessageDialog(new JFrame(), "Element ne moze imati svoje dete!", "Warning", JOptionPane.WARNING_MESSAGE);
    }

    private void pExplorerRename() {
        JOptionPane.showMessageDialog(new JFrame(), "Project explorer ne moze biti preimenovan!", "Warning", JOptionPane.WARNING_MESSAGE);
    }

    private void deleteMess() {
        JOptionPane.showMessageDialog(new JFrame(), "Morate da oznacite objekat koji zelite da obrisete!", "Warning", JOptionPane.WARNING_MESSAGE);
    }

    private void deleteProjectE(){
        JOptionPane.showMessageDialog(new JFrame(), "ProjectExplorer ne moze biti obrisan!","Error",JOptionPane.ERROR_MESSAGE);
    }

    private void mindMapSelect(){
        JOptionPane.showMessageDialog(new JFrame(), "Selektujte zeljeni MindMap!","Error",JOptionPane.ERROR_MESSAGE);
    }

}
