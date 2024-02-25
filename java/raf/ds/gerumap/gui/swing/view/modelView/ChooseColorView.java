package raf.ds.gerumap.gui.swing.view.modelView;

import raf.ds.gerumap.notification.Notification;
import raf.ds.gerumap.observer.IPublisher;
import raf.ds.gerumap.observer.ISubscriber;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChooseColorView extends JFrame implements ActionListener, IPublisher {

    JButton okBtn;

    JColorChooser jColorChooser;
    public ChooseColorView(){
        initialise();
        this.setVisible(true);
    }

    private void initialise(){
        this.setSize(400, 400);
        this.setTitle("Choose color:");
        jColorChooser = new JColorChooser();
        okBtn = new JButton("OK");
        okBtn.addActionListener(this);
        add(jColorChooser);
        add(okBtn, BorderLayout.SOUTH);
        setLocationRelativeTo(null);
    }

    public JColorChooser getjColorChooser() {
        return jColorChooser;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MindView mindView = ((MindView) ProjectView.getInstance().getjTabbedPane().getSelectedComponent());
        Color color = jColorChooser.getSelectionModel().getSelectedColor();
        //AbstractCommand command = new ChangeColorCommand(mindView, color);
        //ApplicationFramework.getInstance().getMapRepository().getCommandManager().addCommand(command);
        mindView.setColorForSelectedElements(color);
        this.dispose();
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
