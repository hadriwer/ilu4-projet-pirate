package noyauFonctionnel.entity;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import noyauFonctionnel.entity.cartes.*;

class DictionnaireCarteTest {
	
	private Popularite cartePopularite;
    private DictionnaireCarte dictCarte;
    
	@BeforeEach
    public void setUp() {
        cartePopularite = new Popularite(2,"Popularite", "desc", 1, 1);
        
        dictCarte = new DictionnaireCarte();
        
    }
	
	
    @Test 
    public void testSetEtGeTCarte() {
    	Carte[] cartes = {cartePopularite};
    	dictCarte.setCartes(cartes);
    	assertEquals(cartePopularite, dictCarte.getCarte(0));
    }

}
