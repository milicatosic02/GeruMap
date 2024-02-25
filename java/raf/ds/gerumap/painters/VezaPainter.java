package raf.ds.gerumap.painters;

import raf.ds.gerumap.gui.swing.view.modelView.MindView;
import raf.ds.gerumap.gui.swing.view.modelView.ProjectView;
import raf.ds.gerumap.notification.Notification;
import raf.ds.gerumap.repository.implementation.Veza;
import raf.ds.gerumap.repository.implementation.MindMap;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

public class VezaPainter extends ElementPainter{

    private Veza veza;

    public VezaPainter(Veza veza) {
        this.element = veza;
        this.veza = veza;
        this.element.addSubscriber(this);
        if(veza.getStartTopic() == null || veza.getEndTopic() == null){
            System.out.println("startT i endT su null");
        }
        this.shape = new Line2D.Double(veza.getStartTopic().getX(),
                veza.getStartTopic().getY(),
                veza.getWidth(),
                veza.getHeight());
    }

    @Override
    public void paint(Graphics2D g) {
        g.setColor(color);
        g.setStroke(new BasicStroke(element.getStroke()));
        g.draw(shape);
        if(element.getText() != "" || element.getText() != null){
            if(shape instanceof Line2D.Double){
                Line2D.Double line = (Line2D.Double)shape;
                g.drawString(element.getText(), (int)line.getBounds2D().getCenterX(), (int)line.getBounds2D().getCenterY());
            }
        }
    }


    @Override
    public void update(Notification notification) {
        if (veza.getEndTopic() != null){

            //Ellipse2D.Double elipsa1  = (Ellipse2D.Double)veza.getStartingTopic().getShape();
            //Ellipse2D.Double elipsa2 = (Ellipse2D.Double)veza.getEndingTopic().getShape();

           Ellipse2D.Double elipsa1  = (Ellipse2D.Double)veza.getStartTopic().getTopicShape();
            Ellipse2D.Double elipsa2 = (Ellipse2D.Double)veza.getEndTopic().getTopicShape();
           
            this.shape = new Line2D.Double(elipsa1.getCenterX(), elipsa1.getCenterY(), elipsa2.getCenterX(), elipsa2.getCenterY());

        }

        else {
            this.shape = new Line2D.Double(veza.getX(), veza.getY(), veza.getHeight(), veza.getWidth());
        }

        MindView mv = (MindView) ProjectView.getInstance().getjTabbedPane().getSelectedComponent();
        MindMap mindMap = mv.getMindModel();
        mindMap.notifySubscribers(null);
    }

    public Veza getVeza() {
        return veza;
    }
}
