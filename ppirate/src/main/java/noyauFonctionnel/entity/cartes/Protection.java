/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package noyauFonctionnel.entity.cartes;

import java.util.Objects;
import noyauFonctionnel.entity.Joueur;

/**
 *
 * @author Solène
 */
public class Protection extends Carte{
    private Attaque attaqueBloque;
    
    public Protection(String nom, String description, Attaque attaqueBloque) {
        super(nom, description);
        effet = (self, cible) -> {
            self.getCarteProtegeJoueur().add(attaqueBloque);
        };
        this.attaqueBloque = attaqueBloque;
    }
    
    @Override
    public String toString() {
        return "Protection[nom=" + this.getNom() + "";
    }
    
    public boolean bloque(Attaque attaque) {
        return attaqueBloque.equals(attaque);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode());
    }  
}
