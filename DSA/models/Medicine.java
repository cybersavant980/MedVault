package DSA.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

public class Medicine implements Serializable {

    private static final long serialVersionUID = 1L;

    // =====================================================
    // Basic Information
    // =====================================================

    private String medicineId;
    private String medicineName;
    private String genericName;
    private String manufacturer;

    // =====================================================
    // Dosage Information
    // =====================================================

    private String dosage;
    private String frequency;
    private String intakeTime;

    // =====================================================
    // Stock Information
    // =====================================================

    private int stockQuantity;
    private int minimumStock;

    // =====================================================
    // Medical Information
    // =====================================================

    private String prescribedFor;
    private String prescribedBy;

    // =====================================================
    // Expiry
    // =====================================================

    private LocalDate expiryDate;

    // =====================================================
    // Constructors
    // =====================================================

    public Medicine() {
    }

    public Medicine(String medicineId,
                    String medicineName,
                    String genericName,
                    String manufacturer,
                    String dosage,
                    String frequency,
                    String intakeTime,
                    int stockQuantity,
                    int minimumStock,
                    String prescribedFor,
                    String prescribedBy,
                    LocalDate expiryDate) {

        this.medicineId = medicineId;
        this.medicineName = medicineName;
        this.genericName = genericName;
        this.manufacturer = manufacturer;
        this.dosage = dosage;
        this.frequency = frequency;
        this.intakeTime = intakeTime;
        this.stockQuantity = stockQuantity;
        this.minimumStock = minimumStock;
        this.prescribedFor = prescribedFor;
        this.prescribedBy = prescribedBy;
        this.expiryDate = expiryDate;
    }

    // =====================================================
    // Getters & Setters
    // =====================================================

    public String getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(String medicineId) {
        this.medicineId = medicineId;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public String getGenericName() {
        return genericName;
    }

    public void setGenericName(String genericName) {
        this.genericName = genericName;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public String getIntakeTime() {
        return intakeTime;
    }

    public void setIntakeTime(String intakeTime) {
        this.intakeTime = intakeTime;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public int getMinimumStock() {
        return minimumStock;
    }

    public void setMinimumStock(int minimumStock) {
        this.minimumStock = minimumStock;
    }

    public String getPrescribedFor() {
        return prescribedFor;
    }

    public void setPrescribedFor(String prescribedFor) {
        this.prescribedFor = prescribedFor;
    }

    public String getPrescribedBy() {
        return prescribedBy;
    }

    public void setPrescribedBy(String prescribedBy) {
        this.prescribedBy = prescribedBy;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    // =====================================================
    // Utility Methods
    // =====================================================

    @Override
    public String toString() {
        return medicineName + " (" + dosage + ")";
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;

        if (!(obj instanceof Medicine)) return false;

        Medicine medicine = (Medicine) obj;

        return Objects.equals(medicineId, medicine.medicineId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(medicineId);
    }
}