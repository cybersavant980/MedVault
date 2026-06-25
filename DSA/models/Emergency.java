package DSA.models;

import java.io.Serializable;
import java.util.Objects;

public class Emergency implements Serializable {

    private static final long serialVersionUID = 1L;

    // =====================================================
    // Patient Information
    // =====================================================

    private String patientId;

    // =====================================================
    // Emergency Contacts
    // =====================================================

    private String primaryContactName;
    private String primaryContactNumber;

    private String secondaryContactName;
    private String secondaryContactNumber;

    // =====================================================
    // Medical Information
    // =====================================================

    private String bloodGroup;
    private String allergies;
    private String chronicDisease;

    // =====================================================
    // Hospital Information
    // =====================================================

    private String preferredHospital;
    private String familyDoctor;
    private String doctorContact;

    // =====================================================
    // Constructors
    // =====================================================

    public Emergency() {
    }

    public Emergency(String patientId,
                     String primaryContactName,
                     String primaryContactNumber,
                     String secondaryContactName,
                     String secondaryContactNumber,
                     String bloodGroup,
                     String allergies,
                     String chronicDisease,
                     String preferredHospital,
                     String familyDoctor,
                     String doctorContact) {

        this.patientId = patientId;
        this.primaryContactName = primaryContactName;
        this.primaryContactNumber = primaryContactNumber;
        this.secondaryContactName = secondaryContactName;
        this.secondaryContactNumber = secondaryContactNumber;
        this.bloodGroup = bloodGroup;
        this.allergies = allergies;
        this.chronicDisease = chronicDisease;
        this.preferredHospital = preferredHospital;
        this.familyDoctor = familyDoctor;
        this.doctorContact = doctorContact;
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

    public String getPrimaryContactName() {
        return primaryContactName;
    }

    public void setPrimaryContactName(String primaryContactName) {
        this.primaryContactName = primaryContactName;
    }

    public String getPrimaryContactNumber() {
        return primaryContactNumber;
    }

    public void setPrimaryContactNumber(String primaryContactNumber) {
        this.primaryContactNumber = primaryContactNumber;
    }

    public String getSecondaryContactName() {
        return secondaryContactName;
    }

    public void setSecondaryContactName(String secondaryContactName) {
        this.secondaryContactName = secondaryContactName;
    }

    public String getSecondaryContactNumber() {
        return secondaryContactNumber;
    }

    public void setSecondaryContactNumber(String secondaryContactNumber) {
        this.secondaryContactNumber = secondaryContactNumber;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    public String getChronicDisease() {
        return chronicDisease;
    }

    public void setChronicDisease(String chronicDisease) {
        this.chronicDisease = chronicDisease;
    }

    public String getPreferredHospital() {
        return preferredHospital;
    }

    public void setPreferredHospital(String preferredHospital) {
        this.preferredHospital = preferredHospital;
    }

    public String getFamilyDoctor() {
        return familyDoctor;
    }

    public void setFamilyDoctor(String familyDoctor) {
        this.familyDoctor = familyDoctor;
    }

    public String getDoctorContact() {
        return doctorContact;
    }

    public void setDoctorContact(String doctorContact) {
        this.doctorContact = doctorContact;
    }

    // =====================================================
    // Utility Methods
    // =====================================================

    @Override
    public String toString() {
        return patientId + " - " + primaryContactName;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (!(obj instanceof Emergency))
            return false;

        Emergency emergency = (Emergency) obj;

        return Objects.equals(patientId, emergency.patientId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(patientId);
    }

}