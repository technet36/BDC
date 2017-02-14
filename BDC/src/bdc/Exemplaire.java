package bdc;

import java.io.Serializable;

/**
 * Created by moran on 07/02/2017.
 */
public class Exemplaire implements Serializable {
    private String ISBN;
    private int num;

    public Exemplaire(String ISBN, int num) {
        this.ISBN = ISBN;
        this.num = num;
    }
    public void afficherExemplaire(){
        EntreesSorties.afficherMessage("num : "+num);
    }
}
