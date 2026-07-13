package UI;
import DSA.models.HealthPassport;
import DSA.managers.HealthPassportManager;
import UI.components.*;
import UI.theme.Theme;
import javax.swing.*;
import java.awt.*;

public class HealthPassportPanel extends JPanel {
    private HealthPassportManager passportManager;
    private JLabel titleLabel,subtitleLabel;
    private RoundedTextField passportIdField,patientIdField,patientNameField,ageField,genderField,bloodGroupField,heightField,weightField,allergiesField,chronicDiseaseField,currentMedicinesField,vaccinationField,emergencyContactField,doctorField,doctorContactField,hospitalField;
    private RoundedButton addButton,updateButton,deleteButton,clearButton,refreshButton,detailsButton;
    private AppTable passportTable;
    private JLabel statusLabel,totalPassportLabel;
    public HealthPassportPanel() {
        passportManager = new HealthPassportManager();
        initializeComponents();
        layoutComponents();
        registerEvents();
        loadPassportTable();
    }

    private void initializeComponents() {
        titleLabel = new JLabel("Health Passport");
        titleLabel.setFont(Theme.TITLE_FONT);
        titleLabel.setForeground(Theme.TEXT_PRIMARY);
        subtitleLabel = new JLabel("Digital Health Passport Records");
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
        hospitalField = new RoundedTextField(20);
        doctorField = new RoundedTextField(20);
        doctorContactField = new RoundedTextField(20);
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

    private void layoutComponents() {
        setLayout(new BorderLayout(15,15));
        setBackground(Theme.BACKGROUND);
        add(createHeaderPanel(), BorderLayout.NORTH);
        JPanel contentPanel = new JPanel();
        contentPanel.setOpaque(false);
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.add(createFormPanel());
        contentPanel.add(Box.createVerticalStrut(15));
        contentPanel.add(createButtonPanel());
        contentPanel.add(Box.createVerticalStrut(15));
        contentPanel.add(createTablePanel());
        JScrollPane scrollPane = new JScrollPane(contentPanel);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        add(scrollPane, BorderLayout.CENTER);
        add(createStatusPanel(), BorderLayout.SOUTH);
    }

    private JPanel createHeaderPanel() {
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

    private JPanel createFormPanel() {
        RoundedPanel panel = new RoundedPanel();
        panel.setPreferredSize(new Dimension(1000,620));
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10,10,10,10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;
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
        gbc.gridy++;
        gbc.gridx = 0;
        panel.add(new JLabel("Emergency Contact"), gbc);
        gbc.gridx = 1;
        panel.add(new JLabel("Hospital"), gbc);
        gbc.gridx = 2;
        panel.add(new JLabel("Doctor Name"), gbc);
        gbc.gridy++;
        gbc.gridx = 0;
        panel.add(emergencyContactField, gbc);
        gbc.gridx = 1;
        panel.add(hospitalField, gbc);
        gbc.gridx = 2;
        panel.add(doctorField, gbc);
        gbc.gridy++;
        gbc.gridx = 0;
        panel.add(new JLabel("Doctor Phone"), gbc);
        gbc.gridy++;
        gbc.gridx = 0;
        panel.add(doctorContactField, gbc);
        return panel;
    }

    private JPanel createButtonPanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER,15,10));
        panel.setOpaque(false);
        panel.add(addButton);
        panel.add(updateButton);
        panel.add(deleteButton);
        panel.add(clearButton);
        panel.add(refreshButton);
        panel.add(detailsButton);
        return panel;
    }

    private JPanel createTablePanel() {
        RoundedPanel panel = new RoundedPanel();
        panel.setPreferredSize(new Dimension(1000,300));
        panel.setLayout(new BorderLayout());
        JLabel title = new JLabel("Health Passport Records");
        title.setFont(Theme.HEADER_FONT);
        panel.add(title, BorderLayout.NORTH);
        String[] columns = {"Passport ID","Patient ID","Blood Group","Height","Weight","Doctor","Doctor Contact"};
        passportTable.setTableData(columns,new Object[][]{});
        JScrollPane scrollPane = new JScrollPane(passportTable);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        panel.add(scrollPane,BorderLayout.CENTER);
        return panel;
    }

    private JPanel createStatusPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setOpaque(false);
        statusLabel.setForeground(Theme.TEXT_SECONDARY);
        totalPassportLabel.setForeground(Theme.TEXT_SECONDARY);
        panel.add(statusLabel,BorderLayout.WEST);
        panel.add(totalPassportLabel,BorderLayout.EAST);
        return panel;
    }

