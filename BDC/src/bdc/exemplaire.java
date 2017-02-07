package bdc;

/**
 * Created by moran on 07/02/2017.
 */
public class exemplaire {
    private String ISBN;
    private int num;


    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public exemplaire(String ISBN, int num) {
        this.ISBN = ISBN;
        this.num = num;
    }
}
