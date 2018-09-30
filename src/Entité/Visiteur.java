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
public class Visiteur {
    
    private String idVisiteur;
    private String nom;
    private String prenom;
    private static Connection laConnexion = ControleConnexion.getLaConnectionStatique();
    private final ArrayList<Visiteur> lesEnrg = new ArrayList<>(); 

    public ArrayList<Visiteur> getLesEnrg() {
        return lesEnrg;
    }
    
    

    public String getIdVisiteur() {
        return idVisiteur;
    }

    public void setIdVisiteur(String idVisiteur) {
        this.idVisiteur = idVisiteur;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Visiteur(String idVisiteur, String nom, String prenom) {
        this.idVisiteur = idVisiteur;
        this.nom = nom;
        this.prenom = prenom;
    }

    public Visiteur() {
        LireRecup();
    }

    private void LireRecup() {
        try {
            String reqSQL = "SELECT * FROM visiteur ";
            lesEnrg.retainAll(lesEnrg);
            Statement state = laConnexion.createStatement();  //permet d'exécuter des requêtes
            ResultSet rs = state.executeQuery(reqSQL);  //rs contient les résultats des fiches frais
            while (rs.next()) {
                String unIdVisiteur = rs.getString("id");
                String unNomVisiteur = rs.getString("nom");
                String unPrenomVisiteur = rs.getString("prenom");
                lesEnrg.add(new Visiteur(unIdVisiteur, unNomVisiteur, unPrenomVisiteur));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Problème rencontré : "
            + e.getMessage(), "Resultat", JOptionPane.ERROR_MESSAGE);
        }
    }
    
}
