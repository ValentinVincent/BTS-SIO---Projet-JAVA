/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import Entité.FicheFrais;
import Entité.LigneFraisForfait;
import Entité.LigneFraisHorsForfait;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author DELL
 */
public class ModeleLigneFraisHorsForfait extends AbstractTableModel {

    LigneFraisHorsForfait instanceLigneFraisHorsForfait;
    private ArrayList<LigneFraisHorsForfait> lesDonnees;
    private final String[] lesTitres = {"Libelle", "Date", "Montant"};

    public ModeleLigneFraisHorsForfait(String visiteur, String mois) {
        this.instanceLigneFraisHorsForfait = new LigneFraisHorsForfait( visiteur, mois);
        this.lesDonnees = instanceLigneFraisHorsForfait.getLesEnrg();
    }

    @Override
    public int getRowCount() {
        return lesDonnees.size();
    }

    @Override
    public int getColumnCount() {
        return lesTitres.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return lesDonnees.get(rowIndex).getLibelle();
            case 1:
                return lesDonnees.get(rowIndex).getDate();
            case 2:
                return lesDonnees.get(rowIndex).getMontant();
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
                case 1:
                    return Date.class;
                default:
                    return Object.class;
            }
        }
    }
