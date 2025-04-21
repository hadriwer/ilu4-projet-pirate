/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package noyauFonctionnel.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import noyauFonctionnel.entity.cartes.Attaque;
import noyauFonctionnel.entity.cartes.Carte;
import noyauFonctionnel.entity.cartes.Popularite;

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
        for (int i = 0; i < 5; i ++)
            pioche.add(new Attaque("Coup de Sabre", "tqt", 1, 0));
        
        for (int i = 0; i < 5; i++)
            pioche.add(new Popularite("Vainqueur", "tqt", 1, 0));
        
        trierPioche();
    }
    
    public void trierPioche() {
        pioche = pioche.stream()
                .sorted((a, b) -> (Math.random() < 0.5 ? -1 : 1))
                .collect(Collectors.toList());
    }
    
    public Carte piocher() {
        Carte res = pioche.removeFirst();
        return res;
    } 
    
    public List<Carte> distribuer(int n) {
        return IntStream.range(0, n)
                .mapToObj(t -> piocher())
                .collect(Collectors.toList());
    }
    
    public List<Carte> getPioche() {
        return pioche;
    }
}