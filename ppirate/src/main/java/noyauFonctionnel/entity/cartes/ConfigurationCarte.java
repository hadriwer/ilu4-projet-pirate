/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.cartes;

import noyauFonctionnel.entity.cartes.Carte;

/**
 *
 * @author ember
 */

public class ConfigurationCarte {
	
	private int nbExemplaires;
	private Carte carte;

	public ConfigurationCarte(Carte carte, int nbExemplaires) {
		this.carte = carte;
		this.nbExemplaires = nbExemplaires;
	}

	public Carte getCarte() {
		return carte;
	}

	public int getNbExemplaires() {
		return nbExemplaires;
	}


}

