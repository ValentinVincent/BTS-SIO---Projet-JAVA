/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle.Fonctions;

import java.util.ArrayList;

/**
 *
 * @author Valentin VINCENT
 */
public class Mois {
    
    public ArrayList<String> liste() {
        ArrayList<String> laListe = new ArrayList();
        laListe.add("Janvier");
        laListe.add("Février");
        laListe.add("Mars");
        laListe.add("Avril");
        laListe.add("Mai");
        laListe.add("Juin");
        laListe.add("Juillet");
        laListe.add("Août");
        laListe.add("Septembre");
        laListe.add("Octobre");
        laListe.add("Novembre");
        laListe.add("Décembre");
        return laListe;
    }
    
    public String Nommois (String mois) {
        String str = "";
        switch(mois) {
            case "01" : str = "Janvier";break;
            case "02" : str = "Février";break;
            case "03" : str = "Mars";break;
            case "04" : str = "Avril";break;
            case "05" : str = "Mai";break;
            case "06" : str = "Juin";break;
            case "07" : str = "Juillet";break;
            case "08" : str = "Août";break;
            case "09" : str = "Septembre";break;
            case "10" : str = "Octobre";break;    
            case "11" : str = "Novembre";break;
            case "12" : str = "Décembre"; 
        }
        return str;
    }
    
    public String Nummois (String mois) {
        String str = "";
        switch(mois) {
            case "Janvier" : str = "01";break;
            case "Février" : str = "02";break;
            case "Mars" : str = "03";break;    
            case "Avril" : str = "04";break;
            case "Mai" : str = "05";break;
            case "Juin" : str = "06";break;
            case "Juillet" : str = "07";break;
            case "Août" : str = "08";break;    
            case "Septembre" : str = "09";break;
            case "Octobre" : str = "10";break;
            case "Novembre" : str = "11";break;
            case "Décembre" : str = "12";   
        }
        return str;
    }
    
}
