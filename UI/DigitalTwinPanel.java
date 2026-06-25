package UI;

import UI.components.RoundedPanel;
import UI.theme.Theme;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class DigitalTwinPanel extends JPanel {

    // =====================================================
    // Header
    // =====================================================

    private JLabel titleLabel;
    private JLabel subtitleLabel;

    // =====================================================
    // Left Side
    // =====================================================

    private JLabel humanBodyImage;

    // =====================================================
    // Right Side
    // =====================================================

    private JComboBox<String> bodyPartCombo;

    private JTextArea organDescriptionArea;

    private JTextArea patientObservationArea;

    private JButton updateButton;

    // =====================================================
    // Constructor
    // =====================================================

    public DigitalTwinPanel() {

        initializeComponents();
        layoutComponents();
        registerEvents();

    }

    // =====================================================
    // Initialize
    // =====================================================

    private void initializeComponents() {

        titleLabel = new JLabel("Medical Digital Twin");
        titleLabel.setFont(Theme.TITLE_FONT);

        subtitleLabel = new JLabel(
                "Interactive Human Body & Disease Viewer");
        subtitleLabel.setFont(Theme.SUBTITLE_FONT);

        humanBodyImage = new JLabel(
                "Human Body Image",
                SwingConstants.CENTER);

        humanBodyImage.setPreferredSize(new Dimension(350, 550));

        humanBodyImage.setBorder(
                BorderFactory.createLineBorder(Theme.BORDER));

        bodyPartCombo = new JComboBox<>(new String[]{

                "Select Body Part",

                "Head",

                "Eyes",

                "Heart",

                "Lungs",

                "Liver",

                "Kidney",

                "Stomach",

                "Hands",

                "Legs"

        });

        organDescriptionArea = new JTextArea();

        organDescriptionArea.setEditable(false);
        organDescriptionArea.setLineWrap(true);
        organDescriptionArea.setWrapStyleWord(true);
        organDescriptionArea.setFont(Theme.BODY_FONT);

        patientObservationArea = new JTextArea();

        patientObservationArea.setLineWrap(true);
        patientObservationArea.setWrapStyleWord(true);
        patientObservationArea.setFont(Theme.BODY_FONT);

        updateButton = new JButton("Update Observation");

    }

    // =====================================================
    // Layout
    // =====================================================

    private void layoutComponents() {

        setLayout(new BorderLayout(20,20));
        setBackground(Theme.BACKGROUND);
        setBorder(new EmptyBorder(20,20,20,20));

        add(createHeaderPanel(),BorderLayout.NORTH);

        JSplitPane splitPane = new JSplitPane(

                JSplitPane.HORIZONTAL_SPLIT,

                createBodyPanel(),

                createInformationPanel()

        );

        splitPane.setDividerLocation(420);

        add(splitPane,BorderLayout.CENTER);

    }

    // =====================================================
    // Header
    // =====================================================

    private JPanel createHeaderPanel() {

        JPanel panel = new JPanel();

        panel.setOpaque(false);

        panel.setLayout(new BoxLayout(
                panel,
                BoxLayout.Y_AXIS));

        panel.add(titleLabel);

        panel.add(Box.createVerticalStrut(5));

        panel.add(subtitleLabel);

        return panel;

    }
    // =====================================================
    // Human Body Panel
    // =====================================================

    private JPanel createBodyPanel() {

        RoundedPanel panel = new RoundedPanel();
        panel.setLayout(new BorderLayout(10,10));
        panel.setBorder(new EmptyBorder(20,20,20,20));

        JLabel title = new JLabel("Human Body");
        title.setFont(Theme.HEADER_FONT);

        panel.add(title, BorderLayout.NORTH);
        panel.add(humanBodyImage, BorderLayout.CENTER);

        return panel;

    }

    // =====================================================
    // Information Panel
    // =====================================================

    private JPanel createInformationPanel() {

        RoundedPanel panel = new RoundedPanel();
        panel.setLayout(new BorderLayout(15,15));
        panel.setBorder(new EmptyBorder(20,20,20,20));

        JPanel topPanel = new JPanel(new BorderLayout(10,10));
        topPanel.setOpaque(false);

        JLabel selectLabel = new JLabel("Select Body Part");
        selectLabel.setFont(Theme.HEADER_FONT);

        topPanel.add(selectLabel, BorderLayout.NORTH);
        topPanel.add(bodyPartCombo, BorderLayout.CENTER);

        JPanel descriptionPanel = new JPanel(new BorderLayout(10,10));
        descriptionPanel.setOpaque(false);

        JLabel descriptionLabel = new JLabel("Medical Information");
        descriptionLabel.setFont(Theme.SUBTITLE_FONT);

        JScrollPane descriptionScroll =
                new JScrollPane(organDescriptionArea);

        descriptionPanel.add(descriptionLabel, BorderLayout.NORTH);
        descriptionPanel.add(descriptionScroll, BorderLayout.CENTER);

        JPanel observationPanel = new JPanel(new BorderLayout(10,10));
        observationPanel.setOpaque(false);

        JLabel observationLabel =
                new JLabel("Patient Observation");

        observationLabel.setFont(Theme.SUBTITLE_FONT);

        JScrollPane observationScroll =
                new JScrollPane(patientObservationArea);

        observationPanel.add(observationLabel, BorderLayout.NORTH);
        observationPanel.add(observationScroll, BorderLayout.CENTER);

        JPanel centerPanel = new JPanel(new GridLayout(2,1,15,15));
        centerPanel.setOpaque(false);

        centerPanel.add(descriptionPanel);
        centerPanel.add(observationPanel);

        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        bottomPanel.setOpaque(false);

        bottomPanel.add(updateButton);

        panel.add(topPanel, BorderLayout.NORTH);
        panel.add(centerPanel, BorderLayout.CENTER);
        panel.add(bottomPanel, BorderLayout.SOUTH);

        return panel;

    }
    
    // =====================================================
    // Register Events
    // =====================================================

    private void registerEvents() {

        bodyPartCombo.addActionListener(e -> updateOrganInformation());

        updateButton.addActionListener(e ->
                JOptionPane.showMessageDialog(
                        this,
                        "Patient observations updated successfully.",
                        "Information",
                        JOptionPane.INFORMATION_MESSAGE));

    }

    // =====================================================
    // Update Organ Information
    // =====================================================

    private void updateOrganInformation() {

        String selectedPart =
                (String) bodyPartCombo.getSelectedItem();

        if (selectedPart == null) {
            return;
        }

        switch (selectedPart) {

            case "Head":
                organDescriptionArea.setText(
                        "Brain and nervous system.\n\n"
                                + "Responsible for thinking, memory, "
                                + "decision making and body coordination.");
                break;

            case "Eyes":
                organDescriptionArea.setText(
                        "Human vision organs.\n\n"
                                + "Used for visual perception and balance.");
                break;

            case "Heart":
                organDescriptionArea.setText(
                        "Heart pumps blood throughout the body.\n\n"
                                + "Common diseases:\n"
                                + "• Hypertension\n"
                                + "• Heart Attack\n"
                                + "• Coronary Artery Disease");
                break;

            case "Lungs":
                organDescriptionArea.setText(
                        "Responsible for oxygen exchange.\n\n"
                                + "Common diseases:\n"
                                + "• Asthma\n"
                                + "• Pneumonia\n"
                                + "• COPD");
                break;

            case "Liver":
                organDescriptionArea.setText(
                        "Largest internal organ.\n\n"
                                + "Functions:\n"
                                + "• Detoxification\n"
                                + "• Digestion\n"
                                + "• Metabolism");
                break;

            case "Kidney":
                organDescriptionArea.setText(
                        "Filters blood and removes waste.\n\n"
                                + "Common diseases:\n"
                                + "• Kidney Stones\n"
                                + "• Kidney Failure");
                break;

            case "Stomach":
                organDescriptionArea.setText(
                        "Primary digestive organ.\n\n"
                                + "Common diseases:\n"
                                + "• Gastritis\n"
                                + "• Ulcers");
                break;

            case "Hands":
                organDescriptionArea.setText(
                        "Upper limb movement and coordination.");
                break;

            case "Legs":
                organDescriptionArea.setText(
                        "Responsible for walking and balance.");
                break;

            default:
                organDescriptionArea.setText(
                        "Select a body part to view its information.");
        }

    }

}



