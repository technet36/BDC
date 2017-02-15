package bdc;


import java.util.ArrayList;
import java.util.GregorianCalendar;

public class MenuBiblio {
	private Biblio _bibliotheque;
	
	public MenuBiblio (Biblio bibliotheque) {
	_bibliotheque = bibliotheque;
	}
	
	/*
	 * menuPrincipal permet � l'utilisateur de selectionner un type de sous menu (Lecteur, Ouvrage ou Exemplaire) 
	 * o� il effectuera par la suite l'action d�sir�e. Si l'utilisateur a fini d'utiliuser le programme, il choisit l'option Quitter.
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

	/* menuLect permet d'effectuer une s�rie d'action concernant les utilisateur (lecteurs) de la biblioth�que.
	 * Une fois une action effectu�e, l'utilisateur sera rediriger vers ce m�me menu afin de pouvoir selectionner
	 * une nouvelle fois une action concernant les lecteurs.
	 * "Retour Menu Principal" renvoi l'utilisateur au menu principal.
	*/
public void menuLecteur() {
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
					_bibliotheque.newLecteur();
					break;
				}
				case 2 : {
					_bibliotheque.getLecteur().afficherLecteur();
					break;
				}
				case 3 : {
					_bibliotheque.getLecteur().setLecteur();

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


public void menuOuvrage() {
		Integer menuOuvr;
		do {
			EntreesSorties.afficherMessage(" ========================================================");
			EntreesSorties.afficherMessage("| Saisissez un numero correspondant :                    |");
			EntreesSorties.afficherMessage("| Nouvel ouvrage : 1                                     |");
			EntreesSorties.afficherMessage("| Choisir ouvrage: 2                                   |");
			EntreesSorties.afficherMessage("| Modifier ouvrage: 3                                    |");
			EntreesSorties.afficherMessage("| Lister ouvrages: 4                                     |");
			EntreesSorties.afficherMessage("| Nouvel exemplaire: 5                                   |");
			EntreesSorties.afficherMessage("| modifier exemplaire: 6                                 |");
			EntreesSorties.afficherMessage("| Lister exemplaires: 7                                  |");
			EntreesSorties.afficherMessage("| Retour Menu Principal : 0                              |");
			EntreesSorties.afficherMessage(" ========================================================");
			menuOuvr = EntreesSorties.lireEntier();

			switch (menuOuvr){
				case 1 : {
					_bibliotheque.newOuvrage();
					break;
				}
				case 2 : {
					_bibliotheque.getOuvrage().afficherOuvrage();
					break;
				}
				case 3 : {
					_bibliotheque.getOuvrage().setInfo();
					break;
				}
				case 4 : {
					_bibliotheque.listerOuvrage();
					break;
				}
				case 5 : {
					_bibliotheque.getOuvrage().newExemplaire();
					break;
				}
				case 6 : {
					_bibliotheque.getOuvrage().setExemplaires();
					break;
				}
				case 7 : {
					_bibliotheque.getOuvrage().listerExemplaires();
				}
				default : {
					break;
				}
			}
		} while (menuOuvr != 0);
	}

	public void menuLivre(String ISBN){
		Integer menuLivre;
		do {
			EntreesSorties.afficherMessage(" ========================================================");
			EntreesSorties.afficherMessage("| Saisissez un numero correspondant :                    |");
			EntreesSorties.afficherMessage("| Modifier ouvrage: 3                                    |");
			EntreesSorties.afficherMessage("| Lister ouvrages: 4                                     |");
			EntreesSorties.afficherMessage("| Nouvel exemplaire: 5                                   |");
			EntreesSorties.afficherMessage("| modifier exemplaire: 6                                 |");
			EntreesSorties.afficherMessage("| Lister exemplaires: 7                                  |");
			EntreesSorties.afficherMessage("| Retour Menu Principal : 0                              |");
			EntreesSorties.afficherMessage(" ========================================================");
			menuLivre = EntreesSorties.lireEntier();

			switch (menuLivre){
				case 3 : {
					_bibliotheque.getOuvrage().setInfo();
					break;
				}
				case 4 : {
					_bibliotheque.listerOuvrage();
					break;
				}
				case 5 : {
					_bibliotheque.getOuvrage().newExemplaire();
					break;
				}
				case 6 : {
					_bibliotheque.getOuvrage().setExemplaires();
					break;
				}
				case 7 : {
					_bibliotheque.getOuvrage().listerExemplaires();
				}
				default : {
					break;
				}
			}
		} while (menuOuvr != 0);
	}
}

