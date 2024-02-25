package raf.ds.gerumap.factory;

import raf.ds.gerumap.repository.command.CommandManager;
import raf.ds.gerumap.repository.composite.MapNode;
import raf.ds.gerumap.repository.composite.MapNodeComposite;
import raf.ds.gerumap.repository.implementation.MindMap;

public class MindMapFactory extends MapNodeFactory{
    @Override
    public MapNode createMapNode(MapNode parent) {
        return new MindMap("MindMap ", parent, new CommandManager());
    }
}
