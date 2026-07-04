package DSA.models;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
public class HealthPassport implements Serializable {
    private static final long serialVersionUID = 1L;
    private String passportId,patientId,patientName,bloodGroup,gender,familyDoctor,hospitalName,emergencyContact,doctorContact;
    private int age;
    private List<String> medicalHistory,allergies,chronicDiseases,currentMedicines,vaccinations;
    private double height,weight;
    private LocalDate issueDate,lastUpdated;
    public HealthPassport() {
        medicalHistory = new ArrayList<>();
        allergies = new ArrayList<>();
        chronicDiseases = new ArrayList<>();
        currentMedicines = new ArrayList<>();
        vaccinations = new ArrayList<>();
        issueDate = LocalDate.now();
        lastUpdated = LocalDate.now();
    }
    public HealthPassport(String passportId,String patientId,String patientName,int age,String gender,String bloodGroup,double height,double weight,String emergencyContact,String familyDoctor,String doctorContact,String hospitalName) {
        this();
        this.passportId = passportId;
        this.patientId = patientId;
        this.patientName = patientName;
        this.age = age;
        this.gender = gender;
        this.bloodGroup = bloodGroup;
        this.height = height;
        this.weight = weight;
        this.emergencyContact = emergencyContact;
        this.familyDoctor = familyDoctor;
        this.doctorContact = doctorContact;
        this.hospitalName = hospitalName;
    }
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
    public String getPatientName() {
        return patientName;
    }
    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public int getAge() {
        return age;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
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
    public List<String> getCurrentMedicines() {
        return currentMedicines;
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
    public String getEmergencyContact() {
        return emergencyContact;
    }
    public void setEmergencyContact(String emergencyContact) {
        this.emergencyContact = emergencyContact;
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
    public void addCurrentMedicine(String medicine) {
        currentMedicines.add(medicine);
        lastUpdated = LocalDate.now();
    }
    public void addVaccination(String vaccination) {
        vaccinations.add(vaccination);
        lastUpdated = LocalDate.now();
    }
    @Override
    public String toString() {
        return passportId + " - " + patientId;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof HealthPassport)) return false;
        HealthPassport passport = (HealthPassport) obj;
        return Objects.equals(passportId, passport.passportId);
    }
    @Override
    public int hashCode() { return Objects.hash(passportId); }
}