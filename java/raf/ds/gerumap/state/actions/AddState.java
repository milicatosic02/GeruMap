package raf.ds.gerumap.state.actions;

import raf.ds.gerumap.gui.swing.view.modelView.MindView;
import raf.ds.gerumap.gui.swing.view.modelView.ProjectView;
import raf.ds.gerumap.state.State;

public class AddState extends State {
    private  ProjectView mediator;
    public AddState(ProjectView mediator){
        this.mediator = mediator;
    }

}
