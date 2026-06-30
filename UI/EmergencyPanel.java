package UI;

import DSA.managers.EmergencyManager;
import DSA.models.Emergency;

import UI.components.*;
import UI.theme.Theme;

import javax.swing.*;
import java.awt.*;

public class EmergencyPanel extends JPanel {

    // =====================================================
    // Manager
    // =====================================================

    private EmergencyManager emergencyManager;

    // =====================================================
    // Header
    // =====================================================

    private JLabel titleLabel;
    private JLabel subtitleLabel;

    // =====================================================
    // Search
    // =====================================================

    private SearchBar searchBar;

    // =====================================================
    // Form Fields
    // =====================================================

    private RoundedTextField patientIdField;
    private RoundedTextField patientNameField;
    private RoundedTextField bloodGroupField;

    private RoundedTextField allergiesField;
    private RoundedTextField diseasesField;

    private RoundedTextField emergencyContactField;
    private RoundedTextField emergencyPhoneField;

    private RoundedTextField doctorNameField;
    private RoundedTextField doctorPhoneField;

    private RoundedTextField medicinesField;

    // =====================================================
    // Buttons
    // =====================================================

    private RoundedButton addButton;
    private RoundedButton updateButton;
    private RoundedButton deleteButton;
    private RoundedButton clearButton;
    private RoundedButton refreshButton;
    private RoundedButton detailsButton;

    // =====================================================
    // Table
    // =====================================================

    private AppTable emergencyTable;

    // =====================================================
    // Status
    // =====================================================

    private JLabel statusLabel;
    private JLabel totalEmergencyLabel;

    public EmergencyPanel() {

        emergencyManager = new EmergencyManager();

        initializeComponents();
        layoutComponents();
        registerEvents();

        loadEmergencyTable();

    }

    private void initializeComponents() {

        titleLabel = new JLabel("Emergency Management");
        titleLabel.setFont(Theme.TITLE_FONT);
        titleLabel.setForeground(Theme.TEXT_PRIMARY);

        subtitleLabel = new JLabel("Manage emergency information");
        subtitleLabel.setFont(Theme.SUBTITLE_FONT);
        subtitleLabel.setForeground(Theme.TEXT_SECONDARY);

        searchBar = new SearchBar();

        patientIdField = new RoundedTextField(20);
        patientNameField = new RoundedTextField(20);
        bloodGroupField = new RoundedTextField(20);

        allergiesField = new RoundedTextField(20);
        diseasesField = new RoundedTextField(20);

        emergencyContactField = new RoundedTextField(20);
        emergencyPhoneField = new RoundedTextField(20);

        doctorNameField = new RoundedTextField(20);
        doctorPhoneField = new RoundedTextField(20);

        medicinesField = new RoundedTextField(20);

        addButton = new RoundedButton("Add");
        updateButton = new RoundedButton("Update");
        deleteButton = new RoundedButton("Delete");
        clearButton = new RoundedButton("Clear");
        refreshButton = new RoundedButton("Refresh");
        detailsButton = new RoundedButton("View Details");

        emergencyTable = new AppTable();

        statusLabel = new JLabel("Status : Ready");
        totalEmergencyLabel = new JLabel("Emergency Records : 0");

    }

    // =====================================================
    // Layout
    // =====================================================

    private void layoutComponents() {

        setLayout(new BorderLayout(15, 15));
        setBackground(Theme.BACKGROUND);

        add(createHeaderPanel(), BorderLayout.NORTH);

        JPanel centerPanel = new JPanel(new BorderLayout(15, 15));
        centerPanel.setOpaque(false);

        JPanel topPanel = new JPanel(new BorderLayout(15, 15));
        topPanel.setOpaque(false);

        topPanel.add(createSearchPanel(), BorderLayout.NORTH);
        topPanel.add(createFormPanel(), BorderLayout.CENTER);

        centerPanel.add(topPanel, BorderLayout.NORTH);
        centerPanel.add(createButtonPanel(), BorderLayout.CENTER);
        centerPanel.add(createTablePanel(), BorderLayout.SOUTH);

        add(centerPanel, BorderLayout.CENTER);
        add(createStatusPanel(), BorderLayout.SOUTH);

    }

    // =====================================================
    // Header Panel
    // =====================================================

    private JPanel createHeaderPanel() {

        JPanel panel = new JPanel(new BorderLayout());
        panel.setOpaque(false);

        JPanel titlePanel = new JPanel();
        titlePanel.setOpaque(false);
        titlePanel.setLayout(new BoxLayout(titlePanel, BoxLayout.Y_AXIS));

        titlePanel.add(titleLabel);
        titlePanel.add(Box.createVerticalStrut(5));
        titlePanel.add(subtitleLabel);

        panel.add(titlePanel, BorderLayout.WEST);

        return panel;

    }

    // =====================================================
    // Search Panel
    // =====================================================

    private JPanel createSearchPanel() {

        RoundedPanel panel = new RoundedPanel();
        panel.setLayout(new BorderLayout(10,10));

        JLabel label = new JLabel("Search Emergency Record");
        label.setFont(Theme.HEADER_FONT);

        panel.add(label, BorderLayout.NORTH);
        panel.add(searchBar, BorderLayout.CENTER);

        return panel;

    }

    // =====================================================
    // Form Panel
    // =====================================================

