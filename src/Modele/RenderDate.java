/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import java.awt.Component;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import javax.swing.JTable;
import static javax.swing.SwingConstants.CENTER;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author DELL
 */
public class RenderDate extends DefaultTableCellRenderer{
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
            int row, int column) {
            Date date = (Date) value;
            DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT, Locale.FRENCH);
            String str = df.format(date);
            this.setText(str);
            this.setHorizontalAlignment(CENTER);
            this.setBackground(null);
            return this;
    }
}
