/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boundary;

import noyauFonctionnel.controller.*;
import noyauFonctionnel.entity.Jeu;

/**
 *
 * @author wer
 */
public class AdaptateurDuNoyauFonctionnel {
    private Jeu jeu;
    private ControlJeu controlJeu;
    private ControlJouerCarte controlJouerCarte;
    private ControlPiocherCarte controlPiocherCarte;
    
    public AdaptateurDuNoyauFonctionnel() {
        this.jeu = new Jeu();
        this.controlJeu = new ControlJeu(jeu);
        this.controlJouerCarte = new ControlJouerCarte(jeu);
        this.controlPiocherCarte = new ControlPiocherCarte(jeu);
    }

    public ControlJeu getControlJeu() {
        return controlJeu;
    }
    
    public ControlJouerCarte getControlJouerCarte() {
        return controlJouerCarte;
    }
    
    public ControlPiocherCarte getControlPiocherCarte() {
        return controlPiocherCarte;
    }
}