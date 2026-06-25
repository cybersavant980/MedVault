package UI;

import javax.swing.*;
import java.awt.*;

public class HealthPassportPanel extends JPanel {

    public HealthPassportPanel() {

        setLayout(new BorderLayout());

        JLabel label = new JLabel(
                "HealthPassport Module - Under Development",
                SwingConstants.CENTER);

        add(label, BorderLayout.CENTER);

    }

}