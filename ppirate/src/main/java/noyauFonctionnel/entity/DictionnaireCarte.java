/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package noyauFonctionnel.entity;

import noyauFonctionnel.entity.cartes.Carte;

/**
 *
 * @author Solène
 */
public class DictionnaireCarte {
    private Carte[] cartes;
    
    public void setCartes(Carte[] cartes){
        this.cartes=cartes;
        // modifie l'id de chaque carte pour qu'il sois unique
        for (int i = 0; i < cartes.length; i++) {
            cartes[i].setId(i);
        }
    }
    
    public Carte getCarte(int id){
        return cartes[id];
    }
    
}
