package raf.ds.gerumap.gui.swing.view.modelView;

import raf.ds.gerumap.painters.ElementPainter;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddTextView extends JFrame implements ActionListener {

    private JTextField textTf;
    private JLabel addTextLbl;
    private JButton okBtn;

    public AddTextView(){
        initialise();
        this.setVisible(true);
    }

    private void initialise(){
        this.setSize(200, 115);
        this.setTitle("Add Text:");
        addTextLbl = new JLabel("Text: ");
        textTf = new JTextField();
        MindView mv = (MindView) ProjectView.getInstance().getjTabbedPane().getSelectedComponent();
        for(ElementPainter painter : mv.getSelectedElements()){
            textTf.setText(painter.getElement().getText());
        }
        okBtn = new JButton("Ok");
        okBtn.addActionListener(this);

        JPanel mainPanel = new JPanel(new BorderLayout(0,0));
        mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

        JPanel strokePanel  = new JPanel(new BorderLayout(5, 5));
        strokePanel.add(addTextLbl, BorderLayout.WEST);
        strokePanel.add(textTf, BorderLayout.CENTER);
        mainPanel.add(strokePanel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new BorderLayout(5, 5));
        buttonPanel.add(okBtn, BorderLayout.CENTER);

        mainPanel.add(strokePanel, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        this.add(mainPanel);
        this.setLocationRelativeTo(null);

    }



    @Override
    public void actionPerformed(ActionEvent e) {
        MindView mv = (MindView) ProjectView.getInstance().getjTabbedPane().getSelectedComponent();
        String text = textTf.getText();

        for(ElementPainter painter : mv.getSelectedElements()){
            painter.getElement().setText(text);
            painter.returnOriginalColor();
        }

        mv.getSelectedElements().removeAll(mv.getSelectedElements());
        this.dispose();
    }
}
