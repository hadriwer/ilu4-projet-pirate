/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package noyauFonctionnel.entity.cartes;

import java.util.Objects;
import util.EnumCarte;

/**
 *
 * @author David Marquet
 */
public class Echange extends Carte {

    public Echange (int id, String nom, String description) {
        super(id, nom, description);
        
        setEffet((self, cible) -> {
            Carte c1 = self.carteHasard(3); 
            Carte c2 = cible.carteHasard(4); 
            self.getMainJoueur().prendreCarte(c2);
            cible.getMainJoueur().prendreCarte(c1);
        });
    }

    @Override
    public String toString() {
        return "Echange[nom=" + this.getNom() + "]";
    }
    
    @Override
    public Echange clone() {
        return new Echange(id, nom, description);
    }

    @Override
    public EnumCarte getType() {
        return EnumCarte.ECHANGE;
    }
}
