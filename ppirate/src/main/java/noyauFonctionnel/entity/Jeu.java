/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package noyauFonctionnel.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import noyauFonctionnel.entity.cartes.Attaque;
import noyauFonctionnel.entity.cartes.Carte;
import noyauFonctionnel.entity.cartes.Popularite;

/**
 *
 * @author wer
 */
public class Jeu {
    private static final int NOMBRE_CARTE = 0;
    private Joueur joueur1;
    private Joueur joueur2;
    private boolean tourDeJeu;
    private Pioche pioche;
    private int compteNombreJeu;
    
    // Zone de jeu
    private List<Carte> zonePopularite;
    private List<Carte> zoneAction;
    
    public Jeu() {
        pioche = new Pioche();
        joueur1 = new Joueur("Jack Sparrow", pioche.distribuer(NOMBRE_CARTE));
        joueur2 = new Joueur("Barbe Noire", pioche.distribuer(NOMBRE_CARTE));
        this.tourDeJeu = true;
        this.compteNombreJeu = 1;
        this.zoneAction = new ArrayList<>();
        this.zonePopularite = new ArrayList<>();
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
        return joueur1.giveGagnant() 
                || joueur1.givePerdant()
                || joueur2.giveGagnant()
                || joueur2.givePerdant();
    }
   
    public Joueur giveJoueurGagnant() {
        if (joueur1.giveGagnant() || joueur2.givePerdant()) {
            return joueur1;
        }
        else {
            return joueur2;
        }
    }
    
    public void jouerJeu() {
        while (giveFinPartie()) {
            System.out.println("Nombre étape de jeu : " + compteNombreJeu);
            
            Joueur playingJoueur = donnerTourDeJoueur();
            Carte piocherCarte = pioche.piocher();
            
            playingJoueur.prendreCarte(piocherCarte);
            
            
            
            changerJoueur();
            
            compteNombreJeu++;
        }
    }
    
    public List<Carte> getZoneAction() {
        return zoneAction;
    }
    
    public List<Carte> getZonePopularite() {
        return zonePopularite;
    }
    
    public Pioche getPioche() {
        return pioche;
    }
}