    private JPanel createFormPanel() {

        RoundedPanel panel = new RoundedPanel();
        panel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets = new Insets(10,10,10,10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;

        gbc.gridx=0; gbc.gridy=0;
        panel.add(new JLabel("Patient ID"), gbc);

        gbc.gridx=1;
        panel.add(new JLabel("Patient Name"), gbc);

        gbc.gridx=2;
        panel.add(new JLabel("Blood Group"), gbc);

        gbc.gridy++;

        gbc.gridx=0;
        panel.add(patientIdField, gbc);

        gbc.gridx=1;
        panel.add(patientNameField, gbc);

        gbc.gridx=2;
        panel.add(bloodGroupField, gbc);

        gbc.gridy++;

        gbc.gridx=0;
        panel.add(new JLabel("Allergies"), gbc);

        gbc.gridx=1;
        panel.add(new JLabel("Diseases"), gbc);

        gbc.gridx=2;
        panel.add(new JLabel("Current Medicines"), gbc);

        gbc.gridy++;

        gbc.gridx=0;
        panel.add(allergiesField, gbc);

        gbc.gridx=1;
        panel.add(diseasesField, gbc);

        gbc.gridx=2;
        panel.add(medicinesField, gbc);

        gbc.gridy++;

        gbc.gridx=0;
        panel.add(new JLabel("Emergency Contact"), gbc);

        gbc.gridx=1;
        panel.add(new JLabel("Emergency Phone"), gbc);

        gbc.gridx=2;
        panel.add(new JLabel("Doctor Name"), gbc);

        gbc.gridy++;

        gbc.gridx=0;
        panel.add(emergencyContactField, gbc);

        gbc.gridx=1;
        panel.add(emergencyPhoneField, gbc);

        gbc.gridx=2;
        panel.add(doctorNameField, gbc);

        gbc.gridy++;

        gbc.gridx=0;
        panel.add(new JLabel("Doctor Phone"), gbc);

        gbc.gridy++;

        gbc.gridx=0;
        panel.add(doctorPhoneField, gbc);

        return panel;

    }

    // =====================================================
    // Button Panel
    // =====================================================

    private JPanel createButtonPanel() {

        JPanel panel = new JPanel(
                new FlowLayout(
                        FlowLayout.CENTER,
                        15,
                        10));

        panel.setOpaque(false);

        panel.add(addButton);
        panel.add(updateButton);
        panel.add(deleteButton);
        panel.add(clearButton);
        panel.add(refreshButton);
        panel.add(detailsButton);

        return panel;

    }

    // =====================================================
    // Table Panel
    // =====================================================

    private JPanel createTablePanel() {

        RoundedPanel panel = new RoundedPanel();
        panel.setLayout(new BorderLayout());

        JLabel title = new JLabel("Emergency Records");
        title.setFont(Theme.HEADER_FONT);

        panel.add(title, BorderLayout.NORTH);

        String[] columns = {

                "Patient ID",
                "Patient Name",
                "Blood",
                "Emergency Contact",
                "Doctor"

        };

        emergencyTable.setTableData(columns,new Object[][]{});

        JScrollPane scrollPane =
                new JScrollPane(emergencyTable);

        scrollPane.setBorder(
                BorderFactory.createEmptyBorder());

        panel.add(scrollPane,BorderLayout.CENTER);

        return panel;

    }

    // =====================================================
    // Status Panel
    // =====================================================

    private JPanel createStatusPanel() {

        JPanel panel = new JPanel(new BorderLayout());

        panel.setOpaque(false);

        panel.add(statusLabel,BorderLayout.WEST);
        panel.add(totalEmergencyLabel,BorderLayout.EAST);

        return panel;

    }

    // =====================================================
    // Register Events
    // =====================================================

    private void registerEvents() {

        addButton.addActionListener(e -> addEmergency());

        updateButton.addActionListener(e -> updateEmergency());

        deleteButton.addActionListener(e -> deleteEmergency());

        clearButton.addActionListener(e -> clearForm());

        refreshButton.addActionListener(e -> loadEmergencyTable());

        detailsButton.addActionListener(e -> viewEmergencyDetails());

    }

    // =====================================================
    // Load Table
    // =====================================================

    private void loadEmergencyTable() {

        statusLabel.setText("Status : Emergency records loaded.");

    }

    // =====================================================
    // Add
    // =====================================================

    private void addEmergency() {

        MessageDialog.showInfo(
                this,
                "Emergency CRUD integration coming next.");

    }

    // =====================================================
    // Update
    // =====================================================

    private void updateEmergency() {

        MessageDialog.showInfo(
                this,
                "Update module coming next.");

    }

    // =====================================================
    // Delete
    // =====================================================

    private void deleteEmergency() {

        MessageDialog.showInfo(
                this,
                "Delete module coming next.");

    }

    // =====================================================
    // Details
    // =====================================================

    private void viewEmergencyDetails() {

        MessageDialog.showInfo(
                this,
                "Emergency details coming next.");

    }

    // =====================================================
    // Clear Form
    // =====================================================

    private void clearForm() {

        patientIdField.setText("");
        patientNameField.setText("");
        bloodGroupField.setText("");

        allergiesField.setText("");
        diseasesField.setText("");

        medicinesField.setText("");

        emergencyContactField.setText("");
        emergencyPhoneField.setText("");

        doctorNameField.setText("");
        doctorPhoneField.setText("");

        patientIdField.requestFocus();

        statusLabel.setText("Status : Form Cleared");

    }

}