private void registerEvents() {
    addButton.addActionListener(e -> addPassport());
    updateButton.addActionListener(e -> updatePassport());
    deleteButton.addActionListener(e -> deletePassport());
    clearButton.addActionListener(e -> clearForm());
    refreshButton.addActionListener(e -> loadPassportTable());
    detailsButton.addActionListener(e -> viewPassportDetails());
    passportTable.getSelectionModel().addListSelectionListener(e -> {
        if (e.getValueIsAdjusting()) return;
        int row = passportTable.getSelectedRow();
        if (row == -1) return;
        String passportId = passportTable.getValueAt(row, 0).toString();
        HealthPassport passport = passportManager.getPassport(passportId);
        if (passport == null) return;
        passportIdField.setText(passport.getPassportId());
        patientIdField.setText(passport.getPatientId());
        patientNameField.setText(passport.getPatientName());
        ageField.setText(String.valueOf(passport.getAge()));
        genderField.setText(passport.getGender());
        bloodGroupField.setText(passport.getBloodGroup());
        heightField.setText(String.valueOf(passport.getHeight()));
        weightField.setText(String.valueOf(passport.getWeight()));
        doctorField.setText(passport.getFamilyDoctor());
        doctorContactField.setText(passport.getDoctorContact());
        hospitalField.setText(passport.getHospitalName());
        emergencyContactField.setText(passport.getEmergencyContact());
        allergiesField.setText(passport.getAllergies().isEmpty() ? "" : String.join(", ", passport.getAllergies()));
        chronicDiseaseField.setText(passport.getChronicDiseases().isEmpty() ? "" : String.join(", ", passport.getChronicDiseases()));
        currentMedicinesField.setText(passport.getCurrentMedicines().isEmpty() ? "" : String.join(", ", passport.getCurrentMedicines()));
        vaccinationField.setText(passport.getVaccinations().isEmpty() ? "" : String.join(", ", passport.getVaccinations()));
    });
}

    private void loadPassportTable() {
        String[] columns = {"Passport ID","Patient ID","Blood Group","Height","Weight","Doctor","Doctor Contact"};
        java.util.List<HealthPassport> list = passportManager.getAllPassports();
        list.sort(java.util.Comparator.comparing(HealthPassport::getPassportId));
        Object[][] data = new Object[list.size()][7];
        for (int i = 0; i < list.size(); i++) {
            HealthPassport passport = list.get(i);
            data[i][0] = passport.getPassportId();
            data[i][1] = passport.getPatientId();
            data[i][2] = passport.getBloodGroup();
            data[i][3] = passport.getHeight();
            data[i][4] = passport.getWeight();
            data[i][5] = passport.getFamilyDoctor();
            data[i][6] = passport.getDoctorContact();
        }
        passportTable.setTableData(columns, data);
        totalPassportLabel.setText("Total Passports : " + list.size());
        statusLabel.setText("Status : " + list.size() + " passport(s) loaded.");
    }

    private void addPassport() {
        try {
            String passportId = passportIdField.getText().trim();
            String patientId = patientIdField.getText().trim();
            String patientName = patientNameField.getText().trim();
            int age = Integer.parseInt(ageField.getText().trim());
            String gender = genderField.getText().trim();
            String bloodGroup = bloodGroupField.getText().trim();
            double height = Double.parseDouble(heightField.getText().trim());
            double weight = Double.parseDouble(weightField.getText().trim());
            String emergencyContact = emergencyContactField.getText().trim();
            String doctor = doctorField.getText().trim();
            String doctorContact = doctorContactField.getText().trim();
            String hospital = hospitalField.getText().trim();
            if (passportId.isEmpty() || patientId.isEmpty()) { MessageDialog.showError(this,"Passport ID and Patient ID are required."); return; }
            HealthPassport passport = new HealthPassport(passportId,patientId,patientName,age,gender,bloodGroup,height,weight,emergencyContact,doctor,doctorContact,hospital);
            if (!allergiesField.getText().trim().isEmpty()) passport.addAllergy(allergiesField.getText().trim());
            if (!chronicDiseaseField.getText().trim().isEmpty()) passport.addChronicDisease(chronicDiseaseField.getText().trim());
            if (!currentMedicinesField.getText().trim().isEmpty()) passport.addCurrentMedicine(currentMedicinesField.getText().trim());
            if (!vaccinationField.getText().trim().isEmpty()) passport.addVaccination(vaccinationField.getText().trim());
            boolean added = passportManager.addPassport(passport);
            if (added) {
                MessageDialog.showSuccess(this,"Health Passport added successfully.");
                clearForm();
                loadPassportTable();
            } else { MessageDialog.showError(this,"Passport ID already exists."); }
        } catch (NumberFormatException ex) { MessageDialog.showError(this,"Age, Height and Weight must be numeric."); }
    }

