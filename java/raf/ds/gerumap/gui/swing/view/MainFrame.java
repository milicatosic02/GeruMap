package raf.ds.gerumap.gui.swing.view;

import raf.ds.gerumap.core.ApplicationFramework;
import raf.ds.gerumap.core.MessageGeneratorInterface;
import raf.ds.gerumap.gui.swing.controller.ActionManager;
import raf.ds.gerumap.gui.swing.tree.MapTree;
import raf.ds.gerumap.gui.swing.tree.MapTreeImplementation;
import raf.ds.gerumap.gui.swing.view.modelView.MindView;
import raf.ds.gerumap.gui.swing.view.modelView.ProjectView;
import raf.ds.gerumap.message.MessageGeneratorImpl;
import raf.ds.gerumap.state.StateManager;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private static MainFrame instance;
    private ActionManager actionManager;
    private JMenuBar menu;
    private JToolBar toolBar;
    private MapTree mapTree;
    private MessageGeneratorInterface messageGenerator;
    private ProjectView projectView;
    private JTree peTree;

    private StateManager stateManager;
    private JToolBar paintToolBar;





    public MainFrame(){

    }

    public static MainFrame getInstance(){
        if(instance == null){
            instance = new MainFrame();
            instance.initialise();
        }

        return instance;
    }

    private void initialise(){
        actionManager = new ActionManager();
        mapTree = new MapTreeImplementation();
        initialiseGUI();
    }

    private void initialiseGUI(){
        Toolkit tool  = Toolkit.getDefaultToolkit();
        Dimension screenSize = getToolkit().getScreenSize();
        int height = screenSize.height;
        int width = screenSize.width;
        setSize(width/2,height/2);
        setTitle("GeRuMap");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        menu = new MyMenuBar();
        setJMenuBar(menu);

        toolBar = new ToolBar();
        add(toolBar, BorderLayout.NORTH);

        paintToolBar = new PaintToolBar();
        add(paintToolBar, BorderLayout.EAST);

        messageGenerator = ApplicationFramework.getInstance().getMessageGeneratorInterface();

        ((MessageGeneratorImpl)messageGenerator).addSubscriber(new MessageGeneratorView());

        JTree projectExplorer = mapTree.generateTree(ApplicationFramework.getInstance().getMapRepository().getProjectExplorer());

        JScrollPane scroll = new JScrollPane(projectExplorer);
        scroll.setMinimumSize(new Dimension(200, 150));
        JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, scroll, ProjectView.getInstance());
        getContentPane().add(split, BorderLayout.CENTER);
        split.setDividerLocation(250);
        split.setOneTouchExpandable(true);


    }


    public ActionManager getActionManager(){
        return actionManager;
    }

    public MapTree getMapTree() {
        return mapTree;
    }

    public ProjectView getProjectView() {
        return projectView;
    }

    public MessageGeneratorInterface getMessageGenerator() {
        return messageGenerator;
    }

    public JToolBar getToolBar() {
        return toolBar;
    }


}
