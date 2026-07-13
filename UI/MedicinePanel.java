package UI;
import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import DSA.managers.MedicineManager;
import DSA.managers.ReminderScheduler;
import DSA.managers.MedicineConflictDetector;
import DSA.models.Medicine;
import UI.components.*;
import UI.theme.Theme;

public class MedicinePanel extends JPanel {
    private MedicineManager medicineManager;
    private JLabel titleLabel,subtitleLabel;
    private RoundedTextField medicineIdField,medicineNameField,genericNameField,manufacturerField,dosageField,frequencyField,intakeTimeField,stockField,      minimumStockField,prescribedForField,prescribedByField,expiryDateField;
    private RoundedButton addButton,updateButton,deleteButton,clearButton,refreshButton,detailsButton;
    private AppTable medicineTable;
    private JLabel statusLabel,totalMedicineLabel;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public MedicinePanel() {
        medicineManager = new MedicineManager();
        initializeComponents();
        layoutComponents();
        registerEvents();
        loadMedicineTable();
    }

    private void initializeComponents() {
        titleLabel = new JLabel("Medicine Management");
        titleLabel.setFont(Theme.TITLE_FONT);
        titleLabel.setForeground(Theme.TEXT_PRIMARY);
        subtitleLabel = new JLabel("Manage medicines and prescriptions");
        subtitleLabel.setFont(Theme.SUBTITLE_FONT);
        subtitleLabel.setForeground(Theme.TEXT_SECONDARY);
        medicineIdField = new RoundedTextField(20);
        medicineNameField = new RoundedTextField(20);
        genericNameField = new RoundedTextField(20);
        manufacturerField = new RoundedTextField(20);
        dosageField = new RoundedTextField(20);
        frequencyField = new RoundedTextField(20);
        intakeTimeField = new RoundedTextField(20);
        stockField = new RoundedTextField(20);
        minimumStockField = new RoundedTextField(20);
        prescribedForField = new RoundedTextField(20);
        prescribedByField = new RoundedTextField(20);
        expiryDateField = new RoundedTextField(20);
        addButton = new RoundedButton("Add");
        updateButton = new RoundedButton("Update");
        deleteButton = new RoundedButton("Delete");
        clearButton = new RoundedButton("Clear");
        refreshButton = new RoundedButton("Refresh");
        detailsButton = new RoundedButton("View Details");
        medicineTable = new AppTable();
        statusLabel = new JLabel("Status : Ready");
        statusLabel.setFont(Theme.BODY_FONT);
        totalMedicineLabel = new JLabel("Total Medicines : 0");
        totalMedicineLabel.setFont(Theme.BODY_FONT);
    }

