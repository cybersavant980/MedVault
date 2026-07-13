package UI;
import javax.swing.*;
import java.awt.*;
import DSA.managers.EmergencyManager;
import DSA.models.Emergency;
import UI.components.*;
import UI.theme.Theme;
public class EmergencyPanel extends JPanel {
    private EmergencyManager emergencyManager;
    private JLabel titleLabel,subtitleLabel;
    private RoundedTextField patientIdField,patientNameField,bloodGroupField,allergiesField,diseasesField,emergencyContactField,doctorNameField,doctorPhoneField,medicinesField;
    private RoundedButton addButton,updateButton,deleteButton,clearButton,refreshButton,detailsButton;
    private AppTable emergencyTable;
    private JLabel statusLabel,totalEmergencyLabel;
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

    private void layoutComponents() {
        setLayout(new BorderLayout(15,15));
        setBackground(Theme.BACKGROUND);
        add(createHeaderPanel(), BorderLayout.NORTH);
        JPanel centerPanel = new JPanel(new BorderLayout(15,15));
        centerPanel.setOpaque(false);
        JScrollPane formScroll = new JScrollPane(createFormPanel());
        formScroll.setBorder(BorderFactory.createEmptyBorder());
        formScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        formScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        centerPanel.add(formScroll, BorderLayout.NORTH);
        JPanel bottomPanel = new JPanel(new BorderLayout(15,15));
        bottomPanel.setOpaque(false);
        bottomPanel.add(createButtonPanel(), BorderLayout.NORTH);
        bottomPanel.add(createTablePanel(), BorderLayout.CENTER);
        centerPanel.add(bottomPanel, BorderLayout.CENTER);
        add(centerPanel, BorderLayout.CENTER);
        add(createStatusPanel(), BorderLayout.SOUTH);
    }

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

