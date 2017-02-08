package bdc;
import java.util.GregorianCalendar;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author anthony
 */
public class Lecteur {

	private String nom;
	private String prenom;
	private GregorianCalendar dateN;
	private String tel;
	private String adresse;
	private int num;


	Lecteur(String nom,String prenom,int num){
		this.nom=nom;
		this.prenom=prenom;
		this.num=num;

	}

	public void setLecteur(){
		String auteur;
		this.adresse = EntreesSorties.lireChaine("Veuillez saisir l'adresse du lecteur : ");
		this.dateN = EntreesSorties.lireDate("Veuillez saisir la date de de naissance du lecteur : ");
		this.tel = EntreesSorties.lireChaine("Veuillez saisir le numero de telephone du lecteur : ");

	}


	/*public String afficherLecteur() {
		return "Lecteur{" + "nom=" + nom + ", prenom=" + prenom + ", dateN=" + dateN + ", tel=" + tel + ", adresse=" + adresse + ", num=" + num + '}';
	}
    */

     public void afficherLecteur(){
     	EntreesSorties.afficherMessage("Num : "+num);
     	EntreesSorties.afficherMessage("Nom : "+nom);
     	EntreesSorties.afficherMessage("Prenom : "+prenom);
     	EntreesSorties.afficherMessage("Data de naissance : "+EntreesSorties.ecrireDate(dateN));
     	EntreesSorties.afficherMessage("Tel : "+tel);
     	EntreesSorties.afficherMessage("Adresse : "+adresse);

    }


}
