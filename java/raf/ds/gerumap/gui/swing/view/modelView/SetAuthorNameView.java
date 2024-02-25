package raf.ds.gerumap.gui.swing.view.modelView;

import raf.ds.gerumap.gui.swing.tree.model.MapTreeItem;
import raf.ds.gerumap.gui.swing.view.MainFrame;
import raf.ds.gerumap.notification.Notification;
import raf.ds.gerumap.notification.NotificationCode;
import raf.ds.gerumap.observer.IPublisher;
import raf.ds.gerumap.observer.ISubscriber;
import raf.ds.gerumap.repository.implementation.Project;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SetAuthorNameView extends JDialog implements ActionListener, IPublisher{

    private JTextField imeTextField;
    private JLabel setNameLabel;
    private JButton okBtn;

    public SetAuthorNameView(){
        initialise();
        this.setVisible(true);
    }

    private void initialise(){
        this.setSize(200, 115);
        this.setTitle("Set author name:");
        setNameLabel = new JLabel("Name: ");
        imeTextField = new JTextField();
        okBtn = new JButton("Ok");
        okBtn.addActionListener(this);

        JPanel mainPanel = new JPanel(new BorderLayout(0,0));
        mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

        JPanel autorPanel  = new JPanel(new BorderLayout(5, 5));
        autorPanel.add(setNameLabel, BorderLayout.WEST);
        autorPanel.add(imeTextField, BorderLayout.CENTER);
        mainPanel.add(autorPanel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new BorderLayout(5, 5));
        buttonPanel.add(okBtn, BorderLayout.CENTER);

        mainPanel.add(autorPanel, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        this.add(mainPanel);
        this.setLocationRelativeTo(null);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("ACTION PERFORMED(SET AUTHOR");
        MapTreeItem node = MainFrame.getInstance().getMapTree().getSelectedNode();
        if(node.getMapNode() instanceof Project){
            ( (Project)node.getMapNode()).setAuthorName(imeTextField.getText());
            ( (Project)node.getMapNode()).sendMessage(new Notification(NotificationCode.SET_AUTHOR, this));
            this.dispose();
        }
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

    @Override
    public String toString() {
        return imeTextField.getText().toString();
    }
}
