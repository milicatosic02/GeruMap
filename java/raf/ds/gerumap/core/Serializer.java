package raf.ds.gerumap.core;

import raf.ds.gerumap.repository.implementation.Project;

import java.io.File;

public interface Serializer {

    Project loadProject(File file);
    void saveProject(Project node);


}
