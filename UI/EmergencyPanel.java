package UI;

import javax.swing.*;
import java.awt.*;

public class EmergencyPanel extends JPanel {

    public EmergencyPanel() {

        setLayout(new BorderLayout());

        JLabel label = new JLabel(
                "Emergency Module - Under Development",
                SwingConstants.CENTER);

        add(label, BorderLayout.CENTER);

    }

}

