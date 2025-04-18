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
    private final int pointDePop;
    private final int selfDegats;
    
    public Popularite(String nom, String description, int pointDePop, int selfDegats) {
        super(nom, description);
        this.pointDePop = pointDePop;
        this.selfDegats = selfDegats;
    }

    public int getPointDepPop() {
        return pointDePop;
    }
    
    public int getSelfDegats() {
        return selfDegats;
    }
    
    @Override
    public String toString() {
        return "Carte Popularité -> gain = " + pointDePop + ", dégats à nous même = " + selfDegats;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Popularite p = (Popularite)o;
        return pointDePop == p.getPointDepPop() && selfDegats == p.getSelfDegats() && super.getNom().equals(p.getNom());
    }

    @Override
    public int hashCode() {
        return 37 * pointDePop * super.getNom().hashCode();
    }
    
}
