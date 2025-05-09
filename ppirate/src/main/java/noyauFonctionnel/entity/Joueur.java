/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package noyauFonctionnel.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import noyauFonctionnel.entity.cartes.Attaque;
import noyauFonctionnel.entity.cartes.Carte;

/**
 *
 * @author wer
 */
public class Joueur {
    private String nom;
    private int indicePopularite;
    private int indiceVie;
    private final MainJoueur mainJoueur;
    public static final int MAXVIE = 5;
    public static final int MINVIE = 0;
    public static final int MAXPOP = 5;
    public static final int MINPOP = 0;
    public List<Attaque> carteProtegeJoueur;
    
    public Joueur(List<Carte> mainJoueur) {
        this.indicePopularite = MINPOP;
        this.indiceVie = MAXVIE;
        this.mainJoueur = new MainJoueur(mainJoueur);
        this.carteProtegeJoueur = new ArrayList<>();
    }
    
    public boolean peutAttaquer(Attaque attaque) {
        return !carteProtegeJoueur.stream().anyMatch(carte -> carte.equals(attaque));
    }
    
    public Carte carteHasard(){
        Random randomNum = new Random();
        int nb = randomNum.nextInt(3);
        Carte c = this.mainJoueur.getCartes().get(nb);
        this.mainJoueur.getCartes().remove(nb);
        return c;
    }
    
    public List<Attaque> getCarteProtegeJoueur() {
        return carteProtegeJoueur;
    }
    
    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public int getIndicePopularite(){
        return this.indicePopularite;
    }
    
    public int getIndiceVie(){
        return this.indiceVie;
    }
    
    public String getNom(){
        return this.nom;
    }
    
    public MainJoueur getMainJoueur(){
        return this.mainJoueur;
    }
    
    public void perdreVie(int vie){
        if (indiceVie - vie >= MINVIE){
            this.indiceVie -= vie;
        }
        else {
            this.indiceVie = MINVIE;
        }
    }
    
    public void gagnerVie(int vie) {
        if (indiceVie + vie <= MAXVIE) {
            this.indiceVie += vie;
        }
        else {
            this.indiceVie = MAXVIE;
        }
    }
    
    public void gagnerPop(int popularite){
        if (indicePopularite + popularite <= MAXPOP) {
            this.indicePopularite += popularite;
        }
        else{
            this.indicePopularite = MAXPOP;
        }
    }
    
    public boolean aGagne(){
        return this.indicePopularite == MAXPOP;
    }
    
    public boolean aPerdu(){
        return this.indiceVie == MINVIE;
    }
    
    @Override
    public String toString(){
        return "Joueur[nom="+this.getNom() + ", vie=" + this.indiceVie + 
                ", popularite="+this.indicePopularite + ", contenu de la main=" + this.mainJoueur.toString() + "]";
    }
    
    public void prendreCarte(Carte carte){
        mainJoueur.prendreCarte(carte);
    }
    
    public class MainJoueur {
        private List<Carte> mainJoueur;

        public MainJoueur(List<Carte> mainJoueur) {
            this.mainJoueur = new ArrayList<>(mainJoueur);
        }
        
        public void prendreCarte(Carte carte){
            this.mainJoueur.add(carte);
        }
        
        public void jouerCarte(Carte carte){
            if (this.mainJoueur.contains(carte)){
                this.mainJoueur.remove(carte);
            }
        }
        
        public List<Carte> getCartes() {
            return mainJoueur;
        }
        
        @Override
        public String toString(){
            String cartes = "";
            if (this.getCartes().isEmpty()) {
                return cartes + " vide";
            }
            cartes += "(\n";
            
            for (Carte c : this.getCartes()){
                cartes += c.toString() + "\n";
            }
            
            cartes += ")";
            return cartes;
        }
    }
}
