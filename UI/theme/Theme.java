package UI.theme;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

public final class Theme {

    private Theme() {}

    /* ==========================================================
                          APPLICATION
       ========================================================== */

    public static final int WINDOW_WIDTH = 1400;
    public static final int WINDOW_HEIGHT = 850;

    /* ==========================================================
                              COLORS
       ========================================================== */

    // Modern Blue
    public static final Color PRIMARY = new Color(37, 99, 235);
    public static final Color PRIMARY_DARK = new Color(30, 64, 175);
    public static final Color PRIMARY_LIGHT = new Color(219, 234, 254);

    // Sidebar
    public static final Color SIDEBAR = new Color(30, 41, 59);
    public static final Color SIDEBAR_HOVER = new Color(51, 65, 85);
    public static final Color SIDEBAR_ACTIVE = new Color(37, 99, 235);

    // Background
    public static final Color BACKGROUND = new Color(245, 247, 250);
    public static final Color SURFACE = Color.WHITE;

    // Text
    public static final Color TEXT_PRIMARY = new Color(17, 24, 39);
    public static final Color TEXT_SECONDARY = new Color(107, 114, 128);

    // Status
    public static final Color SUCCESS = new Color(22, 163, 74);
    public static final Color WARNING = new Color(245, 158, 11);
    public static final Color ERROR = new Color(220, 38, 38);

    // Borders
    public static final Color BORDER = new Color(226, 232, 240);

    // Cards
    public static final Color CARD = Color.WHITE;
    public static final Color CARD_BORDER = new Color(229, 231, 235);

    // Table
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
            new Font("Segoe UI", Font.PLAIN, 15);

    public static final Font BODY_FONT =
            new Font("Segoe UI", Font.PLAIN, 15);

    public static final Font SMALL_FONT =
            new Font("Segoe UI", Font.PLAIN, 13);

    public static final Font BUTTON_FONT =
            new Font("Segoe UI", Font.BOLD, 15);

    public static final Font SIDEBAR_FONT =
            new Font("Segoe UI", Font.BOLD, 15);

    public static final Font CARD_TITLE =
            new Font("Segoe UI", Font.BOLD, 16);

    public static final Font CARD_VALUE =
            new Font("Segoe UI", Font.BOLD, 34);

    /* ==========================================================
                            COMPONENTS
       ========================================================== */

    public static final int BUTTON_WIDTH = 150;
    public static final int BUTTON_HEIGHT = 42;
    public static final int BUTTON_RADIUS = 20;

    public static final int TEXTFIELD_HEIGHT = 42;
    public static final int TEXTFIELD_RADIUS = 16;

    public static final int PANEL_RADIUS = 24;
    public static final int CARD_RADIUS = 24;

    public static final int PANEL_PADDING = 20;
    public static final int PADDING = 16;

    public static final int SIDEBAR_WIDTH = 250;

    /* ==========================================================
                               BORDERS
       ========================================================== */

    public static final Border EMPTY_BORDER =
            BorderFactory.createEmptyBorder(12,16,12,16);

    public static final Border PANEL_BORDER =
            BorderFactory.createLineBorder(BORDER);

}