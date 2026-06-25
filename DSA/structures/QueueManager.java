package DSA.structures;

import DSA.models.Reminder;

import java.util.LinkedList;
import java.util.Queue;

public class QueueManager {

    // =====================================================
    // Reminder Queue
    // =====================================================

    private final Queue<Reminder> reminderQueue;

    // =====================================================
    // Constructor
    // =====================================================

    public QueueManager() {
        reminderQueue = new LinkedList<>();
    }

    // =====================================================
    // Add Reminder
    // =====================================================

    public void enqueue(Reminder reminder) {

        if (reminder != null) {
            reminderQueue.offer(reminder);
        }

    }

    // =====================================================
    // Remove Reminder
    // =====================================================

    public Reminder dequeue() {

        if (reminderQueue.isEmpty()) {
            return null;
        }

        return reminderQueue.poll();
    }

    // =====================================================
    // View Next Reminder
    // =====================================================

    public Reminder peek() {
        return reminderQueue.peek();
    }

    // =====================================================
    // Queue Status
    // =====================================================

    public boolean isEmpty() {
        return reminderQueue.isEmpty();
    }

    public int size() {
        return reminderQueue.size();
    }

    // =====================================================
    // Clear Queue
    // =====================================================

    public void clear() {
        reminderQueue.clear();
    }

}