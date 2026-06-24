package UI;

import UI.theme.Theme;

import javax.swing.*;
import java.awt.*;

public class DigitalTwinPanel extends JPanel {

    public DigitalTwinPanel() {

        setLayout(new BorderLayout());
        setBackground(Theme.BACKGROUND);

        JLabel label = new JLabel("Interactive Human Body (Medical Digital Twin)");
        label.setFont(Theme.TITLE_FONT);

        add(label, BorderLayout.NORTH);
    }

}