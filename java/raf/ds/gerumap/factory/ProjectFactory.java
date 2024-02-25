package raf.ds.gerumap.factory;

import raf.ds.gerumap.repository.composite.MapNode;
import raf.ds.gerumap.repository.composite.MapNodeComposite;
import raf.ds.gerumap.repository.implementation.Project;

public class ProjectFactory extends MapNodeFactory{
    @Override
    public MapNode createMapNode(MapNode parent) {
        return new Project("Project " , parent);
    }
}
