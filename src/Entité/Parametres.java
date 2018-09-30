/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entité;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author DELL
 */

public class Parametres {
    private String nomUtilisateur;
    private String motDePasse;
    private String serveurBD;
    private String driverSGBD;
    private String nomComptable;
    private String motPasseComptable;
    private String nomAdmin;
    private String motPasseAdmin;
    private String adresseIPserveur;
    private String nomBD;

    public String getNomBD() {
        return nomBD;
    }

    public void setNomBD(String nomBD) {
        this.nomBD = nomBD;
    }
    

    public String getAdresseIPserveur() {
        return adresseIPserveur;
    }

    public void setAdresseIPserveur(String adresseIPserveur) {
        this.adresseIPserveur = adresseIPserveur;
    }

    public String getNomAdmin() {
        return nomAdmin;
    }

    public void setNomAdmin(String nomAdmin) {
        this.nomAdmin = nomAdmin;
    }

    public String getMotPasseAdmin() {
        return motPasseAdmin;
    }

    public void setMotPasseAdmin(String motPasseAdmin) {
        this.motPasseAdmin = motPasseAdmin;
    }

    // constructeur, on laisse tous ca, le reste est dans le lire fichier en bas
    public Parametres() throws IOException {
        
        driverSGBD = "org.gjt.mm.mysql.Driver";
        LireFichier();
    }

    public String getNomUtilisateur() {
        return nomUtilisateur;
    }

    public void setNomUtilisateur(String nomUtilisateur) {
        this.nomUtilisateur = nomUtilisateur;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public String getServeurBD() {
        return serveurBD;
    }

    public void setServeurBD(String serveurBD) {
        this.serveurBD = serveurBD;
    }

    public String getDriverSGBD() {
        return driverSGBD;
    }

    public void setDriverSGBD(String driverSGBD) {
        this.driverSGBD = driverSGBD;
    }

    public String getNomComptable() {
        return nomComptable;
    }

    public void setNomComptable(String nomComptable) {
        this.nomComptable = nomComptable;
    }

    public String getMotPasseComptable() {
        return motPasseComptable;
    }

    public void setMotPasseComptable(String motPasseComptable) {
        this.motPasseComptable = motPasseComptable;
    }
    
    // look le fichier avec le bon chemin et si il existe aps il le fait tout seul 
    public File cheminFichier() throws IOException{
        String repertoire = System.getProperty("user.dir");
        repertoire= repertoire + "/reseau/";
        File fichierIP = new File(repertoire + "parametre.txt");
        if(!fichierIP.exists()){
            fichierIP.createNewFile();
        }
        return fichierIP;
    }
        
        // lis le fichier et enregistre dans les trucs
    public void LireFichier() throws IOException{
        File fichierIP = cheminFichier();
        String lesParametres = "jdbc:mysql://";
        try ( BufferedReader entree = new BufferedReader(new FileReader(fichierIP))) { // enregistre la lecture dans le buffer ( mémoire temporaire)
            for ( int i=0;i<6;i++) {// li les lignes du fichier ( les 5 lignes)
                switch(i){ 
                    case 0 :
                            adresseIPserveur = entree.readLine();
                            lesParametres = lesParametres + adresseIPserveur;
                    break;
                    case 1:
                            nomBD = entree.readLine();
                            lesParametres = lesParametres + "/" +nomBD;
                            serveurBD = lesParametres;
                    break;
                    case 2 :
                            nomUtilisateur = entree.readLine();
                            break;
                    case 3: motDePasse = entree.readLine();
                            break;
                    case 4: nomComptable = entree.readLine();
                            break;
                    case 5: motPasseComptable = entree.readLine();
                            break;
                }
        }
    }
    }
    
    
    
    
    
}


