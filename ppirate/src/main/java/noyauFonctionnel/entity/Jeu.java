/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package noyauFonctionnel.entity;

import java.util.ArrayList;
import java.util.List;
import noyauFonctionnel.entity.cartes.Attaque;
import noyauFonctionnel.entity.cartes.Carte;
import noyauFonctionnel.entity.cartes.Popularite;

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
    private final List<Carte> zoneAction;
    
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
        if (joueur1.aGagne() || joueur2.aPerdu()) {
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
    
    public List<Carte> getZoneAction() {
        return zoneAction;
    }
    
    public List<Carte> getZonePopularite() {
        return zonePopularite;
    }
    
    public Pioche getPioche() {
        return pioche;
    }
    
    public Joueur getJoueur1() {
        return joueur1;
    }
    
    public Joueur getJoueur2() {
        return joueur2;
    }
}
