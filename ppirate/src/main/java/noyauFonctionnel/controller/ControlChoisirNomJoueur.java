package noyauFonctionnel.controller;

import noyauFonctionnel.entity.Jeu;

/**
 *
 * @author ember
 */
public class ControlChoisirNomJoueur {
    private final Jeu jeu;
    
    public ControlChoisirNomJoueur(Jeu jeu) {
        this.jeu = jeu;
    }
    
    public void initierJoueur1(String nom) {
        jeu.instancierJoueur1(nom);
    }
    
    public void initierJoueur2(String nom) {
        jeu.instancierJoueur2(nom);
    }
}
