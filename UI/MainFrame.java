package UI;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import UI.theme.Theme;
public class MainFrame extends JFrame {
    private CardLayout cardLayout;
    private JPanel contentPanel;
    private JButton dashboardBtn,patientBtn,medicineBtn,emergencyBtn,passportBtn,reportBtn,twinBtn,settingsBtn;
    public MainFrame() {
        initializeComponents();
        layoutComponents();
        setFrameProperties();
    }

    private void initializeComponents() {
        cardLayout = new CardLayout();
        contentPanel = new JPanel(cardLayout);
        contentPanel.setBackground(Theme.BACKGROUND);
        contentPanel.add(new Dashboard(this), "Dashboard");
        contentPanel.add(new PatientPanel(), "Patients");
        contentPanel.add(new MedicinePanel(), "Medicines");
        contentPanel.add(new EmergencyPanel(), "Emergency");
        contentPanel.add(new HealthPassportPanel(), "Passport");
        contentPanel.add(new ReportsPanel(), "Reports");
        contentPanel.add(new DigitalTwinPanel(), "DigitalTwin");
        contentPanel.add(new SettingsPanel(), "Settings");
    }

    private void layoutComponents() {
        setLayout(new BorderLayout());
        add(createSidebar(), BorderLayout.WEST);
        add(contentPanel, BorderLayout.CENTER);
        registerNavigation();
        showPanel("Dashboard");
    }

    private JPanel createSidebar() {
        JPanel sidebar = new JPanel();
        sidebar.setBackground(Theme.SIDEBAR);
        sidebar.setPreferredSize(new Dimension(Theme.SIDEBAR_WIDTH,0));
        sidebar.setBorder(new EmptyBorder(25,20,25,20));
        sidebar.setLayout(new BoxLayout(sidebar,BoxLayout.Y_AXIS));
        JLabel logo = new JLabel("MedVault");
        logo.setFont(new Font("Segoe UI",Font.BOLD,28));
        logo.setForeground(Color.WHITE);
        JLabel subTitle = new JLabel("Health Management");
        subTitle.setFont(Theme.SMALL_FONT);
        subTitle.setForeground(new Color(200,200,200));
        sidebar.add(logo);
        sidebar.add(Box.createVerticalStrut(5));
        sidebar.add(subTitle);
        sidebar.add(Box.createVerticalStrut(35));
        dashboardBtn = createNavButton("Dashboard");
        patientBtn = createNavButton("Patients");
        medicineBtn = createNavButton("Medicines");
        emergencyBtn = createNavButton("Emergency");
        passportBtn = createNavButton("Passport");
        reportBtn = createNavButton("Reports");
        twinBtn = createNavButton("Digital Twin");
        settingsBtn = createNavButton("Settings");
        sidebar.add(dashboardBtn);
        sidebar.add(Box.createVerticalStrut(10));
        sidebar.add(patientBtn);
        sidebar.add(Box.createVerticalStrut(10));
        sidebar.add(medicineBtn);
        sidebar.add(Box.createVerticalStrut(10));
        sidebar.add(emergencyBtn);
        sidebar.add(Box.createVerticalStrut(10));
        sidebar.add(passportBtn);
        sidebar.add(Box.createVerticalStrut(10));
        sidebar.add(reportBtn);
        sidebar.add(Box.createVerticalStrut(10));
        sidebar.add(twinBtn);
        sidebar.add(Box.createVerticalStrut(10));
        sidebar.add(settingsBtn);
        sidebar.add(Box.createVerticalGlue());
        return sidebar;
    }

    private JButton createNavButton(String text) {
        JButton button = new JButton(text);
        button.setMaximumSize(new Dimension(Integer.MAX_VALUE, 48));
        button.setPreferredSize(new Dimension(220, 48));
        button.setHorizontalAlignment(SwingConstants.LEFT);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setOpaque(true);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setBackground(Theme.SIDEBAR);
        button.setForeground(Color.WHITE);
        button.setFont(Theme.SIDEBAR_FONT);
        button.setBorder(BorderFactory.createEmptyBorder(0,18,0,10));
        return button;
    }

    private void resetNavigation() {
        JButton[] buttons = {dashboardBtn,patientBtn,medicineBtn,emergencyBtn,passportBtn,reportBtn,twinBtn,settingsBtn};
        for (JButton button : buttons) { button.setBackground(Theme.SIDEBAR); }
    }

    private void activate(JButton button) {
        resetNavigation();
        button.setBackground(Theme.SIDEBAR_ACTIVE);
    }

    private void registerNavigation() {
        dashboardBtn.addActionListener(e -> {
            activate(dashboardBtn);
            showPanel("Dashboard");
        });
        patientBtn.addActionListener(e -> {
            activate(patientBtn);
            showPanel("Patients");
        });
        medicineBtn.addActionListener(e -> {
            activate(medicineBtn);
            showPanel("Medicines");
        });
        emergencyBtn.addActionListener(e -> {
            activate(emergencyBtn);
            showPanel("Emergency");
        });
        passportBtn.addActionListener(e -> {
            activate(passportBtn);
            showPanel("Passport");
        });
        reportBtn.addActionListener(e -> {
            activate(reportBtn);
            showPanel("Reports");
        });
        twinBtn.addActionListener(e -> {
            activate(twinBtn);
            showPanel("DigitalTwin");
        });
        settingsBtn.addActionListener(e -> {
            activate(settingsBtn);
            showPanel("Settings");
        });
        activate(dashboardBtn);
    }

    private void showPanel(String panelName) { cardLayout.show(contentPanel, panelName); }

    private void setFrameProperties() {
        setTitle("MedVault");
        setSize(Theme.WINDOW_WIDTH,Theme.WINDOW_HEIGHT);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        getContentPane().setBackground(Theme.BACKGROUND);
        setVisible(true);
    }
    
    public void openPanel(String panelName) { cardLayout.show(contentPanel, panelName); }
}