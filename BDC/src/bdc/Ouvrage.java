package bdc;

import UI.EntreesSorties;

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

    /**
     * Constructeur complet de la class ouvrage
     * @param ISBN : n° ISBN de l'ouvrage à créer (String)
     * @param titre : titre de l'ouvrage à créer (String)
     * @param auteurs : ArrayList<String> des auteurs
     * @param editeur : éditeur de l'ouvrage (string)
     * @param dateP : date de parution de l'ouvrage (GregorianCalendar)
     * @param target : public ciblé par l'ouvrage (String)
     */
    public Ouvrage(String ISBN, String titre, ArrayList<String> auteurs, String editeur, GregorianCalendar dateP, String target) {
        this.ISBN = ISBN;
        this.titre = titre;
        this.auteurs = auteurs;
        this.editeur = editeur;
        this.dateP = dateP;
        this.target = target;
    }

    /**
     * Permet de modifier les attributs d'un ouvrage
     * @param auteurs : l'auteur de l'ouvrage (ArrayList)
     * @param editeur : éditeur de l'ouvrage
     * @param dateP : date de parution de l'ouvrage (GregorianCalendar)
     * @param target : public ciblé par l'ouvrage
     */
    public void setInfo (ArrayList<String> auteurs, String editeur, GregorianCalendar dateP, String target) {
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

    /**
     * Crée un nouvel exemplaire
     * @param isEmpruntable : isEmpruntable état du livre (boolean)
     */
    public void newExemplaire (boolean isEmpruntable){
        lastNumExemplaire++;
        Exemplaire e = new Exemplaire(this, isEmpruntable,lastNumExemplaire);
        exemplaires.put(lastNumExemplaire,e);
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

    /**
     * Change l'état de boolean empruntable de l'exemplaire
     * @param numExememplaire : n° de l'exemplaire
     */
    public void setExemplaires(int numExememplaire) {
        exemplaires.get(numExememplaire).toggleEmpruntability();
    }
    public void setExemplaires(){
        int num = EntreesSorties.lireEntier("Pour quel exemplaire voulez-vous changer son empruntabilité (num): ");
        exemplaires.get(num).toggleEmpruntability();
    }

    public String getISBN() {
        return ISBN;
    }

    public String getTitre() {
        return titre;
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

    public int getNbExemplaires() {
        return exemplaires.size();
    }
}
