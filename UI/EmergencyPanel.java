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

        setLayout(new BorderLayout(15,15));
        setBackground(Theme.BACKGROUND);

        add(createHeaderPanel(), BorderLayout.NORTH);

        JPanel centerPanel = new JPanel(new BorderLayout(15,15));
        centerPanel.setOpaque(false);

        // Form at the top
        JScrollPane formScroll = new JScrollPane(createFormPanel());

        formScroll.setBorder(BorderFactory.createEmptyBorder());
        formScroll.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        formScroll.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        centerPanel.add(formScroll, BorderLayout.NORTH);

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
        panel.setPreferredSize(new Dimension(1000,300));
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

        emergencyTable.getSelectionModel().addListSelectionListener(e -> {

            if (e.getValueIsAdjusting()) return;

            int row = emergencyTable.getSelectedRow();

            if (row == -1) return;

            String patientId =
                    emergencyTable.getValueAt(row,0).toString();

            Emergency emergency =
                    emergencyManager.getEmergency(patientId);

            if (emergency == null) return;

                patientIdField.setText(emergency.getPatientId());

                patientNameField.setText("");

                bloodGroupField.setText(
                        emergency.getBloodGroup());

                allergiesField.setText(
                        emergency.getAllergies());

                diseasesField.setText(
                        emergency.getChronicDisease());

                medicinesField.setText("");

                emergencyContactField.setText(
                        emergency.getPrimaryContactName());

                emergencyPhoneField.setText(
                        emergency.getPrimaryContactNumber());

                doctorNameField.setText(
                        emergency.getFamilyDoctor());

                doctorPhoneField.setText(
                        emergency.getDoctorContact());
        });

    }

    // =====================================================
    // Load Table
    // =====================================================

    private void loadEmergencyTable() {

        String[] columns = {

            "Patient ID",
            "Blood Group",
            "Emergency Contact",
            "Doctor",
            "Hospital"

        };

        java.util.List<Emergency> list =
                emergencyManager.getAllEmergencyRecords();

        Object[][] data = new Object[list.size()][5];

        for (int i = 0; i < list.size(); i++) {

            Emergency e = list.get(i);

            data[i][0] = e.getPatientId();
            data[i][1] = e.getBloodGroup();
            data[i][2] = e.getPrimaryContactName();
            data[i][3] = e.getFamilyDoctor();
            data[i][4] = e.getPreferredHospital();

        }

        emergencyTable.setTableData(columns, data);

        totalEmergencyLabel.setText(
                "Emergency Records : " + list.size());

        statusLabel.setText(
                "Status : " + list.size() + " record(s) loaded.");

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


