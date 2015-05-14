package UI.common;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;

public class FenseRenderforhot implements TableCellRenderer {
    Color a=new Color(254,191,55);
    Color b=new Color(247,174,17);
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JLabel renderer = (JLabel) new DefaultTableCellRenderer().getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        renderer.setHorizontalAlignment(JLabel.CENTER); 

        if (row % 2 == 1) {
            renderer.setForeground(Color.WHITE);
            renderer.setBackground(b);
        } else {
            renderer.setForeground(Color.black);
            renderer.setBackground(a);
        }
    
        return renderer;
    }
}
