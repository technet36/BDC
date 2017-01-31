/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdc;

import java.util.GregorianCalendar;
import java.util.*;

/**
 *
 * @author caucharb
 */
public class Etudiant {
	private String _nom;
	private HashMap<GregorianCalendar, Float> _notes;
                	
	public Etudiant(String nom) {
			_notes = new HashMap<GregorianCalendar, Float>();
                        _nom = nom;
		
		}
		
	public void nouvelleNote(GregorianCalendar d, Float n)
	{
		_notes.put (d,n );
		
	}
        
        public void afficheDateNotation()
	{
		
 System.out.print ("AFFICHER TOUTES LES DATES DE NOTATION");
        }
	
	
        public void afficheNote()
	{
System.out.print ("AFFICHER TOUTES LES NOTES DE l’ETUDIANT");		
	}
        
	public String getNom()
	{
		return _nom;
	}
 
}
