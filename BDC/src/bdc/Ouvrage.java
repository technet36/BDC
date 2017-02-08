package bdc;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;

/**
 * Created by moran on 07/02/2017.
 */
public class Ouvrage {
    private String ISBN;
    private String titre;
    private ArrayList<String> auteurs;
    private String editeur;
    private GregorianCalendar dateP;
    private String target;
    private int lastNumExemplaire;
    private HashMap<Integer,exemplaire> exemplaires;

    public Ouvrage(String ISBN, String titre) {
        this.ISBN = ISBN;
        this.titre = titre;
    }

    public void setInfo (ArrayList<String> auteurs, GregorianCalendar dateP, String target){
        if(!auteurs.isEmpty())
            this.auteurs = auteurs;
        if (dateP != null)
            this.dateP = dateP;
        if (!target.isEmpty())
            this.target = target;
    }

    public Ouvrage(String ISBN, String titre, ArrayList<String> auteurs, String editeur, GregorianCalendar dateP, String target) {
        this.ISBN = ISBN;
        this.titre = titre;
        this.auteurs = auteurs;
        this.editeur = editeur;
        this.dateP = dateP;
        this.target = target;
    }

    public void setOuvrage(String ISBN) {
        this.ISBN = ISBN;
    }

    public String afficher() {
        return "Ouvrage{" +
                "ISBN='" + ISBN + '\'' +
                ", titre='" + titre + '\'' +
                ", auteurs=" + auteurs +
                ", editeur='" + editeur + '\'' +
                ", dateP=" + dateP +
                ", target='" + target + '\'' +
                '}';
    }

    public void newExemplaire(String ISBN){
        lastNumExemplaire++;
        exemplaire e = new exemplaire(ISBN,lastNumExemplaire);
        exemplaires.put(lastNumExemplaire,e);
    }

    public String getISBN() {
        return ISBN;
    }

    public String getTitre() {
        return titre;
    }

    public ArrayList<String> getAuteurs() {
        return auteurs;
    }

    public String getEditeur() {
        return editeur;
    }

    public GregorianCalendar getDateP() {
        return dateP;
    }

    public String getTarget() {
        return target;
    }

    public int getLastNumExemplaire() {
        return lastNumExemplaire;
    }

    public HashMap<Integer, exemplaire> getExemplaires() {
        return exemplaires;
    }

}
