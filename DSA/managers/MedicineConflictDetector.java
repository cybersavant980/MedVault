package DSA.managers;
import DSA.models.Medicine;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class MedicineConflictDetector {
    private final Map<String, List<String>> conflictMap;
    public MedicineConflictDetector() {
        conflictMap = new HashMap<>();
        loadDefaultConflicts();
    }

    private void loadDefaultConflicts() {
        addConflict("Aspirin", "Warfarin");
        addConflict("Ibuprofen", "Warfarin");
        addConflict("Paracetamol", "Alcohol");
        addConflict("Metformin", "Alcohol");
        addConflict("Amoxicillin", "Methotrexate");
        addConflict("Ciprofloxacin", "Tizanidine");
        addConflict("Ibuprofen", "Diclofenac");
        addConflict("Ibuprofen", "Aspirin");
        addConflict("Warfarin", "Vitamin K");
        addConflict("Insulin", "Alcohol");
        addConflict("Metformin", "Contrast Dye");
        addConflict("Aspirin", "Clopidogrel");
    }

    public void addConflict(String medicineA, String medicineB) {
        medicineA = medicineA.toLowerCase();
        medicineB = medicineB.toLowerCase();
        conflictMap.computeIfAbsent(medicineA, k -> new ArrayList<>()).add(medicineB);
        conflictMap.computeIfAbsent(medicineB, k -> new ArrayList<>()).add(medicineA);
    }

    public boolean hasConflict(String medicineA, String medicineB) {
        if (medicineA == null || medicineB == null)  return false;
        medicineA = medicineA.toLowerCase();
        medicineB = medicineB.toLowerCase();
        List<String> conflicts = conflictMap.get(medicineA);
        return conflicts != null && conflicts.contains(medicineB);
    }

    public List<String> detectConflicts(List<Medicine> medicines) {
        List<String> conflicts = new ArrayList<>();
        for (int i = 0; i < medicines.size(); i++) {
            for (int j = i + 1; j < medicines.size(); j++) {
                Medicine first = medicines.get(i);
                Medicine second = medicines.get(j);
                if (hasConflict(first.getMedicineName(),second.getMedicineName())) {
                    conflicts.add(first.getMedicineName() + " conflicts with " + second.getMedicineName());
                }
            }
        }
        return conflicts;
    }
}