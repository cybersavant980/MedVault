package DSA.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

public class Reminder implements Serializable {

    private static final long serialVersionUID = 1L;

    // =====================================================
    // Basic Information
    // =====================================================

    private String reminderId;
    private String patientId;
    private String medicineId;

    // =====================================================
    // Reminder Details
    // =====================================================

    private String title;
    private String description;

    private LocalDate reminderDate;
    private LocalTime reminderTime;

    // =====================================================
    // Status
    // =====================================================

    private boolean completed;

    // =====================================================
    // Constructors
    // =====================================================

    public Reminder() {
    }

    public Reminder(String reminderId,
                    String patientId,
                    String medicineId,
                    String title,
                    String description,
                    LocalDate reminderDate,
                    LocalTime reminderTime,
                    boolean completed) {

        this.reminderId = reminderId;
        this.patientId = patientId;
        this.medicineId = medicineId;
        this.title = title;
        this.description = description;
        this.reminderDate = reminderDate;
        this.reminderTime = reminderTime;
        this.completed = completed;
    }

    // =====================================================
    // Getters & Setters
    // =====================================================

    public String getReminderId() {
        return reminderId;
    }

    public void setReminderId(String reminderId) {
        this.reminderId = reminderId;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(String medicineId) {
        this.medicineId = medicineId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getReminderDate() {
        return reminderDate;
    }

    public void setReminderDate(LocalDate reminderDate) {
        this.reminderDate = reminderDate;
    }

    public LocalTime getReminderTime() {
        return reminderTime;
    }

    public void setReminderTime(LocalTime reminderTime) {
        this.reminderTime = reminderTime;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    // =====================================================
    // Utility Methods
    // =====================================================

    @Override
    public String toString() {
        return title + " - " + reminderTime;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;

        if (!(obj instanceof Reminder)) return false;

        Reminder reminder = (Reminder) obj;

        return Objects.equals(reminderId, reminder.reminderId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reminderId);
    }

}