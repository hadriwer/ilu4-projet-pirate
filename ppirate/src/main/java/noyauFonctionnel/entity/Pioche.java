package noyauFonctionnel.entity;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import noyauFonctionnel.entity.cartes.Carte;
import util.CarteFactory;

public class Pioche {
    
    private final List<Carte> pioche;
    
    public Pioche(DictionnaireCarte dictionnaireCarte) {
        pioche = new LinkedList<>();
        
        Map<Carte, Integer> configuration = CarteFactory.creerCartes();
        
        configuration.entrySet().stream().forEach(entry -> {
            for (int i = 0; i < entry.getValue(); i++) {
                pioche.add(entry.getKey().clone());
            }
        });
        
        Collections.shuffle(pioche);
        dictionnaireCarte.setCartes(pioche.toArray(new Carte[0]));
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
   
    
    public int nbCartesRestantes(){
        return pioche.size();
    }
}