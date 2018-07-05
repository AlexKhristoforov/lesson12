package by.itacademy.lesson12.service.write;

import by.itacademy.lesson12.domain.Hospital;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.time.LocalDate;

public class LocalWrite {
    private File file;

    public LocalWrite(String fileName) {
        this.file = new File(fileName);
    }

   /* public LocalWrite(URL url) {
        try {
            this.file = Paths.get(url.toURI()).toFile();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    } */

    public void execute(Hospital hospital) {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .registerTypeAdapter(LocalDate.class, new LocalDateSerializer())
                .registerTypeAdapter(Boolean.class, new BooleanSerializer())
                .create();
        try (FileWriter fileWriter = new FileWriter(file)) {
            gson.toJson(hospital, fileWriter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}