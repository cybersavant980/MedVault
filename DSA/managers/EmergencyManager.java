package DSA.managers;

import DSA.models.Emergency;
import DSA.storage.FileManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EmergencyManager {

    // =====================================================
    // Constants
    // =====================================================

    private static final String FILE_NAME = "data/emergency.dat";

    // =====================================================
    // Data Structures
    // =====================================================

    private HashMap<String, Emergency> emergencyMap;

    // =====================================================
    // Constructor
    // =====================================================

    public EmergencyManager() {

        emergencyMap = new HashMap<>();

        loadEmergencyRecords();

    }

    // =====================================================
    // Add Emergency Record
    // =====================================================

    public boolean addEmergency(Emergency emergency) {

        if (emergency == null)
            return false;

        if (emergencyMap.containsKey(emergency.getPatientId()))
            return false;

        emergencyMap.put(emergency.getPatientId(), emergency);

        saveEmergencyRecords();

        return true;

    }

    // =====================================================
    // Update Emergency Record
    // =====================================================

    public boolean updateEmergency(Emergency emergency) {

        if (emergency == null)
            return false;

        if (!emergencyMap.containsKey(emergency.getPatientId()))
            return false;

        emergencyMap.put(emergency.getPatientId(), emergency);

        saveEmergencyRecords();

        return true;

    }

    // =====================================================
    // Delete Emergency Record
    // =====================================================

    public boolean deleteEmergency(String patientId) {

        if (!emergencyMap.containsKey(patientId))
            return false;

        emergencyMap.remove(patientId);

        saveEmergencyRecords();

        return true;

    }

    // =====================================================
    // Get Emergency Record
    // =====================================================

    public Emergency getEmergency(String patientId) {

        return emergencyMap.get(patientId);

    }

    // =====================================================
    // Get All Emergency Records
    // =====================================================

    public List<Emergency> getAllEmergencyRecords() {

        return new ArrayList<>(emergencyMap.values());

    }

    // =====================================================
    // Emergency Count
    // =====================================================

    public int getEmergencyCount() {

        return emergencyMap.size();

    }

    // =====================================================
    // Save Records
    // =====================================================

    public void saveEmergencyRecords() {

        FileManager.saveData(
                getAllEmergencyRecords(),
                FILE_NAME);

    }

    // =====================================================
    // Load Records
    // =====================================================

    public void loadEmergencyRecords() {

        List<Emergency> records =
                FileManager.loadData(FILE_NAME);

        emergencyMap.clear();

        for (Emergency emergency : records) {

            emergencyMap.put(
                    emergency.getPatientId(),
                    emergency);

        }

    }

}
