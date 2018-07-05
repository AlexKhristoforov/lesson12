package by.itacademy.lesson12.service.read;

import by.itacademy.lesson12.domain.Hospital;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.time.LocalDate;

public class LocalRead {
    private File file;

    public LocalRead(String fileName) {
        this.file = new File(fileName);
    }

    public LocalRead(URL url) {
        try {
            this.file = Paths.get(url.toURI()).toFile();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }


    public Hospital execute() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.addDeserializer(LocalDate.class, new LocalDateDeserializer(LocalDate.class));
        module.addDeserializer(boolean.class, new BooleanDeserializer(Boolean.class));
        mapper.registerModule(module);
        Hospital hospital = mapper.readValue(file, Hospital.class);
        return hospital;
    }
}
