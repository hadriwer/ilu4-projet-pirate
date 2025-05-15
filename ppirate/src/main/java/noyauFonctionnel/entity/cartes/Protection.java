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
    private final Attaque attaqueBloque;
    
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
        return "Protection[nom=" + this.getNom() + ", attaque bloquée="+this.attaqueBloque.getNom()+"]";
    }
    
    public boolean bloque(Attaque attaque) {
        return attaqueBloque.equals(attaque);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), attaqueBloque);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Protection other = (Protection) obj;
        return Objects.equals(this.attaqueBloque, other.attaqueBloque);
    }
    
    

    @Override
    public EnumCarte getType() {
        return EnumCarte.PROTECTION;
    }

    @Override
    public Protection copie() {
        return new Protection(id, nom, description, attaqueBloque.copie());
    }
}
