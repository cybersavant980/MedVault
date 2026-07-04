package DSA.structures;
import DSA.models.Medicine;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.PriorityQueue;
public class PriorityManager {
    private final PriorityQueue<Medicine> expiryQueue;
    public PriorityManager() {
        expiryQueue = new PriorityQueue<>(Comparator.comparing(Medicine::getExpiryDate));
    }

    public void addMedicine(Medicine medicine) {
        if (medicine != null) {
            expiryQueue.offer(medicine);
        }
    }

    public Medicine removeMedicine() {
        if (expiryQueue.isEmpty()) {
            return null;
        }
        return expiryQueue.poll();
    }

    public Medicine peekMedicine() {
        return expiryQueue.peek();
    }

    public boolean isEmpty() {
        return expiryQueue.isEmpty();
    }

    public int size() {
        return expiryQueue.size();
    }

    public void removeExpiredMedicines() {
        LocalDate today = LocalDate.now();
        while (!expiryQueue.isEmpty() && expiryQueue.peek().getExpiryDate().isBefore(today)) {
            expiryQueue.poll();
        }
    }

    public void clear() {
        expiryQueue.clear();
    }
}