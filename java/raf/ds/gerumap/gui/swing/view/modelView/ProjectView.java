package raf.ds.gerumap.gui.swing.view.modelView;


import raf.ds.gerumap.gui.swing.view.MainFrame;
import raf.ds.gerumap.notification.NotificationCode;
import raf.ds.gerumap.observer.ISubscriber;
import raf.ds.gerumap.painters.TopicPainter;
import raf.ds.gerumap.painters.VezaPainter;
import raf.ds.gerumap.repository.composite.MapNode;
import raf.ds.gerumap.repository.implementation.MindMap;
import raf.ds.gerumap.repository.implementation.Project;
import raf.ds.gerumap.notification.Notification;
import raf.ds.gerumap.repository.implementation.Topic;
import raf.ds.gerumap.repository.implementation.Veza;

import javax.swing.*;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class ProjectView extends JPanel implements ISubscriber {

    private Project projectModel;
    private JLabel projectName;
    private JLabel authorName;
    private List<MindView> mindViews;

    private JTabbedPane jTabbedPane;
    private JScrollPane jScrollPane;
    private static ProjectView instance;
    //

    public static ProjectView getInstance(){
        if(instance == null)
            instance = new ProjectView();
        return instance;
    }

    private ProjectView(){
        initialiseThis();
    }

    private List<MindView> getMindViews(Project project){
        List<MindView> list = new ArrayList<>();
        for(MapNode mapNode : project.getChildren()){
            MindView mindView = new MindView((MindMap) mapNode, this);
            list.add(mindView);
        }
            return list;
    }

    public void createTabs(List<MindView> mindViews) {
        for (MindView mindView : mindViews) {
            jTabbedPane.addTab(mindView.getMindModel().getName(), mindView);
        }
    }


    private void initialiseThis() {
        projectName = new JLabel("Project name:");
        authorName = new JLabel("Project author:");
        jTabbedPane = new JTabbedPane();
        mindViews = new ArrayList<>();


        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        add(projectName);
        add(authorName);

        add(jTabbedPane);

        setVisible(true);

        jTabbedPane.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
             MindView mv =  (MindView) jTabbedPane.getSelectedComponent();
                System.out.println("Ime mape: " + mv.getMindModel().getName() + ", broj dece u mapi: " + mv.getMindModel().getChildren().size() + ", a broj paintera je :" + mv.getElementi().size());
                System.out.println("mapin br sub " + ((MapNode)mv.getMindModel()).countSubscribers());
             mv.getMindModel().getCommandManager().doCheck();
             mv.getMindModel().getCommandManager().undoCheck();

             if(!mv.getMindModel().getChildren().isEmpty() && mv.getElementi().isEmpty()){
                 for(MapNode element: mv.getMindModel().getChildren()){
                     if(element instanceof Topic){
                         TopicPainter tp = new TopicPainter((Topic) element);
                         mv.addElementPainter(tp);
                        // mv.getElementi().add(tp);
                     }
                     else {
                         VezaPainter vp = new VezaPainter((Veza) element);
                         mv.addElementPainter(vp);
                     }
                 }
             }
                MainFrame.getInstance().repaint();

             mv.getMindModel().notifySubscribers(null);
            }
        });

    }

    @Override
    public void update(Notification notification) {

        if(notification.getNotificationCode() != null) {
            switch (notification.getNotificationCode()) {
                case OPEN_PROJECT:
                    jTabbedPane.removeAll();
                     mindViews = getMindViews(projectModel);

                    createTabs(mindViews);
                    projectName.setText("Project name: " + projectModel.getName());
                    if (projectModel.getAuthorName() == null)
                        authorName.setText("No project author");
                    else
                        authorName.setText("Author: " + projectModel.getAuthorName());

                    jTabbedPane.setVisible(true);
                    break;

                case DELETE_CHILD:
                    jTabbedPane.remove(ProjectView.getInstance().getjTabbedPane().getSelectedComponent());
                   break;

                case ADD_CHILD:
                    MindMap mindMap = (MindMap)notification.getObject();
                    MindView mindView = new MindView(mindMap, this);
                    getMindViews(projectModel).add(mindView);
                    jTabbedPane.addTab(((MindMap) notification.getObject()).getName(), mindView);

                    createTabs(getMindViews(projectModel));
                    jTabbedPane.setVisible(true);
                    break;

                case EDIT_NAME:
                    projectName.setText("Project name: " + projectModel.getName());
                    break;
                case SET_AUTHOR:
                    authorName.setText("Author " + notification.getObject().toString());
                    break;
                case OPEN_TAB:
                    MindView mv = (MindView) notification.getObject();
                    MindMap mp = mv.getMindModel();
                    Project pr = (Project) mp.getParent();
                    if(projectModel == pr) {
                       jTabbedPane.setSelectedComponent(mv);

                    }
                }
            }
        }

    public void setProjectModel(Project projectModel) {
        this.projectModel = projectModel;
        this.projectModel.addSubscriber(this);
        mindViews = getMindViews(projectModel);
        projectModel.sendMessage(new Notification(NotificationCode.OPEN_PROJECT, this));
        createTabs(mindViews);

       // createTabs(projectModel.getChildren());
    }

    public Project getProjectModel() {
        return projectModel;
    }

    public List<MindView> getMindViews() {
        return mindViews;
    }

    public JLabel getAuthorName() {
        return authorName;
    }


    public JTabbedPane getjTabbedPane() {
        return jTabbedPane;
    }
}

