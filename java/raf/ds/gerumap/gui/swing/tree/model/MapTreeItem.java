package raf.ds.gerumap.gui.swing.tree.model;

import raf.ds.gerumap.repository.composite.MapNode;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;

public class MapTreeItem extends DefaultMutableTreeNode {
    private MapNode mapNode;

    public MapTreeItem(MapNode nodeModel) {
        this.mapNode = nodeModel;
    }

    @Override
    public String toString() {
        return mapNode.getName();
    }

    public void setName(String name) {
        this.mapNode.setName(name);
    }

    public MapNode getMapNode() {
        return mapNode;
    }

}
