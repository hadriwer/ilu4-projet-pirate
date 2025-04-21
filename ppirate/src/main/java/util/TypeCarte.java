/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import noyauFonctionnel.entity.cartes.Attaque;
import noyauFonctionnel.entity.cartes.Carte;
import noyauFonctionnel.entity.cartes.Popularite;

/**
 *
 * @author wer
 */
public enum TypeCarte {
    ATTAQUE("Sabre", "tqt"),
    POPULARITE("Discours", "Gagne de la popularité");
    
    private String nom;
    private String description;
    
    TypeCarte(String nom, String description) {
        this.nom = nom;
        this.description = description; 
    }
    
    public Carte creerCarte() {
        switch (this) {
            case ATTAQUE -> {
                return new Attaque(nom, description, 2);
            }
            case POPULARITE -> {
                return new Popularite(nom, description, 1);
            }
            default -> throw new IllegalArgumentException("Type de carte inconnu");
        }
    }
    
    public String getNom() {
        return nom;
    }

    public String getDescription() {
        return description;
    }
}
