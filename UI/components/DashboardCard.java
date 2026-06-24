package UI.components;

import UI.theme.Theme;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class DashboardCard extends RoundedPanel {

    private final JLabel titleLabel;
    private final JLabel valueLabel;

    public DashboardCard(String title, String value) {

        setLayout(new BorderLayout());
        setBorder(new EmptyBorder(15, 15, 15, 15));
        setPreferredSize(new Dimension(220, 120));

        titleLabel = new JLabel(title);
        titleLabel.setFont(Theme.SUBTITLE_FONT);
        titleLabel.setForeground(Theme.TEXT_SECONDARY);

        valueLabel = new JLabel(value);
        valueLabel.setFont(Theme.TITLE_FONT);
        valueLabel.setForeground(Theme.PRIMARY);

        add(titleLabel, BorderLayout.NORTH);
        add(valueLabel, BorderLayout.CENTER);
    }

    public void setValue(String value) {
        valueLabel.setText(value);
    }

    public String getValue() {
        return valueLabel.getText();
    }
}