package UI.components;
import UI.theme.Theme;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
public class RoundedPasswordField extends JPasswordField {
    private final int cornerRadius;
    public RoundedPasswordField() {
        this(20);
    }
    public RoundedPasswordField(int columns) {
        super(columns);
        this.cornerRadius = Theme.TEXTFIELD_RADIUS;
        initialize();
    }
    private void initialize() {
        setOpaque(false);
        setFont(Theme.BODY_FONT);
        setForeground(Theme.TEXT_PRIMARY);
        setBackground(Color.WHITE);
        setBorder(new EmptyBorder(10, 15, 10, 15));
        setPreferredSize(new Dimension(250, Theme.TEXTFIELD_HEIGHT));
        setCaretColor(Theme.PRIMARY);
        setSelectionColor(Theme.PRIMARY_LIGHT);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillRoundRect(
                0,
                0,
                getWidth(),
                getHeight(),
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
            g2.setColor(Theme.BORDER);
        }
        g2.drawRoundRect(
                0,
                0,
                getWidth() - 1,
                getHeight() - 1,
                cornerRadius,
                cornerRadius);

        g2.dispose();
    }
}