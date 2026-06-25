package DSA.structures;

import DSA.models.Medicine;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityManager {

    // =====================================================
    // Expiry Priority Queue
    // Medicines with the nearest expiry appear first.
    // =====================================================

    private final PriorityQueue<Medicine> expiryQueue;

    // =====================================================
    // Constructor
    // =====================================================

    public PriorityManager() {

        expiryQueue = new PriorityQueue<>(Comparator.comparing(Medicine::getExpiryDate));

    }

    // =====================================================
    // Add Medicine
    // =====================================================

    public void addMedicine(Medicine medicine) {

        if (medicine != null) {
            expiryQueue.offer(medicine);
        }

    }

    // =====================================================
    // Remove Highest Priority Medicine
    // =====================================================

    public Medicine removeMedicine() {

        if (expiryQueue.isEmpty()) {
            return null;
        }

        return expiryQueue.poll();
    }

    // =====================================================
    // View Highest Priority Medicine
    // =====================================================

    public Medicine peekMedicine() {
        return expiryQueue.peek();
    }

    // =====================================================
    // Check if Queue is Empty
    // =====================================================

    public boolean isEmpty() {
        return expiryQueue.isEmpty();
    }

    // =====================================================
    // Total Medicines
    // =====================================================

    public int size() {
        return expiryQueue.size();
    }

    // =====================================================
    // Remove Expired Medicines
    // =====================================================

    public void removeExpiredMedicines() {

        LocalDate today = LocalDate.now();

        while (!expiryQueue.isEmpty()
                && expiryQueue.peek().getExpiryDate().isBefore(today)) {

            expiryQueue.poll();
        }

    }

    // =====================================================
    // Clear Queue
    // =====================================================

    public void clear() {
        expiryQueue.clear();
    }

}