/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.List;
import model.cartes.Carte;

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
        this.indiceVie = 0;
        this.nom = nom;
        this.mainJoueur = new MainJoueur(mainJoueur);        
    }
}
