package by.itacademy.lesson12.read;

import by.itacademy.lesson12.domain.Hospital;
import by.itacademy.lesson12.domain.Patient;
import by.itacademy.lesson12.service.read.LocalRead;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class LocalReadTest {
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
    public void LocalReadValidTest() throws IOException {
        LocalRead read = new LocalRead((LocalReadTest.class.getClassLoader().getResource("hospital_test_success.json")));
        Hospital newHospital = read.execute();
        Assert.assertEquals(hospital, newHospital);
    }

    @Test
    public void LocalReadInvalidTest() throws IOException {
        LocalRead read = new LocalRead((LocalReadTest.class.getClassLoader().getResource("hospital_test_unsuccess.json")));
        Hospital newHospital = read.execute();
        Assert.assertNotEquals(hospital, newHospital);
    }
}
