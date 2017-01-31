/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdc;

/**
 *
 * @author caucharb
 */
public class MenuGestionNote {
	private GestionNote _gestionNote;
	
	public MenuGestionNote (GestionNote gestionNote) {
	_gestionNote = gestionNote;
	}
	
	/*
	 * menuPrincipal permet � l'utilisateur de selectionner un cas d'utilisation, Si l'utilisateur a fini d'utiliuser le programme, il choisit l'option Quitter.
	*/
public void menuPrincipal() {
	Integer menu;
	do {
		EntreesSorties.afficherMessage(" ========================================================");
		EntreesSorties.afficherMessage("|                   Menu Principal                       |");
		EntreesSorties.afficherMessage("| Saisissez un numero correspondant :                    |");
		EntreesSorties.afficherMessage("| Créer Liste Etudiants : 1                              |");
                EntreesSorties.afficherMessage("| Affecter Notes : 2                                     |");
		EntreesSorties.afficherMessage("| Afficher Etudiant : 3                                  |");
                EntreesSorties.afficherMessage("| Quitter : 0                                            |");
		EntreesSorties.afficherMessage(" ========================================================");
		menu = EntreesSorties.lireEntier();
			
			switch (menu){
				case 1 : {
					_gestionNote.creerListeEtudiant();
					break;
				}
                                case 2 : {
					_gestionNote.affecterNote();
					break;
				}
				case 3 : {
					_gestionNote.afficherEtudiantNote();
					break;
                                }        
                                default : {
					break;
				}
			}
	} while (menu != 0);	
}
}
