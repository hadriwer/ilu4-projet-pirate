/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package noyauFonctionnel.entity;

import java.util.ArrayList;
import java.util.List;
import noyauFonctionnel.entity.cartes.Carte;

/**
 *
 * @author wer
 */
public class Joueur {
    private String nom;
    private int indicePopularite;
    private int indiceVie;
    private MainJoueur mainJoueur;
    
    public Joueur(String nom, List<Carte> mainJoueur) {
        this.indicePopularite = 0;
        this.indiceVie = 5;
        this.nom = nom;
        this.mainJoueur = new MainJoueur(mainJoueur);        
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
        if (indiceVie - vie >= 0){
            this.indiceVie += vie;
        }
        else {
            this.indiceVie = 0;
        }
    }
    
    public void gagnerPop(int popularite){
        if (indicePopularite + popularite <= 5) {
            this.indicePopularite += popularite;
        }
        else{
            this.indicePopularite = 5;
        }
    }
    
    public boolean aGagne(){
        return this.indicePopularite == 5;
    }
    
    public boolean aPerdu(){
        return this.indiceVie == 0;
    }
    
    @Override
    public String toString(){
        return "Joueur : "+this.getNom()+ "\n" + 
                "Vie : " + this.indiceVie + "\n" +
                "Popularité : "+this.indicePopularite + "\n" +
                this.mainJoueur.toString();
    }
    
    public void prendreCarte(Carte carte){
        mainJoueur.prendreCarte(carte);
    }
    
    public class MainJoueur {
        private List<Carte> mainJoueur;

        public MainJoueur(List<Carte> mainJoueur) {
            this.mainJoueur = new ArrayList<>();
        }
        
        public List<Carte> getMain(){
            return this.mainJoueur;
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
            String cartes = "Contenu de la main du joueur :";
            for (Carte c : this.getMain()){
                cartes += c.toString()+" ";
            }
            cartes += "]";
            return cartes;
        }
    }
}
