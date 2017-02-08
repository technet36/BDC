package bdc;

/**
 * Created by moran on 07/02/2017.
 */
public class Exemplaire {
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
