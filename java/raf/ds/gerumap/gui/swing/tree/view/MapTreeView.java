package raf.ds.gerumap.gui.swing.tree.view;

import raf.ds.gerumap.gui.swing.tree.controller.DoubleClickTree;
import raf.ds.gerumap.gui.swing.tree.controller.MapTreeCellEditor;
import raf.ds.gerumap.gui.swing.tree.controller.MapTreeSelectionListener;

import javax.swing.*;
import javax.swing.tree.DefaultTreeModel;

public class MapTreeView extends JTree{

    public MapTreeView(DefaultTreeModel defaultTreeModel) {
        setModel(defaultTreeModel);
        MapTreeCellRenderer ruTreeCellRenderer = new MapTreeCellRenderer();
        addTreeSelectionListener(new MapTreeSelectionListener());
        setCellEditor(new MapTreeCellEditor(this, ruTreeCellRenderer));
        setCellRenderer(ruTreeCellRenderer);
        addMouseListener(new DoubleClickTree());
        setEditable(true);
    }
}
