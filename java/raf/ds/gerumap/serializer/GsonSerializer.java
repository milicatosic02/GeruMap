package raf.ds.gerumap.serializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.GsonBuilder;
import raf.ds.gerumap.core.Serializer;
import raf.ds.gerumap.repository.composite.MapNode;
import raf.ds.gerumap.repository.implementation.Project;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import com.google.gson.Gson;
import raf.ds.gerumap.serializer.custom.ProjectSerializer;

public class GsonSerializer implements Serializer {

    private Gson gson = new Gson();
    public GsonSerializer() {
        GsonBuilder gsonBuilder = new GsonBuilder();
//
       gsonBuilder.registerTypeAdapter(MapNode.class, new ProjectSerializer());
        gson = gsonBuilder.create();
    }

    @Override
    public Project loadProject(File file) {
        try (FileReader fileReader = new FileReader(file)) {
            return gson.fromJson(fileReader, Project.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void saveProject(Project project) {
        try (FileWriter writer = new FileWriter(project.getFilePath()))  {
            gson.toJson(project, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
