package raf.ds.gerumap.state.actions;

import raf.ds.gerumap.gui.swing.view.modelView.MindView;
import raf.ds.gerumap.gui.swing.view.modelView.ProjectView;
import raf.ds.gerumap.painters.TopicPainter;
import raf.ds.gerumap.painters.VezaPainter;
import raf.ds.gerumap.repository.implementation.Topic;
import raf.ds.gerumap.repository.implementation.Veza;
import raf.ds.gerumap.state.State;

public class LineState extends State {

    private Veza veza ;
    int startX;
    int startY;
    private VezaPainter vezaPainter = null;
    int brojac = 0;


    public LineState(ProjectView mediator) {

    }


    @Override
    public void mousePressed(MindView mv, int x, int y) {
        for(TopicPainter topicPainter: mv.getTopicPainters()){
                if(topicPainter.elementAt(x,y)){
                    startX = x;
                    startY = y;
                    veza = new Veza(startX, startY, x, y);
                    mv.getMindModel().addChild(veza);
                    veza.setParent(mv.getMindModel());
                    veza.setName("Veza" + ++brojac);
                    veza.setStartTopic((Topic) topicPainter.getElement());
                    vezaPainter = new VezaPainter(veza);
                    mv.addElementPainter(vezaPainter);
                    return;
                }

            }
        //todo: proveris da li neki painter sadrzi x, y,
        // ako da -> njegove x,y su start
        }


    @Override
    public void mouseDragged(MindView mv,int x, int y) {

        if(vezaPainter != null) {
            vezaPainter.getElement().setWidth(y);
            vezaPainter.getElement().setHeight(x);
            vezaPainter.getElement().notifySubscribers(null);
        }
        else
            return;

        //todo: crtas novi line2D od pocetnih, do ovih koje su stigle kao argumenti
    }

    @Override
    public void mouseReleased(MindView mv,int x, int y) {
        boolean found = false;

        if(vezaPainter != null) {

            if(x == startX && y == startY){
                for (VezaPainter painter : mv.getVezaPainters()) {
                    if (painter.equals(vezaPainter)) {
                        mv.getElementPainteri().remove(painter);
                        mv.getMindModel().removeChild(veza);
                        vezaPainter.getElement().notifySubscribers(null);
                        break;
                    }
                }
                vezaPainter = null;
                return;
            }

                if(veza.getStartTopic().getTopicShape().contains(x, y)){
                for (VezaPainter painter : mv.getVezaPainters()) {
                    if (painter.equals(vezaPainter)) {
                        mv.getElementPainteri().remove(painter);
                        mv.getMindModel().removeChild(veza);
                        vezaPainter.getElement().notifySubscribers(null);
                        break;
                    }
                }
                vezaPainter = null;
                return;
            }


            for (TopicPainter p : mv.getTopicPainters()) {
                if (p.elementAt(x, y)) {
                    veza.setEndTopic((Topic) p.getElement());
                 //   veza.setEndingTopic(p);
                   // mv.addElementPainter(vezaPainter);
                    vezaPainter.getElement().notifySubscribers(null);
                    found = true;
                    break;
                }
            }
                    if(!found) {
                        for (VezaPainter painter : mv.getVezaPainters()) {
                            if (painter.equals(vezaPainter)) {
                                mv.getElementPainteri().remove(painter);
                                vezaPainter.getElement().notifySubscribers(null);
                                break;
                            }
                        }
                    }
                    vezaPainter = null;
                   found = false;
                }
        else {
            return;
        }
        //todo: proveris da li x,y pripadaju nekom painteru
        // ako da, napravis VezaPainter, pozoves da se napravi shape, ubacis painter u View
        // ako ne, brises liniju
        }

    public Veza getVeza() {
        return veza;
    }

    public void setVeza(Veza veza) {
        this.veza = veza;
    }
}
