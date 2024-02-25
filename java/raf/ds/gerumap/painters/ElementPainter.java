package raf.ds.gerumap.painters;

import raf.ds.gerumap.observer.ISubscriber;
import raf.ds.gerumap.repository.implementation.Veza;
import raf.ds.gerumap.repository.implementation.Element;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

public abstract class ElementPainter implements ISubscriber {

    protected Element element;
    protected  Shape shape;
    public Color color = new Color(255,102,178);
    private Color selectedColor = Color.BLUE;
    private Color preSelektovanja;

    public void paint(Graphics2D g) {
        g.setColor(this.color);
        g.setStroke(new BasicStroke(element.getStroke()));
        g.draw(shape);
       if(element.getText() != "" || element.getText() != null){
           if(shape instanceof Ellipse2D.Double){
               Ellipse2D.Double ellipse = (Ellipse2D.Double)shape;
              // g.drawString(element.getText(), (int)ellipse.getCenterX(), (int)ellipse.getCenterY());
           }
        }

    }

    public void setSelectedColor() {
        preSelektovanja = color;
        setColor(selectedColor);
    }

    public void returnOriginalColor(){
        setColor(preSelektovanja);
    }

    public boolean elementAt(double x, double y){
        if(element instanceof Veza) {
            return shape.getBounds2D().contains(x, y);
        }
        return shape.contains(x,y);
    }


    public void setElement(Element element) {
        this.element = element;
    }

    public Element getElement() {
        return element;
    }

    public Shape getShape() {
        return shape;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }

    public Color getColor() {
        return color;
    }

    public  void setColor(Color clr) {
       this.color = clr;
    }



}
