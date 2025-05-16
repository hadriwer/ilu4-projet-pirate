package noyaufonctionnel.entity.cartes;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import noyaufonctionnel.entity.Joueur;
import util.EnumCarte;

class GainVieTest {

	private GainVie carteGainVie;
    private Joueur j1;
    private Joueur j2;

    @BeforeEach
    public void setUp() {
        carteGainVie = new GainVie(5, "Potion", "Rend 2 PV", 2);
        j1 = new Joueur(new ArrayList<>());
        j2 = new Joueur(new ArrayList<>());
    }

    @Test
    void testGetGainVie() {
        assertEquals(2, carteGainVie.getGain());
    }

    @Test
    void testGetType() {
        assertEquals(EnumCarte.GAIN_VIE, carteGainVie.getType());
    }

    @Test
    void testClone() {
        Carte copie = carteGainVie.copie();
        assertEquals(carteGainVie, copie);
        assertNotSame(carteGainVie, copie);
    }

    @Test
    void testApplyEffetGainVie() {
        j1.perdreVie(3);  
        carteGainVie.apply(j1, j2); 
        assertEquals(4, j1.getIndiceVie()); 
        assertEquals(5, j2.getIndiceVie()); 
    }
    
    @Test
    void testHashCode() {
        GainVie memeGainVie = new GainVie(5, "Potion", "Rend 2 PV", 2);
        assertEquals(carteGainVie.hashCode(), memeGainVie.hashCode());
    }
    
    @Test
    void testEqualsTrue() {
    	// cas même référence
    	assertEquals(carteGainVie, carteGainVie);
    	
    	// cas même attributs
    	GainVie memeGainVie = new GainVie(5, "Potion", "Rend 2 PV", 2);
        assertEquals(carteGainVie, memeGainVie);
    }
    
    @Test
    void testEqualsFalse() {
    	// cas object null 
        assertFalse(carteGainVie.equals(null));

        // cas objet d�un autre type
        assertFalse(carteGainVie.equals("Pas une carte"));
        
        // cas effet actionVie différent
        GainVie gainVieDiff2 = new GainVie(4, "Potion", "desc", 1);
        assertNotEquals(carteGainVie, gainVieDiff2);
        
    }
    
    @Test
    void testToString() {
        String attendu = "GainVie[nom=Potion, gain de vie=2]";
        assertEquals(attendu, carteGainVie.toString());
    }

}
