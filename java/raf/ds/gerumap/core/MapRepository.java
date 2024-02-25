package raf.ds.gerumap.core;

import raf.ds.gerumap.repository.command.CommandManager;
import raf.ds.gerumap.repository.composite.MapNode;
import raf.ds.gerumap.repository.composite.MapNodeComposite;
import raf.ds.gerumap.repository.implementation.ProjectExplorer;

public interface MapRepository {

    ProjectExplorer getProjectExplorer();
    void addChild(MapNodeComposite parent, MapNode child);

}
