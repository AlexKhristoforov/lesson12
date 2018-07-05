package by.itacademy.lesson12;

import by.itacademy.lesson12.domain.Hospital;
import by.itacademy.lesson12.domain.Patient;
import by.itacademy.lesson12.domain.Secretary;

import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class App {
    private static final Logger LOGGER = Logger.getLogger(App.class.getName());

    public static void main(String[] args) {
        Hospital hospital = Hospital.builder()
                .add(Patient.builder()
                        .name("Alex")
                        .surname("Khristoforov")
                        .birth(1996, 03, 07)
                        .health(true)
                        .build())
                .add(Patient.builder()
                        .name("Urban")
                        .surname("Pavel")
                        .birth(1995, 05, 14)
                        .health(false)
                        .build())
                .build();

        try {
            Secretary secretary = new Secretary(hospital);
            secretary.localWrite();
            secretary.localRead();
            secretary.remoteRead();
        } catch (MalformedURLException e) {
            LOGGER.log(Level.INFO, e.getMessage());

        }
        System.out.println(hospital);
    }
}
