package UI;

import DSA.managers.EmergencyManager;
import DSA.managers.MedicineManager;
import DSA.managers.PatientManager;
import DSA.managers.ReminderScheduler;
import UI.components.DashboardCard;
import UI.components.RoundedButton;
import UI.components.RoundedPanel;
import UI.theme.Theme;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Dashboard extends JPanel {

    private MainFrame parentFrame;

    // =====================================================
    // Cards
    // =====================================================

    private DashboardCard patientCard;
    private DashboardCard medicineCard;
    private DashboardCard reminderCard;
    private DashboardCard emergencyCard;

    // =====================================================
    // Managers
    // =====================================================

    private PatientManager patientManager;
    private MedicineManager medicineManager;
    private ReminderScheduler reminderScheduler;
    private EmergencyManager emergencyManager;

    // =====================================================
    // Quick Action Buttons
    // =====================================================

    private RoundedButton addPatientButton;
    private RoundedButton addMedicineButton;
    private RoundedButton emergencyButton;
    private RoundedButton refreshButton;

        public Dashboard(MainFrame parentFrame) {

        this.parentFrame = parentFrame;

        patientManager = new PatientManager();
        medicineManager = new MedicineManager();
        reminderScheduler = new ReminderScheduler();
        emergencyManager = new EmergencyManager();

        initializeComponents();
        layoutComponents();

        refreshDashboard();

        }

    private void initializeComponents() {

        patientCard =
                new DashboardCard("Patients", "0");

        medicineCard =
                new DashboardCard("Medicines", "0");

        reminderCard =
                new DashboardCard("Today's Reminders", "0");

        emergencyCard =
                new DashboardCard("Emergency Records", "0");

        addPatientButton =
                new RoundedButton("Add Patient");

        addMedicineButton =
                new RoundedButton("Add Medicine");

        emergencyButton =
                new RoundedButton("Emergency");

        refreshButton =
                new RoundedButton("Refresh");

    }

    private void layoutComponents() {

        setLayout(new BorderLayout(25,25));

        setBackground(Theme.BACKGROUND);

        setBorder(new EmptyBorder(25,25,25,25));

        add(createHeaderPanel(), BorderLayout.NORTH);

        JPanel centerPanel =
                new JPanel(new BorderLayout(25,25));

        centerPanel.setOpaque(false);

        centerPanel.add(createCardPanel(), BorderLayout.NORTH);

        centerPanel.add(createQuickActionPanel(), BorderLayout.CENTER);

        add(centerPanel, BorderLayout.CENTER);

    }
        // =====================================================
    // Header
    // =====================================================

    private JPanel createHeaderPanel() {

        JPanel panel = new JPanel(new BorderLayout());
        panel.setOpaque(false);

        JPanel titlePanel = new JPanel();
        titlePanel.setOpaque(false);
        titlePanel.setLayout(new BoxLayout(titlePanel, BoxLayout.Y_AXIS));

        JLabel title = new JLabel("MedVault Dashboard");
        title.setFont(Theme.TITLE_FONT);
        title.setForeground(Theme.TEXT_PRIMARY);

        JLabel subtitle = new JLabel(
                "Offline Home Medical Record & Emergency Management System");

        subtitle.setFont(Theme.SUBTITLE_FONT);
        subtitle.setForeground(Theme.TEXT_SECONDARY);

        titlePanel.add(title);
        titlePanel.add(Box.createVerticalStrut(6));
        titlePanel.add(subtitle);

        panel.add(titlePanel, BorderLayout.WEST);

        return panel;

    }

    // =====================================================
    // Dashboard Cards
    // =====================================================

    private JPanel createCardPanel() {

        JPanel panel = new JPanel(new GridLayout(1,4,20,20));

        panel.setOpaque(false);

        panel.add(patientCard);
        panel.add(medicineCard);
        panel.add(reminderCard);
        panel.add(emergencyCard);

        return panel;

    }

    // =====================================================
    // Quick Actions
    // =====================================================

    private JPanel createQuickActionPanel() {

        RoundedPanel panel = new RoundedPanel();

        panel.setLayout(new BorderLayout(15,15));

        JLabel heading = new JLabel("Quick Actions");

        heading.setFont(Theme.HEADER_FONT);

        heading.setForeground(Theme.TEXT_PRIMARY);

        panel.add(heading, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(
                new GridLayout(2,2,20,20));

        buttonPanel.setOpaque(false);

        buttonPanel.add(addPatientButton);
        buttonPanel.add(addMedicineButton);
        buttonPanel.add(emergencyButton);
        buttonPanel.add(refreshButton);

        panel.add(buttonPanel, BorderLayout.CENTER);

        // Events

        addPatientButton.addActionListener(e ->
                parentFrame.openPanel("Patients"));

        addMedicineButton.addActionListener(e ->
                parentFrame.openPanel("Medicines"));

        emergencyButton.addActionListener(e ->
                parentFrame.openPanel("Emergency"));

        refreshButton.addActionListener(e ->
                refreshDashboard());

        return panel;

    }
        // =====================================================
    // Dashboard Update Methods
    // =====================================================

    public void setPatientCount(int count) {

        patientCard.setValue(String.valueOf(count));

    }

    public void setMedicineCount(int count) {

        medicineCard.setValue(String.valueOf(count));

    }

    public void setReminderCount(int count) {

        reminderCard.setValue(String.valueOf(count));

    }

    public void setEmergencyCount(int count) {

        emergencyCard.setValue(String.valueOf(count));

    }

    // =====================================================
    // Refresh Dashboard
    // =====================================================

    public void refreshDashboard() {

        patientManager.loadPatients();
        medicineManager.loadMedicines();
        emergencyManager.loadEmergencyRecords();

        setPatientCount(
                patientManager.getPatientCount());

        setMedicineCount(
                medicineManager.getMedicineCount());

        setReminderCount(
                reminderScheduler.getReminderCount());

        setEmergencyCount(
                emergencyManager.getEmergencyCount());

    }

}