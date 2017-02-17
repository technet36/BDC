package bdc;

import UI.EntreesSorties;

import java.io.Serializable;
import java.util.GregorianCalendar;

/**
 * Created by moran on 07/02/2017.
 */
public class Exemplaire implements Serializable {
    private boolean empruntable;
    private GregorianCalendar dateE;
    private int num;
    private Ouvrage monOuvrage;

    public Exemplaire(Ouvrage monOuvrage, boolean i, int num) {
        this.empruntable = i;
        this.num = num;
        this.dateE = new GregorianCalendar();
        this.monOuvrage = monOuvrage;
    }
    public void afficherExemplaire(){
        EntreesSorties.afficherMessage("num : "+num);
        EntreesSorties.afficherMessage("empruntable : "+empruntable);
        EntreesSorties.afficherMessage(EntreesSorties.ecrireDate(dateE));
    }
    public void toggleEmpruntability(){
        this.empruntable = !this.empruntable;
    }
}
