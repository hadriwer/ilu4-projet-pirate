/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.Jeu;
import model.cartes.Carte;

/**
 *
 * @author vnm4618a
 */
public class ControlJouerCarte {
    private Jeu jeu;
    
    public ControlJouerCarte(Jeu jeu) {
        this.jeu = jeu;
    }
    
    public void deposerCarte(Carte carte) {
        jeu.deposerCarte(carte);
    }
}
