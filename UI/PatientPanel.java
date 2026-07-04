package UI;
import UI.components.*;
import UI.theme.Theme;
import DSA.managers.PatientManager;
import DSA.models.Patient;
import DSA.util.Validation;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class PatientPanel extends JPanel {
    private JLabel titleLabel,subtitleLabel;

    private RoundedTextField patientIdField,patientNameField,diseaseField,ageField,phoneField,emailField,addressField,emergencyContactField,emergencyPhoneField;

    private JComboBox<String> genderComboBox;
    private JComboBox<String> bloodGroupComboBox;

    private RoundedButton addButton,updateButton,deleteButton,clearButton,refreshButton,detailsButton;

    private AppTable patientTable;
    private PatientManager patientManager;

    private JLabel statusLabel,totalPatientsLabel;

    public PatientPanel() {
        patientManager = new PatientManager();
        initializeComponents();
        layoutComponents();
        registerEvents();
        loadPatientTable();
    }

    private void initializeComponents() {
        titleLabel = new JLabel("Patient Management");
        titleLabel.setFont(Theme.TITLE_FONT);
        titleLabel.setForeground(Theme.TEXT_PRIMARY);
        subtitleLabel = new JLabel("Manage family patient records");
        subtitleLabel.setFont(Theme.SUBTITLE_FONT);
        subtitleLabel.setForeground(Theme.TEXT_SECONDARY);
        patientIdField = new RoundedTextField(20);
        patientNameField = new RoundedTextField(20);
        ageField = new RoundedTextField(20);
        genderComboBox = new JComboBox<>(
                new String[]{
                        "Male",
                        "Female",
                        "Other"
                }
        );
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
                }
        );
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

    private void layoutComponents() {
        setLayout(new BorderLayout(15,15));
        setBackground(Theme.BACKGROUND);
        setBorder(new EmptyBorder(20,20,20,20));
        add(createHeaderPanel(), BorderLayout.NORTH);
        JPanel centerPanel = new JPanel(new BorderLayout(15,15));
        centerPanel.setOpaque(false);
        // Form
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

    private JPanel createFormPanel() {
        RoundedPanel panel = new RoundedPanel();
        panel.setMaximumSize(new Dimension(Integer.MAX_VALUE,320));
        panel.setLayout(new GridBagLayout());
        panel.setBorder(new EmptyBorder(20, 20, 20, 20));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;
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

    private void registerEvents() {
        addButton.addActionListener(e -> addPatient());
        updateButton.addActionListener(e -> updatePatient());
        deleteButton.addActionListener(e -> deletePatient());
        clearButton.addActionListener(e -> clearForm());
        refreshButton.addActionListener(e -> loadPatientTable());
        detailsButton.addActionListener(e -> viewPatientDetails());
        patientTable.getSelectionModel().addListSelectionListener(e -> {
                if (e.getValueIsAdjusting()) { return; }
                int row = patientTable.getSelectedRow();
                if (row == -1) { return; }
                String patientId = patientTable.getValueAt(row, 0).toString();
                Patient patient = patientManager.getPatient(patientId);
                if (patient == null) { return; }
                patientIdField.setText(patient.getPatientId());
                patientNameField.setText(patient.getFullName());
                ageField.setText(String.valueOf(patient.getAge()));
                genderComboBox.setSelectedItem(patient.getGender());
                bloodGroupComboBox.setSelectedItem(patient.getBloodGroup());
                diseaseField.setText(patient.getCurrentDisease());
                phoneField.setText(patient.getPhoneNumber());
                emailField.setText(patient.getEmail());
                addressField.setText(patient.getAddress());
                emergencyContactField.setText(patient.getEmergencyContactName());
                emergencyPhoneField.setText(patient.getEmergencyContactPhone());
        });
    }

    private void addPatient() {
        String patientId = patientIdField.getText().trim();
        String fullName = patientNameField.getText().trim();
        String ageText = ageField.getText().trim();
        String gender = genderComboBox.getSelectedItem().toString();
        String bloodGroup = bloodGroupComboBox.getSelectedItem().toString();
        String disease = diseaseField.getText().trim();
        String phone = phoneField.getText().trim();
        String email = emailField.getText().trim();
        String address = addressField.getText().trim();
        String emergencyContact = emergencyContactField.getText().trim();
        String emergencyPhone = emergencyPhoneField.getText().trim();
        //validate
        if (Validation.isEmpty(patientId) || Validation.isEmpty(fullName) || Validation.isEmpty(ageText) || Validation.isEmpty(phone)) {
            MessageDialog.showError(this,"Please fill all required fields.");
            return;
        }
        int age;
        try { age = Integer.parseInt(ageText);} 
        catch (NumberFormatException ex) {
            MessageDialog.showError(this,"Age must be numeric.");
            return;
        }
        if (!Validation.isValidAge(age)) {
            MessageDialog.showError(this,"Invalid age.");
            return;
        }
        if (!Validation.isValidPhone(phone)) {
            MessageDialog.showError(this,"Invalid phone number.");
            return;
        }
        if (!email.isEmpty() && !Validation.isValidEmail(email)) {
            MessageDialog.showError(this,"Invalid email address.");
            return;
        }

        Patient patient = new Patient(
                patientId,
                fullName,
                age,
                gender,
                bloodGroup,
                phone,
                email,
                address,
                emergencyContact,
                emergencyPhone,
                disease,
                ""
        );

        boolean added = patientManager.addPatient(patient);
        if (added) {
            MessageDialog.showSuccess(this,"Patient added successfully.");
            clearForm();
            loadPatientTable();
        } else {
            MessageDialog.showError(this,"Patient ID already exists.");
        }
    }

    private void updatePatient() {
        String patientId = patientIdField.getText().trim();
        if (Validation.isEmpty(patientId)) {
            MessageDialog.showError(this,"Enter Patient ID to update.");
            return;
        }
        Patient existingPatient = patientManager.getPatient(patientId);
        if (existingPatient == null) {
            MessageDialog.showError(this,"Patient not found.");
            return;
        }
        String fullName = patientNameField.getText().trim();
        String ageText = ageField.getText().trim();
        int age;
        try {age = Integer.parseInt(ageText); } 
        catch (NumberFormatException ex) {
            MessageDialog.showError(this,"Age must be numeric.");
            return;
        }
        existingPatient.setFullName(fullName);
        existingPatient.setAge(age);
        existingPatient.setGender(genderComboBox.getSelectedItem().toString());
        existingPatient.setBloodGroup(bloodGroupComboBox.getSelectedItem().toString());
        existingPatient.setCurrentDisease(diseaseField.getText().trim());
        existingPatient.setPhoneNumber(phoneField.getText().trim());
        existingPatient.setEmail(emailField.getText().trim());
        existingPatient.setAddress(addressField.getText().trim());
        existingPatient.setEmergencyContactName(emergencyContactField.getText().trim());
        existingPatient.setEmergencyContactPhone(emergencyPhoneField.getText().trim());
        if (patientManager.updatePatient(existingPatient)) {
            MessageDialog.showSuccess(this,"Patient updated successfully.");
            loadPatientTable();
            clearForm();
        } else {
            MessageDialog.showError(this,"Unable to update patient.");
        }
    }
    private void deletePatient() {
        String patientId = patientIdField.getText().trim();
        if (Validation.isEmpty(patientId)) {
            MessageDialog.showError(this,"Enter Patient ID to delete.");
            return;
        }
        boolean confirm = MessageDialog.showConfirm(this,"Are you sure you want to delete this patient?");
        if (!confirm) { return; }
        boolean deleted = patientManager.deletePatient(patientId);
        if (deleted) {
            MessageDialog.showSuccess(this, "Patient deleted successfully.");
            clearForm();
            loadPatientTable();
        } else {
            MessageDialog.showError(this,"Patient not found.");
        }
    }

    private void viewPatientDetails() {
        String patientId = patientIdField.getText().trim();
        if (Validation.isEmpty(patientId)) {
            MessageDialog.showError(this,"Enter Patient ID.");
            return;
        }
        Patient patient = patientManager.getPatient(patientId);
        if (patient == null) {
            MessageDialog.showError(this,"Patient not found.");
            return;
        }
        String details =
                "Patient ID : " + patient.getPatientId() +
                "\nName : " + patient.getFullName() +
                "\nAge : " + patient.getAge() +
                "\nGender : " + patient.getGender() +
                "\nBlood Group : " + patient.getBloodGroup() +
                "\nDisease : " + patient.getCurrentDisease() +
                "\nPhone : " + patient.getPhoneNumber() +
                "\nEmail : " + patient.getEmail() +
                "\nAddress : " + patient.getAddress() +
                "\nEmergency Contact : " + patient.getEmergencyContactName() +
                "\nEmergency Phone : " + patient.getEmergencyContactPhone();
        MessageDialog.showInfo(this, details);
    }

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

    private void loadPatientTable() {
        String[] columns = {
                "Patient ID",
                "Name",
                "Age",
                "Gender",
                "Blood Group",
                "Disease",
                "Phone"
        };
        java.util.List<Patient> patients = patientManager.getAllPatients();
        Object[][] data = new Object[patients.size()][7];
        for (int i = 0; i < patients.size(); i++) {
            Patient patient = patients.get(i);
            data[i][0] = patient.getPatientId();
            data[i][1] = patient.getFullName();
            data[i][2] = patient.getAge();
            data[i][3] = patient.getGender();
            data[i][4] = patient.getBloodGroup();
            data[i][5] = patient.getCurrentDisease();
            data[i][6] = patient.getPhoneNumber();
        }
        patientTable.setTableData(columns, data);
        totalPatientsLabel.setText("Total Patients : " + patients.size());
        statusLabel.setText("Status : " + patients.size() + " patient(s) loaded");
    }

    public void updatePatientCount(int count) { totalPatientsLabel.setText("Total Patients : " + count); }
}