package UI;

import UI.components.*;
import UI.theme.Theme;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class PatientPanel extends JPanel {

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
    private RoundedTextField ageField;
    private JComboBox<String> genderComboBox;
    private JComboBox<String> bloodGroupComboBox;
    private RoundedTextField diseaseField;
    private RoundedTextField phoneField;
    private RoundedTextField emailField;
    private RoundedTextField addressField;
    private RoundedTextField emergencyContactField;
    private RoundedTextField emergencyPhoneField;

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

    private AppTable patientTable;

    // =====================================================
    // Status
    // =====================================================

    private JLabel statusLabel;
    private JLabel totalPatientsLabel;

    // =====================================================
    // Constructor
    // =====================================================

    public PatientPanel() {

        initializeComponents();
        layoutComponents();
        registerEvents();

    }

    // =====================================================
    // Initialize Components
    // =====================================================

    private void initializeComponents() {

        titleLabel = new JLabel("Patient Management");
        titleLabel.setFont(Theme.TITLE_FONT);
        titleLabel.setForeground(Theme.TEXT_PRIMARY);

        subtitleLabel = new JLabel("Manage family patient records");
        subtitleLabel.setFont(Theme.SUBTITLE_FONT);
        subtitleLabel.setForeground(Theme.TEXT_SECONDARY);

        searchBar = new SearchBar();

        patientIdField = new RoundedTextField(20);
        patientNameField = new RoundedTextField(20);
        ageField = new RoundedTextField(20);

        genderComboBox = new JComboBox<>(
                new String[]{
                        "Male",
                        "Female",
                        "Other"
                });

        bloodGroupComboBox = new JComboBox<>(
                new String[]{
                        "A+",
                        "A-",
                        "B+",
                        "B-",
                        "AB+",
                        "AB-",
                        "O+",
                        "O-"
                });

        diseaseField = new RoundedTextField(20);
        phoneField = new RoundedTextField(20);
        emailField = new RoundedTextField(20);
        addressField = new RoundedTextField(20);
        emergencyContactField = new RoundedTextField(20);
        emergencyPhoneField = new RoundedTextField(20);

        addButton = new RoundedButton("Add");
        updateButton = new RoundedButton("Update");
        deleteButton = new RoundedButton("Delete");
        clearButton = new RoundedButton("Clear");
        refreshButton = new RoundedButton("Refresh");
        detailsButton = new RoundedButton("View Details");

        patientTable = new AppTable();

        statusLabel = new JLabel("Status : Ready");
        statusLabel.setFont(Theme.BODY_FONT);

        totalPatientsLabel = new JLabel("Total Patients : 0");
        totalPatientsLabel.setFont(Theme.BODY_FONT);

    }

    // =====================================================
    // Layout
    // =====================================================

    private void layoutComponents() {

        setLayout(new BorderLayout(15,15));
        setBackground(Theme.BACKGROUND);
        setBorder(new EmptyBorder(20,20,20,20));

        add(createHeaderPanel(), BorderLayout.NORTH);

        JPanel centerPanel = new JPanel(new BorderLayout(15,15));
        centerPanel.setOpaque(false);

        JPanel topPanel = new JPanel(new BorderLayout(15,15));
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
    // Header
    // =====================================================

    private JPanel createHeaderPanel(){

        JPanel panel = new JPanel(new BorderLayout());
        panel.setOpaque(false);

        JPanel titlePanel = new JPanel();
        titlePanel.setOpaque(false);
        titlePanel.setLayout(new BoxLayout(titlePanel,BoxLayout.Y_AXIS));

        titlePanel.add(titleLabel);
        titlePanel.add(Box.createVerticalStrut(5));
        titlePanel.add(subtitleLabel);

        panel.add(titlePanel,BorderLayout.WEST);

        return panel;

    }

    // =====================================================
    // Search Panel
    // =====================================================

    private JPanel createSearchPanel(){

        RoundedPanel panel = new RoundedPanel();
        panel.setLayout(new BorderLayout(10,10));
        panel.setBorder(new EmptyBorder(15,15,15,15));

        JLabel searchLabel = new JLabel("Search Patient");
        searchLabel.setFont(Theme.HEADER_FONT);

        panel.add(searchLabel,BorderLayout.NORTH);
        panel.add(searchBar,BorderLayout.CENTER);

        return panel;

    }
    // =====================================================
    // Form Panel
    // =====================================================

    private JPanel createFormPanel() {

        RoundedPanel panel = new RoundedPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBorder(new EmptyBorder(20, 20, 20, 20));

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;

        // =========================
        // Row 1
        // =========================

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("Patient ID"), gbc);

        gbc.gridx = 1;
        panel.add(new JLabel("Patient Name"), gbc);

        gbc.gridx = 2;
        panel.add(new JLabel("Age"), gbc);

        gbc.gridx = 3;
        panel.add(new JLabel("Gender"), gbc);

        gbc.gridy++;

        gbc.gridx = 0;
        panel.add(patientIdField, gbc);

        gbc.gridx = 1;
        panel.add(patientNameField, gbc);

        gbc.gridx = 2;
        panel.add(ageField, gbc);

        gbc.gridx = 3;
        panel.add(genderComboBox, gbc);

        // =========================
        // Row 2
        // =========================

        gbc.gridy++;

        gbc.gridx = 0;
        panel.add(new JLabel("Blood Group"), gbc);

        gbc.gridx = 1;
        panel.add(new JLabel("Disease"), gbc);

        gbc.gridx = 2;
        panel.add(new JLabel("Phone"), gbc);

        gbc.gridx = 3;
        panel.add(new JLabel("Email"), gbc);

        gbc.gridy++;

        gbc.gridx = 0;
        panel.add(bloodGroupComboBox, gbc);

        gbc.gridx = 1;
        panel.add(diseaseField, gbc);

        gbc.gridx = 2;
        panel.add(phoneField, gbc);

        gbc.gridx = 3;
        panel.add(emailField, gbc);

        // =========================
        // Row 3
        // =========================

        gbc.gridy++;

        gbc.gridx = 0;
        panel.add(new JLabel("Address"), gbc);

        gbc.gridx = 1;
        panel.add(new JLabel("Emergency Contact"), gbc);

        gbc.gridx = 2;
        panel.add(new JLabel("Emergency Phone"), gbc);

        gbc.gridy++;

        gbc.gridx = 0;
        panel.add(addressField, gbc);

        gbc.gridx = 1;
        panel.add(emergencyContactField, gbc);

        gbc.gridx = 2;
        panel.add(emergencyPhoneField, gbc);

        return panel;

    }

    // =====================================================
    // Button Panel
    // =====================================================

    private JPanel createButtonPanel() {

        JPanel panel = new JPanel(new FlowLayout(
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
        panel.setBorder(new EmptyBorder(15, 15, 15, 15));

        JLabel tableTitle = new JLabel("Patient Records");
        tableTitle.setFont(Theme.HEADER_FONT);

        panel.add(tableTitle, BorderLayout.NORTH);

        String[] columns = {
                "Patient ID",
                "Name",
                "Age",
                "Gender",
                "Blood Group",
                "Disease",
                "Phone"
        };

        patientTable.setTableData(columns, new Object[][]{});

        JScrollPane scrollPane = new JScrollPane(patientTable);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());

        panel.add(scrollPane, BorderLayout.CENTER);

        return panel;

    }

    // =====================================================
    // Status Panel
    // =====================================================

    private JPanel createStatusPanel() {

        JPanel panel = new JPanel(new BorderLayout());

        panel.setBorder(new EmptyBorder(5, 10, 5, 10));
        panel.setOpaque(false);

        statusLabel.setForeground(Theme.TEXT_SECONDARY);
        totalPatientsLabel.setForeground(Theme.TEXT_SECONDARY);

        panel.add(statusLabel, BorderLayout.WEST);
        panel.add(totalPatientsLabel, BorderLayout.EAST);

        return panel;

    }

    // =====================================================
    // Event Registration
    // =====================================================

    private void registerEvents() {

        addButton.addActionListener(e -> addPatient());

        updateButton.addActionListener(e -> updatePatient());

        deleteButton.addActionListener(e -> deletePatient());

        clearButton.addActionListener(e -> clearForm());

        refreshButton.addActionListener(e -> loadTable());

        detailsButton.addActionListener(e -> viewPatientDetails());

    }

    // =====================================================
    // Button Actions (Integration Ready)
    // =====================================================

    private void addPatient() {

        MessageDialog.showInfo(this,
                "PatientManager integration coming next.");

    }

    private void updatePatient() {

        MessageDialog.showInfo(this,
                "Patient update module coming next.");

    }

    private void deletePatient() {

        MessageDialog.showInfo(this,
                "Patient delete module coming next.");

    }

    private void viewPatientDetails() {

        MessageDialog.showInfo(this,
                "Patient details module coming next.");

    }

    // =====================================================
    // Utility Methods
    // =====================================================

    private void clearForm() {

        patientIdField.setText("");
        patientNameField.setText("");
        ageField.setText("");
        diseaseField.setText("");
        phoneField.setText("");
        emailField.setText("");
        addressField.setText("");
        emergencyContactField.setText("");
        emergencyPhoneField.setText("");

        genderComboBox.setSelectedIndex(0);
        bloodGroupComboBox.setSelectedIndex(0);

        patientNameField.requestFocus();

        statusLabel.setText("Status : Form Cleared");

    }

    private void loadTable() {

        statusLabel.setText("Status : Table Refreshed");

    }

    public void updatePatientCount(int count) {

        totalPatientsLabel.setText("Total Patients : " + count);

    }

}



