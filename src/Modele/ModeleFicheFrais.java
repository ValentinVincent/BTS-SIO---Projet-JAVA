/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import Entité.FicheFrais;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author DELL
 */
public class ModeleFicheFrais extends AbstractTableModel {

    FicheFrais instanceFicheFrais;
    private ArrayList<FicheFrais> lesDonnees;
    private final String[] lesTitres = {"Id", "Nom", "Prenom", "Mois", "Nb Justificatifs", "Montant Validé", "Date Modification", "IdEtat"};

    // On prépare 3 constructeur de même nom, c'est un polymorphisme de paramètre, bravo
    public ModeleFicheFrais(String type) {
        this.instanceFicheFrais = new FicheFrais(type, "", "");
        this.lesDonnees = instanceFicheFrais.getLesEnrg();
    }

    public ModeleFicheFrais(String type, String visiteur) {
        this.instanceFicheFrais = new FicheFrais(type, visiteur, "");
        this.lesDonnees = instanceFicheFrais.getLesEnrg();
    }

    public ModeleFicheFrais(String type, String visiteur, String mois) {
        this.instanceFicheFrais = new FicheFrais(type, visiteur, mois);
        this.lesDonnees = instanceFicheFrais.getLesEnrg();
    }

    // Nombre de ligne du tableau (on s'en servira ailleurs)
    @Override
    public int getRowCount() {
        return lesDonnees.size();
    }

    // Nombre de colonnes du tableau
    @Override
    public int getColumnCount() {
        return lesTitres.length;
    }

    // Cette procédure permet de retourner la valeur dans la case (ligne, colonne)
    // On s'en servira pour afficher les bonnes informations dans les bonnes cases (ex : la colonne 0 contient les idVisiteur) 
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return lesDonnees.get(rowIndex).getIdVisiteur();
            case 1:
                return lesDonnees.get(rowIndex).getNomVisiteur();
            case 2:
                return lesDonnees.get(rowIndex).getPrenomVisiteur();
            case 3:
                return lesDonnees.get(rowIndex).getMois();
            case 4:
                return lesDonnees.get(rowIndex).getNbJustif();
            case 5:
                return lesDonnees.get(rowIndex).getMontantValide();
            case 6:
                return lesDonnees.get(rowIndex).getDateModif();
            case 7:
                return lesDonnees.get(rowIndex).getIdEtat();
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
