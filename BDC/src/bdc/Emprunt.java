package bdc;

import java.io.Serializable;
import java.util.GregorianCalendar;

/**
 * Created by moran on 14/02/2017.
 */
public class Emprunt implements Serializable {

    private int numLecteur;
    private int ISBN;
    private int numExemplaire;
    private GregorianCalendar dateEmprunt;
    private GregorianCalendar dateRetour;

    public Emprunt(int numLecteur, int ISBN, int numExemplaire) {
        this.numLecteur = numLecteur;
        this.ISBN = ISBN;
        this.numExemplaire = numExemplaire;
        this.dateEmprunt = new  GregorianCalendar();
        this.dateEmprunt = new  GregorianCalendar();
    }
}
