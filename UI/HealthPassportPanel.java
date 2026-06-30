package UI;

import DSA.models.HealthPassport;

import UI.components.*;
import UI.theme.Theme;

import javax.swing.*;
import java.awt.*;

public class HealthPassportPanel extends JPanel {

    // =====================================================
    // Header
    // =====================================================

    private JLabel titleLabel;
    private JLabel subtitleLabel;

    // =====================================================
    // Form Fields
    // =====================================================

    private RoundedTextField passportIdField;
    private RoundedTextField patientIdField;
    private RoundedTextField patientNameField;

    private RoundedTextField ageField;
    private RoundedTextField genderField;
    private RoundedTextField bloodGroupField;

    private RoundedTextField heightField;
    private RoundedTextField weightField;

    private RoundedTextField allergiesField;
    private RoundedTextField chronicDiseaseField;

    private RoundedTextField currentMedicinesField;
    private RoundedTextField vaccinationField;

    private RoundedTextField emergencyContactField;
    private RoundedTextField emergencyPhoneField;

    private RoundedTextField doctorField;
    private RoundedTextField doctorPhoneField;

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

    private AppTable passportTable;

    // =====================================================
    // Status
    // =====================================================

    private JLabel statusLabel;
    private JLabel totalPassportLabel;

    public HealthPassportPanel() {

        initializeComponents();
        layoutComponents();
        registerEvents();

        loadPassportTable();

    }

    // =====================================================
    // Initialize
    // =====================================================

    private void initializeComponents() {

        titleLabel = new JLabel("Health Passport");
        titleLabel.setFont(Theme.TITLE_FONT);
        titleLabel.setForeground(Theme.TEXT_PRIMARY);

        subtitleLabel = new JLabel(
                "Digital Health Passport Records");

        subtitleLabel.setFont(Theme.SUBTITLE_FONT);
        subtitleLabel.setForeground(Theme.TEXT_SECONDARY);

        passportIdField = new RoundedTextField(20);
        patientIdField = new RoundedTextField(20);
        patientNameField = new RoundedTextField(20);

        ageField = new RoundedTextField(20);
        genderField = new RoundedTextField(20);
        bloodGroupField = new RoundedTextField(20);

        heightField = new RoundedTextField(20);
        weightField = new RoundedTextField(20);

        allergiesField = new RoundedTextField(20);
        chronicDiseaseField = new RoundedTextField(20);

        currentMedicinesField = new RoundedTextField(20);
        vaccinationField = new RoundedTextField(20);

        emergencyContactField = new RoundedTextField(20);
        emergencyPhoneField = new RoundedTextField(20);

        doctorField = new RoundedTextField(20);
        doctorPhoneField = new RoundedTextField(20);

        addButton = new RoundedButton("Add");
        updateButton = new RoundedButton("Update");
        deleteButton = new RoundedButton("Delete");
        clearButton = new RoundedButton("Clear");
        refreshButton = new RoundedButton("Refresh");
        detailsButton = new RoundedButton("View Details");

        passportTable = new AppTable();

        statusLabel = new JLabel("Status : Ready");

        totalPassportLabel = new JLabel("Total Passports : 0");

    }

    // =====================================================
    // Layout
    // =====================================================

        private void layoutComponents() {

        setLayout(new BorderLayout(15,15));
        setBackground(Theme.BACKGROUND);

        add(createHeaderPanel(), BorderLayout.NORTH);

        JPanel centerPanel = new JPanel(new BorderLayout(15,15));
        centerPanel.setOpaque(false);

        // Form at the top
        centerPanel.add(createFormPanel(), BorderLayout.NORTH);

        // Buttons + Table
        JPanel bottomPanel = new JPanel(new BorderLayout(15,15));
        bottomPanel.setOpaque(false);

        bottomPanel.add(createButtonPanel(), BorderLayout.NORTH);
        bottomPanel.add(createTablePanel(), BorderLayout.CENTER);

        centerPanel.add(bottomPanel, BorderLayout.CENTER);

        add(centerPanel, BorderLayout.CENTER);

        add(createStatusPanel(), BorderLayout.SOUTH);

        }

    // =====================================================
    // Header
    // =====================================================

    private JPanel createHeaderPanel() {

        JPanel panel =
                new JPanel(new BorderLayout());

        panel.setOpaque(false);

        JPanel titlePanel = new JPanel();

        titlePanel.setOpaque(false);

        titlePanel.setLayout(
                new BoxLayout(
                        titlePanel,
                        BoxLayout.Y_AXIS));

        titlePanel.add(titleLabel);
        titlePanel.add(Box.createVerticalStrut(5));
        titlePanel.add(subtitleLabel);

        panel.add(titlePanel,BorderLayout.WEST);

        return panel;

    }


    // =====================================================
    // Form Panel
    // =====================================================

