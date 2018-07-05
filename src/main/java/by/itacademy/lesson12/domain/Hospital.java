package by.itacademy.lesson12.domain;

import java.util.HashSet;
import java.util.Set;

public class Hospital {
    private Set<Patient> patients = new HashSet<>();

    public void add(Patient patient) {
        patients.remove(patient);
        patients.add(patient);
    }

    public void addAll(Set<Patient> patients) {
        this.patients.removeAll(patients);
        this.patients.addAll(patients);
    }

    public Set<Patient> getPatients() {
        return patients;
    }

    public static HospitalBuilder builder() {
        return new HospitalBuilder();
    }

    public static class HospitalBuilder {
        private Hospital hospital = new Hospital();

        public HospitalBuilder add(Patient patient) {
            hospital.add(patient);
            return this;
        }

        public Hospital build() {
            return hospital;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Hospital hospital = (Hospital) o;

        return patients != null ? patients.equals(hospital.patients) : hospital.patients == null;
    }

    @Override
    public int hashCode() {
        return patients != null ? patients.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "patients=" + patients +
                '}';
    }
}
