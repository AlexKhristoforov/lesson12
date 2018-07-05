package by.itacademy.lesson12.read;

import by.itacademy.lesson12.domain.Hospital;
import by.itacademy.lesson12.domain.Patient;
import by.itacademy.lesson12.service.read.RemoteRead;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class RemoteReadTest {
    private Hospital hospital = Hospital.builder()
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

    @Test
    public void RemoteReadValidTest() throws IOException {
        RemoteRead read = new RemoteRead("https://raw.githubusercontent.com/AlexKhristoforov/Hospital_1/master/Hospital_test_suc%D1%81ess");
        Hospital newHospital = read.execute();
        Assert.assertEquals(hospital, newHospital);
    }

    @Test
    public void RemoteReadInvalidTest() throws IOException {
        RemoteRead read = new RemoteRead("https://raw.githubusercontent.com/AlexKhristoforov/Hospital_1/master/Hospital_test_unsuccess");
        Hospital newHospital = read.execute();
        Assert.assertNotEquals(hospital, newHospital);
    }
}
