package raf.ds.gerumap.state;

import raf.ds.gerumap.gui.swing.view.modelView.ProjectView;
import raf.ds.gerumap.state.actions.*;

public class StateManager {

    private ProjectView mediator;
    private State currentState;

    private DeleteState deleteState;
    private ZoomState zoomState;
    private MoveState moveState;
    private SelectState selectState;
    private ElipsaState elipsaState;

    private LineState lineState;

    public StateManager(ProjectView mediator){
        initStates();
        this.mediator = mediator;
    }

    private void initStates(){
        this.selectState = new SelectState(mediator);
        this.deleteState = new DeleteState(mediator);
        this.moveState = new MoveState(mediator);
        this.elipsaState = new ElipsaState(mediator);
        this.lineState = new LineState(mediator);
        this.zoomState = new ZoomState(mediator);
        this.currentState = elipsaState;

    }

    public State getCurrentState() {
        return currentState;
    }

    public void setMoveState() {
        currentState = moveState;
    }


    public void setDeleteState(){
        currentState = deleteState;
    }

    public void setSelectState(){
        currentState = selectState;
    }

    public void setRectangleState() {
        currentState = elipsaState;
    }

    public void setZoomState() {
        currentState = zoomState;
    }

    public void setLineState() {
        currentState = lineState;
    }
}
