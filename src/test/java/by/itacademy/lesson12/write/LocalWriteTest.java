package by.itacademy.lesson12.write;

import by.itacademy.lesson12.domain.Hospital;
import by.itacademy.lesson12.domain.Patient;
import by.itacademy.lesson12.service.read.LocalRead;
import by.itacademy.lesson12.service.write.LocalWrite;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class LocalWriteTest {
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
    public void executeReadLocalTest() throws IOException {
        LocalWrite write = new LocalWrite("new_write.json");
        write.execute(hospital);
        LocalRead read = new LocalRead("new_write.json");
        Hospital newHospital = read.execute();
        Assert.assertEquals(hospital,newHospital);
    }
}
