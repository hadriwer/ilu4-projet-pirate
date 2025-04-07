/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.cartes;

/**
 *
 * @author wer
 */
public class Attaque extends Carte {
    private int actionVie;
    
    public Attaque(String nom, String description, int actionVie) {
        super(nom, description);
        this.actionVie = actionVie;
    }

    public int getActionVie() {
        return actionVie;
    }
    
    @Override
    public String toString() {
        return "Carte Attaque -> dégat = " + actionVie;
    }
}
