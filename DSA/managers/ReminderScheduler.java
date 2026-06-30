package DSA.managers;

import DSA.models.Reminder;
import DSA.storage.FileManager;
import DSA.structures.QueueManager;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ReminderScheduler {

    // =====================================================
    // Constants
    // =====================================================

    private static final String FILE_NAME = "data/reminders.dat";

    // =====================================================
    // Data Structures
    // =====================================================

    private HashMap<String, Reminder> reminderMap;

    private QueueManager queueManager;

    // =====================================================
    // Constructor
    // =====================================================

    public ReminderScheduler() {

        reminderMap = new HashMap<>();
        queueManager = new QueueManager();

        loadReminders();

    }

    // =====================================================
    // Add Reminder
    // =====================================================

    public boolean addReminder(Reminder reminder) {

        if (reminder == null)
            return false;

        if (reminderMap.containsKey(reminder.getReminderId()))
            return false;

        reminderMap.put(reminder.getReminderId(), reminder);

        queueManager.enqueue(reminder);

        saveReminders();

        return true;

    }

    // =====================================================
    // Update Reminder
    // =====================================================

    public boolean updateReminder(Reminder reminder) {

        if (reminder == null)
            return false;

        if (!reminderMap.containsKey(reminder.getReminderId()))
            return false;

        reminderMap.put(reminder.getReminderId(), reminder);

        rebuildQueue();

        saveReminders();

        return true;

    }

    // =====================================================
    // Delete Reminder
    // =====================================================

    public boolean deleteReminder(String reminderId) {

        if (!reminderMap.containsKey(reminderId))
            return false;

        reminderMap.remove(reminderId);

        rebuildQueue();

        saveReminders();

        return true;

    }

    // =====================================================
    // Get Reminder
    // =====================================================

    public Reminder getReminder(String reminderId) {

        return reminderMap.get(reminderId);

    }

    // =====================================================
    // Get All Reminders
    // =====================================================

    public List<Reminder> getAllReminders() {

        return new ArrayList<>(reminderMap.values());

    }

    // =====================================================
    // Get Upcoming Reminders
    // =====================================================

    public List<Reminder> getUpcomingReminders() {

        List<Reminder> upcoming = new ArrayList<>();

        LocalDate today = LocalDate.now();
        LocalTime now = LocalTime.now();

        for (Reminder reminder : reminderMap.values()) {

            if (!reminder.isCompleted()) {

                if (reminder.getReminderDate().isAfter(today)
                        || (reminder.getReminderDate().isEqual(today)
                        && !reminder.getReminderTime().isBefore(now))) {

                    upcoming.add(reminder);

                }

            }

        }

        return upcoming;

    }

    // =====================================================
    // Mark Reminder Completed
    // =====================================================

    public boolean markCompleted(String reminderId) {

        Reminder reminder = reminderMap.get(reminderId);

        if (reminder == null)
            return false;

        reminder.setCompleted(true);

        saveReminders();

        return true;

    }

    // =====================================================
    // Reminder Count
    // =====================================================

    public int getReminderCount() {

        return reminderMap.size();

    }

    // =====================================================
    // Save Reminders
    // =====================================================

    public void saveReminders() {

        FileManager.saveData(getAllReminders(), FILE_NAME);

    }

    // =====================================================
    // Load Reminders
    // =====================================================

    public void loadReminders() {

        List<Reminder> reminders = FileManager.loadData(FILE_NAME);

        reminderMap.clear();

        queueManager.clear();

        for (Reminder reminder : reminders) {

            reminderMap.put(reminder.getReminderId(), reminder);

            queueManager.enqueue(reminder);

        }

    }

    // =====================================================
    // Rebuild Queue
    // =====================================================

    private void rebuildQueue() {

        queueManager.clear();

        for (Reminder reminder : reminderMap.values()) {

            queueManager.enqueue(reminder);

        }

    }

}