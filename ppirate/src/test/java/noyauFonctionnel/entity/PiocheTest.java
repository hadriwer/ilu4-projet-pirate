package noyauFonctionnel.entity;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class PiocheTest {
    private Pioche pioche;
    private DictionnaireCarte dictCarte;
	
    @BeforeEach
    public void setUp() {
        dictCarte = new DictionnaireCarte();
        
        pioche = new Pioche(dictCarte);
    }
	
	
    @Test
    void testIsEmpty() {
    	assertFalse(pioche.isEmpty());
    }
   
    
    @Test
    void testNbCartesRestantesAvantLancementJeu() {
    	assertEquals(67, pioche.nbCartesRestantes());
    }
    
    @Test
    void testNbCartesRestantesApresLancementJeu() {
    	new Jeu(pioche);
    	assertEquals(59, pioche.nbCartesRestantes());
    }
}
