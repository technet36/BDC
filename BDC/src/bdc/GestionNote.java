/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdc;

	import java.util.GregorianCalendar;
	import java.util.HashSet;
	import java.util.Vector;

/**
 *
 * @author caucharb
 */
public class GestionNote {
	private Vector <Etudiant> _etudiants;
	
		
	public GestionNote () {
		_etudiants = new Vector <Etudiant> ();	
		}
		

         public void creerListeEtudiant() {
             Etudiant e; String nom;
             do {
                 nom = EntreesSorties.lireChaine ("entrer le nom ou taper fin pour arrêter la saisie : ");
                 if (! (nom.equals ("fin")))
                         { e = new Etudiant(nom);
                           _etudiants.add(e);}
             } while (!(nom.equals("fin")));
        
               }
         
         public void affecterNote() {
             Float note ;
             if (_etudiants.isEmpty())
                    EntreesSorties.afficherMessage("                   Pas d'Etudiant                    ");
                else 
                {
                GregorianCalendar dateNotation = EntreesSorties.lireDate ("saisir la date de notation : ");

System.out.println ("FAIRE UNE BOUCLE SUR _ETUDIANTS, POUR CHACUN AFFICHER SON NOM, SAISIR UNE NOTE ET DEMANDER À L’ÉTUDIANT DE METTRE À JOUR SES NOTES (faire appel à la méthode NouvelleNote() de Etudiant)");
                }
                }
         
         
	public void afficherEtudiantNote() {
                if (_etudiants.isEmpty())
                    EntreesSorties.afficherMessage("                   Pas d'Etudiant                    ");
                else 
                {
                EntreesSorties.afficherMessage(" ========================================================");
		EntreesSorties.afficherMessage("                   Notes des Etudiants                    ");
		System.out.println ();
 
System.out.print ("AFFICHE LA PREMIERE LIGNE DU TABLEAU DE NOTE. ELLE COMPORTE « ETUDIANT » SUIVI DES DIFFÉRENTES DATES DE NOTATION (appel à la méthode afficheDateNotation() de Etudiant)"); 
                System.out.println ();
                
System.out.print ("AFFICHE LES LIGNES SUIVANTES. CHAQUE LIGNE CONCERNE UN ETUDIANT :   SON NOM PUIS SES NOTES (appel à la méthode afficheNote() de Etudiant");

                System.out.println ();
                }
         }				

}
