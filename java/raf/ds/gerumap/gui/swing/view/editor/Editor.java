package raf.ds.gerumap.gui.swing.view.editor;

import raf.ds.gerumap.gui.swing.view.MainFrame;
import raf.ds.gerumap.painters.ElementPainter;

import javax.swing.*;

public class Editor extends JDialog {

    protected ElementPainter elementPainter;	//view u kom se nalazi

    public Editor(ElementPainter elementView) {
        super(MainFrame.getInstance(), "", true);

        this.elementPainter = elementView;

        podesavanja();
    }

    private void podesavanja() {
        setSize(500,500);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    public ElementPainter getSlotView() {
        return elementPainter;
    }


}
