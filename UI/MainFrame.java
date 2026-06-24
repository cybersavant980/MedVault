package UI;

import UI.theme.Theme;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private CardLayout cardLayout;
    private JPanel contentPanel;

    public MainFrame() {
        initializeComponents();
        layoutComponents();
        setFrameProperties();
    }

    private void initializeComponents() {

        cardLayout = new CardLayout();
        contentPanel = new JPanel(cardLayout);

        // Panels
        contentPanel.add(new Dashboard(), "Dashboard");
        contentPanel.add(new PatientPanel(), "Patients");

        // Lakshmi's Panels
        contentPanel.add(new MedicinePanel(), "Medicines");
        contentPanel.add(new EmergencyPanel(), "Emergency");
        contentPanel.add(new HealthPassportPanel(), "Passport");
        contentPanel.add(new ReportsPanel(), "Reports");
        contentPanel.add(new SettingsPanel(), "Settings");

        // Your USP
        contentPanel.add(new DigitalTwinPanel(), "DigitalTwin");
    }

    private void layoutComponents() {

        setLayout(new BorderLayout());

        JPanel navigationPanel = createNavigationPanel();

        add(navigationPanel, BorderLayout.WEST);
        add(contentPanel, BorderLayout.CENTER);

        showPanel("Dashboard");
    }

    private JPanel createNavigationPanel() {

        JPanel panel = new JPanel();
        panel.setBackground(Theme.PRIMARY);
        panel.setPreferredSize(new Dimension(220, 0));
        panel.setLayout(new GridLayout(9, 1, 10, 10));

        JButton dashboardBtn = createNavButton("Dashboard");
        JButton patientBtn = createNavButton("Patients");
        JButton medicineBtn = createNavButton("Medicines");
        JButton emergencyBtn = createNavButton("Emergency");
        JButton passportBtn = createNavButton("Health Passport");
        JButton reportBtn = createNavButton("Reports");
        JButton twinBtn = createNavButton("Digital Twin");
        JButton settingsBtn = createNavButton("Settings");

        dashboardBtn.addActionListener(e -> showPanel("Dashboard"));
        patientBtn.addActionListener(e -> showPanel("Patients"));
        medicineBtn.addActionListener(e -> showPanel("Medicines"));
        emergencyBtn.addActionListener(e -> showPanel("Emergency"));
        passportBtn.addActionListener(e -> showPanel("Passport"));
        reportBtn.addActionListener(e -> showPanel("Reports"));
        twinBtn.addActionListener(e -> showPanel("DigitalTwin"));
        settingsBtn.addActionListener(e -> showPanel("Settings"));

        panel.add(dashboardBtn);
        panel.add(patientBtn);
        panel.add(medicineBtn);
        panel.add(emergencyBtn);
        panel.add(passportBtn);
        panel.add(reportBtn);
        panel.add(twinBtn);
        panel.add(settingsBtn);

        return panel;
    }

    private JButton createNavButton(String text) {

        JButton button = new JButton(text);

        button.setFocusPainted(false);
        button.setFont(Theme.BUTTON_FONT);
        button.setBackground(Theme.PRIMARY);
        button.setForeground(Color.WHITE);

        return button;
    }

    private void showPanel(String panelName) {
        cardLayout.show(contentPanel, panelName);
    }

    private void setFrameProperties() {

        setTitle("THE_PROJECT");
        setSize(Theme.WINDOW_WIDTH, Theme.WINDOW_HEIGHT);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
}