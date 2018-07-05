package by.itacademy.lesson12.service.read;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;

import java.io.IOException;
import java.lang.reflect.Type;

public class BooleanDeserializer extends StdDeserializer<Boolean> implements JsonDeserializer<Boolean> {
    public BooleanDeserializer() {
        this(null);
    }

    public BooleanDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public Boolean deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        return jsonParser.getText().equals("healthy");
    }

    @Override
    public Boolean deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) {

        return jsonElement.getAsString().equals("healthy");
    }
}
