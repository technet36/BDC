package bdc;

import UI.EntreesSorties;

import java.util.HashMap;
import java.io.Serializable;

/**
 * Created by moran on 07/02/2017.
 */
public class Biblio implements Serializable
{

    private static final long serialVersionUID = 262L;
    private HashMap<String, Ouvrage> ouvrages;
    private HashMap<Integer,Lecteur> lecteurs;
    private int lastNumLecteur;

    public Biblio() {
        this.ouvrages = new HashMap<String, Ouvrage>() ;
        this.lecteurs = new HashMap<>();
        this.lastNumLecteur = 0;
    }

    /**
     * appel au constructeur d'ouvrage
     * @param ISBN : n° ISBN de l'ouvrage
     * @param titre : titre de l'ouvrage
     */
    public void newOuvrage(String ISBN, String titre){
        Ouvrage o = new Ouvrage(ISBN, titre);
        ouvrages.put(ISBN,o);
    }
    public void newOuvrage(){
        String ISBN = EntreesSorties.lireChaine("Veuillez saisir le numero ISBN de l'ouvrage : ");
        String titre = EntreesSorties.lireChaine("Veuillez saisir le titre de l'ouvrage : ");
        Ouvrage o = new Ouvrage(ISBN, titre);
        ouvrages.put(ISBN,o);
    }

    /**
     * Crée un nouveau lecteur, avec un nom et un prenom
     * @param nom : nom nom du lecteur
     * @param prenom : prenom prenom du lecteur
     */
    public void newLecteur(String nom, String prenom){
        lastNumLecteur++;
        Lecteur l = new Lecteur(nom,prenom,lastNumLecteur);
        lecteurs.put(lastNumLecteur,l);
    }
    public void newLecteur(){
        String prenom = EntreesSorties.lireChaine("Veuillez saisir le prenom du lecteur : ");
        String nom = EntreesSorties.lireChaine("Veuillez saisir le nom du lecteur : ");
        lastNumLecteur++;
        Lecteur l = new Lecteur(nom,prenom,lastNumLecteur);
        lecteurs.put(lastNumLecteur,l);
    }

    /**
     * recuperre l'ouvrage pour un n° ISBN donné
     * @param ISBN : n° ISBN de l'ouvrage voulu
     * @return Ouvrage : l'ouvrage avec le n° ISBN voulu
     */
    public Ouvrage getOuvrage (String ISBN){
        return ouvrages.containsKey(ISBN)?ouvrages.get(ISBN):null;
    }
    public Ouvrage getOuvrage (){
        String ISBN = EntreesSorties.lireChaine("Veuillez saisir le numero ISBN de l'ouvrage : ");
        boolean a = ouvrages.containsKey(ISBN);
        if (a) {
            EntreesSorties.afficherMessage("Pas d'ouvrage avec cet ISBN\n error not handled sry");
        }
        return ouvrages.get(ISBN);
    }

    public Lecteur getLecteur (int num){
        return lecteurs.containsKey(num)?lecteurs.get(num):null;
    }
    public Lecteur getLecteur (){
        int num = EntreesSorties.lireEntier("Veuillez saisir le numero du lecteur : ");
        Lecteur a = lecteurs.get(num);
        if (a==null) {
            EntreesSorties.afficherMessage("Pas de lecteur avec ce numero \n error not handled sry");
        }
        return a;
    }

    public HashMap<Integer, Lecteur> getLecteurs() {
        return lecteurs;
    }

    public HashMap<String, Ouvrage> getOuvrages() {
        return ouvrages;
    }

    public void listerLecteurs(){
        if (lecteurs.isEmpty()){
            EntreesSorties.afficherMessage("Il n'y a pas de lecteur d'enregistré");
        }else {
            for(int num : lecteurs.keySet()){
                lecteurs.get(num).afficherLecteur();
            }
        }
    }

    public void listerOuvrage(){
        if (ouvrages.isEmpty()){
            EntreesSorties.afficherMessage("Il n'y a pas d'ouvrage enregistré");
        }else {
            for(String ISBN : ouvrages.keySet()){
                ouvrages.get(ISBN).afficherOuvrage();
            }
        }
    }
}
