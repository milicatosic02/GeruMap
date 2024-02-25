package raf.ds.gerumap.gui;

import raf.ds.gerumap.repository.command.CommandManager;
import raf.ds.gerumap.core.Gui;
import raf.ds.gerumap.gui.swing.view.MainFrame;

public class SwingGui implements Gui {

    @Override
    public void start() {
            MainFrame mf = MainFrame.getInstance();
            mf.setVisible(true);
        }

    @Override
    public void disableUndoAction() {
        MainFrame.getInstance().getActionManager().getUndoAction().setEnabled(false);
    }

    @Override
    public void disableRedoAction() {
        MainFrame.getInstance().getActionManager().getRedoAction().setEnabled(false);
    }

    @Override
    public void enableUndoAction() {
        MainFrame.getInstance().getActionManager().getUndoAction().setEnabled(true);
    }

    @Override
    public void enableRedoAction() {
        MainFrame.getInstance().getActionManager().getRedoAction().setEnabled(true);
    }

}
