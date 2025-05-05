/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vue.ui.dialog;

import noyauFonctionnel.controller.*;
import noyauFonctionnel.entity.Jeu;

/**
 *
 * @author wer
 */
public class AdaptateurDuNoyauFonctionnel {
    private ControlJeu controlJeu;
    
    public AdaptateurDuNoyauFonctionnel(Jeu jeu) {
        this.controlJeu = new ControlJeu(jeu);
    }

    public ControlJeu getControlJeu() {
        return controlJeu;
    }
}