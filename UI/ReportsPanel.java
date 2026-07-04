package UI;
import DSA.managers.EmergencyManager;
import DSA.managers.MedicineManager;
import DSA.managers.PatientManager;
import UI.components.RoundedButton;
import UI.components.RoundedPanel;
import UI.theme.Theme;
import javax.swing.*;
import java.awt.*;

public class ReportsPanel extends JPanel {
    private PatientManager patientManager;
    private MedicineManager medicineManager;
    private EmergencyManager emergencyManager;
    private JTextArea reportArea;
    private RoundedButton patientReportButton,medicineReportButton,emergencyReportButton,clearButton;

    public ReportsPanel() {
        patientManager = new PatientManager();
        medicineManager = new MedicineManager();
        emergencyManager = new EmergencyManager();
        initializeComponents();
        layoutComponents();
        registerEvents();
    }

    private void initializeComponents() {
        reportArea = new JTextArea();
        reportArea.setEditable(false);
        reportArea.setFont(Theme.BODY_FONT);
        patientReportButton=new RoundedButton("Patient Report");
        medicineReportButton=new RoundedButton("Medicine Report");
        emergencyReportButton=new RoundedButton("Emergency Report");
        clearButton=new RoundedButton("Clear");
    }

    private void layoutComponents() {
        setLayout(new BorderLayout(15,15));
        setBackground(Theme.BACKGROUND);
        RoundedPanel topPanel=new RoundedPanel();
        topPanel.add(patientReportButton);
        topPanel.add(medicineReportButton);
        topPanel.add(emergencyReportButton);
        topPanel.add(clearButton);
        JScrollPane scrollPane=new JScrollPane(reportArea);
        add(topPanel,BorderLayout.NORTH);
        add(scrollPane,BorderLayout.CENTER);
    }

    private void registerEvents() {
        patientReportButton.addActionListener(e -> generatePatientReport());
        medicineReportButton.addActionListener(e -> generateMedicineReport());
        emergencyReportButton.addActionListener(e -> generateEmergencyReport());
        clearButton.addActionListener(e -> reportArea.setText(""));
    }

    private void generatePatientReport() {
        patientManager.loadPatients();
        reportArea.setText(
                "========== PATIENT REPORT ==========\n\n"
                + "Total Patients : "
                + patientManager.getPatientCount()
                + "\n\nReport Generated Successfully."
        );
    }

    private void generateMedicineReport() {
        medicineManager.loadMedicines();
        reportArea.setText(
                "========== MEDICINE REPORT ==========\n\n"
                + "Total Medicines : "
                + medicineManager.getMedicineCount()
                + "\n\nReport Generated Successfully."
        );
    }

    private void generateEmergencyReport() {
        emergencyManager.loadEmergencyRecords();
        reportArea.setText(
                "========== EMERGENCY REPORT ==========\n\n"
                + "Emergency Records : "
                + emergencyManager.getEmergencyCount()
                + "\n\nReport Generated Successfully."
        );
    }
}