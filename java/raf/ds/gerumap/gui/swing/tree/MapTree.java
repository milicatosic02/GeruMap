package raf.ds.gerumap.gui.swing.tree;

import raf.ds.gerumap.gui.swing.tree.model.MapTreeItem;
import raf.ds.gerumap.gui.swing.tree.view.MapTreeView;
import raf.ds.gerumap.notification.Notification;
import raf.ds.gerumap.repository.composite.MapNode;
import raf.ds.gerumap.repository.implementation.Element;
import raf.ds.gerumap.repository.implementation.Project;
import raf.ds.gerumap.repository.implementation.ProjectExplorer;

public interface MapTree {

    MapTreeView generateTree(ProjectExplorer projectExplorer);
    MapTreeView getTreeView();
    void addChild(MapTreeItem parent, MapNode child);
    MapTreeItem getSelectedNode();
    void deleteChild(MapTreeItem child);
    void setSelectedNode(MapTreeItem mapNode);

    void addElement(Element element);

    void loadProject(Project node);



}
