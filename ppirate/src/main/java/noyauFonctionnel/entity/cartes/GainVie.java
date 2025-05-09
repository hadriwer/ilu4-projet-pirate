/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package noyauFonctionnel.entity.cartes;

import util.EnumCarte;

/**
 *
 * @author wer
 */
public class GainVie extends Carte {
    private int gainVie;

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
    public Carte clone() {
        return new GainVie(id, nom, description, gainVie);
    }
    
}
