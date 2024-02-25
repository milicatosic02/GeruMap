package raf.ds.gerumap.factory;

import raf.ds.gerumap.repository.composite.MapNode;
import raf.ds.gerumap.repository.implementation.Element;

public class ElementFactory extends MapNodeFactory{
    @Override
    public MapNode createMapNode(MapNode parent) {
        return new Element("Element ", parent);
    }
}
