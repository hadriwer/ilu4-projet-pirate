/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package noyauFonctionnel.controller;

import noyauFonctionnel.entity.Jeu;
import noyauFonctionnel.entity.Joueur;

/**
 *
 * @author wer
 */
public class ControlJoueur {
    private Jeu jeu;
    
    public ControlJoueur(Jeu jeu) {
        this.jeu = jeu;
    }
    
    public Joueur.MainJoueur getMainJoueur1() {
        return jeu.getJoueur1().getMainJoueur();
    }
    
    public Joueur.MainJoueur getMainJoueur2() {
        return jeu.getJoueur2().getMainJoueur();
    }
    
    public boolean isMainJoueur1Empty() {
        return getMainJoueur1().getCartes().isEmpty();
    }
    
    public boolean isMainJoueur2Empty() {
        return getMainJoueur2().getCartes().isEmpty();
    }
}
