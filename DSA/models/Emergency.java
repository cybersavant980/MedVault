package DSA.models;
import java.io.Serializable;
import java.util.Objects;
public class Emergency implements Serializable {
    private static final long serialVersionUID = 1L;
    private String patientId,patientName,bloodGroup,allergies,chronicDisease,currentMedicines,emergencyContact,familyDoctor,doctorContact;
    public Emergency() { }
    public Emergency(String patientId,String patientName,String bloodGroup,String allergies,String chronicDisease,String currentMedicines,String emergencyContact,String familyDoctor,String doctorContact) {
        this.patientId = patientId;
        this.patientName = patientName;
        this.bloodGroup = bloodGroup;
        this.allergies = allergies;
        this.chronicDisease = chronicDisease;
        this.currentMedicines = currentMedicines;
        this.emergencyContact = emergencyContact;
        this.familyDoctor = familyDoctor;
        this.doctorContact = doctorContact;
    }
    public String getPatientId() {
        return patientId;
    }
    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }
    public String getPatientName() {
        return patientName;
    }
    public void setPatientName(String patientName) {
        this.patientName = patientName;
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
    public String getCurrentMedicines() {
        return currentMedicines;
    }
    public void setCurrentMedicines(String currentMedicines) {
        this.currentMedicines = currentMedicines;
    }
    public String getFamilyDoctor() {
        return familyDoctor;
    }
    public void setFamilyDoctor(String familyDoctor) {
        this.familyDoctor = familyDoctor;
    }
    public String getEmergencyContact() {
        return emergencyContact;
    }
    public void setEmergencyContact(String emergencyContact) {
        this.emergencyContact = emergencyContact;
    }
    public String getDoctorContact() {
        return doctorContact;
    }
    public void setDoctorContact(String doctorContact) {
        this.doctorContact = doctorContact;
    }
    @Override
    public String toString() {
        return patientId + " - " + patientName;
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