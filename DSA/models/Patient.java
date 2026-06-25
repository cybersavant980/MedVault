package DSA.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class Patient implements Serializable {

    private static final long serialVersionUID = 1L;

    // =====================================================
    // Basic Information
    // =====================================================

    private String patientId;
    private String fullName;
    private int age;
    private String gender;
    private String bloodGroup;

    // =====================================================
    // Contact Information
    // =====================================================

    private String phoneNumber;
    private String email;
    private String address;

    // =====================================================
    // Emergency Contact
    // =====================================================

    private String emergencyContactName;
    private String emergencyContactPhone;

    // =====================================================
    // Medical Information
    // =====================================================

    private String currentDisease;
    private String allergies;

    private LocalDate registrationDate;

    // =====================================================
    // Constructors
    // =====================================================

    public Patient() {
        this.registrationDate = LocalDate.now();
    }

    public Patient(String patientId,
                   String fullName,
                   int age,
                   String gender,
                   String bloodGroup,
                   String phoneNumber,
                   String email,
                   String address,
                   String emergencyContactName,
                   String emergencyContactPhone,
                   String currentDisease,
                   String allergies) {

        this.patientId = patientId;
        this.fullName = fullName;
        this.age = age;
        this.gender = gender;
        this.bloodGroup = bloodGroup;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.emergencyContactName = emergencyContactName;
        this.emergencyContactPhone = emergencyContactPhone;
        this.currentDisease = currentDisease;
        this.allergies = allergies;
        this.registrationDate = LocalDate.now();
    }

    // =====================================================
    // Getters & Setters
    // =====================================================

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmergencyContactName() {
        return emergencyContactName;
    }

    public void setEmergencyContactName(String emergencyContactName) {
        this.emergencyContactName = emergencyContactName;
    }

    public String getEmergencyContactPhone() {
        return emergencyContactPhone;
    }

    public void setEmergencyContactPhone(String emergencyContactPhone) {
        this.emergencyContactPhone = emergencyContactPhone;
    }

    public String getCurrentDisease() {
        return currentDisease;
    }

    public void setCurrentDisease(String currentDisease) {
        this.currentDisease = currentDisease;
    }

    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    // =====================================================
    // Object Methods
    // =====================================================

    @Override
    public String toString() {
        return patientId + " - " + fullName;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;

        if (!(obj instanceof Patient)) return false;

        Patient patient = (Patient) obj;

        return Objects.equals(patientId, patient.patientId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(patientId);
    }
}