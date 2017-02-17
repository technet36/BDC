package bdc;
import UI.EntreesSorties;

import java.io.Serializable;
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
public class Lecteur implements Serializable{

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

	/**
	 * modifie les attribut du lecteur
	 * @param adresse : adresse du domicile du lecteur
	 * @param dateN : date de naissance du lecteur (GregorianCalendar)
	 * @param tel : n° de téléphone du lecteur
	 */
	public void setLecteur(String adresse, GregorianCalendar dateN, String tel){
		this.adresse = adresse;
		this.dateN = dateN;
		this.tel = tel;
	}
	public void setLecteur(){
		this.adresse = EntreesSorties.lireChaine("Veuillez saisir l'adresse du lecteur : ");
		this.dateN = EntreesSorties.lireDate("Veuillez saisir la date de de naissance du lecteur : ");
		this.tel = EntreesSorties.lireChaine("Veuillez saisir le numero de telephone du lecteur : ");
	}


	/*public String afficherLecteur() {
		return "LecteurButton{" + "nom=" + nom + ", prenom=" + prenom + ", dateN=" + dateN + ", tel=" + tel + ", adresse=" + adresse + ", num=" + num + '}';
	}
    */

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public int getNum() {
		return num;
	}

	public GregorianCalendar getDateN() {
		return dateN;
	}

	public String getTel() {
		return tel;
	}

	public String getAdresse() {
		return adresse;
	}

	public void afficherLecteur(){
     	EntreesSorties.afficherMessage("Num : "+num);
     	EntreesSorties.afficherMessage("Nom : "+nom);
     	EntreesSorties.afficherMessage("Prenom : "+prenom);
     	EntreesSorties.afficherMessage("Data de naissance : "+EntreesSorties.ecrireDate(dateN));
     	EntreesSorties.afficherMessage("Tel : "+tel);
     	EntreesSorties.afficherMessage("Adresse : "+adresse);

    }


}
