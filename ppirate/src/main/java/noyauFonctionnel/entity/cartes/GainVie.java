/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package noyauFonctionnel.entity.cartes;

import java.util.Objects;
import util.EnumCarte;

/**
 *
 * @author wer
 */
public class GainVie extends Carte {
    private final int gainVie;

    public GainVie(int id, String nom, String description, int gainVie) {
        super(id, nom, description);
        this.gainVie = gainVie;
        
        setEffet((self, cible) -> {
            self.gagnerVie(gainVie);
        });
    }
    
    public int getGainVie() {
        return gainVie;
    }

    @Override
    public EnumCarte getType() {
        return EnumCarte.GAIN_VIE;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), gainVie);
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
        final GainVie other = (GainVie) obj;
        return this.gainVie == other.gainVie;
    }
    
    @Override
    public String toString() {
        return "GainVie[nom=" + this.getNom() + ", gain de vie=" + gainVie +"]";
    }

    @Override
    public GainVie copie() {
        return new GainVie(id, nom, description, gainVie);
    }
    
}
