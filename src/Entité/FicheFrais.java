package Entité;

import Controle.Connexion.ControleConnexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Valentin VINCENT
 */
public class FicheFrais {

    private String idVisiteur;
    private String nomVisiteur;
    private String prenomVisiteur;
    private String mois;
    private int nbJustif;
    private double montantValide;
    private Date dateModif;
    private String idEtat;
    private static Connection laConnexion = ControleConnexion.getLaConnectionStatique();
    private final ArrayList<FicheFrais> lesEnrg = new ArrayList<>();

    public String getIdVisiteur() {
        return idVisiteur;
    }

    public void setIdVisiteur(String idVisiteur) {
        this.idVisiteur = idVisiteur;
    }

    public String getNomVisiteur() {
        return nomVisiteur;
    }

    public void setNomVisiteur(String nomVisiteur) {
        this.nomVisiteur = nomVisiteur;
    }

    public String getPrenomVisiteur() {
        return prenomVisiteur;
    }

    public void setPrenomVisiteur(String prenomVisiteur) {
        this.prenomVisiteur = prenomVisiteur;
    }

    public String getMois() {
        return mois;
    }

    public void setMois(String mois) {
        this.mois = mois;
    }

    public int getNbJustif() {
        return nbJustif;
    }

    public void setNbJustif(int nbJustif) {
        this.nbJustif = nbJustif;
    }

    public double getMontantValide() {
        return montantValide;
    }

    public void setMontantValide(double montantValide) {
        this.montantValide = montantValide;
    }

    public Date getDateModif() {
        return dateModif;
    }

    public void setDateModif(Date dateModif) {
        this.dateModif = dateModif;
    }

    public String getIdEtat() {
        return idEtat;
    }

    public void setIdEtat(String idEtat) {
        this.idEtat = idEtat;
    }

    public ArrayList<FicheFrais> getLesEnrg() {
        return lesEnrg;
    }

    public FicheFrais(String idVisiteur, String nomVisiteur, String prenomVisiteur, String mois, int nbJustif, double montantValide, Date dateModif, String idEtat) {
        this.idVisiteur = idVisiteur;
        this.nomVisiteur = nomVisiteur;
        this.prenomVisiteur = prenomVisiteur;
        this.mois = mois;
        this.nbJustif = nbJustif;
        this.montantValide = montantValide;
        this.dateModif = dateModif;
        this.idEtat = idEtat;
    }

