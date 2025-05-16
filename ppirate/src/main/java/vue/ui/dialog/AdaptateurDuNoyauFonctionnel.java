/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vue.ui.dialog;

import noyaufonctionnel.controller.ControlCarte;
import noyaufonctionnel.controller.ControlJeu;
import noyaufonctionnel.controller.ControlChoisirNomJoueur;
import java.util.List;
import util.EnumCarte;

/**
 *
 * @author wer
 */
public class AdaptateurDuNoyauFonctionnel {
    private final ControlJeu controlJeu;
    private final ControlChoisirNomJoueur controlChoisirNomJoueur;
    private final ControlCarte controlCarte;
    
    public AdaptateurDuNoyauFonctionnel(ControlJeu controlJeu, ControlChoisirNomJoueur controlChoisirNomJoueur, ControlCarte controlCarte) {
        this.controlJeu = controlJeu;
        this.controlChoisirNomJoueur = controlChoisirNomJoueur;
        this.controlCarte = controlCarte;
    }
    
    public boolean joueur1gagne() {
        return controlJeu.joueur1gagne();
    }
    
    public boolean joueur2gagne() {
        return controlJeu.joueur2gagne();
    }
    
    public boolean joueur1perdu() {
        return controlJeu.joueur1perdu();
    }
    
    public boolean joueur2perdu() {
        return controlJeu.joueur2perdu();
    }
    
    public int getPointDeVieJ1(){
        return controlJeu.getPointDeVieJ1();
    }
    
    public int getPointDeVieJ2(){
        return controlJeu.getPointDeVieJ2();
    }
    
    public int getIndicePopulariteJ1(){
        return controlJeu.getIndicePopulariteJ1();
    }
    
    public int getIndicePopulariteJ2(){
        return controlJeu.getIndicePopulariteJ2();
    }
    
    public List<Integer> getZonePopulariteJ1(){
        return controlJeu.getZonePopulariteJ1();
    }
    
    public List<Integer> getZonePopulariteJ2(){
        return controlJeu.getZonePopulariteJ2();
    }
    
    public List<Integer> getMainJoueur1(){
        return controlJeu.getMainJoueur1();
    }
    
    public List<Integer> getMainJoueur2(){
        return controlJeu.getMainJoueur2();
    }
    
    public List<Integer> getZoneAction(){
        return controlJeu.getZoneAction();
    }
    
    public EnumCarte getType(int idCarte){
        return controlCarte.getType(idCarte);
    }
    
    public String getNomAttaqueBloque(int idCarte) {
        return controlCarte.getNomAttaqueBloque(idCarte);
    }
    
    public String getNom(int idCarte){
        return controlCarte.getNom(idCarte);
    }
    public String getDescription(int idCarte){
        return controlCarte.getDescription(idCarte);
    }
    public int getPointPopularite(int idCarte){
        return controlCarte.getPointPopularite(idCarte);
    }
    public int getSelfDegat(int idCarte){
        return controlCarte.getSelfDegat(idCarte);
    }
    public int getActionVie(int idCarte){
        return controlCarte.getActionVie(idCarte);       
    }
    
    public int getGainVie(int idCarte) {
        return controlCarte.getGainVie(idCarte);
    }
    
    public void setNomJoueur1(String nomJoueur1){
        controlChoisirNomJoueur.setNomJoueur1(nomJoueur1);
    }
    
    public void setNomJoueur2(String nomJoueur2){
        controlChoisirNomJoueur.setNomJoueur2(nomJoueur2);
    }
    
    public String getNomJoueur1(){
        return controlChoisirNomJoueur.getNomJoueur1();
    }
    
    public String getNomJoueur2(){
        return controlChoisirNomJoueur.getNomJoueur2();
    }
    
    public int getNbCartesRestantes(){
        return controlJeu.getNbCartesRestantes();
    }
    
    public boolean verifierFinPartie(){
        return controlJeu.verifierFinPartie();
    }
    
    public void deposerCarte(int idCarte){
        controlJeu.deposerCarte(idCarte);
    }
    
    public void removeCarteMainJoueur(int idCarte){
        controlJeu.removeCarteMainJoueur(idCarte);
    }
    
    public void appliquerEffetCarte(int idCarte){
        controlJeu.appliquerEffetCarte(idCarte);
    }
    
    public void changerJoueur(){
        controlJeu.changerJoueur();
    }
    
    public int piocher(){
        return controlJeu.piocher();
    }
    
    public void joueurPrendreCarte(int idCarte){
        controlJeu.joueurPrendreCarte(idCarte);
    }
    
    public boolean getTourDeJeu(){
        return controlJeu.getTourDeJeu();
    }
    
    public String getTypeVictoire() {
        boolean j1Gagne = controlJeu.joueur1gagne();
        boolean j2Gagne = controlJeu.joueur2gagne();
        boolean j1Perdu = controlJeu.joueur1perdu();
        boolean j2Perdu = controlJeu.joueur2perdu();

        // Égalité
        if ((j1Gagne && j2Gagne) || (j1Perdu && j2Perdu)) {
            return "égalité";
        }

        // Victoire par popularité
        if ((j1Gagne && !j1Perdu) || (j2Gagne && !j2Perdu)) {
            return "popularité";
        }

        // Victoire par sacrifice (gagne en popularité et perd en vie)
        if ((j1Gagne) || (j2Gagne)) {
            return "sacrifice";
        }

        // Victoire par K.O. (adversaire perd sans que le joueur gagne directement)
        if ((j1Perdu) || (j2Perdu)) {
            return "K.O.";
        }

        // Par défaut, indéfini
        return "inconnu";
    }
    
    public String getNomGagnant() {
        boolean j1Gagne = controlJeu.joueur1gagne();
        boolean j2Gagne = controlJeu.joueur2gagne();
        boolean j1Perdu = controlJeu.joueur1perdu();
        boolean j2Perdu = controlJeu.joueur2perdu();

        if ((j1Gagne && j2Gagne) || (j1Perdu && j2Perdu)) {
            return "ÉGALITÉ";
        } else if (j1Gagne || j2Perdu) {
            return this.getNomJoueur1();
        } else if (j2Gagne || j1Perdu) {
            return this.getNomJoueur2();
        }

        return "Inconnu";
    }
}