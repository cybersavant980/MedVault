package UI.components;

import UI.theme.Theme;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class RoundedPanel extends JPanel {

    private final int cornerRadius;

    public RoundedPanel() {
        this(Theme.PANEL_RADIUS);
    }

    public RoundedPanel(int cornerRadius) {

        this.cornerRadius = cornerRadius;

        setOpaque(false);
        setBackground(Theme.CARD);
        setBorder(new EmptyBorder(18,18,18,18));

    }

    @Override
    protected void paintComponent(Graphics g) {

        Graphics2D g2 = (Graphics2D) g.create();

        g2.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        g2.setRenderingHint(
                RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);

        // Soft Shadow

        g2.setColor(new Color(0,0,0,18));

        g2.fillRoundRect(
                4,
                5,
                getWidth()-8,
                getHeight()-5,
                cornerRadius,
                cornerRadius);

        // Card

        g2.setColor(getBackground());

        g2.fillRoundRect(
                0,
                0,
                getWidth()-4,
                getHeight()-4,
                cornerRadius,
                cornerRadius);

        super.paintComponent(g2);

        g2.dispose();

    }

    @Override
    protected void paintBorder(Graphics g) {

        Graphics2D g2=(Graphics2D)g.create();

        g2.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        g2.setColor(Theme.CARD_BORDER);

        g2.drawRoundRect(
                0,
                0,
                getWidth()-5,
                getHeight()-5,
                cornerRadius,
                cornerRadius);

        g2.dispose();

    }

}