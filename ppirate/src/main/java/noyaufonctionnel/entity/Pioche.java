package noyaufonctionnel.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import noyaufonctionnel.entity.cartes.Carte;
import util.CarteFactory;

public class Pioche {
    
    private final List<Carte> contenu;
    
    public Pioche(DictionnaireCarte dictionnaireCarte) {
    	contenu = new ArrayList<>();
        
        Map<Carte, Integer> configuration = CarteFactory.creerCartes();
        
        configuration.entrySet().stream().forEach(entry -> {
            for (int i = 0; i < entry.getValue(); i++) {
            	contenu.add(entry.getKey().copie()); 
            }
        });
        
        Collections.shuffle(contenu);
        dictionnaireCarte.setCartes(contenu.toArray(Carte[]::new));
    }
    
    public boolean isEmpty() {
        return contenu.isEmpty();
    }
    
    public Carte piocher() {
        return contenu.remove(contenu.size() - 1);
    }
    
    public List<Carte> distribuer(int n) {
        return IntStream.range(0, n).mapToObj(t -> piocher()).toList(); 
        // .collect(Collectors.toList()) en java < 16 (au lieu de .toList())
    }
   
    
    public int nbCartesRestantes(){
        return contenu.size();
    }
}