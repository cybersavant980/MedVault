package DSA.managers;
import DSA.models.Medicine;
import DSA.storage.FileManager;
import DSA.structures.PriorityManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
public class MedicineManager {
    private static final String FILE_NAME = "data/medicines.dat";
    private HashMap<String, Medicine> medicineMap;
    private PriorityManager priorityManager;
    public MedicineManager() {
        medicineMap = new HashMap<>();
        priorityManager = new PriorityManager();
        loadMedicines();
    }

    public boolean addMedicine(Medicine medicine) {
        if (medicine == null)
            return false;
        if (medicineMap.containsKey(medicine.getMedicineId()))
            return false;
        medicineMap.put(medicine.getMedicineId(), medicine);
        priorityManager.addMedicine(medicine);
        saveMedicines();
        return true;
    }

    public boolean updateMedicine(Medicine medicine) {
        if (medicine == null)
            return false;
        if (!medicineMap.containsKey(medicine.getMedicineId()))
            return false;
        medicineMap.put(medicine.getMedicineId(), medicine);
        rebuildPriorityQueue();
        saveMedicines();
        return true;
    }

    public boolean deleteMedicine(String medicineId) {
        if (!medicineMap.containsKey(medicineId))
            return false;
        medicineMap.remove(medicineId);
        rebuildPriorityQueue();
        saveMedicines();
        return true;
    }

    public Medicine getMedicine(String medicineId) {
        return medicineMap.get(medicineId);
    }

    public List<Medicine> getAllMedicines() {
        return new ArrayList<>(medicineMap.values());
    }

    public Medicine getNextExpiringMedicine() {
        return priorityManager.peekMedicine();
    }

    public int getMedicineCount() {
        return medicineMap.size();
    }

    public void saveMedicines() {
        FileManager.saveData(getAllMedicines(), FILE_NAME);
    }

    public void loadMedicines() {
        List<Medicine> medicines = FileManager.loadData(FILE_NAME);
        medicineMap.clear();
        priorityManager.clear();
        for (Medicine medicine : medicines) {
            medicineMap.put(medicine.getMedicineId(), medicine);
            priorityManager.addMedicine(medicine);
        }
    }

    private void rebuildPriorityQueue() {
        priorityManager.clear();
        for (Medicine medicine : medicineMap.values()) {
            priorityManager.addMedicine(medicine);
        }
    }
}