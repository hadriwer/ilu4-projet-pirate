/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.List;
import java.util.Stack;
import model.cartes.Attaque;
import model.cartes.Carte;
import model.cartes.Popularite;

/**
 *
 * @author wer
 */
public class Jeu {
    private static final int NOMBRE_CARTE = 3;
    private Joueur joueur1;
    private Joueur joueur2;
    private boolean tourDeJeu;
    private Pioche pioche;
    
    // Zone de jeu
    private List<Carte> zonePopularite;
    private Stack<Carte> zoneAction;
    
    public Jeu() {
        pioche = new Pioche();
        joueur1 = new Joueur("Jack Sparrow", pioche.distribuer(NOMBRE_CARTE));
        joueur2 = new Joueur("Barbe Noire", pioche.distribuer(NOMBRE_CARTE));
        this.tourDeJeu = true;
    }
    
    public Joueur donnerTourDeJoueur() {
        return tourDeJeu ? joueur1 : joueur2;
    }
    
    public void changerJoueur() {
        this.tourDeJeu = !tourDeJeu;
    }
    
    public void deposerCarte(Carte carte) {
        if (carte instanceof Attaque) {
            zoneAction.add(carte);
        }
        else if (carte instanceof Popularite) {
            zonePopularite.add(carte);
        }
        else {
            throw new IllegalStateException("Aucune des cartes connues");
        }
    }
    
    public boolean giveFinPartie() {
        return joueur1.giveGagnant() || joueur2.giveGagnant();
    }
   
    public Joueur giveJoueurGagnant() {
        if (joueur1.giveGagnant() || joueur2.givePerdant()) {
            return joueur1;
        }
        else {
            return joueur2;
        }
    }
}
