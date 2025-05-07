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
    private ControlChoisirNomJoueur controlChoisirNomJoueur;
    
    public AdaptateurDuNoyauFonctionnel(Jeu jeu) {
        this.controlJeu = new ControlJeu(jeu);
        this.controlChoisirNomJoueur = new ControlChoisirNomJoueur(jeu);
    }

    public ControlJeu getControlJeu() {
        return controlJeu;
    }
    
    public ControlChoisirNomJoueur getControlChoisirNomJoueur() {
        return controlChoisirNomJoueur;
    }
}