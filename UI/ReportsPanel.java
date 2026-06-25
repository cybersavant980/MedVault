package UI;

import javax.swing.*;
import java.awt.*;

public class ReportsPanel extends JPanel {

    public ReportsPanel() {

        setLayout(new BorderLayout());

        JLabel label = new JLabel(
                "ReportsPanel Module - Under Development",
                SwingConstants.CENTER);

        add(label, BorderLayout.CENTER);

    }

}