    private JPanel createFormPanel() {

        RoundedPanel panel = new RoundedPanel();
        panel.setPreferredSize(new Dimension(1000,420));
        panel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets = new Insets(10,10,10,10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;

        // ===============================================
        // Row 1
        // ===============================================

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("Passport ID"), gbc);

        gbc.gridx = 1;
        panel.add(new JLabel("Patient ID"), gbc);

        gbc.gridx = 2;
        panel.add(new JLabel("Patient Name"), gbc);

        gbc.gridy++;

        gbc.gridx = 0;
        panel.add(passportIdField, gbc);

        gbc.gridx = 1;
        panel.add(patientIdField, gbc);

        gbc.gridx = 2;
        panel.add(patientNameField, gbc);

        // ===============================================
        // Row 2
        // ===============================================

        gbc.gridy++;

        gbc.gridx = 0;
        panel.add(new JLabel("Age"), gbc);

        gbc.gridx = 1;
        panel.add(new JLabel("Gender"), gbc);

        gbc.gridx = 2;
        panel.add(new JLabel("Blood Group"), gbc);

        gbc.gridy++;

        gbc.gridx = 0;
        panel.add(ageField, gbc);

        gbc.gridx = 1;
        panel.add(genderField, gbc);

        gbc.gridx = 2;
        panel.add(bloodGroupField, gbc);

        // ===============================================
        // Row 3
        // ===============================================

        gbc.gridy++;

        gbc.gridx = 0;
        panel.add(new JLabel("Height"), gbc);

        gbc.gridx = 1;
        panel.add(new JLabel("Weight"), gbc);

        gbc.gridx = 2;
        panel.add(new JLabel("Allergies"), gbc);

        gbc.gridy++;

        gbc.gridx = 0;
        panel.add(heightField, gbc);

        gbc.gridx = 1;
        panel.add(weightField, gbc);

        gbc.gridx = 2;
        panel.add(allergiesField, gbc);

        // ===============================================
        // Row 4
        // ===============================================

        gbc.gridy++;

        gbc.gridx = 0;
        panel.add(new JLabel("Chronic Diseases"), gbc);

        gbc.gridx = 1;
        panel.add(new JLabel("Current Medicines"), gbc);

        gbc.gridx = 2;
        panel.add(new JLabel("Vaccinations"), gbc);

        gbc.gridy++;

        gbc.gridx = 0;
        panel.add(chronicDiseaseField, gbc);

        gbc.gridx = 1;
        panel.add(currentMedicinesField, gbc);

        gbc.gridx = 2;
        panel.add(vaccinationField, gbc);

        // ===============================================
        // Row 5
        // ===============================================

        gbc.gridy++;

        gbc.gridx = 0;
        panel.add(new JLabel("Emergency Contact"), gbc);

        gbc.gridx = 1;
        panel.add(new JLabel("Emergency Phone"), gbc);

        gbc.gridx = 2;
        panel.add(new JLabel("Doctor Name"), gbc);

        gbc.gridy++;

        gbc.gridx = 0;
        panel.add(emergencyContactField, gbc);

        gbc.gridx = 1;
        panel.add(emergencyPhoneField, gbc);

        gbc.gridx = 2;
        panel.add(doctorField, gbc);

        // ===============================================
        // Row 6
        // ===============================================

        gbc.gridy++;

        gbc.gridx = 0;
        panel.add(new JLabel("Doctor Phone"), gbc);

        gbc.gridy++;

        gbc.gridx = 0;
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
        panel.setPreferredSize(new Dimension(1000,300));
        panel.setLayout(new BorderLayout());

        JLabel title =
                new JLabel("Health Passport Records");

        title.setFont(Theme.HEADER_FONT);

        panel.add(title, BorderLayout.NORTH);

        String[] columns = {

                "Passport ID",
                "Patient",
                "Blood Group",
                "Disease",
                "Doctor"

        };

        passportTable.setTableData(columns,new Object[][]{});

        JScrollPane scrollPane =
                new JScrollPane(passportTable);

        scrollPane.setBorder(
                BorderFactory.createEmptyBorder());

        panel.add(scrollPane,BorderLayout.CENTER);

        return panel;

    }

    // =====================================================
    // Status Panel
    // =====================================================

    private JPanel createStatusPanel() {

        JPanel panel =
                new JPanel(new BorderLayout());

        panel.setOpaque(false);

        statusLabel.setForeground(
                Theme.TEXT_SECONDARY);

        totalPassportLabel.setForeground(
                Theme.TEXT_SECONDARY);

        panel.add(statusLabel,BorderLayout.WEST);

        panel.add(totalPassportLabel,BorderLayout.EAST);

        return panel;

    }

    // =====================================================
    // Register Events
    // =====================================================

    private void registerEvents() {

        addButton.addActionListener(e -> addPassport());

        updateButton.addActionListener(e -> updatePassport());

        deleteButton.addActionListener(e -> deletePassport());

        clearButton.addActionListener(e -> clearForm());

        refreshButton.addActionListener(e -> loadPassportTable());

        detailsButton.addActionListener(e -> viewPassportDetails());

    }

    // =====================================================
    // Load Table
    // =====================================================

    private void loadPassportTable() {

        statusLabel.setText(
                "Status : Passport records loaded.");

        totalPassportLabel.setText(
                "Total Passports : 0");

    }

    // =====================================================
    // Add Passport
    // =====================================================

    private void addPassport() {

        MessageDialog.showInfo(
                this,
                "Health Passport integration will be implemented later.");

    }

    // =====================================================
    // Update Passport
    // =====================================================

    private void updatePassport() {

        MessageDialog.showInfo(
                this,
                "Update Passport module coming next.");

    }

    // =====================================================
    // Delete Passport
    // =====================================================

    private void deletePassport() {

        MessageDialog.showInfo(
                this,
                "Delete Passport module coming next.");

    }

    // =====================================================
    // View Passport Details
    // =====================================================

    private void viewPassportDetails() {

        MessageDialog.showInfo(
                this,
                "Passport details module coming next.");

    }

    // =====================================================
    // Clear Form
    // =====================================================

    private void clearForm() {

        passportIdField.setText("");
        patientIdField.setText("");
        patientNameField.setText("");

        ageField.setText("");
        genderField.setText("");
        bloodGroupField.setText("");

        heightField.setText("");
        weightField.setText("");

        allergiesField.setText("");
        chronicDiseaseField.setText("");

        currentMedicinesField.setText("");
        vaccinationField.setText("");

        emergencyContactField.setText("");
        emergencyPhoneField.setText("");

        doctorField.setText("");
        doctorPhoneField.setText("");

        passportIdField.requestFocus();

        statusLabel.setText("Status : Form Cleared");

    }

}