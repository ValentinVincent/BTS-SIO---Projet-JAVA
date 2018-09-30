/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entité;

import Controle.Connexion.ControleConnexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author DELL
 */
public class LigneFraisHorsForfait {

    private String idVisiteur;
    private String mois;
    private String libelle;
    private Date date;
    private float montant;
    private static Connection laConnexion = ControleConnexion.getLaConnectionStatique();
    private final ArrayList<LigneFraisHorsForfait> lesEnrg = new ArrayList<>();

    public String getIdVisiteur() {
        return idVisiteur;
    }

    public String getMois() {
        return mois;
    }

    public Date getDate() {
        return date;
    }

    public String getLibelle() {
        return libelle;
    }

    public float getMontant() {
        return montant;
    }
    
    

    public ArrayList<LigneFraisHorsForfait> getLesEnrg() {
        return lesEnrg;
    }

    public LigneFraisHorsForfait(String idVisiteur, String mois, String libelle, Date date, float montant) {
        this.idVisiteur = idVisiteur;
        this.mois = mois;
        this.libelle = libelle;
        this.date = date;
        this.montant = montant;
    }

    public LigneFraisHorsForfait(String idVisiteur, String mois) {
        LireRecup(idVisiteur, mois);
    }

    private void LireRecup(String vIdVisiteur, String vMois) {
        try {
            if (vIdVisiteur.equals("")) {
                vIdVisiteur = "%";
            }
            if (vMois.equals("")) {
                vMois = "%";
            }
            String reqSQL = "SELECT * FROM lignefraishorsforfait "
                    + "WHERE idVisiteur like '" + vIdVisiteur
                    + "' and mois like '" + vMois + "'";
            lesEnrg.retainAll(lesEnrg);
            Statement state = laConnexion.createStatement();  //permet d'exécuter des requêtes
            ResultSet rs = state.executeQuery(reqSQL);  //rs contient les résultats des lignes frais
            while (rs.next()) {
                String unIdVisiteur = rs.getString("idVisiteur");
                String unMois = rs.getString("mois");
                String unLibelle = rs.getString("libelle");
                float unMontant = rs.getFloat("montant");
                Date uneDate = rs.getDate("date");
                lesEnrg.add(new LigneFraisHorsForfait(unIdVisiteur, unMois, unLibelle, uneDate, unMontant));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Problème rencontré : "
                    + e.getMessage(), "Resultat", JOptionPane.ERROR_MESSAGE);
        }
    }
}
