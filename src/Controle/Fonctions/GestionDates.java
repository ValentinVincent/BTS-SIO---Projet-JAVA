/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle.Fonctions;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author Valentin VINCENT
 */
public class GestionDates {
    public static String MoisAvant(String leMois) {
        String mois = "";
        switch(leMois) {
            case "01" : mois = "12"; break;
            case "02" : mois = "01"; break;  
            case "03" : mois = "02"; break; 
            case "04" : mois = "03"; break;   
            case "05" : mois = "04"; break;
            case "06" : mois = "05"; break;
            case "07" : mois = "06"; break;
            case "08" : mois = "07"; break;
            case "09" : mois = "08"; break;
            case "10" : mois = "09"; break;
            case "11" : mois = "10"; break;
            case "12" : mois = "11";    
        }
        return mois;
    }
    
    public static String dateEnChaineFR(Date laDate) {
        Locale locale = Locale.FRANCE;
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy", locale);
        String date = dateFormat.format(laDate);
        return date;
    }
    
    public static String chaineDateFRversEN (String dateFR) {
        String dateEN = "";
        String vAnneEN = dateFR.substring(6, 10);
        String vMoisEN = dateFR.substring(3, 5);
        String vJourEN = dateFR.substring(0, 2);
        dateEN = vAnneEN + "-" + vMoisEN + "-" + vJourEN;
        return dateEN;
    }
    
    public static Date dateJavaEnDateSQL(Date laDate) {
        Date dateSQL = new java.sql.Date(laDate.getTime());
        return dateSQL;
    }
    
    public static String chainedateENversFR (String dateEN) {
        String dateFR = "";
        String vJourFR = dateEN.substring(8, 10);
        String vMoisFR = dateEN.substring(5,7);
        String vAnneeFR = dateEN.substring(0, 4);
        dateFR = vJourFR + "/" + vMoisFR + "/" + vAnneeFR;
        return dateFR;
    }
    
    /**
     *
     * @param laDateChaineEN
     * @return
     * @throws ParseException
     */
    public static Date chaineENversDateJava(String laDateChaineEN) throws ParseException {
        SimpleDateFormat dateStandard = new SimpleDateFormat("yyyy-MM-dd");
        Date laDateDate = dateStandard.parse(laDateChaineEN);
        return laDateDate;
    }
    
}
