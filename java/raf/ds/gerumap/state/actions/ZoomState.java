package raf.ds.gerumap.state.actions;

import raf.ds.gerumap.gui.swing.view.modelView.MindView;
import raf.ds.gerumap.gui.swing.view.modelView.ProjectView;
import raf.ds.gerumap.painters.ZoomPainter;
import raf.ds.gerumap.state.State;

import java.awt.event.MouseWheelEvent;

public class ZoomState extends State {

    double uX = 0;
    double uY = 0;
    double xPomeraj = 0;
    double yPomeraj = 0 ;
    double p1;
    double p2;

    public ZoomState(ProjectView mediator) {

    }

    @Override
    public void mouseWheelMoved(MindView mv, int x, int y, int wheelRotation) {
        ZoomPainter z = mv.getZoomPainter();
        z.setxRel(x-uX);
        z.setyRel(y-uY);

        if(wheelRotation < 0 ){
            z.setZoomFactor(1.1,"+");
        }if(wheelRotation > 0){
            z.setZoomFactor(1.1,"-");
        }
        z.setZoomer(true);
    }

    @Override
    public void mousePressed(MindView mv, int x, int y) {
        xPomeraj = x;
        yPomeraj =y;
    }

    @Override
    public void mouseDragged(MindView mv, int x, int y) {
        ZoomPainter z = mv.getZoomPainter();
        uX = (uX + x - xPomeraj) *z.getZoomFactor();
        uY = (uY + y - yPomeraj)*z.getZoomFactor();
        pom(uX,uY);
        z.setOffSet(uX,uY);
    }


    public void pom(double xOffSet, double yoffSet){
        if(xOffSet > 0  && yoffSet >0){
            xOffSet =0;
            yoffSet =0;
        } else if (xOffSet>0) {
            xOffSet =0;
        }else if (yoffSet >0) {
            yoffSet = 0;
        }
    }
}
