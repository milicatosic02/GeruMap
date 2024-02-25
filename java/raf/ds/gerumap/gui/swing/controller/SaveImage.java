package raf.ds.gerumap.gui.swing.controller;

import raf.ds.gerumap.AppCore;
import raf.ds.gerumap.core.ApplicationFramework;
import raf.ds.gerumap.gui.swing.view.MainFrame;
import raf.ds.gerumap.gui.swing.view.modelView.MindView;
import raf.ds.gerumap.gui.swing.view.modelView.ProjectView;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.file.Path;

public class SaveImage extends AbstractRudokAction{

    public SaveImage(){
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_F4,ActionEvent.ALT_MASK));
        putValue(SMALL_ICON,loadIcon("/images/saveImage.png"));
        putValue(NAME,"Save Image");
        putValue(SHORT_DESCRIPTION,"Save Image");
        //hj
    }
    @Override
    public void actionPerformed(ActionEvent agr0) {
        MindView panel = (MindView) ProjectView.getInstance().getjTabbedPane().getSelectedComponent();
        JFileChooser jfile = new JFileChooser();
        jfile.showSaveDialog(null);
        Path pth = jfile.getSelectedFile().toPath();

        BufferedImage img = new BufferedImage(panel.getWidth(), panel.getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics2D = img.createGraphics();
       // panel.paint(img.getGraphics());
        panel.printAll(graphics2D);
       // File f  = null;
        try {
            ImageIO.write(img, "png",new File(pth.toString()));
            System.out.println("panel saved as image");

        } catch (Exception e) {
            System.out.println("panel not saved" + e.getMessage());
        }

    }
}
