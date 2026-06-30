package UI.components;

import UI.theme.Theme;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class RoundedTextField extends JTextField {

    private final int cornerRadius;

    public RoundedTextField() {
        this(20);
    }

    public RoundedTextField(int columns) {
        super(columns);
        cornerRadius = Theme.TEXTFIELD_RADIUS;
        initialize();
    }

    private void initialize() {

        setOpaque(false);

        setFont(Theme.BODY_FONT);

        setForeground(Theme.TEXT_PRIMARY);

        setBackground(Color.WHITE);

        setCaretColor(Theme.PRIMARY);

        setSelectionColor(Theme.PRIMARY_LIGHT);

        setBorder(new EmptyBorder(10,16,10,16));

        setPreferredSize(
                new Dimension(
                        260,
                        Theme.TEXTFIELD_HEIGHT));

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

        // Shadow

        g2.setColor(new Color(0,0,0,12));

        g2.fillRoundRect(
                2,
                3,
                getWidth()-4,
                getHeight()-3,
                cornerRadius,
                cornerRadius);

        // Background

        g2.setColor(Color.WHITE);

        g2.fillRoundRect(
                0,
                0,
                getWidth()-2,
                getHeight()-2,
                cornerRadius,
                cornerRadius);

        super.paintComponent(g2);

        g2.dispose();

    }

    @Override
    protected void paintBorder(Graphics g) {

        Graphics2D g2 = (Graphics2D) g.create();

        g2.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        if (isFocusOwner()) {

            g2.setColor(Theme.PRIMARY);

        } else {

            g2.setColor(Theme.CARD_BORDER);

        }

        g2.setStroke(new BasicStroke(1.5f));

        g2.drawRoundRect(
                0,
                0,
                getWidth()-3,
                getHeight()-3,
                cornerRadius,
                cornerRadius);

        g2.dispose();

    }

}