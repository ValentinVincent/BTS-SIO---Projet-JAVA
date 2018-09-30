/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle.Connexion;

import java.sql.Connection;
import Entité.Parametres;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public abstract class ControleConnexion {
    static Parametres lesParametres;
    static boolean etatConnexion;
    static Connection laConnectionStatique;
    
    static {
        boolean ok = true;
        try {
            lesParametres = new Parametres();
        } catch (IOException ex) {
            Logger.getLogger(ControleConnexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        //verif du driver
        try {
            Class.forName(lesParametres.getDriverSGBD());
            etatConnexion = true;
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Classe Non Trouvée" + 
            "Pour le chargement du pilote", "ALERTE", JOptionPane.ERROR_MESSAGE);
            ok = false;
            etatConnexion = false;
        }
        if(ok) {
            String urlBD = lesParametres.getServeurBD();
            String nomUtilisateur = lesParametres.getNomUtilisateur();
            String mDP = lesParametres.getMotDePasse();
            try {
                //creation de la connexion
                laConnectionStatique = (Connection) DriverManager.getConnection(urlBD, nomUtilisateur, mDP);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Impossible de se connecter " 
                + "à la base de données", "ALERTE", JOptionPane.ERROR_MESSAGE);
                etatConnexion = false;
            }
        }
    }

    public static Parametres getLesParametres() {
        return lesParametres;
    }

    public static boolean isEtatConnexion() {
        return etatConnexion;
    }

    public static Connection getLaConnectionStatique() {
        return laConnectionStatique;
    }
    
    public static boolean control(String nom, String mdp) {
        //verif des id et mdp
        boolean verification;
        if(nom.equals(lesParametres.getNomComptable())&& mdp.equals(lesParametres.getMotPasseComptable())) {
            if(etatConnexion) {
                verification = true;
            } else {
                verification = false;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Erreur de saisie", "ERREUR", JOptionPane.ERROR_MESSAGE);
            verification = false;
        }
        return verification;
    }
    
    public static void fermetureSession(){
        try {
            laConnectionStatique.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Problème rencontré à la"
            + "déconnexion", "ERREUR", JOptionPane.ERROR_MESSAGE);
        }
    }
}
