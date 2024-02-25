package raf.ds.gerumap.core;

import raf.ds.gerumap.notification.Notification;

public  class ApplicationFramework {

    protected Gui gui;
    protected MapRepository mapRepository;
    protected MessageGeneratorInterface messageGeneratorInterface;
    protected Serializer serializer;

    public void run(){
        this.gui.start();
    }



    public void initalise(Gui gui, MapRepository mapRepository, MessageGeneratorInterface messageGeneratorInterface, Serializer serializer){
        this.gui = gui;
        this.mapRepository = mapRepository;
        this.messageGeneratorInterface = messageGeneratorInterface;
        this.serializer = serializer;
    }

    private static ApplicationFramework instance;

    private ApplicationFramework(){

    }

    public static ApplicationFramework getInstance(){
        if(instance==null){
            instance = new ApplicationFramework();
        }
        return instance;
    }

    public MapRepository getMapRepository() {
        return mapRepository;
    }

    public MessageGeneratorInterface getMessageGeneratorInterface() {
        return messageGeneratorInterface;
    }

    public Gui getGui() {
        return gui;
    }

    public Serializer getSerializer() {
        return serializer;
    }
}
