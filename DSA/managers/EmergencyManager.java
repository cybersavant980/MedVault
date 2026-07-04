package DSA.managers;
import DSA.models.Emergency;
import DSA.storage.FileManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
public class EmergencyManager {
    private static final String FILE_NAME = "data/emergency.dat";
    private HashMap<String, Emergency> emergencyMap;
    public EmergencyManager() {
        emergencyMap = new HashMap<>();
        loadEmergencyRecords();
    }

    public boolean addEmergency(Emergency emergency) {
        if (emergency == null)
            return false;
        if (emergencyMap.containsKey(emergency.getPatientId()))
            return false;
        emergencyMap.put(emergency.getPatientId(), emergency);
        saveEmergencyRecords();
        return true;
    }

    public boolean updateEmergency(Emergency emergency) {
        if (emergency == null)
            return false;
        if (!emergencyMap.containsKey(emergency.getPatientId()))
            return false;
        emergencyMap.put(emergency.getPatientId(), emergency);
        saveEmergencyRecords();
        return true;
    }

    public boolean deleteEmergency(String patientId) {
        if (!emergencyMap.containsKey(patientId))
            return false;
        emergencyMap.remove(patientId);
        saveEmergencyRecords();
        return true;
    }

    public Emergency getEmergency(String patientId) {
        return emergencyMap.get(patientId);
    }

    public List<Emergency> getAllEmergencyRecords() {
        return new ArrayList<>(emergencyMap.values());
    }

    public int getEmergencyCount() {
        return emergencyMap.size();
    }

    public void saveEmergencyRecords() {
        FileManager.saveData(
                getAllEmergencyRecords(),
                FILE_NAME);
    }

    public void loadEmergencyRecords() {
        List<Emergency> records =
                FileManager.loadData(FILE_NAME);
        emergencyMap.clear();
        for (Emergency emergency : records) {
            emergencyMap.put(emergency.getPatientId(),emergency);
        }
    }
}
