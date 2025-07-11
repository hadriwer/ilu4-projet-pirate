/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package noyaufonctionnel.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import noyaufonctionnel.entity.cartes.Attaque;
import noyaufonctionnel.entity.cartes.Carte;

/**
 *
 * @author wer
 */
public class Joueur {
    private String nom;
    private int indicePopularite;
    private int indiceVie;
    private final MainJoueur mainJoueur;
    private static final int MAXVIE = 5;
    private static final int MINVIE = 0;
    private static final int MAXPOP = 5;
    private static final int MINPOP = 0;
    private final List<Attaque> carteProtegeJoueur;
    private Random randomNum = new Random();
    
    public Joueur(List<Carte> mainJoueur) {
        this.indicePopularite = MINPOP;
        this.indiceVie = MAXVIE;
        this.mainJoueur = new MainJoueur(mainJoueur);
        this.carteProtegeJoueur = new ArrayList<>();
    }
    
    
    public String getNom(){
        return this.nom;
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
    
    
    public boolean peutAttaquer(Attaque attaque) {
        return carteProtegeJoueur.stream().noneMatch(carte -> carte.equals(attaque));
    }
    
    public Carte carteHasard(int nbCartes){
        int nb = randomNum.nextInt(nbCartes);
        Carte c = this.mainJoueur.getCartes().get(nb);
        this.mainJoueur.getCartes().remove(nb);
        return c;
    }
    
    public List<Attaque> getCarteProtegeJoueur() {
        return carteProtegeJoueur;
    }
    
    public class MainJoueur {
        private final List<Carte> cartes;

        public MainJoueur(List<Carte> mainJoueur) {
            this.cartes = new ArrayList<>(mainJoueur);
        }
        
        public void prendreCarte(Carte carte){
            this.cartes.add(carte);
        }
        
        public void jouerCarte(Carte carte){
            if (this.cartes.contains(carte)){
                this.cartes.remove(carte);
            }
        }
        
        public List<Carte> getCartes() {
            return cartes;
        }
        
        @Override
        public String toString(){
            StringBuilder cartesStr = new StringBuilder();
            if (this.getCartes().isEmpty()) {
                return cartesStr.append(" vide").toString();
            }
            cartesStr.append("(\n");
            
            for (Carte c : this.getCartes()){
            	cartesStr.append(c.toString()).append("\n");
            }
            
            cartesStr.append(")");
            return cartesStr.toString();
        }
    }
}
