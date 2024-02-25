package raf.ds.gerumap.core;

import raf.ds.gerumap.repository.command.CommandManager;

public interface Gui {
    void start();

    void disableUndoAction();
    void disableRedoAction();

    void enableUndoAction();
    void enableRedoAction();
}
