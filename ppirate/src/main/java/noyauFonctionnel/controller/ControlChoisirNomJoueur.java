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
    
    public void setNomJoueur1(String nom) {
        jeu.setJoueur1Nom(nom);
    }
    
    public void setNomJoueur2(String nom) {
        jeu.setJoueur2Nom(nom);
    }
    
    public String getNomJoueur1() {
        return jeu.getJoueur1Nom();
    }
    
    public String getNomJoueur2() {
        return jeu.getJoueur2Nom();
    }
}
