package raf.ds.gerumap.repository;

import raf.ds.gerumap.core.MapRepository;
import raf.ds.gerumap.gui.swing.view.MainFrame;
import raf.ds.gerumap.repository.command.CommandManager;
import raf.ds.gerumap.repository.composite.MapNode;
import raf.ds.gerumap.repository.composite.MapNodeComposite;
import raf.ds.gerumap.repository.implementation.ProjectExplorer;

public class MapRepositoryImpl implements MapRepository {

    private ProjectExplorer projectExplorer;

    public MapRepositoryImpl(){
        projectExplorer = new ProjectExplorer("My Project Explorer");
    }

    @Override
    public ProjectExplorer getProjectExplorer(){
        return projectExplorer;
    }

    @Override
    public void addChild(MapNodeComposite parent, MapNode child){
        ///TODO: implement add Shild metod
    }


   // @Override
  //  public CommandManager getCommandManager() {
   //  //   return commandManager;
  //  }

}
