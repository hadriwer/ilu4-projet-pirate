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
import noyauFonctionnel.entity.cartes.Protection;

/**
 *
 * @author wer
 */
public class Jeu {
    private static final int NOMBRE_CARTE = 4;
    private Joueur joueur1;
    private Joueur joueur2;
    private boolean tourDeJeu;
    private final Pioche pioche;
    private int compteNombreJeu;
    
    // Zone de jeu
    private List<Carte> zonePopulariteJ1;
    private List<Carte> zonePopulariteJ2;
    private List<Carte> zoneAction;
    
    public Jeu(Pioche pioche) {
        this.pioche = pioche;
        this.joueur1 = new Joueur(pioche.distribuer(NOMBRE_CARTE));
        this.joueur2 = new Joueur(pioche.distribuer(NOMBRE_CARTE));
        this.tourDeJeu = true;
        this.compteNombreJeu = 1;
        this.zoneAction = new ArrayList<>();
        this.zonePopulariteJ1 = new ArrayList<>();
        this.zonePopulariteJ2 = new ArrayList<>();
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
        else if (carte instanceof Popularite || carte instanceof Protection) {
            if (tourDeJeu) {
                zonePopulariteJ1.add(carte);
            }
            else{
                zonePopulariteJ2.add(carte);
            }
        }
        else {
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
    
    public void joueurPrendreCarte(Carte carte) {
        if (tourDeJeu) {
            joueur1.prendreCarte(carte);
        }
        else {
            joueur2.prendreCarte(carte);
        }
    }
    
    public void removeCarteMainJoueur(Carte carte) {
        if (tourDeJeu) {
            joueur1.getMainJoueur().getCartes().remove(carte);
        }
        else {
            joueur2.getMainJoueur().getCartes().remove(carte);
        }
    }
    
    public void appliquerEffetCarte(Carte carte) {
        if (tourDeJeu) {
            carte.apply(joueur1, joueur2);
        }
        else {
            carte.apply(joueur2, joueur1);
        }
    }
    
    public List<Carte> getZoneAction() {
        return zoneAction;
    }
    
    public List<Carte> getZonePopulariteJ1() {
        return zonePopulariteJ1;
    }
    
    public List<Carte> getZonePopulariteJ2() {
        return zonePopulariteJ2;
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
    
    public void setJoueur1Nom(String nom) {
        joueur1.setNom(nom);
    }
    
    public void setJoueur2Nom(String nom) {
        joueur2.setNom(nom);
    }    
    
    public boolean getTourDeJeu() {
        return tourDeJeu;
    }
    
    @Override
    public String toString(){
        String result = "";
        if (!this.tourDeJeu){
            result += this.joueur2.toString() +"\nZone de Popularité J2: [";
            for (Carte c : this.zonePopulariteJ2){
                result += c.toString() +" ";  
            }
        }else{
            result += this.joueur1.toString() +"\nZone de Popularité J1: [";
            for (Carte c : this.zonePopulariteJ1){
                result += c.toString() +" ";  
            } 
        }
        result += "]\nZone d'action : "+ (this.zoneAction.isEmpty() ? "vide" : this.zoneAction.getLast());
        return result;
    }
}
