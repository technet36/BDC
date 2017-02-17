package bdc;

import UI.EntreesSorties;
import UI.Fenetre;
import UI.MenuBiblio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class Main {
	
	public Main(boolean isGUI) {
		boolean GUI = isGUI;

		Biblio bibliotheque = new Biblio();
		
		String nomFich="save.ser";
		
		/*---------------------------------------------------------------------------------------------
		 * Récupération des serialisation précédentes dans le fichier du nom de "save.ser".
		 * L'utilisateur est informé de la réussite ou non de la récupération des données.
		*/
		try {
			FileInputStream fichier = new FileInputStream(nomFich);
			ObjectInputStream in = new ObjectInputStream(fichier);

			bibliotheque = (Biblio) in.readObject();
			
			fichier.close();
			in.close();

			EntreesSorties.afficherMessage(" $$$ Restauration du fichier " + nomFich + " realisee");
		} catch (Exception e) {
			EntreesSorties.afficherMessage(" *** Start : Pbs de Restauration / fichier " + nomFich);
			EntreesSorties.afficherMessage(e.getMessage());
		}
		//----------------------------------------------------------------------------------------------

		if (GUI) {
			Fenetre maFenetre = new Fenetre(bibliotheque);
		}else{
			MenuBiblio menu = new MenuBiblio(bibliotheque);
			menu.menuPrincipal();
		}

		/*---------------------------------------------------------------------------------------------
		 * Sériaisation dans le fichier du nom de "save.ser".
		 * L'utilisateur est informé de la réussite ou non de la sauvegarde des données.
		*/
		try {
			FileOutputStream f = new FileOutputStream(nomFich);
			ObjectOutputStream out = new ObjectOutputStream(f);

			out.writeObject(bibliotheque);

			EntreesSorties.afficherMessage(" $$$ Sauvegarde dans le fichier " + nomFich + " realisee");
			
			out.close();
			f.close();
		} catch (Exception e) {
			EntreesSorties.afficherMessage(" *** Start :Pbs de Sauvegarde dans le fichier " + nomFich);
			EntreesSorties.afficherMessage(e.getMessage());
		}
	}
	
	public static void main(String args[]){
		//new Main(args[0].equalsIgnoreCase("true"));
		new Main(false);
	}
}
