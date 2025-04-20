/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package noyauFonctionnel.entity.cartes;

/**
 *
 * @author wer
 */
public abstract class Carte {
    private String nom;
    private String description;
    
    
    public Carte(String nom, String description) {
        this.nom = nom;
        this.description = description;
    }    
    
    public String getNom() {
       return nom;
    }
    
    public String getDescription() {
        return description;
    }
    
    @Override
    public abstract String toString();
    
    @Override
    public abstract boolean equals(Object o);
    
    @Override
    public abstract int hashCode();
}
