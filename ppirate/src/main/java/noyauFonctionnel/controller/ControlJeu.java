/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package noyauFonctionnel.controller;

import java.util.List;
import noyauFonctionnel.entity.Jeu;
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
    
    public List<Carte> getZoneAction() {
        return jeu.getZoneAction();
    }
    
    public List<Carte> getPopularite() {
        return jeu.getZonePopularite();
    }
    
    public boolean isZoneActionEmpty() { // DEMANDER AU PROF
        return getZoneAction().isEmpty();
    }
    
    public boolean isZonePopulariteEmpty() {
        return getZoneAction().isEmpty();
    }
}