    private JPanel createFormPanel() {
        RoundedPanel panel = new RoundedPanel();
        panel.setPreferredSize(new Dimension(1000, 420));
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;
        // Row 1 - Labels
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("Patient ID"), gbc);
        gbc.gridx = 1;
        panel.add(new JLabel("Patient Name"), gbc);
        gbc.gridx = 2;
        panel.add(new JLabel("Blood Group"), gbc);
        // Row 2 - Fields
        gbc.gridy++;
        gbc.gridx = 0;
        panel.add(patientIdField, gbc);
        gbc.gridx = 1;
        panel.add(patientNameField, gbc);
        gbc.gridx = 2;
        panel.add(bloodGroupField, gbc);
        // Row 3 - Labels
        gbc.gridy++;
        gbc.gridx = 0;
        panel.add(new JLabel("Allergies"), gbc);
        gbc.gridx = 1;
        panel.add(new JLabel("Diseases"), gbc);
        gbc.gridx = 2;
        panel.add(new JLabel("Current Medicines"), gbc);
        // Row 4 - Fields
        gbc.gridy++;
        gbc.gridx = 0;
        panel.add(allergiesField, gbc);
        gbc.gridx = 1;
        panel.add(diseasesField, gbc);
        gbc.gridx = 2;
        panel.add(medicinesField, gbc);
        // Row 5 - Labels
        gbc.gridy++;
        gbc.gridx = 0;
        panel.add(new JLabel("Emergency Contact"), gbc);
        gbc.gridx = 1;
        panel.add(new JLabel("Doctor Name"), gbc);
        gbc.gridx = 2;
        panel.add(new JLabel("Doctor Contact"), gbc);
        // Row 6 - Fields
        gbc.gridy++;
        gbc.gridx = 0;
        panel.add(emergencyContactField, gbc);
        gbc.gridx = 1;
        panel.add(doctorNameField, gbc);
        gbc.gridx = 2;
        panel.add(doctorPhoneField, gbc);
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
        JLabel title = new JLabel("Emergency Records");
        title.setFont(Theme.HEADER_FONT);
        panel.add(title, BorderLayout.NORTH);
        String[] columns = {"Patient ID","Blood Group","Emergency Contact","Doctor","Doctor Contact"};;
        emergencyTable.setTableData(columns,new Object[][]{});
        JScrollPane scrollPane = new JScrollPane(emergencyTable);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        panel.add(scrollPane,BorderLayout.CENTER);
        return panel;
    }

    private JPanel createStatusPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setOpaque(false);
        panel.add(statusLabel,BorderLayout.WEST);
        panel.add(totalEmergencyLabel,BorderLayout.EAST);
        return panel;
    }

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
            String patientId = emergencyTable.getValueAt(row,0).toString();
            Emergency emergency = emergencyManager.getEmergency(patientId);
            if (emergency == null) return;
            patientIdField.setText(emergency.getPatientId());
            patientNameField.setText(emergency.getPatientName());
            bloodGroupField.setText(emergency.getBloodGroup());
            allergiesField.setText(emergency.getAllergies());
            diseasesField.setText(emergency.getChronicDisease());
            emergencyContactField.setText(emergency.getEmergencyContact());
            doctorNameField.setText(emergency.getFamilyDoctor());
            doctorPhoneField.setText(emergency.getDoctorContact());
            medicinesField.setText(emergency.getCurrentMedicines());
        });
    }

    private void loadEmergencyTable() {
        String[] columns = {"Patient ID","Blood Group","Emergency Contact","Doctor","Doctor Contact"};
        java.util.List<Emergency> list = emergencyManager.getAllEmergencyRecords();
        list.sort(java.util.Comparator.comparing(Emergency::getPatientId));
        Object[][] data = new Object[list.size()][5];
        for (int i = 0; i < list.size(); i++) {
            Emergency e = list.get(i);
            data[i][0] = e.getPatientId();
            data[i][1] = e.getBloodGroup();
            data[i][2] = e.getEmergencyContact();
            data[i][3] = e.getFamilyDoctor();
            data[i][4] = e.getDoctorContact();
        }
        emergencyTable.setTableData(columns, data);
        totalEmergencyLabel.setText("Emergency Records : " + list.size());
        statusLabel.setText("Status : " + list.size() + " record(s) loaded.");
    }
    
    private void addEmergency() {
        String patientId = patientIdField.getText().trim();
        String patientName = patientNameField.getText().trim();
        String bloodGroup = bloodGroupField.getText().trim();
        String allergies = allergiesField.getText().trim();
        String diseases = diseasesField.getText().trim();
        String emergencyContact = emergencyContactField.getText().trim();
        String doctorName = doctorNameField.getText().trim();
        String doctorPhone = doctorPhoneField.getText().trim();
        String medicines = medicinesField.getText().trim();
        if (patientId.isEmpty() || bloodGroup.isEmpty() || emergencyContact.isEmpty()) {
             MessageDialog.showError(this,"Please fill all required fields."); return;
        }
        Emergency emergency = new Emergency(patientId,patientName,bloodGroup,allergies,diseases,medicines,emergencyContact,doctorName,doctorPhone);
        boolean added = emergencyManager.addEmergency(emergency);
        if (added) {MessageDialog.showSuccess(this,"Emergency record added successfully."); clearForm(); loadEmergencyTable();
        } else { MessageDialog.showError(this,"Patient ID already exists."); }
     }

    private void updateEmergency() {
        String patientId = patientIdField.getText().trim();
        String patientName = patientNameField.getText().trim();
        String bloodGroup = bloodGroupField.getText().trim();
        String allergies = allergiesField.getText().trim();
        String diseases = diseasesField.getText().trim();
        String emergencyContact = emergencyContactField.getText().trim();
        String doctorName = doctorNameField.getText().trim();
        String doctorPhone = doctorPhoneField.getText().trim();
        String medicines = medicinesField.getText().trim();
        if (patientId.isEmpty() || bloodGroup.isEmpty() ||emergencyContact.isEmpty())  {MessageDialog.showError(this,"Select an emergency record first."); return; }
        Emergency emergency = new Emergency(patientId,patientName,bloodGroup,allergies,diseases,medicines,emergencyContact,doctorName,doctorPhone);
        boolean updated = emergencyManager.updateEmergency(emergency);
        if (updated) { MessageDialog.showSuccess(this,"Emergency record updated successfully."); clearForm(); loadEmergencyTable();} 
        else { MessageDialog.showError(this,"Emergency record not found."); }
    }

    private void deleteEmergency() {
        String patientId = patientIdField.getText().trim();
        if (patientId.isEmpty()) {MessageDialog.showError(this,"Select an emergency record first."); return; }
        int choice = JOptionPane.showConfirmDialog(this,"Delete this emergency record?","Confirm Delete",JOptionPane.YES_NO_OPTION );
        if (choice != JOptionPane.YES_OPTION) return;
        boolean deleted = emergencyManager.deleteEmergency(patientId);
        if (deleted) { MessageDialog.showSuccess(this,"Emergency record deleted successfully."); clearForm(); loadEmergencyTable();} 
        else { MessageDialog.showError( this, "Emergency record not found."); }
    }

    private void viewEmergencyDetails() {
        String patientId = patientIdField.getText().trim();
        if (patientId.isEmpty()) {MessageDialog.showError(this,"Select an emergency record first."); return; }
        Emergency emergency = emergencyManager.getEmergency(patientId);
        if (emergency == null) {MessageDialog.showError(this, "Emergency record not found."); return; }
        String details = """
                        Patient ID : %s
                        Patient Name : %s
                        Blood Group : %s
                        Allergies : %s
                        Chronic Disease : %s
                        Current Medicines : %s
                        Emergency Contact : %s
                        Doctor : %s
                        Doctor Contact : %s
                        """.formatted(emergency.getPatientId(),emergency.getPatientName(),emergency.getBloodGroup(),emergency.getAllergies(),emergency.getChronicDisease(),emergency.getCurrentMedicines(),emergency.getEmergencyContact(),emergency.getFamilyDoctor(),emergency.getDoctorContact()
                        );
                JOptionPane.showMessageDialog(this, details, "Emergency Details", JOptionPane.INFORMATION_MESSAGE);
    }

    private void clearForm() {
        patientIdField.setText("");
        patientNameField.setText("");
        bloodGroupField.setText("");
        allergiesField.setText("");
        diseasesField.setText("");
        medicinesField.setText("");
        emergencyContactField.setText("");
        doctorNameField.setText("");
        doctorPhoneField.setText("");
        patientIdField.requestFocus();
        statusLabel.setText("Status : Form Cleared");
    }
}