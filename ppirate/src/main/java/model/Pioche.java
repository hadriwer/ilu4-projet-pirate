/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;
import model.cartes.Attaque;
import model.cartes.Carte;

/**
 *
 * @author wer
 */
public class Pioche {
    private List<Carte> pioche;
    public Pioche() {
        pioche = new ArrayList<>();
        initPioche();
    }
    
    public void initPioche() {
        pioche.add(new Attaque("Coup de Sabre", "tqt", 10));
    }
}