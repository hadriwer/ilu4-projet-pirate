package noyauFonctionnel.entity;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import noyauFonctionnel.entity.cartes.Carte;
import util.CarteFactory;
import noyauFonctionnel.entity.cartes.ConfigurationCarte;

public class Pioche {
    private final List<Carte> pioche;
    
    public Pioche() {
        pioche = new LinkedList<>();
        
        ConfigurationCarte[] configurations = CarteFactory.creerCartes();
        
        Arrays.stream(configurations).forEach(configuration -> {
            for (int x = 0; x < configuration.getNbExemplaires(); x++) {
                pioche.add(configuration.getCarte().clone());
            }
        });
        
        Collections.shuffle(pioche);
    }
    
    public boolean isEmpty() {
        return pioche.isEmpty();
    }
    
    public Carte piocher() {
        return pioche.removeLast(); // remove last complexité O(1)
    }
    
    public List<Carte> distribuer(int n) {
        return IntStream.range(0, n)
                .mapToObj(t -> piocher())
                .collect(Collectors.toList());
    }
    
    public List<Carte> getPioche() {
        return pioche;
    }
    
    public int nbCartesRestantes(){
        return pioche.size();
    }
}