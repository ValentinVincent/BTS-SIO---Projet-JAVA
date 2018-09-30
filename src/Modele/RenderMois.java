/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author DELL
 */
public class RenderMois extends DefaultTableCellRenderer {
                public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row,
            int column) {
        String val=(String) value;
        String str = "";
        switch (val) {
            case "01" : str = "Janvier";break;
            case "02" : str = "Février";break;
            case "03" : str = "Mars";break;
            case "04" : str = "Avril";break;
            case "05" : str = "Mai";break;
            case "06" : str = "Juin";break;
            case "07" : str = "Juillet";break;
            case "08" : str = "Août";break;
            case "09" : str = "Septembre";break;
            case "10" : str = "Octobre";break;    
            case "11" : str = "Novembre";break;
            case "12" : str = "Décembre"; 
        }
        this.setText(str);
        this.setHorizontalAlignment(CENTER);
        this.setBackground(null);
        return this;
     }  
  }