    //on va chercher les fiche frais voulus dans la bdd et les ajouter à LesEnrg lorsque c'est le cas
    private void LireRecup(String vCode, String vVisiteur, String vMois) {
        try {
            if (vCode.equals("")) {
                vCode = "%";
            }
            if (vVisiteur.equals("")) {
                vVisiteur = "%";
            }
            if (vMois.equals("")) {
                vMois = "%";
            }
            String reqSQL = "SELECT * FROM fichefrais join visiteur "
                    + "on (idVisiteur=id) WHERE idEtat like '" + vCode
                    + "' and idVisiteur like '" + vVisiteur + "' and mois like '" + vMois + "'";
            lesEnrg.retainAll(lesEnrg);
            Statement state = laConnexion.createStatement();  //permet d'exécuter des requêtes
            ResultSet rs = state.executeQuery(reqSQL);  //rs contient les résultats des fiches frais
            while (rs.next()) {
                String unIdVisiteur = rs.getString("id");
                String unMois = rs.getString("mois");
                String unNomVisiteur = rs.getString("nom");
                String unPrenomVisiteur = rs.getString("prenom");
                int unNbJustif = rs.getInt("nbJustificatifs");
                double unMontantValide = rs.getDouble("montantValide");
                Date uneDateModif = rs.getDate("dateModif");
                String unIdEtat = rs.getString("idEtat");
                lesEnrg.add(new FicheFrais(unIdVisiteur, unNomVisiteur, unPrenomVisiteur, unMois, unNbJustif, unMontantValide, uneDateModif, unIdEtat));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Problème rencontré : "
            + e.getMessage(), "Resultat", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public FicheFrais (String vCode) {
        LireRecup (vCode, "", "");
    }
    
    public FicheFrais (String vCode, String idVisiteur) {
        LireRecup(vCode, idVisiteur, "");
    }
    
    public FicheFrais (String vCode, String idVisiteur, String umois) {
        LireRecup(vCode, idVisiteur, umois);
    }
    
    public boolean Modifier (String leIdVisiteur, String leMois, Date laDate, String leEtat) {
        boolean bModif = false;
        try {
            String requete = "UPDATE fichefrais set dateModif = ?, idEtat = ?"
            + "WHERE idVisiteur = ? and mois = ?";
            PreparedStatement prepare = laConnexion.prepareStatement(requete);
            prepare.setString(1, String.valueOf(laDate));
            prepare.setString(2, leEtat);
            prepare.setString(3, leIdVisiteur);
            prepare.setString(4, leMois);
            prepare.executeUpdate();
            prepare.close();
            bModif = true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Modification non effectuée : "
            + ex.getMessage(), "Problème rencontré", JOptionPane.ERROR_MESSAGE);
        }
        return bModif;
    }
    
    // La fameuse fonction Modifier utilisée dans "FenVisualiserFiche"
    public boolean Modifier (String leIdVisiteur, String leMois, int nbJustif, double montantValide, Date dateModif, String leIdEtat) {
        boolean bModif = false;
        try {
            String requete = "UPDATE fichefrais set nbJustificatifs = ?, montantValide = ?, "
            + "dateModif = ?, idEtat = ? WHERE idVisiteur = ? and mois = ?";
            PreparedStatement prepare = laConnexion.prepareStatement(requete);
            prepare.setInt(1, nbJustif);
            prepare.setDouble(2, montantValide);
            prepare.setString(3, String.valueOf(dateModif));
            prepare.setString(4, leIdEtat);
            prepare.setString(5, leIdVisiteur);
            prepare.setString(6, leMois);
            prepare.executeUpdate();
            prepare.close();
            bModif = true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Modification non effectuée : "
            + ex.getMessage(), "Problème rencontré", JOptionPane.ERROR_MESSAGE);
        }
        return bModif;
    }
    
    public boolean Modifier (String unMois, String unIdEtat) {
        boolean bModif = false;
        //mes modifs
        Calendar cale = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateJ = (sdf.format(cale.getTime()));
        //fin modifs
        String requete = "UPDATE fichefrais set idEtat = ?, dateModif = ? WHERE mois = ?";
        PreparedStatement prepare;
        try {
            prepare = laConnexion.prepareStatement(requete);
            prepare.setString(1, unIdEtat);
            prepare.setString(2, dateJ);
            prepare.setString(3, unMois);
            
            prepare.executeUpdate();
            prepare.close();
            bModif = true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Modification non effectuée : "
            + ex.getMessage(), "Problème rencontré", JOptionPane.ERROR_MESSAGE);
        }
        return bModif;
    }
    
     public boolean Modifier (String unMois, String unIdEtat, String unId) {
        boolean bModif = false;
        //mes modifs
        Calendar cale = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateJ = (sdf.format(cale.getTime()));
        //fin modifs
        String requete = "UPDATE fichefrais set idEtat = ?, dateModif = ? WHERE mois = ? and idVisiteur = ?";
        PreparedStatement prepare;
        try {
            prepare = laConnexion.prepareStatement(requete);
            prepare.setString(1, unIdEtat);
            prepare.setString(2, dateJ);
            prepare.setString(3, unMois);
            prepare.setString(4, unId);
            
            prepare.executeUpdate();
            prepare.close();
            bModif = true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Modification non effectuée : "
            + ex.getMessage(), "Problème rencontré", JOptionPane.ERROR_MESSAGE);
        }
        return bModif;
    }
    
    public boolean Generer(String unMois) {
        boolean bGenerer = false;
        Statement state;
        try {
            state = laConnexion.createStatement();
            ResultSet rs = state.executeQuery("SELECT * FROM visiteur");
            while (rs.next()) {
                String unIdVisiteur = rs.getString("id");
                String req = "INSERT into fichefrais VALUES(?,?,?,?,?,?)";
                PreparedStatement prepare = laConnexion.prepareStatement(req);
                prepare.setString(1, unIdVisiteur);
                prepare.setString(2, unMois);
                prepare.setInt(3, 0);
                prepare.setDouble(4, 0.0);
                prepare.setDate(5, null);
                prepare.setString(6, "CR");
                prepare.executeUpdate();
                prepare.close();
                bGenerer = true;
            }  
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Modification non effectuée : "
            + ex.getMessage(), "Problème rencontré", JOptionPane.ERROR_MESSAGE);
        }
        return bGenerer;
    }
    
    public boolean Supprimer (String unMois) {
        boolean bSupprimer = false;
        Statement state;
        try {
            state = laConnexion.createStatement();
            String req = "DELETE FROM fichefrais WHERE mois = '"+unMois + "'";
            PreparedStatement prepare = laConnexion.prepareStatement(req);
            prepare.executeUpdate();
            prepare.close();
            bSupprimer = true;
        } catch (SQLException ex) {
            Logger.getLogger(FicheFrais.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bSupprimer;
    }
    
    
    
}
