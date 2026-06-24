package UI;

import UI.theme.Theme;

import javax.swing.*;
import java.awt.*;

public class PatientPanel extends JPanel {

    public PatientPanel() {

        setLayout(new BorderLayout());
        setBackground(Theme.BACKGROUND);

        JLabel label = new JLabel("Patient Management");
        label.setFont(Theme.TITLE_FONT);

        add(label, BorderLayout.NORTH);
    }

}