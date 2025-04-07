/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author wer
 */
public class Jeu {
    private static final int NOMBRE_CARTE = 3;
    private Joueur joueur1;
    private Joueur joueur2;
    private boolean tourDeJeu;
    private Pioche pioche;
    
    public Jeu() {
        pioche = new Pioche();
        joueur1 = new Joueur("Jack Sparrow", pioche.distribuer(NOMBRE_CARTE));
        joueur2 = new Joueur("Barbe Noire", pioche.distribuer(NOMBRE_CARTE));
    }
}
