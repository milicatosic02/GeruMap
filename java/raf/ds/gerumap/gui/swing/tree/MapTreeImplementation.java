package raf.ds.gerumap.gui.swing.tree;

import raf.ds.gerumap.gui.swing.tree.model.MapTreeItem;
import raf.ds.gerumap.gui.swing.tree.model.MapTreeModel;
import raf.ds.gerumap.gui.swing.tree.view.MapTreeView;
import raf.ds.gerumap.gui.swing.view.MainFrame;
import raf.ds.gerumap.gui.swing.view.modelView.MindView;
import raf.ds.gerumap.gui.swing.view.modelView.ProjectView;
import raf.ds.gerumap.notification.Notification;
import raf.ds.gerumap.notification.NotificationCode;
import raf.ds.gerumap.observer.IPublisherImpl;
import raf.ds.gerumap.painters.TopicPainter;
import raf.ds.gerumap.painters.VezaPainter;
import raf.ds.gerumap.repository.command.CommandManager;
import raf.ds.gerumap.repository.composite.MapNode;
import raf.ds.gerumap.repository.composite.MapNodeComposite;
import raf.ds.gerumap.repository.implementation.*;


import javax.sound.sampled.Port;
import javax.swing.*;
import javax.swing.event.TreeExpansionEvent;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultTreeSelectionModel;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;
import java.awt.event.*;
import java.util.Random;

public class MapTreeImplementation implements MapTree {

    private MapTreeView treeView;
    private MapTreeModel treeModel;

    @Override
    public MapTreeView generateTree(ProjectExplorer projectExplorer) {
        MapTreeItem root = new MapTreeItem(projectExplorer);
        treeModel = new MapTreeModel(root);
        treeView = new MapTreeView(treeModel);
        return treeView;
    }

    @Override
    public MapTreeView getTreeView() {
        return treeView;
    }

    @Override
    public void addChild(MapTreeItem parent, MapNode child) {
        if (!(parent.getMapNode() instanceof MapNodeComposite))
            return;

        parent.add(new MapTreeItem(child));
        ((MapNodeComposite) parent.getMapNode()).addChild(child);
        treeView.expandPath(treeView.getSelectionPath());
        SwingUtilities.updateComponentTreeUI(treeView);
    }

    @Override
    public void deleteChild(MapTreeItem child) {
            ((MapNodeComposite) getSelectedNode().getMapNode().getParent()).removeChild(child.getMapNode());
            treeModel.removeNodeFromParent(child);
    }

    @Override
    public void setSelectedNode(MapTreeItem mapNode) {

    }

    @Override
    public void addElement(Element element) {
        MapNode nodeModel = ((MapTreeItem)treeView.getLastSelectedPathComponent()).getMapNode();
        ((MapTreeItem)treeView.getLastSelectedPathComponent()).add(new MapTreeItem(element));
        ((MindMap)nodeModel).addChild(element);
        treeView.expandPath(treeView.getSelectionPath());
        SwingUtilities.updateComponentTreeUI(treeView);
    }

    @Override
    public void loadProject(Project node) {
        MapTreeItem loadedProject = new MapTreeItem(node);
        treeModel.getRoot().add(loadedProject);
        ProjectView.getInstance().setProjectModel(node);

        MapNodeComposite mapNode = (MapNodeComposite) treeModel.getRoot().getMapNode();
        mapNode.addChild(node);

        for(MapNode map: node.getChildren()){
            map.setParent(node);
            MindMap mindMap = (MindMap)map;

            mindMap.setCommandManager(new CommandManager());
            MindView mv = new MindView(mindMap, ProjectView.getInstance());

            for(MapNode element: mindMap.getChildren()){
                if(element instanceof Veza) {
                    VezaPainter vezaPainter = new VezaPainter((Veza) element);
                   // mv.addElementPainter(vezaPainter);
                    mv.getElementi().add(vezaPainter);
                    System.out.println("mv.sub" + mv.getMindModel().countSubscribers());
                    mv.getMindModel().notifySubscribers(null);
                }
                else{
                    Topic topic = (Topic) element;
                    TopicPainter topicPainter = new TopicPainter(topic);
                   // mv.addElementPainter(topicPainter);
                    mv.getElementi().add(topicPainter);
                    boolean c;
                    c = ((MapNode) mv.getMindModel()).getSubscribers().contains(mv);
                    mv.repaint();
                    System.out.println("mv.sub" + mv.getMindModel().countSubscribers());
                    System.out.println("elemnt: " + topicPainter.getElement().getName());
                    mv.getMindModel().notifySubscribers(null);
                }
            }
            System.out.println("elementi.size " + mv.getElementi().size());
            ProjectView.getInstance().getMindViews().add(mv);

           // mv.getMindModel().notifySubscribers(null);

            MapTreeItem mapTreeItem = new MapTreeItem(map);
            loadedProject.add(mapTreeItem);
        }
        treeView.expandPath(treeView.getSelectionPath());
        SwingUtilities.updateComponentTreeUI(treeView);
    }


    @Override
    public MapTreeItem getSelectedNode() {
        return (MapTreeItem) treeView.getLastSelectedPathComponent();
    }

}

