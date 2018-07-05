package by.itacademy.lesson12.domain;

import by.itacademy.lesson12.service.read.BooleanDeserializer;
import by.itacademy.lesson12.service.read.LocalDateDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.time.LocalDate;

public class Patient {

    private String name;
    private String surname;
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate birth;
    @JsonDeserialize(using = BooleanDeserializer.class)
    private boolean health;

    public Patient() {
    }

    public static PatientBuilder builder() {
        return new PatientBuilder();
    }

    public Patient(String name, String surname, LocalDate birth, boolean health) {
        this.name = name;
        this.surname = surname;
        this.birth = birth;
        this.health = health;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public boolean isHealth() {
        return health;
    }

    public static class PatientBuilder {
        private Patient patient = new Patient();

        public PatientBuilder name(String name) {
            patient.name = name;
            return this;
        }

        public PatientBuilder surname(String surname) {
            patient.surname = surname;
            return this;
        }

        public PatientBuilder birth(LocalDate birth) {
            patient.birth = birth;
            return this;
        }

        public PatientBuilder birth(int year, int month, int days) {
            patient.birth = LocalDate.of(year, month, days);
            return this;
        }

        public PatientBuilder health(Boolean health) {
            patient.health = health;
            return this;
        }

        public Patient build() {
            return patient;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Patient patient = (Patient) o;

        if (health != patient.health) return false;
        if (name != null ? !name.equals(patient.name) : patient.name != null) return false;
        if (surname != null ? !surname.equals(patient.surname) : patient.surname != null) return false;
        return birth != null ? birth.equals(patient.birth) : patient.birth == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (birth != null ? birth.hashCode() : 0);
        result = 31 * result + (health ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birth=" + birth +
                ", health=" + health +
                '}';
    }
}
