package noyauFonctionnel.entity;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class PiocheTest {
	
	private Jeu jeu;
    private Pioche pioche;
    private DictionnaireCarte dictCarte;
    
	
	@BeforeEach
    public void setUp() {
        dictCarte = new DictionnaireCarte();
        
        pioche = new Pioche(dictCarte);
     
        jeu = new Jeu(pioche);
    }
	
	
    @Test
    public void testIsEmpty() {
    	assertFalse(pioche.isEmpty());
    }
    
    
    @Test
    public void testNbCartesRestantes() {
    	assertEquals(61, pioche.nbCartesRestantes());
    }
}
