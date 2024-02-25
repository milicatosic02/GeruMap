package raf.ds.gerumap.painters;

import javafx.scene.transform.Affine;
import raf.ds.gerumap.gui.swing.view.modelView.MindView;
import raf.ds.gerumap.notification.Notification;
import raf.ds.gerumap.notification.NotificationCode;
import raf.ds.gerumap.observer.IPublisher;
import raf.ds.gerumap.observer.ISubscriber;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.List;

public class ZoomPainter implements IPublisher {

    private MindView mindView;
    private List<ISubscriber> subscribers;
    private double zoomFactor = 1;
    private double prevZoom;
    private double xOffSet, yoffSet, xRel, yRel;
    private boolean zoomer = false;

    public ZoomPainter(MindView mindView){
        this.subscribers = new ArrayList<>();
        this.mindView = mindView;
        addSubscriber(mindView);
        xOffSet = 0;
        yoffSet = 0;
    }

    public void crtaj(Graphics2D g){
        AffineTransform affineTransform = new AffineTransform();
        double zoomDiv = zoomFactor/prevZoom;
        if(zoomer){
            xOffSet = (zoomDiv) * (xOffSet) + (1-zoomDiv) * xRel;
            yoffSet = (zoomDiv) * (yoffSet) + (1-zoomDiv) * yRel;
            pom();
            zoomer = false;
        }
        affineTransform.translate(xOffSet,yoffSet);
        affineTransform.scale(zoomFactor,zoomFactor);
        prevZoom = zoomFactor;
        g.transform(affineTransform);
    }
    public void setZoomFactor(double z, String znak ){
        if(znak.equals("+")){
            this.zoomFactor = this.zoomFactor*z;
        }else{
            this.zoomFactor = this.zoomFactor/z;
        }
        if(zoomFactor <0.5){
            zoomFactor = 0.5;
        }
        if(zoomFactor > 3){
            zoomFactor = 3;
        }
        this.notifySubscribers(new Notification(NotificationCode.ZOOM, null));
    }

    private void pom(){
        if(xOffSet > 0  && yoffSet >0){
            xOffSet =0;
            yoffSet =0;
        } else if (xOffSet>0) {
            xOffSet =0;
        }else if (yoffSet >0) {
            yoffSet = 0;
        }
    }

    public void setZoomer(boolean zoomer) {
        this.zoomer = zoomer;
        notifySubscribers(new Notification(NotificationCode.ZOOM,zoomer));
    }

    public void setOffSet(double xOffSet, double yoffSet){
        this.xOffSet = xOffSet;
        this.yoffSet = yoffSet;
        notifySubscribers(new Notification(NotificationCode.offSet,xOffSet));
    }

    @Override
    public void addSubscriber(ISubscriber subscriber) {
        this.getSubscribers().add(subscriber);
    }

    @Override
    public void notifySubscribers(Notification notification) {


        for(ISubscriber subscriber: this.getSubscribers())
            subscriber.update(notification);
    }

    @Override
    public int countSubscribers() {
        return 0;
    }

    public void setxRel(double xRel) {
        this.xRel = xRel;
    }

    public void setyRel(double yRel) {
        this.yRel = yRel;
    }

    public double getZoomFactor() {
        return zoomFactor;
    }

    public double getxOffSet() {
        return xOffSet;
    }

    public double getYoffSet() {
        return yoffSet;
    }

    public List<ISubscriber> getSubscribers() {
        return subscribers;
    }
}

