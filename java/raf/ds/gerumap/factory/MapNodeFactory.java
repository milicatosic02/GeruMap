package raf.ds.gerumap.factory;

import raf.ds.gerumap.repository.command.CommandManager;
import raf.ds.gerumap.repository.composite.MapNode;
import raf.ds.gerumap.repository.composite.MapNodeComposite;
import raf.ds.gerumap.repository.implementation.MindMap;

public abstract class MapNodeFactory {

    public MapNode makeMapNode(MapNode parent){
        MapNode mapNode;
        mapNode = createMapNode(parent);
        mapNode.setParent(parent);
        if(mapNode instanceof MindMap){
          //  ((MindMap) mapNode).getCommandManager().setMindMap((MindMap) mapNode);
        }
        if(parent instanceof MapNodeComposite){
            Integer i = ((MapNodeComposite)parent).getChildren().size() + 1;
           int br = 1;
            for(MapNode mapNode1: ((MapNodeComposite)parent).getChildren()){
                String name = mapNode1.getName();
                String[] niz = name.split(" ");
                String res = niz[1];
                br = Integer.parseInt(res) + 1;
            }

            mapNode.setName(mapNode.getName() + br);
            ((MapNodeComposite)parent).addChild(mapNode);
        }
        return mapNode;
    }

    public abstract MapNode createMapNode(MapNode parent);
}