    private void layoutComponents() {
        setLayout(new BorderLayout(15,15));
        setBackground(Theme.BACKGROUND);
        add(createHeaderPanel(), BorderLayout.NORTH);
        JPanel centerPanel = new JPanel(new BorderLayout(15,15));
        centerPanel.setOpaque(false);
        centerPanel.add(createFormPanel(), BorderLayout.NORTH);
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
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("Medicine ID"), gbc);
        gbc.gridx = 1;
        panel.add(new JLabel("Medicine Name"), gbc);
        gbc.gridx = 2;
        panel.add(new JLabel("Generic Name"), gbc);
        gbc.gridx = 3;
        panel.add(new JLabel("Manufacturer"), gbc);
        gbc.gridy++;
        gbc.gridx = 0;
        panel.add(medicineIdField, gbc);
        gbc.gridx = 1;
        panel.add(medicineNameField, gbc);
        gbc.gridx = 2;
        panel.add(genericNameField, gbc);
        gbc.gridx = 3;
        panel.add(manufacturerField, gbc);
        gbc.gridy++;
        gbc.gridx = 0;
        panel.add(new JLabel("Dosage"), gbc);
        gbc.gridx = 1;
        panel.add(new JLabel("Frequency"), gbc);
        gbc.gridx = 2;
        panel.add(new JLabel("Intake Time"), gbc);
        gbc.gridx = 3;
        panel.add(new JLabel("Expiry Date"), gbc);
        gbc.gridy++;
        gbc.gridx = 0;
        panel.add(dosageField, gbc);
        gbc.gridx = 1;
        panel.add(frequencyField, gbc);
        gbc.gridx = 2;
        panel.add(intakeTimeField, gbc);
        gbc.gridx = 3;
        panel.add(expiryDateField, gbc);
        gbc.gridy++;
        gbc.gridx = 0;
        panel.add(new JLabel("Stock Quantity"), gbc);
        gbc.gridx = 1;
        panel.add(new JLabel("Minimum Stock"), gbc);
        gbc.gridx = 2;
        panel.add(new JLabel("Prescribed For"), gbc);
        gbc.gridx = 3;
        panel.add(new JLabel("Prescribed By"), gbc);
        gbc.gridy++;
        gbc.gridx = 0;
        panel.add(stockField, gbc);
        gbc.gridx = 1;
        panel.add(minimumStockField, gbc);
        gbc.gridx = 2;
        panel.add(prescribedForField, gbc);
        gbc.gridx = 3;
        panel.add(prescribedByField, gbc);
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
        panel.setLayout(new BorderLayout());
        JLabel title = new JLabel("Medicine Records");
        title.setFont(Theme.HEADER_FONT);
        panel.add(title, BorderLayout.NORTH);
        String[] columns = {"Medicine ID","Medicine Name","Dosage","Frequency","Expiry","Stock"};
        medicineTable.setTableData(columns, new Object[][] {});
        JScrollPane scrollPane = new JScrollPane(medicineTable);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        panel.add(scrollPane, BorderLayout.CENTER);
        return panel;
    }

    private JPanel createStatusPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setOpaque(false);
        statusLabel.setForeground(Theme.TEXT_SECONDARY);
        totalMedicineLabel.setForeground(Theme.TEXT_SECONDARY);
        panel.add(statusLabel, BorderLayout.WEST);
        panel.add(totalMedicineLabel, BorderLayout.EAST);
        return panel;
    }

    private void registerEvents() {
        addButton.addActionListener(e -> addMedicine());
        updateButton.addActionListener(e -> updateMedicine());
        deleteButton.addActionListener(e -> deleteMedicine());
        clearButton.addActionListener(e -> clearForm());
        refreshButton.addActionListener(e -> loadMedicineTable());
        detailsButton.addActionListener(e -> viewMedicineDetails());
        medicineTable.getSelectionModel().addListSelectionListener(e -> {
                if (e.getValueIsAdjusting()) return;
                int row = medicineTable.getSelectedRow();
                if (row == -1) return;
                String medicineId = medicineTable.getValueAt(row, 0).toString();
                Medicine medicine = medicineManager.getMedicine(medicineId);
                if (medicine == null) return;
                medicineIdField.setText(medicine.getMedicineId());
                medicineNameField.setText(medicine.getMedicineName());
                genericNameField.setText(medicine.getGenericName());
                manufacturerField.setText(medicine.getManufacturer());
                dosageField.setText(medicine.getDosage());
                frequencyField.setText(medicine.getFrequency());
                intakeTimeField.setText(String.valueOf(medicine.getIntakeTime()));
                stockField.setText(String.valueOf(medicine.getStockQuantity()));
                minimumStockField.setText(String.valueOf(medicine.getMinimumStock()));
                prescribedForField.setText(medicine.getPrescribedFor());
                prescribedByField.setText(medicine.getPrescribedBy());
                expiryDateField.setText(medicine.getExpiryDate().format(formatter));
        });
    }

    private void loadMedicineTable() {
        String[] columns = {"Medicine ID","Medicine Name","Dosage","Frequency","Expiry","Stock"};
        java.util.List<Medicine> medicines = medicineManager.getAllMedicines();
        medicines.sort(java.util.Comparator.comparing(Medicine::getMedicineId));
        Object[][] data = new Object[medicines.size()][6];
        for (int i = 0; i < medicines.size(); i++) {
            Medicine medicine = medicines.get(i);
            data[i][0] = medicine.getMedicineId();
            data[i][1] = medicine.getMedicineName();
            data[i][2] = medicine.getDosage();
            data[i][3] = medicine.getFrequency();
            data[i][4] = medicine.getExpiryDate();
            data[i][5] = medicine.getStockQuantity();
        }
        medicineTable.setTableData(columns, data);
        totalMedicineLabel.setText("Total Medicines : " + medicines.size());
        statusLabel.setText("Status : " + medicines.size() + " medicine(s) loaded");
    }

    private void addMedicine() {
        try {
            String medicineId = medicineIdField.getText().trim();
            String medicineName = medicineNameField.getText().trim();
            String genericName = genericNameField.getText().trim();
            String manufacturer = manufacturerField.getText().trim();
            String dosage = dosageField.getText().trim();
            String frequency = frequencyField.getText().trim();
            String intakeTime = intakeTimeField.getText().trim();
            int stock = Integer.parseInt(stockField.getText().trim());
            int minimumStock = Integer.parseInt(minimumStockField.getText().trim());
            String prescribedFor = prescribedForField.getText().trim();
            String prescribedBy = prescribedByField.getText().trim();
            LocalDate expiryDate = LocalDate.parse(expiryDateField.getText().trim(),formatter);
            Medicine medicine = new Medicine(medicineId,medicineName,genericName,manufacturer,dosage,frequency,intakeTime,stock,minimumStock,prescribedFor,prescribedBy,expiryDate);
            MedicineConflictDetector detector = new MedicineConflictDetector();
            for (Medicine existing : medicineManager.getAllMedicines()) {
                if (detector.hasConflict(medicine.getMedicineName(),existing.getMedicineName())) {
                    int choice = JOptionPane.showConfirmDialog(
                                    this,
                                    "⚠ Medicine Conflict Detected!\n\n"
                                    + "New Medicine : "
                                    + medicine.getMedicineName()
                                    + "\nExisting Medicine : "
                                    + existing.getMedicineName()
                                    + "\n\nThese Medicines may interact with each other."
                                    + "\n\nDo you want to save this medicine anyway?",
                                    "Medicine Conflict",
                                    JOptionPane.YES_NO_OPTION,
                                    JOptionPane.WARNING_MESSAGE);
                    if (choice != JOptionPane.YES_OPTION) {
                        return;
                    }
                    break;
                }
            }

            if (medicineManager.addMedicine(medicine)) {
                MessageDialog.showSuccess(this,"Medicine added successfully.");
                ReminderDialog dialog = new ReminderDialog(medicine);
                dialog.setVisible(true);
                loadMedicineTable();
                clearForm();
            } else {
                MessageDialog.showError(this,"Medicine ID already exists.");
            }
        } catch (Exception ex) {
            MessageDialog.showError(this,"Invalid medicine information.");
        }
    }

    private void updateMedicine() {
        try {
            String medicineId = medicineIdField.getText().trim();
            Medicine medicine = medicineManager.getMedicine(medicineId);
            if (medicine == null) {
                MessageDialog.showError(this,"Medicine not found.");
                return;
            }
            medicine.setMedicineName(medicineNameField.getText().trim());
            medicine.setGenericName(genericNameField.getText().trim());
            medicine.setManufacturer(manufacturerField.getText().trim());
            medicine.setDosage(dosageField.getText().trim());
            medicine.setFrequency(frequencyField.getText().trim());
            medicine.setIntakeTime(intakeTimeField.getText().trim());
            medicine.setStockQuantity(Integer.parseInt(stockField.getText().trim()));
            medicine.setMinimumStock(Integer.parseInt(minimumStockField.getText().trim()));
            medicine.setPrescribedFor(prescribedForField.getText().trim());
            medicine.setPrescribedBy(prescribedByField.getText().trim());
            medicine.setExpiryDate(java.time.LocalDate.parse(expiryDateField.getText().trim(),formatter));
            medicineManager.updateMedicine(medicine);
            MessageDialog.showSuccess(this,"Medicine updated successfully.");
            loadMedicineTable();
            clearForm();
        } catch (Exception ex) {
            ex.printStackTrace();
            MessageDialog.showError(this,"Unable to update medicine.");
        }
    }

    private void deleteMedicine() {
        String medicineId = medicineIdField.getText().trim();
        if (medicineManager.deleteMedicine(medicineId)) {
            ReminderScheduler reminderScheduler = new ReminderScheduler();
            reminderScheduler.deleteReminder("REM-" + medicineId);
            MessageDialog.showSuccess(this,"Medicine deleted successfully.");
            loadMedicineTable();
            clearForm();
        } else {
            MessageDialog.showError(this,"Medicine not found.");
        }
    }

    private void viewMedicineDetails() {
        String medicineId = medicineIdField.getText().trim();
        Medicine medicine = medicineManager.getMedicine(medicineId);
        if (medicine == null) {
            MessageDialog.showError(this,"Medicine not found.");
            return;
        }
        String details =
                "Medicine ID : " + medicine.getMedicineId()
                + "\nMedicine : " + medicine.getMedicineName()
                + "\nGeneric : " + medicine.getGenericName()
                + "\nManufacturer : " + medicine.getManufacturer()
                + "\nDosage : " + medicine.getDosage()
                + "\nFrequency : " + medicine.getFrequency()
                + "\nIntake Time : " + medicine.getIntakeTime()
                + "\nStock : " + medicine.getStockQuantity()
                + "\nMinimum Stock : " + medicine.getMinimumStock()
                + "\nExpiry : " + medicine.getExpiryDate()
                + "\nPrescribed For : " + medicine.getPrescribedFor()
                + "\nPrescribed By : " + medicine.getPrescribedBy();
        MessageDialog.showInfo(this, details);
    }

    private void clearForm() {
        medicineIdField.setText("");
        medicineNameField.setText("");
        genericNameField.setText("");
        manufacturerField.setText("");
        dosageField.setText("");
        frequencyField.setText("");
        intakeTimeField.setText("");
        stockField.setText("");
        minimumStockField.setText("");
        prescribedForField.setText("");
        prescribedByField.setText("");
        expiryDateField.setText("");
        medicineTable.clearSelection();
        medicineIdField.requestFocus();
        statusLabel.setText("Status : Ready");
    }
}