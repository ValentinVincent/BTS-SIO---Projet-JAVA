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
import javax.swing.JOptionPane;

/**
 *
 * @author DELL
 */
public class Etat {
    private String idEtat;
    private String libelle;
    private static Connection laConnexion = ControleConnexion.getLaConnectionStatique();
    private final ArrayList<Etat> lesEnrg = new ArrayList<>(); 

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
    
    
    
    public ArrayList<Etat> getLesEnrg() {
        return lesEnrg;
    }

    public String getIdEtat() {
        return idEtat;
    }

    public Etat(String idEtat, String unLibelle) {
        this.idEtat = idEtat;
        this.libelle = unLibelle;
    }
    
    public Etat() {
        LireRecup();
    }

    private void LireRecup() {
        try {
            String reqSQL = "SELECT * FROM etat";
            lesEnrg.retainAll(lesEnrg);
            Statement state = laConnexion.createStatement();  //permet d'exécuter des requêtes
            ResultSet rs = state.executeQuery(reqSQL);  //rs contient les résultats des fiches frais
            while (rs.next()) {
                String unIdEtat = rs.getString("id");
                String unLibelle = rs.getString("libelle");
                lesEnrg.add(new Etat(unIdEtat, unLibelle));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Problème rencontré : "
            + e.getMessage(), "Resultat", JOptionPane.ERROR_MESSAGE);
        }
    }
    
}
