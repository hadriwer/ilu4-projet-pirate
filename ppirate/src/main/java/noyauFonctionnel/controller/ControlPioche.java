/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package noyauFonctionnel.controller;

import noyauFonctionnel.entity.Jeu;
import noyauFonctionnel.entity.Pioche;
import noyauFonctionnel.entity.cartes.Carte;

/**
 *
 * @author vnm4618a
 */
public class ControlPioche {
    private Jeu jeu;
    
    public ControlPioche(Jeu jeu) {
        this.jeu = jeu;
    }
    
    public boolean isPiocheEmpty() {
        return jeu.getPioche().isEmpty();
    }
    
    public Carte piocher() {
        return jeu.getPioche().piocher();
    }
}
