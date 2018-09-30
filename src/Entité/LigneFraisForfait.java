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
public class LigneFraisForfait {
    private String idVisiteur;
    //a compléter avec les éléments de fraisforfait
    private String mois;
    private String libelle;
    private String idFraisForfait;
    private String id;
    private float montant;
    private int quantite;
    private float total;
    private static Connection laConnexion = ControleConnexion.getLaConnectionStatique();
    private final ArrayList<LigneFraisForfait> lesEnrg = new ArrayList<>();
    
    

    public String getLibelle() {
        return libelle;
    }

    public String getId() {
        return id;
    }

    public float getMontant() {
        return montant;
    }

    public String getIdVisiteur() {
        return idVisiteur;
    }

    public String getMois() {
        return mois;
    }

    public String getIdFraisForfait() {
        return idFraisForfait;
    }

    public int getQuantite() {
        return quantite;
    }

    public float getTotal() {
        return total;
    }

    
    
    public ArrayList<LigneFraisForfait> getLesEnrg() {
        return lesEnrg;
    }

    public LigneFraisForfait(String idVisiteur, String mois, String libelle, String idFraisForfait, String id, float montant, int quantite, float total) {
        this.idVisiteur = idVisiteur;
        this.mois = mois;
        this.libelle = libelle;
        this.idFraisForfait = idFraisForfait;
        this.id = id;
        this.montant = montant;
        this.quantite = quantite;
        this.total = total;
    }
    
    public LigneFraisForfait(String idVisiteur, String mois) {
            LireRecup(idVisiteur, mois);
    }
   
    //Pareil que pour ficheFrais, on va lire et récupérer les LigneFraisForfait et les mettre dans lesEnrg
    private void LireRecup(String vIdVisiteur, String vMois) {
        try {
            if (vIdVisiteur.equals("")) {
                vIdVisiteur = "%";
            }
            if (vMois.equals("")) {
                vMois = "%";
            }

            String reqSQL = "SELECT * FROM lignefraisforfait join fraisforfait "
                    + "on (idFraisForfait=id) WHERE idVisiteur like '" + vIdVisiteur
                    + "' and mois like '" + vMois + "'";
            lesEnrg.retainAll(lesEnrg);
            Statement state = laConnexion.createStatement();  //permet d'exécuter des requêtes
            ResultSet rs = state.executeQuery(reqSQL);  //rs contient les résultats des lignes frais
            while (rs.next()) {
                String unIdVisiteur = rs.getString("idVisiteur");
                String unMois = rs.getString("mois");
                String unLibelle = rs.getString("libelle");
                String unIdFraisForfait = rs.getString("idFraisForfait");
                String unId = rs.getString("id");
                float unMontant = rs.getFloat("montant");
                int uneQuantite = rs.getInt("quantite");
                float unTotal = uneQuantite * unMontant;
                lesEnrg.add(new LigneFraisForfait(unIdVisiteur, unMois, unLibelle, unIdFraisForfait, unId, unMontant, uneQuantite, unTotal));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Problème rencontré : "
            + e.getMessage(), "Resultat", JOptionPane.ERROR_MESSAGE);
        }
    }
}


