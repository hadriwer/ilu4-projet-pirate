/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
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
    private static final int NOMBRE_CARTE = 4;
    private final Joueur joueur1;
    private final Joueur joueur2;
    private boolean tourDeJeu;
    private final Pioche pioche;
    private int compteNombreJeu;
    
    // Zone de jeu
    private final List<Carte> zonePopularite;
    private final Stack<Carte> zoneAction;
    
    public Jeu() {
        pioche = new Pioche();
        joueur1 = new Joueur("Jack Sparrow", pioche.distribuer(NOMBRE_CARTE));
        joueur2 = new Joueur("Barbe Noire", pioche.distribuer(NOMBRE_CARTE));
        tourDeJeu = true;
        compteNombreJeu = 1;
        zonePopularite = new ArrayList<>();
        zoneAction = new Stack<>();
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
        } else if (carte instanceof Popularite) {
            zonePopularite.add(carte);
        } else {
            throw new IllegalStateException("Aucune des cartes connues");
        }
    }
    
    public boolean verifierFinPartie() {
        return joueur1.aGagne() 
                || joueur1.aPerdu()
                || joueur2.aGagne()
                || joueur2.aPerdu();
    }
   
    public Joueur giveJoueurGagnant() {
        if (joueur1.aGagne() || joueur2.aGagne()) {
            return joueur1;
        } else {
            return joueur2;
        }
    }
    
    public void jouerJeu() {
        while (!verifierFinPartie()) {
            System.out.println("Nombre étape de jeu : " + compteNombreJeu);
            
            Joueur playingJoueur = donnerTourDeJoueur();
            Carte piocherCarte = pioche.piocher();
            
            playingJoueur.prendreCarte(piocherCarte);
            
            
            
            changerJoueur();
            
            compteNombreJeu++;
        }
    }
}
