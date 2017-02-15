package bdc;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;

/**
 * Created by moran on 07/02/2017.
 */
public class Ouvrage implements Serializable{
    private String ISBN;
    private String titre;
    private ArrayList<String> auteurs;
    private String editeur;
    private GregorianCalendar dateP;
    private String target;
    private int lastNumExemplaire;
    private HashMap<Integer, Exemplaire> exemplaires;

    public Ouvrage(String ISBN, String titre) {
        this.ISBN = ISBN;
        this.titre = titre;
        this.exemplaires = new HashMap<>();
        this.lastNumExemplaire = 0;
        this.auteurs = null;
        this.editeur = null;
        this.dateP = null;
        this.target = null;
    }

    public Ouvrage(String ISBN, String titre, ArrayList<String> auteurs, String editeur, GregorianCalendar dateP, String target) {
        this.ISBN = ISBN;
        this.titre = titre;
        this.auteurs = auteurs;
        this.editeur = editeur;
        this.dateP = dateP;
        this.target = target;
    }

    public void setInfo (){

        ArrayList<String> auteurs = new ArrayList<>();
        String auteur;
        EntreesSorties.afficherMessage("Veuillez lister les auteurs (0 pour finir la list) : ");
        do {
            auteur = EntreesSorties.lireChaine();
        }while (!auteur.matches("^0$"));
        if(!auteurs.isEmpty())
            this.auteurs = auteurs;
        this.dateP  = EntreesSorties.lireDate("Veuillez saisir la date de parutionde l'ouvrage : ");
        this.target = EntreesSorties.lireChaine("Veuillez saisir le public de l'ouvrage : ");
        this.editeur = EntreesSorties.lireChaine("Veuillez saisir le nom de l'éditeur : ");

    }

    public void afficherOuvrage() {
        EntreesSorties.afficherTitre("Titre : "+titre);
        EntreesSorties.afficherMessage("ISBN : "+ISBN);
        if (auteurs!=null)
            EntreesSorties.afficherMessage("Auteurs : "+auteurs);
        if (editeur!=null)
            EntreesSorties.afficherMessage("Editeur : "+editeur);
        if (dateP!=null)
            EntreesSorties.afficherMessage("Date de parution : "+EntreesSorties.ecrireDate(dateP));
        if (target!=null)
            EntreesSorties.afficherMessage("Public : "+target);
        EntreesSorties.afficherMessage("Exemplaire : "+lastNumExemplaire);
    }

    public void newExemplaire(){
        lastNumExemplaire++;
        boolean isEmpruntable = EntreesSorties.lireChaine("Cet exemplaire est-il empruntable (Y/n)").equalsIgnoreCase("y");

        Exemplaire e = new Exemplaire(this, isEmpruntable,lastNumExemplaire);
        exemplaires.put(lastNumExemplaire,e);
    }

    public void listerExemplaires() {
        EntreesSorties.afficherTitre("Liste des exemplaires de : "+this.titre);
        if (exemplaires.isEmpty())
            EntreesSorties.afficherMessage("Il n'y a pas d'ouvrage enregistré");
        else {
            for(int num: exemplaires.keySet()){
                exemplaires.get(num).afficherExemplaire();
            }
        }
    }

    public void setExemplaires(){
        int num = EntreesSorties.lireEntier("Pour quel exemplaire voulez-vous changer son empruntabilité (num): ");
        exemplaires.get(num).toggleEmpruntability();
    }


}
