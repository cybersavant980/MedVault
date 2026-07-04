package UI.components;
import UI.theme.Theme;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
public class AppTable extends JTable {
    public AppTable() {
        initializeTable();
    }

    private void initializeTable() {
        setFont(Theme.BODY_FONT);
        setRowHeight(38);
        setGridColor(new Color(235, 238, 245));
        setShowHorizontalLines(true);
        setShowVerticalLines(false);
        setIntercellSpacing(new Dimension(0, 1));
        setSelectionBackground(Theme.PRIMARY_LIGHT);
        setSelectionForeground(Theme.TEXT_PRIMARY);
        setBackground(Color.WHITE);
        setForeground(Theme.TEXT_PRIMARY);
        setFillsViewportHeight(true);
        setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        setFocusable(false);
        setRowSelectionAllowed(true);
        setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        styleHeader();
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        setDefaultRenderer(Object.class, centerRenderer);

        setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table,Object value,boolean isSelected,boolean hasFocus,int row,int column) {
                Component c = super.getTableCellRendererComponent(table,value,isSelected,hasFocus,row,column);
                setHorizontalAlignment(CENTER);
                if (isSelected) {
                    c.setBackground(Theme.PRIMARY_LIGHT);
                    c.setForeground(Theme.TEXT_PRIMARY);
                } else {
                    if (row % 2 == 0) {
                        c.setBackground(Color.WHITE);
                    } else {
                        c.setBackground(new Color(248,250,252));
                    }
                    c.setForeground(Theme.TEXT_PRIMARY);
                }
                return c;
            }
        });
    }

    public void setTableData(String[] columns, Object[][] data) {
        DefaultTableModel model = new DefaultTableModel(data, columns) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        setModel(model);
        styleHeader();;
    }

    private void styleHeader() {
        JTableHeader header = getTableHeader();
        header.setPreferredSize(new Dimension(0, 42));
        header.setReorderingAllowed(false);
        header.setResizingAllowed(false);
        header.setDefaultRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table,Object value,boolean isSelected,boolean hasFocus,int row,int column) {
                JLabel label = (JLabel) super.getTableCellRendererComponent(table,value,false,false,row,column);
                label.setOpaque(true);
                label.setBackground(Theme.PRIMARY);
                label.setForeground(Color.WHITE);
                label.setFont(Theme.BUTTON_FONT);
                label.setHorizontalAlignment(SwingConstants.CENTER);
                label.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
                return label;
            }
        });
    }
}