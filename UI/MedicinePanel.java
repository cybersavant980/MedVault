package UI;

import javax.swing.*;
import java.awt.*;

public class MedicinePanel extends JPanel {

    public MedicinePanel() {

        setLayout(new BorderLayout());

        JLabel label = new JLabel(
                "Medicine Module - Under Development",
                SwingConstants.CENTER);

        add(label, BorderLayout.CENTER);

    }

}
