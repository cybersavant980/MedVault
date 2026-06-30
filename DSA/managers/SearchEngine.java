package DSA.managers;

import DSA.models.Medicine;
import DSA.models.Patient;
import DSA.models.Reminder;

import java.util.ArrayList;
import java.util.List;

public class SearchEngine {

    // =====================================================
    // Patient Search
    // =====================================================

    public List<Patient> searchPatients(List<Patient> patients,
                                        String keyword) {

        List<Patient> results = new ArrayList<>();

        if (keyword == null || keyword.isBlank())
            return results;

        keyword = keyword.toLowerCase();

        for (Patient patient : patients) {

            if (patient.getPatientId().toLowerCase().contains(keyword)
                    || patient.getFullName().toLowerCase().contains(keyword)
                    || patient.getPhoneNumber().toLowerCase().contains(keyword)
                    || patient.getCurrentDisease().toLowerCase().contains(keyword)) {

                results.add(patient);

            }

        }

        return results;

    }

    // =====================================================
    // Medicine Search
    // =====================================================

    public List<Medicine> searchMedicines(List<Medicine> medicines,
                                          String keyword) {

        List<Medicine> results = new ArrayList<>();

        if (keyword == null || keyword.isBlank())
            return results;

        keyword = keyword.toLowerCase();

        for (Medicine medicine : medicines) {

            if (medicine.getMedicineId().toLowerCase().contains(keyword)
                    || medicine.getMedicineName().toLowerCase().contains(keyword)
                    || medicine.getGenericName().toLowerCase().contains(keyword)
                    || medicine.getManufacturer().toLowerCase().contains(keyword)) {

                results.add(medicine);

            }

        }

        return results;

    }

    // =====================================================
    // Reminder Search
    // =====================================================

    public List<Reminder> searchReminders(List<Reminder> reminders,
                                          String keyword) {

        List<Reminder> results = new ArrayList<>();

        if (keyword == null || keyword.isBlank())
            return results;

        keyword = keyword.toLowerCase();

        for (Reminder reminder : reminders) {

            if (reminder.getReminderId().toLowerCase().contains(keyword)
                    || reminder.getTitle().toLowerCase().contains(keyword)
                    || reminder.getDescription().toLowerCase().contains(keyword)) {

                results.add(reminder);

            }

        }

        return results;

    }

    // =====================================================
    // Patient Search by Prefix (Trie)
    // =====================================================

    public List<Patient> searchPatientByPrefix(PatientManager manager,
                                               String prefix) {

        return manager.searchPatients(prefix);

    }

}