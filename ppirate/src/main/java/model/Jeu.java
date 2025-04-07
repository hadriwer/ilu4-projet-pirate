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
    private Joueur joueur1;
    private Joueur joueur2;
    private Pioche pioche;
    
    public Jeu() {
        joueur1 = new Joueur();
        joueur2 = new Joueur();
        pioche = new Pioche();
    }
}
