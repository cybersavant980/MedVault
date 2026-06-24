package UI;

import UI.components.DashboardCard;
import UI.theme.Theme;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Dashboard extends JPanel {

    private DashboardCard patientCard;
    private DashboardCard medicineCard;
    private DashboardCard reminderCard;
    private DashboardCard emergencyCard;

    public Dashboard() {
        initializeComponents();
        layoutComponents();
    }

    private void initializeComponents() {

        patientCard = new DashboardCard("Patients", "0");
        medicineCard = new DashboardCard("Medicines", "0");
        reminderCard = new DashboardCard("Today's Reminders", "0");
        emergencyCard = new DashboardCard("Emergency Records", "0");
    }

    private void layoutComponents() {

        setLayout(new BorderLayout(20, 20));
        setBackground(Theme.BACKGROUND);
        setBorder(new EmptyBorder(20, 20, 20, 20));

        // ================= HEADER =================

        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setOpaque(false);

        JLabel title = new JLabel("Dashboard");
        title.setFont(Theme.TITLE_FONT);
        title.setForeground(Theme.TEXT_PRIMARY);

        JLabel subtitle = new JLabel("Welcome to THE_PROJECT");
        subtitle.setFont(Theme.SUBTITLE_FONT);
        subtitle.setForeground(Theme.TEXT_SECONDARY);

        JPanel titlePanel = new JPanel();
        titlePanel.setOpaque(false);
        titlePanel.setLayout(new BoxLayout(titlePanel, BoxLayout.Y_AXIS));

        titlePanel.add(title);
        titlePanel.add(subtitle);

        headerPanel.add(titlePanel, BorderLayout.WEST);

        // ================= DASHBOARD CARDS =================

        JPanel cardPanel = new JPanel(new GridLayout(2, 2, 20, 20));
        cardPanel.setOpaque(false);

        cardPanel.add(patientCard);
        cardPanel.add(medicineCard);
        cardPanel.add(reminderCard);
        cardPanel.add(emergencyCard);

        // ================= RECENT ACTIVITY =================

        JPanel activityPanel = new JPanel(new BorderLayout());
        activityPanel.setBackground(Color.WHITE);
        activityPanel.setBorder(BorderFactory.createTitledBorder("Recent Activity"));

        JTextArea activityArea = new JTextArea();
        activityArea.setEditable(false);
        activityArea.setFont(Theme.BODY_FONT);
        activityArea.setText(
                "• Application Started\n\n" +
                "• No Recent Activities\n\n" +
                "• Patient Records will appear here.\n\n" +
                "• Medicine Updates will appear here."
        );

        activityPanel.add(new JScrollPane(activityArea), BorderLayout.CENTER);

        // ================= MAIN =================

        JPanel centerPanel = new JPanel(new BorderLayout(20, 20));
        centerPanel.setOpaque(false);

        centerPanel.add(cardPanel, BorderLayout.NORTH);
        centerPanel.add(activityPanel, BorderLayout.CENTER);

        add(headerPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
    }

    // ================= UPDATE METHODS =================

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
}