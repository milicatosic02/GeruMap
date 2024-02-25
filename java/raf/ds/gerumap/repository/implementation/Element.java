package raf.ds.gerumap.repository.implementation;

import raf.ds.gerumap.notification.ShapeType;
import raf.ds.gerumap.repository.composite.MapNode;
import raf.ds.gerumap.repository.composite.MapNodeComposite;

import java.awt.*;
import java.io.File;

public class Element extends MapNode {

    protected  double x, y;

    protected transient double pocetnoX;
    protected transient double pocetnoY;

    protected transient double novoX;
    protected transient double novoY;

    protected transient double width, height;
    protected transient int stroke = 2;

    protected transient ShapeType type;
   // protected MapNode parent;
    protected transient String text = "";
   // protected ShapeType sadrzaj;	//da li je textualni ili je graficki


    public Element(String name, MapNode parent) {
        super(name, parent);
    }

    public Element(){}



    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }


    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public int getStroke() {
        return stroke;
    }

    public ShapeType getType() {
        return type;
    }

    public void setType(ShapeType type) {
        this.type = type;
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    public void setStroke(int stroke) {
        this.stroke = stroke;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public double getPocetnoX() {
        return pocetnoX;
    }

    public double getPocetnoY() {
        return pocetnoY;
    }

    public void setPocetnoX(double pocetnoX) {
        this.pocetnoX = pocetnoX;
    }

    public void setPocetnoY(double pocetnoY) {
        this.pocetnoY = pocetnoY;
    }

    public double getNovoX() {
        return novoX;
    }

    public void setNovoX(double novoX) {
        this.novoX = novoX;
    }

    public double getNovoY() {
        return novoY;
    }

    public void setNovoY(double novoY) {
        this.novoY = novoY;
    }


}
