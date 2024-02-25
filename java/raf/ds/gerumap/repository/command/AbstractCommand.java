package raf.ds.gerumap.repository.command;

public abstract class AbstractCommand {

    public abstract void doCommand();
    public abstract void undoCommand();
}
