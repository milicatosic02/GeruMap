package raf.ds.gerumap.repository.command;

import raf.ds.gerumap.core.ApplicationFramework;
import raf.ds.gerumap.gui.swing.view.MainFrame;
import raf.ds.gerumap.repository.implementation.MindMap;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CommandManager {

   // private MindMap mindMap;
    private List<AbstractCommand> commands = new ArrayList<AbstractCommand>();
    private int currentCommand = 0;

    public CommandManager(){
    }

    public void addCommand(AbstractCommand command){
        while(currentCommand < commands.size())
            commands.remove(currentCommand);
        commands.add(command);
        doCommand();
    }

    public void doCommand() {
        if(currentCommand < commands.size()){
            commands.get(currentCommand++).doCommand();
            SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getMapTree().getTreeView());
            ApplicationFramework.getInstance().getGui().enableUndoAction();
        }
        if(currentCommand==commands.size()){
            ApplicationFramework.getInstance().getGui().disableRedoAction();
        }
    }

    public void doCheck(){
        if(currentCommand < commands.size()) {
            ApplicationFramework.getInstance().getGui().enableUndoAction();
        }
        if(currentCommand==commands.size()){
            ApplicationFramework.getInstance().getGui().disableRedoAction();
        }
    }

    public void undoCheck(){
        if(currentCommand > 0) {
            ApplicationFramework.getInstance().getGui().enableRedoAction();
        }
        if(currentCommand==0){
            ApplicationFramework.getInstance().getGui().disableUndoAction();
        }
    }

    public void undoCommand(){
        if(currentCommand > 0){
            ApplicationFramework.getInstance().getGui().enableRedoAction();
            commands.get(--currentCommand).undoCommand();
            SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getMapTree().getTreeView());
        }
        if(currentCommand==0){
            ApplicationFramework.getInstance().getGui().disableUndoAction();
        }
    }

//    public void setMindMap(MindMap mindMap) {
//        this.mindMap = mindMap;
//    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        CommandManager that = (CommandManager) o;
//        return Objects.equals(mindMap, that.mindMap);
//    }

}
