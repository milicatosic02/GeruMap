package raf.ds.gerumap.gui.swing.controller;

import raf.ds.gerumap.gui.swing.view.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class InfoAction extends AbstractRudokAction{

    public InfoAction(){
        putValue(NAME, "About");
        putValue(SMALL_ICON,loadIcon("/images/infoAction.png"));
        putValue(SHORT_DESCRIPTION, "About dialog");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       JDialog jd = new JDialog();
       jd.setLayout(new GridLayout(2, 3, 6, 6));
       jd.setTitle("Creators' information");
       jd.setModal(false);
       jd.setSize(1000, 700);
       jd.setLocationRelativeTo(MainFrame.getInstance());


        JLabel imageOne = new JLabel();
        imageOne.setIcon(new ImageIcon(getClass().getResource("/images/IMG_3271.JPG")));
        jd.add(imageOne);
        Label nameOne = new Label("Milica Tosic");
        nameOne.setFont(new Font("Lucida Calligraphy", Font.BOLD, 25));
        jd.add(nameOne);

        Label indexOne = new Label("101/22 RN");
        indexOne.setFont(new Font("Lucida Calligraphy", Font.BOLD, 25));

        jd.add(indexOne);
        Label mailOne = new Label("mtosic10122rn@raf.rs");
        mailOne.setFont(new Font("Lucida Calligraphy", Font.BOLD, 20));

        jd.add(mailOne);


        Label nameTwo = new Label("Nadja Radojicic");
        nameTwo.setFont(new Font("Lucida Calligraphy", Font.BOLD, 25));

        jd.add(nameTwo);
        Label indexTwo = new Label("100/22 RN");
        indexTwo.setFont(new Font("Lucida Calligraphy", Font.BOLD, 25));

        jd.add(indexTwo);
        Label mailTwo = new Label("nradojicic10022rn@raf.rs");
        mailTwo.setFont(new Font("Lucida Calligraphy", Font.BOLD, 20));

        jd.add(mailTwo);
        JLabel imageTwo = new JLabel();
        imageTwo.setIcon(new ImageIcon(getClass().getResource("/images/IMG_4696.jpg")));
        jd.add(imageTwo);

        jd.setVisible(true);
        

    }
}
