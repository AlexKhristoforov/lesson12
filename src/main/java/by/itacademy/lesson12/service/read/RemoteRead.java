package by.itacademy.lesson12.service.read;

import by.itacademy.lesson12.domain.Hospital;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;

public class RemoteRead {
    private URL source;

    public RemoteRead(String source) throws MalformedURLException {
        this.source = new URL(source);
    }

    public Hospital execute() throws IOException {
        StringBuffer buffer = new StringBuffer();
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDate.class, new LocalDateDeserializer())
                .registerTypeAdapter(Boolean.class, new BooleanDeserializer())
                .create();
        JsonReader reader = new JsonReader(new BufferedReader(new InputStreamReader(source.openStream())));
        return gson.fromJson(reader, Hospital.class);
    }
}
