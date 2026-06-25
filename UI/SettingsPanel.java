package UI;

import javax.swing.*;
import java.awt.*;

public class SettingsPanel extends JPanel {

    public SettingsPanel() {

        setLayout(new BorderLayout());

        JLabel label = new JLabel(
                "SettingsPanel Module - Under Development",
                SwingConstants.CENTER);

        add(label, BorderLayout.CENTER);

    }

}