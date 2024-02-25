package raf.ds.gerumap.gui.swing.view.modelView;

import raf.ds.gerumap.painters.ElementPainter;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChooseLineStrokeView extends JFrame implements ActionListener{


    private JTextField strokeTf;
    private JLabel setStrokeLbl;
    private JButton okBtn;

    public ChooseLineStrokeView(){
        initialise();
        this.setVisible(true);
    }

    private void initialise(){
        this.setSize(200, 115);
        this.setTitle("Choose line stroke:");
        setStrokeLbl = new JLabel("Stroke: ");
        strokeTf = new JTextField();
        okBtn = new JButton("Ok");
        okBtn.addActionListener(this);

        JPanel mainPanel = new JPanel(new BorderLayout(0,0));
        mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

        JPanel strokePanel  = new JPanel(new BorderLayout(5, 5));
        strokePanel.add(setStrokeLbl, BorderLayout.WEST);
        strokePanel.add(strokeTf, BorderLayout.CENTER);
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
        String s = strokeTf.getText();
        if(s.isEmpty() || s == ""){
            JOptionPane.showMessageDialog(new JFrame(), "Upisite zeljenu debljinu:", "Error", JOptionPane.ERROR_MESSAGE);
           strokeTf.setText("");
            return;
        }
        int stroke;
        try {
             stroke = Integer.parseInt(s);
            MindView mindView = ((MindView) ProjectView.getInstance().getjTabbedPane().getSelectedComponent());
          //  AbstractCommand command = new ChangeLineStrokeCommand(mindView, stroke);
           // ApplicationFramework.getInstance().getMapRepository().getCommandManager().addCommand(command);

            for(ElementPainter painter : mindView.getSelectedElements()){
                painter.getElement().setStroke(stroke);
                painter.returnOriginalColor();
            }
            mindView.getSelectedElements().removeAll(mindView.getSelectedElements());
            this.dispose();
        }
        catch (Exception exception){
            JOptionPane.showMessageDialog(new JFrame(), "Upisite BROJ u tekstualno polje!", "Error", JOptionPane.ERROR_MESSAGE);
            strokeTf.setText("");
        }

    }

}
