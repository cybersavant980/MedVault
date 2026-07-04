package DSA.structures;
import DSA.models.Patient;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class PatientTrie {

    private static class TrieNode {
        Map<Character, TrieNode> children;
        List<Patient> patients;
        public TrieNode() {
            children = new HashMap<>();
            patients = new ArrayList<>();
        }
    }
    private final TrieNode root;

    public PatientTrie() {
        root = new TrieNode();
    }

    public void insert(Patient patient) {
        if (patient == null || patient.getFullName() == null) return;
        TrieNode current = root;
        String name = patient.getFullName().toLowerCase();
        for (char ch : name.toCharArray()) {
            current.children.putIfAbsent(ch, new TrieNode());
            current = current.children.get(ch);
            current.patients.add(patient);
        }
    }

    public List<Patient> search(String prefix) {
        List<Patient> result = new ArrayList<>();
        if (prefix == null || prefix.isBlank()) return result;
        TrieNode current = root;
        prefix = prefix.toLowerCase();
        for (char ch : prefix.toCharArray()) {
            if (!current.children.containsKey(ch)) return result;
            current = current.children.get(ch);
        }
        result.addAll(current.patients);
        return result;
    }

    public void clear() {
        root.children.clear();
    }
}