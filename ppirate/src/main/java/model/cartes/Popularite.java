/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.cartes;

/**
 *
 * @author wer
 */
public class Popularite extends Carte {
    private int pointDePop;
    
    public Popularite(String nom, String description, int pointDePop) {
        super(nom, description);
        this.pointDePop = pointDePop;
    }

    public int getPointDepPopularite() {
        return pointDePop;
    }
    
    @Override
    public String toString() {
        return "Carte Popularité -> gain = " + pointDePop;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Popularite p = (Popularite)o;
        return pointDePop == p.getPointDepPopularite() && super.getNom().equals(p.getNom());
    }

    @Override
    public int hashCode() {
        return 37 * pointDePop * super.getNom().hashCode();
    }
    
}
