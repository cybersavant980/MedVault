package UI.theme;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

public final class Theme {

    // Prevent object creation
    private Theme() {
    }

    /* ==========================================================
                       APPLICATION WINDOW
       ========================================================== */

    public static final int WINDOW_WIDTH = 1200;
    public static final int WINDOW_HEIGHT = 750;

    /* ==========================================================
                             COLORS
       ========================================================== */

    public static final Color PRIMARY = new Color(25, 118, 210);
    public static final Color PRIMARY_DARK = new Color(13, 71, 161);
    public static final Color PRIMARY_LIGHT = new Color(227, 242, 253);

    public static final Color BACKGROUND = new Color(245, 247, 250);
    public static final Color SURFACE = Color.WHITE;

    public static final Color TEXT_PRIMARY = new Color(33, 33, 33);
    public static final Color TEXT_SECONDARY = new Color(117, 117, 117);

    public static final Color SUCCESS = new Color(46, 125, 50);
    public static final Color WARNING = new Color(245, 124, 0);
    public static final Color ERROR = new Color(211, 47, 47);

    public static final Color BORDER = new Color(220, 220, 220);

    public static final Color TABLE_HEADER = PRIMARY;
    public static final Color TABLE_HEADER_TEXT = Color.WHITE;
    public static final Color TABLE_ROW = Color.WHITE;
    public static final Color TABLE_SELECTION = PRIMARY_LIGHT;

    /* ==========================================================
                              FONTS
       ========================================================== */

    public static final Font TITLE_FONT =
            new Font("Segoe UI", Font.BOLD, 30);

    public static final Font HEADER_FONT =
            new Font("Segoe UI", Font.BOLD, 22);

    public static final Font SUBTITLE_FONT =
            new Font("Segoe UI", Font.PLAIN, 16);

    public static final Font BODY_FONT =
            new Font("Segoe UI", Font.PLAIN, 15);

    public static final Font SMALL_FONT =
            new Font("Segoe UI", Font.PLAIN, 13);

    public static final Font BUTTON_FONT =
            new Font("Segoe UI", Font.BOLD, 15);

    /* ==========================================================
                          COMPONENT SIZES
       ========================================================== */

    public static final int BUTTON_HEIGHT = 42;
    public static final int BUTTON_RADIUS = 18;
    public static final int BUTTON_WIDTH = 140;
    setPreferredSize(new Dimension(Theme.BUTTON_WIDTH,Theme.BUTTON_HEIGHT));

    public static final int TEXTFIELD_HEIGHT = 42;
    public static final int TEXTFIELD_RADIUS = 16;

    public static final int PANEL_RADIUS = 20;
    public static final int PANEL_PADDING = 20;
    public static final int CARD_RADIUS = 22;

    public static final int PADDING = 15;


    /* ==========================================================
                              BORDERS
       ========================================================== */

    public static final Border EMPTY_BORDER =
            BorderFactory.createEmptyBorder(10, 15, 10, 15);

    public static final Border PANEL_BORDER =
            BorderFactory.createLineBorder(BORDER);

}