package UI.components;

import UI.theme.Theme;

import javax.swing.*;
import java.awt.*;

public class RoundedButton extends JButton {

    private final int radius;

    public RoundedButton(String text) {
        this(text, Theme.BUTTON_RADIUS);
    }

    public RoundedButton(String text, int radius) {
        super(text);
        this.radius = radius;
        initialize();
    }

    private void initialize() {

        setFocusPainted(false);
        setBorderPainted(false);
        setContentAreaFilled(false);

        setForeground(Color.WHITE);
        setBackground(Theme.PRIMARY);

        setFont(Theme.BUTTON_FONT);

        setCursor(new Cursor(Cursor.HAND_CURSOR));

        setPreferredSize(new Dimension(140, Theme.BUTTON_HEIGHT));
    }

    @Override
    protected void paintComponent(Graphics g) {

        Graphics2D g2 = (Graphics2D) g.create();

        g2.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        if (getModel().isPressed()) {
            g2.setColor(Theme.PRIMARY_DARK);
        } else if (getModel().isRollover()) {
            g2.setColor(Theme.PRIMARY_LIGHT);
        } else {
            g2.setColor(getBackground());
        }

        g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);

        super.paintComponent(g2);

        g2.dispose();
    }

    @Override
    protected void paintBorder(Graphics g) {

        Graphics2D g2 = (Graphics2D) g.create();

        g2.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        g2.setColor(getBackground());

        g2.drawRoundRect(
                0,
                0,
                getWidth() - 1,
                getHeight() - 1,
                radius,
                radius);

        g2.dispose();
    }

}