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
    private static final String FILE_NAME = "data/reminders.dat";
    private HashMap<String, Reminder> reminderMap;
    private QueueManager queueManager;
    public ReminderScheduler() {
        reminderMap = new HashMap<>();
        queueManager = new QueueManager();
        loadReminders();
    }
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

    public boolean deleteReminder(String reminderId) {
        if (!reminderMap.containsKey(reminderId))
            return false;
        reminderMap.remove(reminderId);
        rebuildQueue();
        saveReminders();
        return true;
    }

    public Reminder getReminder(String reminderId) {
        return reminderMap.get(reminderId);
    }

    public List<Reminder> getAllReminders() {
        return new ArrayList<>(reminderMap.values());
    }

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

    public boolean markCompleted(String reminderId) {
        Reminder reminder = reminderMap.get(reminderId);
        if (reminder == null)
            return false;
        reminder.setCompleted(true);
        saveReminders();
        return true;
    }

    public int getReminderCount() {
        return reminderMap.size();
    }

    public void saveReminders() {
        FileManager.saveData(getAllReminders(), FILE_NAME);
    }

    public void loadReminders() {
        List<Reminder> reminders = FileManager.loadData(FILE_NAME);
        reminderMap.clear();
        queueManager.clear();
        for (Reminder reminder : reminders) {
            reminderMap.put(reminder.getReminderId(), reminder);
            queueManager.enqueue(reminder);
        }
    }

    private void rebuildQueue() {
        queueManager.clear();
        for (Reminder reminder : reminderMap.values()) {
            queueManager.enqueue(reminder);
        }
    }
}