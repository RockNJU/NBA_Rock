package UI.common;

import java.awt.Color;
import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;

import UI.main.init;

public class FenseRenderer implements TableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JLabel renderer = (JLabel) new DefaultTableCellRenderer().getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        renderer.setHorizontalAlignment(JLabel.CENTER); 

        if (row % 2 == 0) {
            renderer.setForeground(Color.black);
            renderer.setBackground(Color.WHITE);
        } else {
            renderer.setForeground(Color.black);
            renderer.setBackground(init.syslightblue);
        }
       
        return renderer;
        
    }
}
