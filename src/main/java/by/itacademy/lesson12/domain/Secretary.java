package by.itacademy.lesson12.domain;

import by.itacademy.lesson12.service.read.LocalRead;
import by.itacademy.lesson12.service.read.RemoteRead;
import by.itacademy.lesson12.service.write.LocalWrite;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Secretary {
    private static final Logger LOGGER = Logger.getLogger(Secretary.class.getName());
    private Hospital hospital;
    private LocalWrite write = new LocalWrite("hospital.json");
    private LocalRead read = new LocalRead("hospital.json");
    private RemoteRead readRemote = new RemoteRead("https://raw.githubusercontent.com/AlexKhristoforov/Hospital_1/master/hospital.json");

    public Secretary(Hospital hospital) throws MalformedURLException {
        this.hospital = hospital;
    }

    public void remoteRead() {
        try {
            hospital.addAll(readRemote.execute().getPatients());
        } catch (IOException e) {
            LOGGER.log(Level.INFO, e.getMessage());
        }
    }

    public void localWrite()  {

        write.execute(hospital);
    }

    public void localRead()  {
        try {
            hospital.addAll(read.execute().getPatients());
        } catch (IOException e) {
            LOGGER.log(Level.INFO, e.getMessage());
        }
    }
}