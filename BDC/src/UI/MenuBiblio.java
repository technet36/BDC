package UI;


import bdc.Biblio;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class MenuBiblio {
	private Biblio _bibliotheque;
	
	public MenuBiblio (Biblio bibliotheque) {
	_bibliotheque = bibliotheque;
	}
	
	/**
	 * menuPrincipal permet à l'utilisateur de selectionner un type de sous menu (LecteurButton, Ouvrage ou Exemplaire)
	 * où il effectuera par la suite l'action désirée. Si l'utilisateur a fini d'utiliuser le programme, il choisit l'option Quitter.
	*/
	public void menuPrincipal() {
	Integer menu;
	do {
		EntreesSorties.afficherMessage(" ========================================================");
		EntreesSorties.afficherMessage("|                   Menu Principal                       |");
		EntreesSorties.afficherMessage("| Saisissez un numero correspondant :                    |");
		EntreesSorties.afficherMessage("| Menu Lecteur : 1                                       |");
		EntreesSorties.afficherMessage("| Menu ouvrage : 2                                       |");
		EntreesSorties.afficherMessage("| Quitter : 0                                            |");
		EntreesSorties.afficherMessage(" ========================================================");
		menu = EntreesSorties.lireEntier();
			
			switch (menu){
				case 1 : {
					this.menuLecteur();
					break;
				}
				case 2 : {
					this.menuOuvrage();
					break;
				}
				
				default : {
					break;
				}
			}
	} while (menu != 0);	
}

	/**
	 *  menuLect permet d'effectuer une série d'action concernant les utilisateur (lecteurs) de la biblioth�que.
	 * Une fois une action effectuée, l'utilisateur sera rediriger vers ce même menu afin de pouvoir selectionner
	 * une nouvelle fois une action concernant les lecteurs.
	 * "Retour Menu Principal" renvoi l'utilisateur au menu principal.
	*/
	private void menuLecteur() {
	Integer menuLect;
	do {
		EntreesSorties.afficherMessage(" ========================================================");
		EntreesSorties.afficherMessage("| Saisissez un numero correspondant :                    |");
		EntreesSorties.afficherMessage("| Nouveau Lecteur : 1                                    |");
		EntreesSorties.afficherMessage("| Consulter Lecteur : 2                                  |");
		EntreesSorties.afficherMessage("| modifier Lecteur : 3                                   |");
		EntreesSorties.afficherMessage("| Lister Lecteur : 4                                     |");
		EntreesSorties.afficherMessage("| Retour Menu Principal : 0                              |");
		EntreesSorties.afficherMessage(" ========================================================");
		menuLect = EntreesSorties.lireEntier();
			
			switch (menuLect){
				case 1 : {

					String prenom = EntreesSorties.lireChaine("Veuillez saisir le prenom du lecteur : ");
					String nom = EntreesSorties.lireChaine("Veuillez saisir le nom du lecteur : ");
					_bibliotheque.newLecteur(nom,prenom);
					break;
				}
				case 2 : {
					int num = EntreesSorties.lireEntier("Veuillez saisir le numero du lecteur : ");
					if (_bibliotheque.getLecteur(num)==null) {
						EntreesSorties.afficherMessage("Pas de lecteur avec ce numero \n error not handled sry");
					}
					_bibliotheque.getLecteur(num).afficherLecteur();
					break;
				}
				case 3 : {
					int num = EntreesSorties.lireEntier("Veuillez saisir le numero du lecteur : ");
					if (_bibliotheque.getLecteur(num)==null) {
						EntreesSorties.afficherMessage("Pas de lecteur avec ce numero \n error not handled sry");
					}

					String adresse = EntreesSorties.lireChaine("Veuillez saisir l'adresse du lecteur : ");
					GregorianCalendar dateN = EntreesSorties.lireDate("Veuillez saisir la date de de naissance du lecteur : ");
					String tel = EntreesSorties.lireChaine("Veuillez saisir le numero de telephone du lecteur : ");
					_bibliotheque.getLecteur(num).setLecteur(adresse, dateN, tel);

					break;
				}
				case 4 : {
					_bibliotheque.listerLecteurs();
					break;
				}
				default : {
					break;
				}
			}
	} while (menuLect != 0);	
}


	private void menuOuvrage() {
		Integer menuOuvr;
		do {
			EntreesSorties.afficherMessage(" ========================================================");
			EntreesSorties.afficherMessage("| Saisissez un numero correspondant :                    |");
			EntreesSorties.afficherMessage("| Nouvel ouvrage : 1                                     |");
			EntreesSorties.afficherMessage("| Choisir ouvrage: 2                                     |");
			EntreesSorties.afficherMessage("| Lister ouvrages: 3                                     |");
			EntreesSorties.afficherMessage("| Retour Menu Principal : 0                              |");
			EntreesSorties.afficherMessage(" ========================================================");
			menuOuvr = EntreesSorties.lireEntier();

			switch (menuOuvr){
				case 1 : {

					String ISBN = EntreesSorties.lireChaine("Veuillez saisir le numero ISBN de l'ouvrage : ");
					String titre = EntreesSorties.lireChaine("Veuillez saisir le titre de l'ouvrage : ");
					_bibliotheque.newOuvrage(ISBN,titre);
					break;
				}
				case 2 : {
					String ISBN = EntreesSorties.lireChaine("Veuillez saisir le numero ISBN de l'ouvrage : ");
					if (_bibliotheque.getOuvrage(ISBN)==null) {
						EntreesSorties.afficherMessage("Pas d'ouvrage avec cet ISBN\n error not handled sry");
					}else {
						_bibliotheque.getOuvrage(ISBN).afficherOuvrage();
						this.menuLivre(ISBN);
					}
					break;
				}
				case 3 : {
					_bibliotheque.listerOuvrage();
					break;
				}
				default : {
					break;
				}
			}
		} while (menuOuvr != 0);
	}

	private void menuLivre(String ISBN){
		Integer menuLivre;
		do {
			EntreesSorties.afficherMessage(" ========================================================");
			EntreesSorties.afficherMessage("| Saisissez un numero correspondant :                    |");
			EntreesSorties.afficherMessage("| afficher l'ouvrage: 1                                  |");
			EntreesSorties.afficherMessage("| Modifier l'ouvrage: 2                                  |");
			EntreesSorties.afficherMessage("| Nouvel exemplaire: 3                                   |");
			EntreesSorties.afficherMessage("| modifier exemplaire: 4                                 |");
			EntreesSorties.afficherMessage("| Lister exemplaires: 5                                  |");
			EntreesSorties.afficherMessage("| Retour Menu Principal : 0                              |");
			EntreesSorties.afficherMessage(" ========================================================");
			menuLivre = EntreesSorties.lireEntier();

			switch (menuLivre){
				case 1 : {
					_bibliotheque.getOuvrage(ISBN).afficherOuvrage();
					break;
				}
				case 2 : {
					ArrayList<String> auteurs = new ArrayList<>();
					String auteur;
					EntreesSorties.afficherMessage("Veuillez lister les auteurs (0 pour finir la list) : ");
					boolean test = true;
					while (test){
						auteur = EntreesSorties.lireChaine();
						if(!auteur.matches("^0$")){
							auteurs.add(auteur);
						}
						else test = false;
					}
					GregorianCalendar dateP  = EntreesSorties.lireDate("Veuillez saisir la date de parutionde l'ouvrage : ");
					String target = EntreesSorties.lireChaine("Veuillez saisir le public de l'ouvrage : ");
					String editeur = EntreesSorties.lireChaine("Veuillez saisir le nom de l'éditeur : ");

					_bibliotheque.getOuvrage(ISBN).setInfo(auteurs,editeur,dateP,target);
					break;
				}
				case 3 : {
					boolean isEmpruntable = EntreesSorties.lireChaine("Cet exemplaire est-il empruntable (Y/n)").equalsIgnoreCase("y");
					_bibliotheque.getOuvrage(ISBN).newExemplaire(isEmpruntable);
					break;
				}
				case 4 : {
					int num = EntreesSorties.lireEntier("Pour quel exemplaire voulez-vous changer son empruntabilité (num): ");
					_bibliotheque.getOuvrage(ISBN).setExemplaires(num);
				}
				case 5 : {
					_bibliotheque.getOuvrage(ISBN).listerExemplaires();
				}
				default : {
					break;
				}
			}
		} while (menuLivre != 0);
	}
}