private void updatePassport() {
    try {
        String passportId = passportIdField.getText().trim();
        String patientId = patientIdField.getText().trim();
        String patientName = patientNameField.getText().trim();
        int age = Integer.parseInt(ageField.getText().trim());
        String gender = genderField.getText().trim();
        String bloodGroup = bloodGroupField.getText().trim();
        double height = Double.parseDouble(heightField.getText().trim());
        double weight = Double.parseDouble(weightField.getText().trim());
        String emergencyContact = emergencyContactField.getText().trim();
        String doctor = doctorField.getText().trim();
        String doctorContact = doctorContactField.getText().trim();
        String hospital = hospitalField.getText().trim();
        if (passportId.isEmpty()) { MessageDialog.showError(this,"Select a passport first.");return;}
        HealthPassport passport = new HealthPassport(passportId,patientId,patientName,age,gender,bloodGroup,height,weight,emergencyContact,doctor,doctorContact,hospital);
        if (!allergiesField.getText().trim().isEmpty()) passport.addAllergy(allergiesField.getText().trim());
        if (!chronicDiseaseField.getText().trim().isEmpty()) passport.addChronicDisease(chronicDiseaseField.getText().trim());
        if (!currentMedicinesField.getText().trim().isEmpty()) passport.addCurrentMedicine(currentMedicinesField.getText().trim());
        if (!vaccinationField.getText().trim().isEmpty()) passport.addVaccination(vaccinationField.getText().trim());
        boolean updated = passportManager.updatePassport(passport);
        if (updated) {
            MessageDialog.showSuccess(this,"Health Passport updated successfully.");
            clearForm();
            loadPassportTable();
        } else {MessageDialog.showError(this,"Passport not found.");}
    } catch (NumberFormatException ex) {MessageDialog.showError(this,"Age, Height and Weight must be numeric.");}
}

    private void deletePassport() {
        String passportId = passportIdField.getText().trim();
        if (passportId.isEmpty()) {MessageDialog.showError(this,"Select a passport first."); return; }
        int choice = JOptionPane.showConfirmDialog(this,"Delete this passport?","Confirm Delete",JOptionPane.YES_NO_OPTION );
        if (choice != JOptionPane.YES_OPTION)return;
        boolean deleted = passportManager.deletePassport(passportId);
        if (deleted) {MessageDialog.showSuccess(this,"Passport deleted successfully."); clearForm(); loadPassportTable();} 
        else { MessageDialog.showError( this, "Passport not found."); }
    }

    private void viewPassportDetails() {
        String passportId = passportIdField.getText().trim();
        if (passportId.isEmpty()) { MessageDialog.showError(this,"Select a passport first."); return; }
        HealthPassport passport = passportManager.getPassport(passportId);
        if (passport == null) { MessageDialog.showError( this,"Passport not found."); return; }
        String details = """
        Passport ID : %s
        Patient ID : %s
        Patient Name : %s

        Age : %d
        Gender : %s

        Blood Group : %s

        Height : %.2f
        Weight : %.2f

        Allergies : %s
        Chronic Disease : %s
        Current Medicines : %s
        Vaccinations : %s

        Emergency Contact : %s

        Doctor : %s
        Doctor Contact : %s

        Hospital : %s
        """.formatted(passport.getPassportId(),passport.getPatientId(),passport.getPatientName(),passport.getAge(),passport.getGender(),passport.getBloodGroup(),passport.getHeight(),passport.getWeight(),String.join(", ", passport.getAllergies()),String.join(", ", passport.getChronicDiseases()),String.join(", ", passport.getCurrentMedicines()),String.join(", ", passport.getVaccinations()),passport.getEmergencyContact(),passport.getFamilyDoctor(),passport.getDoctorContact(),passport.getHospitalName());
            JOptionPane.showMessageDialog(this,details,"Health Passport Details", JOptionPane.INFORMATION_MESSAGE);
    }

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
        hospitalField.setText("");
        doctorField.setText("");
        doctorContactField.setText("");
        passportIdField.requestFocus();
        statusLabel.setText("Status : Form Cleared");
    }
}