package UI.components;

import UI.theme.Theme;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class DashboardCard extends RoundedPanel {

    private JLabel titleLabel;
    private JLabel valueLabel;
    private JLabel descriptionLabel;

    public DashboardCard(String title, String value) {

        setLayout(new BorderLayout(10,10));

        setBorder(new EmptyBorder(20,20,20,20));

        setPreferredSize(new Dimension(260,160));

        titleLabel = new JLabel(title);

        titleLabel.setFont(Theme.CARD_TITLE);

        titleLabel.setForeground(Theme.TEXT_SECONDARY);

        valueLabel = new JLabel(value);

        valueLabel.setFont(Theme.CARD_VALUE);

        valueLabel.setForeground(Theme.PRIMARY);

        descriptionLabel = new JLabel(getDescription(title));

        descriptionLabel.setFont(Theme.SMALL_FONT);

        descriptionLabel.setForeground(Theme.TEXT_SECONDARY);

        JPanel textPanel = new JPanel();

        textPanel.setOpaque(false);

        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));

        textPanel.add(titleLabel);

        textPanel.add(Box.createVerticalStrut(12));

        textPanel.add(valueLabel);

        textPanel.add(Box.createVerticalStrut(10));

        textPanel.add(descriptionLabel);

        add(textPanel, BorderLayout.CENTER);

    }

    private String getDescription(String title) {

        switch (title.toLowerCase()) {

            case "patients":
                return "Registered Patients";

            case "medicines":
                return "Available Medicines";

            case "today's reminders":
                return "Pending Reminders";

            case "emergency records":
                return "Emergency Contacts";

            default:
                return "";

        }

    }

    public void setValue(String value) {

        valueLabel.setText(value);

    }

    public String getValue() {

        return valueLabel.getText();

    }

}