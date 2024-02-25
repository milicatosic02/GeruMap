package raf.ds.gerumap;

import raf.ds.gerumap.core.*;
import raf.ds.gerumap.gui.SwingGui;
import raf.ds.gerumap.message.MessageGeneratorImpl;
import raf.ds.gerumap.repository.MapRepositoryImpl;
import raf.ds.gerumap.serializer.GsonSerializer;

public class AppCore{
    public static void main(String[] args) {
        Gui gui = new SwingGui();
        ApplicationFramework appCore = ApplicationFramework.getInstance();
        MapRepository mapRepository =  new MapRepositoryImpl();
        MessageGeneratorInterface messageGeneratorInterface = new MessageGeneratorImpl();
        Serializer serializer = new GsonSerializer();
        appCore.initalise(gui, mapRepository,messageGeneratorInterface, serializer);
        appCore.run();
    }


}
