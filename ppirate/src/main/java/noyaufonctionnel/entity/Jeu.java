/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package noyaufonctionnel.entity;

import java.util.ArrayList;
import java.util.List;
import noyaufonctionnel.entity.cartes.Carte;
import util.EnumCarte;

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
    
    // Zone de jeu
    private final List<Carte> zonePopulariteJ1;
    private final List<Carte> zonePopulariteJ2;
    private final List<Carte> zoneAction;
    
    public Jeu(Pioche pioche) {
        this.pioche = pioche;
        this.joueur1 = new Joueur(pioche.distribuer(NOMBRE_CARTE));
        this.joueur2 = new Joueur(pioche.distribuer(NOMBRE_CARTE));
        this.tourDeJeu = true;
        this.zoneAction = new ArrayList<>();
        this.zonePopulariteJ1 = new ArrayList<>();
        this.zonePopulariteJ2 = new ArrayList<>();
    }
    
    public void changerJoueur() {
        this.tourDeJeu = !tourDeJeu;
    }
    
    public void deposerCarte(Carte carte) {
        if (carte.getType() == EnumCarte.ATTAQUE || carte.getType() == EnumCarte.ECHANGE || carte.getType() == EnumCarte.GAIN_VIE) {
            zoneAction.add(carte);
        }
        else {
            if (tourDeJeu) {
                zonePopulariteJ1.add(carte);
            }
            else{
                zonePopulariteJ2.add(carte);
            }
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
        } else if (joueur2.aGagne() || joueur1.aPerdu()) {
            return joueur2;
        } 
        
        return null;
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
    
    public String getJoueur1Nom() {
        return joueur1.getNom();
    }
    
    public String getJoueur2Nom() {
        return joueur2.getNom();
    }
    
    public boolean getTourDeJeu() {
        return tourDeJeu;
    }
    
    @Override
    public String toString(){
    	StringBuilder result = new StringBuilder();
        if (!this.tourDeJeu){
            result.append(this.joueur2.toString()).append("\nZone de Popularité J2: [");
            for (Carte c : this.zonePopulariteJ2){
                result.append(c.toString()).append(" ");  
            }
        }else{
            result.append(this.joueur1.toString()).append("\nZone de Popularité J1: [");
            for (Carte c : this.zonePopulariteJ1){
                result.append(c.toString()).append(" ");  
            } 
        }
        result.append("]\nZone d'action : ").append(this.zoneAction.isEmpty() ? "vide" : this.zoneAction.get(zoneAction.size() - 1));
        return result.toString();
    }
}
