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
    private final int actionVie;
    
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Attaque carte = (Attaque)o;
        return this.actionVie == carte.getActionVie() && super.getNom().equals(carte.getNom());
    }

    @Override
    public int hashCode() {
        return 31 * actionVie * super.getNom().hashCode();
    }
}
