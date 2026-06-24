package UI.components;

import UI.theme.Theme;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class AppTable extends JTable {

    public AppTable() {

        setRowHeight(30);
        setFont(Theme.BODY_FONT);

        setSelectionBackground(Theme.TABLE_SELECTION);
        setSelectionForeground(Theme.TEXT_PRIMARY);

        setGridColor(Theme.BORDER);
        setShowGrid(true);
        setFillsViewportHeight(true);

        setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

        JTableHeader header = getTableHeader();
        header.setFont(Theme.BUTTON_FONT);
        header.setBackground(Theme.TABLE_HEADER);
        header.setForeground(Theme.TABLE_HEADER_TEXT);
        header.setReorderingAllowed(false);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        setDefaultRenderer(Object.class, centerRenderer);
    }

    public void setTableData(String[] columns, Object[][] data) {
        setModel(new DefaultTableModel(data, columns) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });
    }
}