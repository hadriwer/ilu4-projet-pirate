/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package noyauFonctionnel.entity.cartes;

import java.util.Objects;
import util.EnumCarte;

/**
 *
 * @author Solène
 */
public class Protection extends Carte{
    private Attaque attaqueBloque;
    
    public Protection(int id, String nom, String description, Attaque attaqueBloque) {
        super(id, nom, description);
        this.attaqueBloque = attaqueBloque;
        
        setEffet((self, cible) -> {
            self.getCarteProtegeJoueur().add(attaqueBloque);
        });
    }
    
    public String getNomAttaqueBloque() {
        return attaqueBloque.getNom();
    }
    
    @Override
    public String toString() {
        return "Protection[nom=" + this.getNom() + " attaque bloquée="+this.attaqueBloque.getNom()+"]";
    }
    
    public boolean bloque(Attaque attaque) {
        return attaqueBloque.equals(attaque);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode());
    }
    
    @Override
    public Protection clone() {
        return new Protection(id, nom, description, attaqueBloque);
    }

    @Override
    public EnumCarte getType() {
        return EnumCarte.PROTECTION;
    }
    
}
