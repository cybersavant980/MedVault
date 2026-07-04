package UI;
import DSA.managers.ReminderScheduler;
import DSA.models.Medicine;
import DSA.models.Reminder;
import UI.components.RoundedButton;
import UI.components.RoundedPanel;
import UI.theme.Theme;
import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class ReminderDialog extends JDialog {
    private Medicine medicine;
    private ReminderScheduler reminderScheduler;
    private JTextField dateField, timeField;
    private RoundedButton createButton, skipButton;
    private DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

    public ReminderDialog(Medicine medicine) {
        setTitle("Create Medicine Reminder");
        setModal(true);
        this.medicine = medicine;
        reminderScheduler = new ReminderScheduler();
        initializeComponents();
        layoutComponents();
        registerEvents();
        setSize(500, 380);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private void initializeComponents() {
        dateField = new JTextField("dd/MM/yyyy");
        timeField = new JTextField("HH:mm");
        createButton = new RoundedButton("Create Reminder");
        skipButton = new RoundedButton("Skip");
    }

    private void layoutComponents() {
        setLayout(new BorderLayout(15,15));
        RoundedPanel panel = new RoundedPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10,10,10,10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("Medicine :"), gbc);
        gbc.gridx = 1;
        panel.add(new JLabel(medicine.getMedicineName()), gbc);
        gbc.gridx = 0;
        gbc.gridy++;
        panel.add(new JLabel("Dosage :"), gbc);
        gbc.gridx = 1;
        panel.add(new JLabel(medicine.getDosage()), gbc);
        gbc.gridx = 0;
        gbc.gridy++;
        panel.add(new JLabel("Frequency :"), gbc);
        gbc.gridx = 1;
        panel.add(new JLabel(medicine.getFrequency()), gbc);
        gbc.gridx = 0;
        gbc.gridy++;
        panel.add(new JLabel("Reminder Date"), gbc);
        gbc.gridx = 1;
        panel.add(dateField, gbc);
        gbc.gridx = 0;
        gbc.gridy++;
        panel.add(new JLabel("Reminder Time"), gbc);
        gbc.gridx = 1;
        panel.add(timeField, gbc);
        JPanel buttonPanel = new JPanel();
        buttonPanel.setOpaque(false);
        buttonPanel.add(createButton);
        buttonPanel.add(skipButton);
        add(panel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void registerEvents() {
        createButton.addActionListener(e -> createReminder());
        skipButton.addActionListener(e -> dispose());
    }

    private void createReminder() {
        try {
            LocalDate reminderDate=LocalDate.parse(dateField.getText().trim(),dateFormatter);
            LocalTime reminderTime=LocalTime.parse(timeField.getText().trim(),timeFormatter);
            Reminder reminder = new Reminder(
                    "REM-" + medicine.getMedicineId(),
                    "GENERAL",medicine.getMedicineId(),medicine.getMedicineName(),
                    "Take " + medicine.getDosage(),reminderDate,reminderTime,false
            );
            boolean added=reminderScheduler.addReminder(reminder);
            if (added) {
                JOptionPane.showMessageDialog(this,"Reminder created successfully.");
                dispose();
            } else {
                JOptionPane.showMessageDialog(this,"Reminder already exists.");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,"Enter\n\n"+"Date : dd/MM/yyyy\n"+"Time : HH:mm");
        }
    }
}