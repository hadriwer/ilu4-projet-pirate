/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package noyauFonctionnel.controller;

import java.util.List;
import noyauFonctionnel.entity.Jeu;
import noyauFonctionnel.entity.Joueur;
import noyauFonctionnel.entity.Pioche;
import noyauFonctionnel.entity.cartes.Carte;

/**
 *
 * @author wer
 */
public class ControlJeu {
    private Jeu jeu;
    
    public ControlJeu(Jeu jeu) {
        this.jeu = jeu;
    }
    
    public boolean getTourDeJeu() {
        return jeu.getTourDeJeur();
    }
    
    public boolean verifierFinPartie() {
        return jeu.verifierFinPartie();
    }
    
    public Joueur donnerTourDeJoueur() { // TODO pas bon
        return jeu.donnerTourDeJoueur();
    }
    
    public void joueurPrendreCarte(Carte carte) {
        donnerTourDeJoueur().prendreCarte(carte);
    }
    
    public void changerJoueur() {
        jeu.changerJoueur();
    }
    
    public void appliquerEffetCarte(Carte carte) {
        jeu.appliquerEffetCarte(carte);
    }
    
    public void deposerCarte(Carte carte) {
        jeu.deposerCarte(carte);
    }
    
    public List<Carte> getZoneAction() {
        return jeu.getZoneAction();
    }
    
    public List<Carte> getZonePopulariteJ1() {
        return jeu.getZonePopulariteJ1();
    }
    
    public List<Carte> getZonePopulariteJ2() {
        return jeu.getZonePopulariteJ2();
    }
    
    public boolean isZoneActionEmpty() {
        return getZoneAction().isEmpty();
    }
    
    public boolean isZonePopulariteEmpty() {
        return getZoneAction().isEmpty();
    }
}
