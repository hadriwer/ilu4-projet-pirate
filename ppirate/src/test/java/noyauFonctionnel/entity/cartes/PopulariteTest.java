package noyauFonctionnel.entity.cartes;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import noyauFonctionnel.entity.Joueur;
import util.EnumCarte;

class PopulariteTest {

	private Popularite cartePopularite;
	private Joueur j1;
	private Joueur j2;
	
    @BeforeEach
    public void setUp() {
    	cartePopularite = new Popularite(1, "Popularite", "desc", 2, 1);
        
        j1 = new Joueur(new ArrayList<>());
        j2 = new Joueur(new ArrayList<>());
    }

    
    @Test
    public void testGetPointDePop() {
    	assertEquals(2, cartePopularite.getPointDePop());
    }
    
    
    @Test
    public void testGetSelfDegats() {
    	assertEquals(1, cartePopularite.getSelfDegats());
    }
    
    
    @Test
    public void testToString() {
        String attendu = "Popularite[nom=Popularite, gain=2, auto-degat=1]";
        assertEquals(attendu, cartePopularite.toString());
    }
    
    
    
    @Test
    public void testEqualsTrue() {
    	// cas même référence
    	assertTrue(cartePopularite.equals(cartePopularite));
    	
    	// cas même attributs
        Popularite memePopularite = new Popularite(2, "Popularite", "desc", 2, 1);
        assertTrue(cartePopularite.equals(memePopularite));
    }
    
    
    @Test
    public void testEqualsFalse() {
    	// cas object null
    	assertFalse(cartePopularite.equals(null));
    	
    	// cas pas une carte
    	assertFalse(cartePopularite.equals("Pas une carte"));
    	
    	// cas nom différent
    	Popularite populariteDiff1 = new Popularite(2, "populariteDiff1", "desc", 2, 1);
        assertFalse(cartePopularite.equals(populariteDiff1));
        
        // cas effet selfDegat différent
        Popularite populariteDiff2 = new Popularite(3, "Popularite", "desc", 2, 0);
        assertFalse(cartePopularite.equals(populariteDiff2));
        
        // cas effet gain différent
        Popularite populariteDiff3 = new Popularite(4, "Popularite", "desc", 1, 1);
        assertFalse(cartePopularite.equals(populariteDiff3));
        
    }
    
    
    @Test
    public void testHashCode() {
    	Popularite memePopularite = new Popularite(2, "Popularite", "desc", 2, 1);
        assertEquals(cartePopularite.hashCode(), memePopularite.hashCode());
    }
    
    
    @Test
    public void testClone() {
    	Popularite copie = cartePopularite.clone();
        assertEquals(cartePopularite, copie);
        assertNotSame(cartePopularite, copie);
    }

    @Test
    public void testGetType() {
        assertEquals(EnumCarte.POPULARITE, cartePopularite.getType());
    }
    
    
    @Test
    public void testEffetAppliqueSiNonProtege() {
        
    	cartePopularite.apply(j1, j2);

        assertEquals(4, j1.getIndiceVie()); 
        assertEquals(2, j1.getIndicePopularite());
        assertEquals(5, j2.getIndiceVie()); 
    }


}
