package raf.ds.gerumap.gui.swing.view.modelView;

import com.sun.java.swing.plaf.windows.WindowsBorders;
import jdk.jfr.internal.tool.Main;
import raf.ds.gerumap.core.ApplicationFramework;
import raf.ds.gerumap.gui.swing.controller.ScrollController;
import raf.ds.gerumap.gui.swing.listener.MindViewMouseAdapter;
import raf.ds.gerumap.gui.swing.listener.MindViewMouseMotionListener;
import raf.ds.gerumap.gui.swing.tree.model.MapTreeItem;
import raf.ds.gerumap.gui.swing.view.MainFrame;
import raf.ds.gerumap.notification.Notification;
import raf.ds.gerumap.observer.ISubscriber;

import raf.ds.gerumap.painters.ElementPainter;
import raf.ds.gerumap.painters.TopicPainter;
import raf.ds.gerumap.painters.VezaPainter;
import raf.ds.gerumap.painters.ZoomPainter;
import raf.ds.gerumap.repository.command.AbstractCommand;
import raf.ds.gerumap.repository.command.implementations.AddElementCommand;
import raf.ds.gerumap.repository.command.implementations.RemoveElementCommand;
import raf.ds.gerumap.repository.implementation.MindMap;
import raf.ds.gerumap.state.StateManager;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MindView  extends JPanel implements ISubscriber{

   // String name;
    private MindMap mindModel;
    private StateManager stateManager;

    private ProjectView containerParent;

    private JLabel label;
    private transient List<ElementPainter> elementi;
    private transient List<ElementPainter> selectedElements;
    private Rectangle2D selectionRectangle = null;
    private Line2D selectionLine;
    private AffineTransform affineTransform;

    private ZoomPainter zoomPainter;
    private MapTreeItem mapTreeItem;


    public MindView(MindMap mindModel, ProjectView containerParent){
        this.containerParent = containerParent;
        this.mindModel = mindModel;
        this.mindModel.addSubscriber(this);
        init();
   }


    private void init(){
       setMaximumSize(new Dimension(300, 500));
       setBackground(new Color(250, 209, 111, 75));

      addMouseListener(new MindViewMouseAdapter(this));
      addMouseMotionListener(new MindViewMouseMotionListener(this));

       selectionRectangle = new Rectangle2D.Double();
       selectionLine = new Line2D.Double();
       stateManager = new StateManager(containerParent);
       elementi = new ArrayList<>();
       selectedElements = new ArrayList<ElementPainter>();
       affineTransform = new AffineTransform();
       mapTreeItem = new MapTreeItem(mindModel);

       this.addMouseWheelListener(new ScrollController(stateManager,this));
      // ApplicationFramework.getInstance().getMapRepository().disableUndoAction();
      // ApplicationFramework.getInstance().getMapRepository().disableRedoAction();
   }

    @Override
    public void update(Notification notification) {
        System.out.println("update");
        System.out.println("mindmodel " + mindModel.getName());
        System.out.println("br elemenata: " + elementi.size());
        MainFrame.getInstance().repaint();
    }

    public void setColorForSelectedElements(Color color){
        for(ElementPainter painter : selectedElements)
            painter.setColor(color);
        selectedElements.removeAll(selectedElements);
    }

    public void setStrokeForSelectedElements(List<ElementPainter> lista, int stroke){
        for(ElementPainter painter : lista)
            painter.getElement().setStroke(stroke);
        selectedElements.removeAll(selectedElements);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MindView mindView = (MindView) o;
        return Objects.equals(mindModel, mindView.mindModel);
    }

    public MindMap getMindModel() {
        return mindModel;
    }

    public void misKliknut(MindView mv, int x, int y) {
        stateManager.getCurrentState().mousePressed(mv, x, y);
    }

    public void misPrevlacenje(MindView mv, int x, int y){
        stateManager.getCurrentState().mouseDragged(mv, x, y);
    }

    public void misOtpusten(MindView mv, int x, int y){
        stateManager.getCurrentState().mouseReleased(mv, x, y);
    }

    public List<ElementPainter> getSelectedElements() {
        return selectedElements;
    }

    public void setSelectedElements(List<ElementPainter> selectedElements) {
        this.selectedElements = selectedElements;
    }

    public List<ElementPainter> getElementPainteri() {
        return elementi;
    }

    public void addElementPainter(ElementPainter elementPainter){
        AbstractCommand command = new AddElementCommand(this, elementPainter);
       // ApplicationFramework.getInstance().getMapRepository().getCommandManager().addCommand(command);
        mindModel.getCommandManager().addCommand(command);

    }

    public void removeElementPainter(){
        AbstractCommand command = new RemoveElementCommand(this);
       // ApplicationFramework.getInstance().getMapRepository().getCommandManager().addCommand(command);
        mindModel.getCommandManager().addCommand(command);
    }

    public void startRectangleState(){

        this.stateManager.setRectangleState();
    }

    public void startSelectState(){
        this.stateManager.setSelectState();
    }


    public void startLineState(){
        this.stateManager.setLineState();
    }

    public void startDeleteState(){
        this.stateManager.setDeleteState();
        //
    }
    public void startMoveState(){
        this.stateManager.setMoveState();
    }

    public void startZoomState(){
        this.stateManager.setZoomState();
    }

    public void paintComponent(Graphics g){
        System.out.println("paintcomponent");

        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        if(zoomPainter != null) {
            zoomPainter.crtaj(g2);
        }

       if(selectionRectangle != null) {
           g2.setColor(new Color(0,204,255));
           Stroke dashed = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0);
           g2.setStroke(dashed);
           g2.draw(selectionRectangle);
       }

        for (ElementPainter p: elementi){
            p.paint(g2);
        }

     }

     public List<TopicPainter> getTopicPainters(){
        List<TopicPainter> topics = new ArrayList<>();
        for(ElementPainter painter: elementi){
            if(painter instanceof TopicPainter)
                topics.add((TopicPainter) painter);
        }
        return topics;
     }

    public List<VezaPainter> getVezaPainters(){
        List<VezaPainter> veze = new ArrayList<>();
        for(ElementPainter painter: elementi){
            if(painter instanceof VezaPainter)
                veze.add((VezaPainter) painter);
        }
        return veze;
    }


    public void setSelectionRectangle(Rectangle2D selectionRectangle) {
        this.selectionRectangle = selectionRectangle;
    }

    public Rectangle2D getSelectionRectangle() {
        return selectionRectangle;
    }


    public ZoomPainter getZoomPainter() {
        return zoomPainter;
    }

    public void setMindModel(MindMap mindModel) {
        this.mindModel = mindModel;
    }

    public List<ElementPainter> getElementi() {
        return elementi;
    }
}
