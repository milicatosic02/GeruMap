package raf.ds.gerumap.factory;

import raf.ds.gerumap.gui.swing.tree.model.MapTreeItem;
import raf.ds.gerumap.repository.composite.MapNodeComposite;
import raf.ds.gerumap.repository.implementation.MindMap;
import raf.ds.gerumap.repository.implementation.Project;
import raf.ds.gerumap.repository.implementation.ProjectExplorer;

public class UtilsFactory {

    public static MapNodeFactory getFactory(MapTreeItem selected){
       if(((MapNodeComposite)selected.getMapNode() instanceof ProjectExplorer))
           return new ProjectFactory();
        if(((MapNodeComposite)selected.getMapNode() instanceof Project))
            return new MindMapFactory();
        if(((MapNodeComposite)selected.getMapNode() instanceof MindMap))
            return new ElementFactory();

        return null;
    }

}
