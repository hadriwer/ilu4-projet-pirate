package noyaufonctionnel.entity.cartes;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import noyaufonctionnel.entity.Joueur;
import util.EnumCarte;


class AttaqueTest {

	private Attaque carteAttaque;
	private Joueur j1;
	private Joueur j2;
	
    @BeforeEach
    public void setUp() {
        carteAttaque = new Attaque(1, "Attaque", "desc", 2, 0);
        
        j1 = new Joueur(new ArrayList<>());
        j2 = new Joueur(new ArrayList<>());
    }

    
    @Test
    void testGetActionVie() {
    	assertEquals(2, carteAttaque.getActionVie());
    }
    
    
    @Test
    void testGetSelfDegats() {
    	assertEquals(0, carteAttaque.getSelfDegats());
    }
    
    
    @Test
    void testToString() {
        String attendu = "Attaque[nom=Attaque, degat=2, auto-degat=0]";
        assertEquals(attendu, carteAttaque.toString());
    }
    
    
    
    @Test
    void testEqualsTrue() {
    	// cas même référence
    	assertEquals(carteAttaque, carteAttaque);
    	
    	// cas même attributs
        Attaque memeAttaque = new Attaque(2, "Attaque", "desc", 2, 0);
        assertEquals(carteAttaque, memeAttaque);
    }
    
    
    @Test
    void testEqualsFalse() {
    	// cas object null 
        assertFalse(carteAttaque.equals(null));

        // cas objet d�un autre type
        assertFalse(carteAttaque.equals("Pas une carte"));
    	
    	// cas nom différent
        Attaque attaqueDiff1 = new Attaque(2, "AttaqueDiff1", "desc", 2, 0);
        assertNotEquals(carteAttaque, attaqueDiff1);
        
        // cas effet selfDegat différent
        Attaque attaqueDiff2 = new Attaque(3, "Attaque", "desc", 2, 1);
        assertNotEquals(carteAttaque, attaqueDiff2);
        
        // cas effet actionVie différent
        Attaque attaqueDiff3 = new Attaque(4, "Attaque", "desc", 1, 0);
        assertNotEquals(carteAttaque, attaqueDiff3);
        
    }
    
    
    @Test
    void testHashCode() {
        Attaque memeAttaque = new Attaque(2, "Attaque", "desc", 2, 0);
        assertEquals(carteAttaque.hashCode(), memeAttaque.hashCode());
    }
    
    
    @Test
    void testClone() {
        Attaque copie = carteAttaque.copie();
        assertEquals(carteAttaque, copie);
        assertNotSame(carteAttaque, copie);
    }

    @Test
    void testGetType() {
        assertEquals(EnumCarte.ATTAQUE, carteAttaque.getType());
    }
    
    
    @Test
    void testEffetAppliqueSiNonProtege() {
        
        carteAttaque.apply(j1, j2);

        assertEquals(5, j1.getIndiceVie()); 
        assertEquals(3, j2.getIndiceVie()); 
    }

    
    @Test
    void testEffetAppliqueSiProtege() {
    	j2.getCarteProtegeJoueur().add(carteAttaque);
    	
        carteAttaque.apply(j1, j2);

        assertEquals(5, j1.getIndiceVie()); 
        assertEquals(5, j2.getIndiceVie()); 
    }
}
