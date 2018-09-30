/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import Entité.FicheFrais;
import Entité.LigneFraisForfait;
import java.awt.Component;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author DELL
 */

// On va préparer le modèle du tableau pour Visualiser les fiches contenant les ligneFraisForfait et hors forfait
public class ModeleLigneFraisForfait extends AbstractTableModel {

    LigneFraisForfait instanceLigneFraisForfait;
    private ArrayList<LigneFraisForfait> lesDonnees;
    private final String[] lesTitres = {"IdFraisForfait", "Libelle", "Montant", "Quantite", "Total"};

    public ModeleLigneFraisForfait(String visiteur, String mois) {
        this.instanceLigneFraisForfait = new LigneFraisForfait( visiteur, mois);
        this.lesDonnees = instanceLigneFraisForfait.getLesEnrg();
    }

    @Override
    public int getRowCount() {
        return lesDonnees.size();
    }

    @Override
    public int getColumnCount() {
        return lesTitres.length;
    }

    // Pareil que pour modeleFicheFrais, on indique que dans la colonne 1 seronts les idFraisForfait, etc
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return lesDonnees.get(rowIndex).getIdFraisForfait();
            case 1:
                return lesDonnees.get(rowIndex).getLibelle();
            case 2:
                return lesDonnees.get(rowIndex).getMontant();
            case 3:
                return lesDonnees.get(rowIndex).getQuantite();
            case 4:
                return lesDonnees.get(rowIndex).getTotal(); 
            default:
                return null;
        }
    }

  
    
    @Override
    public String getColumnName(int columnIndex) {
        return lesTitres[columnIndex];
    }

    @Override
    public Class<?> getColumnClass (int columnIndex) {
        switch (columnIndex) {
                case 6:
                    return Date.class;
                default:
                    return Object.class;
            }
        }
    }
