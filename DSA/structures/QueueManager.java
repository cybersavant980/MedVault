package DSA.structures;
import DSA.models.Reminder;
import java.util.LinkedList;
import java.util.Queue;
public class QueueManager {
    private final Queue<Reminder> reminderQueue;

    public QueueManager() {
        reminderQueue = new LinkedList<>();
    }

    public void enqueue(Reminder reminder) {
        if (reminder != null) {
            reminderQueue.offer(reminder);
        }
    }

    public Reminder dequeue() {
        if (reminderQueue.isEmpty()) {
            return null;
        }
        return reminderQueue.poll();
    }

    public Reminder peek() {
        return reminderQueue.peek();
    }

    public boolean isEmpty() {
        return reminderQueue.isEmpty();
    }

    public int size() {
        return reminderQueue.size();
    }

    public void clear() {
        reminderQueue.clear();
    }
}