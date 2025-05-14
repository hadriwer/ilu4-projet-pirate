/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package noyauFonctionnel.controller;

import java.util.List;
import noyauFonctionnel.entity.DictionnaireCarte;
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
    private DictionnaireCarte dictionnaireCarte;
    
    public ControlJeu(Jeu jeu, DictionnaireCarte dictionnaireCarte) {
        this.jeu = jeu;
        this.dictionnaireCarte=dictionnaireCarte;
    }
    
    public boolean getTourDeJeu() {
        return jeu.getTourDeJeu();
    }
    
    public void removeCarteMainJoueur(int idCarte) {
        jeu.removeCarteMainJoueur(dictionnaireCarte.getCarte(idCarte));
    }
    
    public boolean verifierFinPartie() {
        return jeu.verifierFinPartie();
    }
    
    public void joueurPrendreCarte(int idCarte) {
        jeu.joueurPrendreCarte(dictionnaireCarte.getCarte(idCarte));
    }
    
    public void changerJoueur() {
        jeu.changerJoueur();
    }
    
    public void appliquerEffetCarte(int idCarte) {
        jeu.appliquerEffetCarte(dictionnaireCarte.getCarte(idCarte));
    }
    
    public void deposerCarte(int idCarte) {
        jeu.deposerCarte(dictionnaireCarte.getCarte(idCarte));
    }
    
    public List<Integer> getZoneAction() {
        return jeu.getZoneAction().stream().map(c -> c.getId()).toList();
    }
    
    public List<Integer> getZonePopulariteJ1() {
        return jeu.getZonePopulariteJ1().stream().map(c -> c.getId()).toList();
    }
    
    public List<Integer> getZonePopulariteJ2() {
        return jeu.getZonePopulariteJ2().stream().map(c -> c.getId()).toList();
    }
    
    public boolean isZoneActionEmpty() {
        return getZoneAction().isEmpty();
    }
    
    public boolean isZonePopulariteEmpty() {
        return getZoneAction().isEmpty();
    }
    
    public List<Integer> getMainJoueur1() {
        return jeu.getJoueur1().getMainJoueur().getCartes().stream().map(c -> c.getId()).toList();
    }
    
    public List<Integer> getMainJoueur2() {
        return jeu.getJoueur2().getMainJoueur().getCartes().stream().map(c -> c.getId()).toList();
    }
    
    public boolean isMainJoueur1Empty() {
        return getMainJoueur1().isEmpty();
    }
    
    public boolean isMainJoueur2Empty() {
        return getMainJoueur2().isEmpty();
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
    
    public int piocher() {
        return jeu.getPioche().piocher().getId();
    }
    
    public String afficherJeu(){
        return jeu.toString();
    }
    
    public boolean joueur1gagne() {
        return jeu.getJoueur1().aGagne();
    }
    
    public int getNbCartesRestantes(){
        return jeu.getPioche().nbCartesRestantes();
    }
}
