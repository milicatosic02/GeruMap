package raf.ds.gerumap.serializer.custom;

import com.google.gson.*;
import raf.ds.gerumap.core.ApplicationFramework;
import raf.ds.gerumap.repository.composite.MapNode;
import raf.ds.gerumap.repository.implementation.Element;
import raf.ds.gerumap.repository.implementation.MindMap;
import raf.ds.gerumap.repository.implementation.Project;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class ProjectSerializer implements JsonSerializer<MapNode>, JsonDeserializer<MapNode>{

    @Override
    public JsonElement serialize(MapNode src, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject result = new JsonObject();
        result.add("type", new JsonPrimitive(src.getClass().getSimpleName()));
        result.add("properties", context.serialize(src, src.getClass()));

        return result;
    }

    @Override
    public MapNode deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
            throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();
        String type = jsonObject.get("type").getAsString();
        JsonElement element = jsonObject.get("properties");

        try {
            return context.deserialize(element, Class.forName("raf.ds.gerumap.repository.implementation." + type));
        } catch (ClassNotFoundException cnfe) {
            throw new JsonParseException("Unknown element type: " + type, cnfe);
        }
    }
}
