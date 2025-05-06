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
    
    public void removeCarteMainJoueur(Carte carte) {
        jeu.removeCarteMainJoueur(carte);
    }
    
    public boolean verifierFinPartie() {
        return jeu.verifierFinPartie();
    }
    
    public void joueurPrendreCarte(Carte carte) {
        jeu.joueurPrendreCarte(carte);
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
    
    public int getPointDeVieJ1() {
        return jeu.getJoueur1().getIndiceVie();
    }
    
    public int getPointDeVieJ2() {
        return jeu.getJoueur2().getIndiceVie();
    }
    
    public int getIndicePopulariteJ1() {
        return jeu.getJoueur1().getIndicePopularite();
    }
    
    public int getIndicePopulariteJ2() {
        return jeu.getJoueur2().getIndicePopularite();
    }
    
    public boolean isPiocheEmpty() {
        return jeu.getPioche().isEmpty();
    }
    
    public Carte piocher() {
        return jeu.getPioche().piocher();
    }
    
    public String afficherJeu(){
        return jeu.toString();
    }
    
    public Joueur giveJoueurGagnant(){
        return jeu.giveJoueurGagnant();
    }
    
    public Joueur getJoueur1(){
        return jeu.getJoueur1();
    }
    
    public Joueur getJoueur2(){
        return jeu.getJoueur2();
    }
}
