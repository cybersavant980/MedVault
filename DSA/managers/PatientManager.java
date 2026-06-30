package DSA.managers;

import DSA.models.Patient;
import DSA.storage.FileManager;
import DSA.structures.PatientTrie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PatientManager {

    // =====================================================
    // Constants
    // =====================================================

    private static final String FILE_NAME = "data/patients.dat";

    // =====================================================
    // Data Structures
    // =====================================================

    private HashMap<String, Patient> patientMap;

    private PatientTrie patientTrie;

    // =====================================================
    // Constructor
    // =====================================================

    public PatientManager() {

        patientMap = new HashMap<>();
        patientTrie = new PatientTrie();

        loadPatients();

    }

    // =====================================================
    // Add Patient
    // =====================================================

    public boolean addPatient(Patient patient) {

        if (patient == null)
            return false;

        if (patientMap.containsKey(patient.getPatientId()))
            return false;

        patientMap.put(patient.getPatientId(), patient);

        patientTrie.insert(patient);

        savePatients();

        return true;

    }

    // =====================================================
    // Update Patient
    // =====================================================

    public boolean updatePatient(Patient patient) {

        if (patient == null)
            return false;

        if (!patientMap.containsKey(patient.getPatientId()))
            return false;

        patientMap.put(patient.getPatientId(), patient);

        rebuildTrie();

        savePatients();

        return true;

    }

    // =====================================================
    // Delete Patient
    // =====================================================

    public boolean deletePatient(String patientId) {

        if (!patientMap.containsKey(patientId))
            return false;

        patientMap.remove(patientId);

        rebuildTrie();

        savePatients();

        return true;

    }

    // =====================================================
    // Get Patient
    // =====================================================

    public Patient getPatient(String patientId) {

        return patientMap.get(patientId);

    }

    // =====================================================
    // Get All Patients
    // =====================================================

    public List<Patient> getAllPatients() {

        return new ArrayList<>(patientMap.values());

    }

    // =====================================================
    // Search Patients
    // =====================================================

    public List<Patient> searchPatients(String prefix) {

        return patientTrie.search(prefix);

    }

    // =====================================================
    // Patient Count
    // =====================================================

    public int getPatientCount() {

        return patientMap.size();

    }

    // =====================================================
    // Save Patients
    // =====================================================

    public void savePatients() {

        FileManager.saveData(getAllPatients(), FILE_NAME);

    }

    // =====================================================
    // Load Patients
    // =====================================================

    public void loadPatients() {

        List<Patient> patients = FileManager.loadData(FILE_NAME);

        patientMap.clear();

        patientTrie.clear();

        for (Patient patient : patients) {

            patientMap.put(patient.getPatientId(), patient);

            patientTrie.insert(patient);

        }

    }

    // =====================================================
    // Rebuild Trie
    // =====================================================

    private void rebuildTrie() {

        patientTrie.clear();

        for (Patient patient : patientMap.values()) {

            patientTrie.insert(patient);

        }

    }

}