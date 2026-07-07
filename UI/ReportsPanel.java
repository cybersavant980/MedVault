package UI;
import DSA.managers.EmergencyManager;
import DSA.managers.MedicineManager;
import DSA.managers.PatientManager;
import UI.components.RoundedButton;
import UI.components.RoundedTextField;
import UI.components.RoundedPanel;
import UI.theme.Theme;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReportsPanel extends JPanel {
    private PatientManager patientManager;
    private MedicineManager medicineManager;
    private EmergencyManager emergencyManager;
    private JTextArea reportArea;
    private RoundedButton patientReportButton,medicineReportButton,emergencyReportButton,clearButton;
    private RoundedTextField patientIdField,filePathField;
    private RoundedButton browseButton,uploadButton,showReportsButton;
    private JTable reportsTable;
    private DefaultTableModel reportsTableModel;
    private File selectedPdf;
    private java.util.List<File> reportFiles = new java.util.ArrayList<>();
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
        reportArea.setLineWrap(true);
        reportArea.setWrapStyleWord(true);
        reportArea.setMargin(new Insets(10,10,10,10));
        patientReportButton=new RoundedButton("Patient Report");
        medicineReportButton=new RoundedButton("Medicine Report");
        emergencyReportButton=new RoundedButton("Emergency Report");
        clearButton=new RoundedButton("Clear");
        patientIdField = new RoundedTextField(15);
        filePathField = new RoundedTextField(40);
        filePathField.setEditable(false);
        browseButton = new RoundedButton("Browse");
        uploadButton = new RoundedButton("Upload");
        showReportsButton = new RoundedButton("Show Reports");
        reportsTableModel = new DefaultTableModel(
            new Object[]{"Sr. No.","Upload Date","Report Type","View","Delete"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 3 || column == 4;
            }
        };
        reportsTable = new JTable(reportsTableModel);
        reportsTable.setRowHeight(35);
        reportsTable.getTableHeader().setFont(Theme.SUBTITLE_FONT);
        reportsTable.setFont(Theme.BODY_FONT);
        reportsTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        reportsTable.setRowSelectionAllowed(false);
        reportsTable.setColumnSelectionAllowed(false);
        reportsTable.setCellSelectionEnabled(false);
        reportsTable.setFocusable(false);
        reportsTable.setRowHeight(40);
        reportsTable.getTableHeader().setReorderingAllowed(false);
        reportsTable.getTableHeader().setResizingAllowed(false);
        reportsTable.getTableHeader().setPreferredSize(new Dimension(0,40));
        DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
        headerRenderer.setBackground(Theme.PRIMARY);
        headerRenderer.setForeground(Color.WHITE);
        headerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        headerRenderer.setFont(Theme.SUBTITLE_FONT);
        for (int i = 0; i < reportsTable.getColumnCount(); i++) {
            reportsTable.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
        }
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        reportsTable.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        reportsTable.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        reportsTable.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        reportsTable.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        reportsTable.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
        reportsTable.getTableHeader().setFont(Theme.SUBTITLE_FONT);
        reportsTable.setShowGrid(false);
        reportsTable.setBorder(BorderFactory.createEmptyBorder());

        reportsTable.getColumnModel().getColumn(0).setPreferredWidth(60);
        reportsTable.getColumnModel().getColumn(1).setPreferredWidth(150);
        reportsTable.getColumnModel().getColumn(2).setPreferredWidth(450);
        reportsTable.getColumnModel().getColumn(3).setPreferredWidth(80);
        reportsTable.getColumnModel().getColumn(4).setPreferredWidth(80);
    }

    private void layoutComponents() {
        setLayout(new BorderLayout(15,15));
        setBackground(Theme.BACKGROUND);

        RoundedPanel topPanel = new RoundedPanel();
        topPanel.add(patientReportButton);
        topPanel.add(medicineReportButton);
        topPanel.add(emergencyReportButton);
        topPanel.add(clearButton);

        add(topPanel, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel(new BorderLayout(15,15));
        centerPanel.setOpaque(false);

        JScrollPane reportScroll = new JScrollPane(reportArea);
        reportScroll.setPreferredSize(new Dimension(900,180));
        centerPanel.add(reportScroll, BorderLayout.NORTH);
        RoundedPanel uploadPanel = new RoundedPanel();
        uploadPanel.setLayout(new GridBagLayout());
        uploadPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(210,210,210)),"Medical Report Management",0,0,Theme.SUBTITLE_FONT,Theme.PRIMARY));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8,8,8,8);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;// Patient ID
        gbc.gridx = 0;
        gbc.gridy = 0;
        uploadPanel.add(new JLabel("Patient ID"), gbc);
        gbc.gridx = 1;
        uploadPanel.add(patientIdField, gbc);// Browse
        gbc.gridx = 0;
        gbc.gridy = 1;
        uploadPanel.add(new JLabel("Choose PDF"), gbc);
        gbc.gridx = 1;
        uploadPanel.add(filePathField, gbc);
        gbc.gridx = 2;
        gbc.weightx = 0;
        uploadPanel.add(browseButton, gbc);// Naming Format
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 3;
        JLabel formatLabel = new JLabel("<html>"+"<b>File Naming Format</b><br>"+"PatientID_ReportType_YYYY-MM-DD.pdf"+"<br><br>"+"<b>Example</b><br>"+"101_BloodTest_2026-07-07.pdf"+"<br><br>"+"<font color='gray'>"+"Use this format to keep reports organized and unique."+"</font>"+"</html>");
        formatLabel.setFont(Theme.BODY_FONT);
        uploadPanel.add(formatLabel, gbc);// Buttons
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER,15,5));
        buttonPanel.setOpaque(false);
        buttonPanel.add(uploadButton);
        buttonPanel.add(showReportsButton);
        gbc.gridy = 3;
        uploadPanel.add(buttonPanel, gbc);
        JScrollPane tableScroll = new JScrollPane(reportsTable); // Table
        tableScroll.getViewport().setBackground(Color.WHITE);
        tableScroll.setBorder(BorderFactory.createEmptyBorder());
        tableScroll.setPreferredSize(new Dimension(900,160));
        gbc.gridy = 4;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;
        uploadPanel.add(tableScroll, gbc);
        gbc.weighty = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        JScrollPane uploadScroll = new JScrollPane(uploadPanel);
        uploadScroll.setBorder(null);
        centerPanel.add(uploadScroll, BorderLayout.CENTER);
        add(centerPanel, BorderLayout.CENTER);
    }

    private void registerEvents() {
        patientReportButton.addActionListener(e -> generatePatientReport());
        medicineReportButton.addActionListener(e -> generateMedicineReport());
        emergencyReportButton.addActionListener(e -> generateEmergencyReport());
        clearButton.addActionListener(e -> { reportArea.setText("");patientIdField.setText("");filePathField.setText("");selectedPdf = null;reportsTableModel.setRowCount(0);});
        browseButton.addActionListener(e -> browsePdf());
        uploadButton.addActionListener(e -> uploadReport());
        showReportsButton.addActionListener(e -> loadPatientReports());
        reportsTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = reportsTable.rowAtPoint(e.getPoint());
                int column = reportsTable.columnAtPoint(e.getPoint());
                if (row == -1) return;
                reportsTable.clearSelection();
                File file = reportFiles.get(row);
                if (!file.exists()) {JOptionPane.showMessageDialog(ReportsPanel.this,"Medical Report not found.");
                    loadPatientReports();
                    return;
                }
                // View
                if (column == 3) {
                    try { Desktop.getDesktop().open(file);} 
                    catch (IOException ex) {JOptionPane.showMessageDialog(ReportsPanel.this,"Unable to open PDF.");}
                }
                // Delete
                else if (column == 4) {
                    int option = JOptionPane.showConfirmDialog(ReportsPanel.this,"Delete this report?","Confirm Delete",JOptionPane.YES_NO_OPTION);
                    if (option == JOptionPane.YES_OPTION) {
                        if (file.delete()) {JOptionPane.showMessageDialog(ReportsPanel.this,"Report deleted successfully.");
                            loadPatientReports();
                        } else {
                            JOptionPane.showMessageDialog(ReportsPanel.this,"Unable to delete report.");
                        }
                    }
                }
            }
        });
    }

    private void browsePdf() {
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Select Medical Report");
        chooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("PDF Files","pdf"));
        int result = chooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            selectedPdf = chooser.getSelectedFile();
            filePathField.setText(selectedPdf.getAbsolutePath());
        }
    }
    private void uploadReport() {
        String patientId = patientIdField.getText().trim();
        if (patientId.isEmpty()) {JOptionPane.showMessageDialog(this,"Please enter Patient ID."); return;}
        if (selectedPdf == null) {JOptionPane.showMessageDialog(this,"Please select a PDF file");return;}
        try {
            File patientFolder = new File("data/patient_reports/" + patientId);
            if (!patientFolder.exists()) patientFolder.mkdirs();
            File destination = new File(patientFolder,selectedPdf.getName());
            if (!selectedPdf.getName().toLowerCase().endsWith(".pdf")) {JOptionPane.showMessageDialog(this,"Only PDF files are allowed."); return;}
            Files.copy(selectedPdf.toPath(),destination.toPath(),StandardCopyOption.REPLACE_EXISTING);
            JOptionPane.showMessageDialog(this,"Medical Report uploaded successfully.");
            filePathField.setText("");
            selectedPdf = null;
            loadPatientReports();
        } catch (IOException ex) {JOptionPane.showMessageDialog(this,"Error uploading report.");}
    }

    private void loadPatientReports() {
        reportsTableModel.setRowCount(0);
        reportFiles.clear();
        String patientId = patientIdField.getText().trim();
        if (patientId.isEmpty()) {JOptionPane.showMessageDialog(this,"Please enter Patient ID.");return;}
        File patientFolder = new File("data/patient_reports/" + patientId);
        if (!patientFolder.exists()) {JOptionPane.showMessageDialog(this,"No reports found for Patient ID " + patientId); return;}
        File[] pdfFiles = patientFolder.listFiles((dir, name) -> name.toLowerCase().endsWith(".pdf"));
        if (pdfFiles == null || pdfFiles.length == 0) {JOptionPane.showMessageDialog(this,"No reports available."); return;}
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        int sr = 1;
        for (File file : pdfFiles) {
            Date uploadDate = new Date(file.lastModified());
            String fileName = file.getName();
            String reportType = fileName;
            if (fileName.endsWith(".pdf")) reportType = fileName.substring(0,fileName.length() - 4);
            String[] parts = reportType.split("_");
            if (parts.length >= 2) reportType = parts[1];
            reportType = reportType.replaceAll("(?<=[a-z])(?=[A-Z])"," ");
            reportsTableModel.addRow(new Object[]{sr++, sdf.format(uploadDate), reportType,"View","Delete"});
            reportFiles.add(file);
        }
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