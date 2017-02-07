package bdc;

import java.util.ArrayList;
import java.util.GregorianCalendar;

/**
 * Created by moran on 07/02/2017.
 */
public class ouvrage {
    private String ISBN;
    private String titre;
    private ArrayList<String> auteurs;
    private String editeur;
    private GregorianCalendar dateP;
    private String target;

    public ouvrage(String ISBN, String titre, ArrayList<String> auteurs, String editeur, GregorianCalendar dateP, String target) {
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
        return "ouvrage{" +
                "ISBN='" + ISBN + '\'' +
                ", titre='" + titre + '\'' +
                ", auteurs=" + auteurs +
                ", editeur='" + editeur + '\'' +
                ", dateP=" + dateP +
                ", target='" + target + '\'' +
                '}';
    }
}
