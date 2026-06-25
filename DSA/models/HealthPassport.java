package DSA.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class HealthPassport implements Serializable {

    private static final long serialVersionUID = 1L;

    // =====================================================
    // Basic Information
    // =====================================================

    private String passportId;
    private String patientId;

    // =====================================================
    // Medical History
    // =====================================================

    private List<String> medicalHistory;
    private List<String> allergies;
    private List<String> chronicDiseases;
    private List<String> surgeries;
    private List<String> vaccinations;

    // =====================================================
    // Health Information
    // =====================================================

    private String bloodGroup;
    private double height;
    private double weight;

    // =====================================================
    // Doctor Information
    // =====================================================

    private String familyDoctor;
    private String hospitalName;

    // =====================================================
    // Passport Information
    // =====================================================

    private LocalDate issueDate;
    private LocalDate lastUpdated;

    // =====================================================
    // Constructors
    // =====================================================

    public HealthPassport() {

        medicalHistory = new ArrayList<>();
        allergies = new ArrayList<>();
        chronicDiseases = new ArrayList<>();
        surgeries = new ArrayList<>();
        vaccinations = new ArrayList<>();

        issueDate = LocalDate.now();
        lastUpdated = LocalDate.now();

    }

    public HealthPassport(String passportId,
                          String patientId,
                          String bloodGroup,
                          double height,
                          double weight,
                          String familyDoctor,
                          String hospitalName) {

        this();

        this.passportId = passportId;
        this.patientId = patientId;
        this.bloodGroup = bloodGroup;
        this.height = height;
        this.weight = weight;
        this.familyDoctor = familyDoctor;
        this.hospitalName = hospitalName;
    }

    // =====================================================
    // Getters & Setters
    // =====================================================

    public String getPassportId() {
        return passportId;
    }

    public void setPassportId(String passportId) {
        this.passportId = passportId;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public List<String> getMedicalHistory() {
        return medicalHistory;
    }

    public List<String> getAllergies() {
        return allergies;
    }

    public List<String> getChronicDiseases() {
        return chronicDiseases;
    }

    public List<String> getSurgeries() {
        return surgeries;
    }

    public List<String> getVaccinations() {
        return vaccinations;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getFamilyDoctor() {
        return familyDoctor;
    }

    public void setFamilyDoctor(String familyDoctor) {
        this.familyDoctor = familyDoctor;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public LocalDate getLastUpdated() {
        return lastUpdated;
    }

    // =====================================================
    // Helper Methods
    // =====================================================

    public void addMedicalHistory(String record) {
        medicalHistory.add(record);
        lastUpdated = LocalDate.now();
    }

    public void addAllergy(String allergy) {
        allergies.add(allergy);
        lastUpdated = LocalDate.now();
    }

    public void addChronicDisease(String disease) {
        chronicDiseases.add(disease);
        lastUpdated = LocalDate.now();
    }

    public void addSurgery(String surgery) {
        surgeries.add(surgery);
        lastUpdated = LocalDate.now();
    }

    public void addVaccination(String vaccination) {
        vaccinations.add(vaccination);
        lastUpdated = LocalDate.now();
    }

    // =====================================================
    // Utility Methods
    // =====================================================

    @Override
    public String toString() {
        return passportId + " - " + patientId;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (!(obj instanceof HealthPassport))
            return false;

        HealthPassport passport = (HealthPassport) obj;

        return Objects.equals(passportId, passport.passportId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passportId);
    }

}