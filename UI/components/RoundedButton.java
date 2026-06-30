package UI.components;

import UI.theme.Theme;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
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
        setOpaque(false);

        setFont(Theme.BUTTON_FONT);
        setForeground(Color.WHITE);
        setBackground(Theme.PRIMARY);

        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        setPreferredSize(new Dimension(Theme.BUTTON_WIDTH, Theme.BUTTON_HEIGHT));
        setBorder(new EmptyBorder(8, 16, 8, 16));
        setRolloverEnabled(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        try {
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

            Color fillColor;
            ButtonModel model = getModel();

            if (!isEnabled()) {
                fillColor = new Color(148, 163, 184);
            } else if (model.isArmed() && model.isPressed()) {
                fillColor = Theme.PRIMARY_DARK;
            } else if (model.isRollover()) {
                fillColor = Theme.SIDEBAR_HOVER;
            } else {
                fillColor = Theme.PRIMARY;
            }

            g2.setColor(fillColor);
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);

            if (model.isRollover() && isEnabled()) {
                g2.setColor(new Color(255, 255, 255, 20));
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);
            }

            super.paintComponent(g2);
        } finally {
            g2.dispose();
        }
    }

    @Override
    protected void paintBorder(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        try {
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(new Color(255, 255, 255, 35));
            g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, radius, radius);
        } finally {
            g2.dispose();
        }
    }
}